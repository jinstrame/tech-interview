import lombok.*;

@NoArgsConstructor
public class BST<T extends Comparable<T>> {
    @Getter
    @Setter
    private class BSTNode<R> {
        R value;
        BSTNode<R> parent;
        BSTNode<R> left;
        BSTNode<R> right;
        BSTNode(R value){
            this.value = value;
        }
    }

    private BSTNode<T> root;

    public void put(T value) {
        BSTNode<T> node = new BSTNode<>(value);
        if (root == null) {
            root = node;
            return;
        }

        BSTNode<T> parent = root;
        while (true) {
            if (parent.getValue().equals(value))
                return;

            if (parent.getValue().compareTo(value) > 0) {
                if (parent.getLeft() == null) {
                    parent.setLeft(node);
                    node.setParent(parent);
                    return;
                } else {
                    parent = parent.getLeft();
                }
            } else {
                if (parent.getRight() == null) {
                    parent.setRight(node);
                    node.setParent(parent);
                    return;
                } else {
                    parent = parent.getRight();
                }
            }
        }
    }

    public T search(T value) {
        BSTNode<T> current = searchNode(value);
        if (current != null)
            return current.getValue();
        return null;
    }

    private BSTNode<T> searchNode(T value) {
        BSTNode<T> current = root;
        while (current != null) {
            if (current.getValue().equals(value))
                return current;
            if (current.getValue().compareTo(value) > 0)
                current = current.getLeft();
            else current = current.getRight();
        }
        return null;
    }

    public T remove(T value){
        BSTNode<T> toRemove = searchNode(value);
        if (toRemove == null)
            return null;

        BSTNode<T> toReplace = toRemove.getLeft();
        if (toRemove.getLeft() == null)
            toReplace = toRemove.getRight();

        while (true){
            if (toReplace.getRight() != null){
                toReplace = toReplace.getRight();
                continue;
            }
            if (toReplace.getLeft() != null){
                toReplace = toReplace.getLeft();
                continue;
            }
            break;
        }

        if (toRemove.getParent() != null) {
            if (toRemove.getParent().getRight() == toRemove)
                toRemove.getParent().setRight(toReplace);
            else toRemove.getParent().setLeft(toReplace);
        }
        else {
            root = toReplace;
        }

        if (toReplace != null){
            if (toReplace.getParent().getRight() == toReplace)
                toReplace.getParent().setRight(null);
            else toReplace.getParent().setLeft(null);

            toReplace.setParent(toRemove.getParent());
            toReplace.setLeft(toRemove.getLeft());
            toReplace.setRight(toRemove.getRight());
        }


        return toRemove.getValue();
    }
}
