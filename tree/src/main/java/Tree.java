import lombok.Getter;

import java.util.*;


@Getter
public class Tree<T> {

    private Node<T> root;


    public Tree(T rootValue){
        root = new Node<>(rootValue);
    }

    public Tree(Node<T> ofNode){
        root = ofNode;
    }

    public int height(){
        return root.getHeight();
    }

    public int height(Node<T> ofNode){
        return ofNode.getHeight();
    }

    public int depth(Node<T> ofNode){
        int i = 0;
        while (ofNode.getParent() != null) {
            i++;
            ofNode = ofNode.getParent();
        }
        return i;
    }

    public int level(){
        return root.getHeight() + 1;
    }


    public List<Node<T>> postOrderDFS(){
        List<Node<T>> list = new LinkedList<>();
        list.addAll(postOrderDFSChildList(root));
        list.add(root);
        return list;
    }

    private List<Node<T>> postOrderDFSChildList(Node<T> ofElement){
        List<Node<T>> list = new LinkedList<>();
        for (Node<T> child : ofElement.getChildren()) {
            list.addAll(postOrderDFSChildList(child));
            list.add(child);
        }
        return list;
    }


    public List<Node<T>> inOrderDFS(){
        List<Node<T>> list = new LinkedList<>();
        list.addAll(inOrderDFSList(root));
        return list;
    }

    private List<Node<T>> inOrderDFSList(Node<T> ofElement) {
        List<Node<T>> list = new LinkedList<>();
        ListIterator<Node<T>> iterator = ofElement.getChildren().listIterator();

        if (iterator.hasNext())
            list.addAll(inOrderDFSList(iterator.next()));

        list.add(ofElement);

        while (iterator.hasNext()) {
            list.addAll(inOrderDFSList(iterator.next()));
        }
        return list;
    }


    public List<Node<T>> preOrderDFS(){
        List<Node<T>> list = new LinkedList<>();
        list.add(root);
        list.addAll(preOrderDFSChildList(root));
        return list;
    }

    private List<Node<T>> preOrderDFSChildList(Node<T> ofElement){
        List<Node<T>> list = new LinkedList<>();
        for (Node<T> child : ofElement.getChildren()) {
            list.add(child);
            list.addAll(preOrderDFSChildList(child));
        }
        return list;
    }

    public List<Node<T>> BFS(){
        List<Node<T>> list = new LinkedList<>();
        list.add(root);
        list.addAll(BFSChildrenList(root));
        return list;
    }

    private List<Node<T>> BFSChildrenList(Node<T> ofElement){
        List<Node<T>> list = new LinkedList<>();
        list.addAll(ofElement.getChildren());
        for (Node<T> child : ofElement.getChildren())
            list.addAll(BFSChildrenList(child));
        return list;
    }
}
