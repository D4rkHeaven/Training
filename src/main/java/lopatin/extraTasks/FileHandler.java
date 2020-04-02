package lopatin.extraTasks;

import lombok.extern.slf4j.Slf4j;
import lopatin.mainTask.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class FileHandler {
    private static final int DEFAULT_AGE = 0;
    private static final String DEFAULT_NAME = "Default";
    private static Collection<File> names = new ArrayList<>();

    /**
     * Find all classes with Entity annotation
     */
    public void searchClassesWithAnnotation() {
        String folderPath = FileHandler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        folderPath = folderPath.substring(1);
        extractFiles(new File(folderPath));

        for (File file : names) {
            String name = file.getPath();
            if (!name.endsWith(".class")) {
                continue;
            }
            name = name.substring(0, name.length() - ".class".length());
            name = name.replace("/", ".");
            name = name.replace("\\", ".");
            int classesPos = name.indexOf(".classes.");
            if (classesPos >= 0) {
                name = name.substring(classesPos + ".classes.".length());
            }
            try {
                if (Class.forName(name).isAnnotationPresent(Entity.class)) {
                    log.info("Find class {} with Entity annotation ", name);
                } else {
                    log.info("No classes with Entity annotation");
                }
            } catch (ClassNotFoundException e) {
                log.warn(String.valueOf(e));
            }
        }
    }

    /**
     * Generate people with values from source file
     *
     * @param path - path to source file
     */
    public void setPeopleValues(String path) {
        String name = "";
        int age = 0;
        List<Human> humanList = new ArrayList<>();
        Class<Human> human = Human.class;
        if (!path.trim().isEmpty()) {
            try {
                Scanner scanner = new Scanner(new FileReader(path));
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] params = line.split("=");
                    if (params.length != 2 || params[1].trim().isEmpty()) {
                        continue;
                    }
                    if (params[0].equalsIgnoreCase("name")) {
                        name = params[1].trim();
                    } else if (params[0].equalsIgnoreCase("age")) {
                        try {
                            age = Integer.parseInt(params[1]);
                        } catch (NumberFormatException e) {
                            log.warn("Invalid age in file - " + e.getMessage());
                        }
                    } else {
                        continue;
                    }
                    if (!name.isEmpty() && age != 0) {
                        try {
                            Human humanInstance = human.newInstance();
                            humanInstance.setAge(age);
                            humanInstance.setName(name);
                            humanList.add(humanInstance);
                        } catch (InstantiationException | IllegalAccessException e) {
                            log.warn(e.getMessage());
                        }
                        name = "";
                        age = 0;
                    }
                }
            } catch (FileNotFoundException e) {
                log.warn(e.getMessage());
            }
        }
        log.info("Generated people with values from file: {}", humanList.toString());
    }

    /**
     * Generate human with values from source file
     */
    public void setHumanValues() {
        Human human = new Human();
        if (human.getClass().isAnnotationPresent(Entity.class)) {
            Field[] fields = human.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Value.class)) {
                    log.info("Found annotation for field {}", field.getName());
                    Value annotation = field.getAnnotation(Value.class);
                    String annotationName = annotation.name();
                    int annotationAge = annotation.age();
                    String annotationPath = annotation.pathToFile();
                    if (!annotationPath.trim().isEmpty()) {
                        try {
                            Scanner scanner = new Scanner(new FileReader(annotationPath));
                            while (scanner.hasNext()) {
                                String line = scanner.nextLine();
                                String[] params = line.split("=");
                                if (params.length != 2 || params[1].trim().isEmpty()) {
                                    continue;
                                }
                                if (params[0].equalsIgnoreCase("name")) {
                                    annotationName = params[1].trim();
                                } else if (params[0].equalsIgnoreCase("age")) {
                                    try {
                                        annotationAge = Integer.parseInt(params[1]);
                                    } catch (NumberFormatException e) {
                                        log.warn("Invalid age format in source file " + e.getMessage());
                                    }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            log.info(e.getMessage());
                        }
                    }
                    if (field.getName().equalsIgnoreCase("name")) {
                        try {
                            field.setAccessible(true);
                            if (annotationName.isEmpty()) {
                                field.set(human, DEFAULT_NAME);
                            } else {
                                field.set(human, annotationName);
                            }
                        } catch (IllegalAccessException e) {
                            log.info(e.getMessage());
                        }
                    } else if (field.getName().equalsIgnoreCase("age")) {
                        try {
                            field.setAccessible(true);
                            if (annotationAge != 0) {
                                field.set(human, annotationAge);
                            } else {
                                field.set(human, DEFAULT_AGE);
                            }
                        } catch (IllegalAccessException e) {
                            log.info(e.getMessage());
                        }
                    }
                }
            }
        }
        log.info("Generated human with values from file: {}", human.toString());
    }

    /**
     * Extract all files in folder to list
     *
     * @param folder searchable folder
     */
    private void extractFiles(File folder) {
        File[] folderEntries = folder.listFiles();
        try {
            assert folderEntries != null;
            for (File entry : folderEntries) {
                if (entry.isDirectory()) {
                    extractFiles(entry);
                    continue;
                }
                names.add(entry);
            }
        }catch (NullPointerException e){
            log.warn("Path doesn't exist or contains non-latin letters");
        }
    }
}
