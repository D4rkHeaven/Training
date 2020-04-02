package lopatin;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
public class UuidUtil {
    public void generate() {
        Stream<String> stream = Stream.generate(() -> Integer.toString((int) (Math.random() * 100000))).limit(10000);
        stream.forEach(log::info);
    }
    public void fileWrite(String path){
        Path filePath = Paths.get(path);
        try {
            Files.write(filePath, Arrays.asList("first line", "second line"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
