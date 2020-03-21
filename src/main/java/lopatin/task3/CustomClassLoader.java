package lopatin.task3;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * Class loader
 */
@Slf4j
public class CustomClassLoader extends ClassLoader {
    private static final String CLASSPATH = "C:/myClasses/";
    private static final String FILE_EXTENSION = ".class";

    /**
     * Get bytecode from file and load class in runtime
     *
     * @param className - name of input class
     * @return loaded class or error
     * @throws ClassNotFoundException when class missing
     */
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] bytes = fetchClassFromFS(CLASSPATH + className + FILE_EXTENSION);
            log.info("File {}{}{} loaded!", CLASSPATH, className, FILE_EXTENSION);
            return defineClass(className, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            log.error("File not found! " + e.getMessage());
            return super.findClass(className);
        } catch (IOException e) {
            log.error("IO error while loading class! " + e.getMessage());
            return super.findClass(className);
        }
    }

    private byte[] fetchClassFromFS(String path) throws IOException {
        InputStream inputStream = new FileInputStream(new File(path));
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            log.error("File {} too large!", path);
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead;
        while (offset < bytes.length
                && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        inputStream.close();
        return bytes;
    }
}
