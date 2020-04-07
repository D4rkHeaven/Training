package lopatin.fileSystem;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Node {

    List<Node> children;
    List<Node> leafs;
    String data;
    String incrementalPath;

    public Node(String data, String incrementalPath) {
        children = new ArrayList<>();
        leafs = new ArrayList<>();
        this.data = data;
        this.incrementalPath = incrementalPath;
    }

    public boolean isLeaf() {
        return children.isEmpty() && leafs.isEmpty();
    }

    public void addElement(String currentPath, String[] list) {
        while (list[0] == null || list[0].equals(""))
            list = Arrays.copyOfRange(list, 1, list.length);
        Node currentChild = new Node(list[0], currentPath + "/" + list[0]);
        if (list.length == 1) {
            leafs.add(currentChild);
        } else {
            int index = children.indexOf(currentChild);
            if (index == -1) {
                children.add(currentChild);
                currentChild.addElement(currentChild.incrementalPath, Arrays.copyOfRange(list, 1, list.length));
            } else {
                Node nextChild = children.get(index);
                nextChild.addElement(currentChild.incrementalPath, Arrays.copyOfRange(list, 1, list.length));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        Node obj1 = (Node) obj;
        return incrementalPath.equals(obj1.incrementalPath) && data.equals(obj1.data);
    }

    public void printNode(int increment) {
        for (int i = 0; i < increment; i++) {
            log.info(" ");
        }
        log.info(incrementalPath + (isLeaf() ? " -> " + data : ""));
        for (Node node : children)
            node.printNode(increment + 2);
        for (Node n : leafs)
            n.printNode(increment + 2);
    }

    @Override
    public String toString() {
        return data;
    }
}
