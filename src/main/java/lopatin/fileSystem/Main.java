package lopatin.fileSystem;

/**
 * Creates tree, based on all folders and files in PATH folder
 */
public class Main {
    private static final String PATH = "C:\\test";

    public static void main(String[] args) {
        Tree tree = new Tree(new Node("", ""));
        tree.printTree(PATH);
    }
}
