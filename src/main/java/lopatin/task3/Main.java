package lopatin.task3;

/**
 * Check class loader
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        CustomClassLoader classLoader = new CustomClassLoader();
        Class clazz = classLoader.loadClass("TestClass");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}

