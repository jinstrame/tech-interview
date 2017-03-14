import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Node<T>{
    private Node<T> parent;
    private T value;
    private int height;
    private int size;
    List<Node<T>> children;

    public Node(T value){
        this.value = value;
        children = new ArrayList<>();
        parent = null;
        height = 0;
        size = 1;
    }

    public Node<T> search(T value){
        for (Node<T> child : children)
            if (child.value.equals(value))
                return child;
        return null;
    }

    public Node<T> addChild(T value){
        Node<T> ret = new Node<>(value);
        ret.parent = this;
        children.add(ret);
        update(ret);
        return ret;
    }

    private void update(Node<T> fromElement){
        if (fromElement.parent == null) return;
        if (fromElement.height >= fromElement.parent.height)
            fromElement.parent.height = fromElement.height + 1;
        fromElement.parent.size++;
        update(fromElement.parent);
    }

    @Override
    public String toString(){
        return value.toString();
    }
}