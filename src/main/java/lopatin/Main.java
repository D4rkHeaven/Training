package lopatin;

public class Main {
    private static final String CLASSPATH = "lopatin.Human";

    public static void main(String[] args) {
        AnnotationCheck checker = new AnnotationCheck();
        Class<?> clazz = checker.loadClass(CLASSPATH);
        checker.checkValueAnnotation(clazz);
    }
}
