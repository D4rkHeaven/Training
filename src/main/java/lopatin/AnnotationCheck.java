package lopatin;

import java.lang.reflect.Field;

public class AnnotationCheck {
    public Class<?> loadClass(String classpath) {
        Class<?> clazz = null;
        {
            try {
                clazz = Class.forName(classpath);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return clazz;
    }

    public void checkValueAnnotation(Class<?> clazz) {
        assert clazz != null;
        if (!clazz.isAnnotationPresent(Entity.class)) {
            System.out.println("Class doesn't have Entity annotation");
            if (checkFields(clazz)) {
                try {
                    throw new IllegalStateException("Class doesn't have Entity annotation, " +
                            "but has Value annotated fields");
                } catch (IllegalStateException e) {
                    System.out.println(e);
                }
            }
        } else {
            System.out.println("Class has annotation: " + clazz.getAnnotation(Entity.class));
            if (!checkFields(clazz)) {
                try {
                    throw new NoValueAnnotationException("Class doesn't have Value annotation on all fields");
                } catch (NoValueAnnotationException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void insertValueInFields() {
        //-------------------------------------
        Human human = new Human();
        Field annotatedField = null;
        try {
            annotatedField = human.getClass().getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert annotatedField != null;
        Value annotation = annotatedField.getAnnotation(Value.class);
        if (annotation != null) {
            System.out.println("Value of annotated field: " + annotation.name());
        }
        System.out.println(human.getName());
    }

    private boolean checkFields(Class<?> clazz) {
        boolean isMoreThanOneAnnotationField = false;
        Field[] field = clazz.getDeclaredFields();
        for (Field fd : field) {
            if (fd.isAnnotationPresent(Value.class)) {
                isMoreThanOneAnnotationField = true;
            }
        }
        return isMoreThanOneAnnotationField;
    }
}
