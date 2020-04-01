package lopatin.mainTask;

public class Main {
    private static final String CLASSPATH = "lopatin.mainTask.Human";

    public static void main(String[] args) {
        AnnotationCheck checker = new AnnotationCheck();
        Class<?> clazz = checker.loadClass(CLASSPATH);
        checker.checkValueAnnotation(clazz);
        checker.insertValueInFields(clazz);
    }
}
