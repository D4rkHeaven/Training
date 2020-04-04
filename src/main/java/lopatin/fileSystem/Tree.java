package lopatin.fileSystem;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class Tree {
    private static Collection<String> names = new ArrayList<>();
    Node root;
    Node commonRoot;

    public Tree(Node root) {
        this.root = root;
        commonRoot = null;
    }

    public void printTree(String path) {
        extractFiles(new File(path));
        for (String data : names) {
            addElement(data);
        }
        getCommonRoot();
        commonRoot.printNode(0);
    }

    private void addElement(String elementValue) {
        String[] list = elementValue.split("/");
        root.addElement(root.incrementalPath, list);
    }

    private void getCommonRoot() {
        Node current = root;
        while (current.leafs.size() <= 0) {
            current = current.children.get(0);
        }
        commonRoot = current;
    }

    private void extractFiles(File folder) {
        File[] folderEntries = folder.listFiles();
        try {
            assert folderEntries != null;
            for (File entry : folderEntries) {
                names.add(entry.toString());
                if (entry.isDirectory()) {
                    extractFiles(entry);
                }
            }
        } catch (NullPointerException e) {
            log.error("Path doesn't exist or contains non-latin letters");
        }
    }
}
