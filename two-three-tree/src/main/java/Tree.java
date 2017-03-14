import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public void put(T value) {
        if (root == null){
            root = new Node<>(value);
            return;
        }


        if (search(value) != null) return;
        Node<T> toPut = root;
        Node<T> next = oneStepLowerSearch(toPut, value);
        while (next != null) {
            toPut = next;
            next = oneStepLowerSearch(toPut, value);
        }

        toPut.addToNodeWithComparation(value, null, null);
        while (toPut.getType() == NodeType.FourNode) {
            if (toPut == root) {
                root = toPut.convertFourNode(null);
                break;
            }
            toPut = toPut.convertFourNode(toPut.getParent());
        }
    }


    public T search(T value) {
        Node<T> current = root;
        while (current != null) {
            if (current.getType() == NodeType.TwoNode) {
                if (current.getTwoNodeValue().equals(value))
                    return current.getTwoNodeValue();
                current = searchInTwoNode(current, value);
            } else {
                if (current.getThreeNodeLeftValue().equals(value))
                    return current.getThreeNodeLeftValue();
                if (current.getThreeNodeRightValue().equals(value))
                    return current.getThreeNodeRightValue();
                current = searchInThreeNode(current, value);
            }
        }
        return null;
    }

    private Node<T> oneStepLowerSearch(Node<T> from, T val) {
        if (from.getType() == NodeType.TwoNode)
            return searchInTwoNode(from, val);
        else return searchInThreeNode(from, val);
    }

    private Node<T> searchInTwoNode(Node<T> node, T val) {
        if (node.getTwoNodeValue().compareTo(val) >= 0)
            return node.getTwoNodeLeft();
        else return node.getTwoNodeRight();
    }

    private Node<T> searchInThreeNode(Node<T> node, T val) {
        if (node.getThreeNodeLeftValue().compareTo(val) >= 0)
            return node.getThreeNodeLeft();
        else if (node.getThreeNodeRightValue().compareTo(val) >= 0)
            return node.getThreeNodeMiddle();
        else return node.getThreeNodeRight();
    }
}