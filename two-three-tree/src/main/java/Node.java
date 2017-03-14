import lombok.Getter;
import lombok.Setter;

public class Node<T extends Comparable<T>> {
    @Getter
    @Setter
    private Node<T> parent;

    private T leftValue;
    private T rightValue;
    private T middleValue;
    private Node<T> left;
    private Node<T> middle;
    private Node<T> secondMiddle;
    private Node<T> right;

    @Getter
    @Setter
    private NodeType type;

    public Node(T value) {
        type = NodeType.TwoNode;
        leftValue = value;
    }

    private Node(T value, Node<T> left, Node<T> right) {
        type = NodeType.TwoNode;
        leftValue = value;
        this.left = left;
        this.right = right;
    }

    public Node<T> convertFourNode(Node<T> parentNode) {
        if (parentNode == null) {
            parentNode = new Node<>(
                    this.getFourNodeMiddleValue());
        } else parentNode.addToNodeWithComparation(
                this.getFourNodeMiddleValue(), null, null);

        Node<T> leftNode = new Node<>(
                this.getFourNodeLeftValue(),
                this.getFourNodeLeft(),
                this.getFourNodeMiddleLeft()
        );
        Node<T> rightNode = new Node<>(
                this.getFourNodeRightValue(),
                this.getFourNodeMiddleRight(),
                this.getFourNodeRight()
        );

        leftNode.setAllChildsParent(leftNode);
        rightNode.setAllChildsParent(rightNode);
        parentNode.setTwoNodeLeft(leftNode);
        parentNode.setTwoNodeRight(rightNode);


        this.setParent(null);
        this.setFourNodeLeft(null);
        this.setFourNodeRight(null);
        this.setFourNodeMiddleLeft(null);
        this.setFourNodeMiddleRight(null);

        return parentNode;
    }

    public void addToNodeWithComparation(T val, Node<T> valLeftChild, Node<T> valRightChild) {
        if (type == NodeType.FourNode)
            throw new UnsupportedOperationException("this is 4-node");

        if (type == NodeType.ThreeNode) {
            if (val.compareTo(rightValue) > 0) {
                middleValue = rightValue;
                rightValue = val;
                middle = right;
                secondMiddle = valLeftChild;
                right = valRightChild;
            } else if (val.compareTo(leftValue) < 0) {
                middleValue = leftValue;
                leftValue = val;
                secondMiddle = left;
                left = valLeftChild;
                middle = valRightChild;
            } else {
                middleValue = val;
                middle = valLeftChild;
                secondMiddle = valRightChild;
            }
            type = NodeType.FourNode;
            return;
        }

        if (type == NodeType.TwoNode) {
            if (val.compareTo(leftValue) < 0) {
                rightValue = leftValue;
                leftValue = val;
                middle = left;
                left = null;
            } else {
                rightValue = val;
            }
            type = NodeType.ThreeNode;
        }
    }


    private void setAllChildsParent(Node<T> parent) {
        if (left != null) left.setParent(parent);
        if (middle != null) middle.setParent(parent);
        if (secondMiddle != null) secondMiddle.setParent(parent);
        if (right != null) right.setParent(parent);
    }

    public Node<T> getTwoNodeLeft() {
        if (!type.equals(NodeType.TwoNode))
            throw new UnsupportedOperationException();
        return left;
    }

    public Node<T> getTwoNodeRight() {
        if (!type.equals(NodeType.TwoNode))
            throw new UnsupportedOperationException();
        return right;
    }

    public T getTwoNodeValue() {
        if (!type.equals(NodeType.TwoNode))
            throw new UnsupportedOperationException();
        return leftValue;
    }

    public void setTwoNodeLeft(Node<T> node) {
        if (!type.equals(NodeType.TwoNode))
            throw new UnsupportedOperationException();
        left = node;
        if (left != null)
            left.setParent(this);
    }

    public void setTwoNodeRight(Node<T> node) {
        if (!type.equals(NodeType.TwoNode))
            throw new UnsupportedOperationException();
        right = node;
        if (right != null)
            right.setParent(this);
    }

    public void setTwoNodeValue(T value) {
        if (!type.equals(NodeType.TwoNode))
            throw new UnsupportedOperationException();
        this.leftValue = value;
    }


    public Node<T> getThreeNodeLeft() {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        return left;
    }

    public Node<T> getThreeNodeRight() {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        return right;
    }

    public Node<T> getThreeNodeMiddle() {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        return middle;
    }

    public void setThreeNodeLeft(Node<T> node) {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        left = node;
        if (left != null)
            left.setParent(this);
    }

    public void setThreeNodeRight(Node<T> node) {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        right = node;
        if (right != null)
            right.setParent(this);
    }

    public void setThreeNodeMiddle(Node<T> node) {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        middle = node;
        if (middle != null)
            middle.setParent(this);
    }

    public T getThreeNodeLeftValue() {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        return leftValue;
    }

    public void setThreeNodeLeftValue(T value) {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        this.leftValue = value;
    }

    public T getThreeNodeRightValue() {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        return rightValue;
    }

    public void setThreeNodeRightValue(T value) {
        if (!type.equals(NodeType.ThreeNode))
            throw new UnsupportedOperationException();
        this.rightValue = value;
    }


    public Node<T> getFourNodeLeft() {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        return left;
    }

    public Node<T> getFourNodeRight() {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        return right;
    }

    public Node<T> getFourNodeMiddleLeft() {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        return middle;
    }

    public Node<T> getFourNodeMiddleRight() {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        return secondMiddle;
    }

    public void setFourNodeLeft(Node<T> node) {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        left = node;
        if (left != null)
            left.setParent(this);
    }

    public void setFourNodeRight(Node<T> node) {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        right = node;
        if (right != null)
            right.setParent(this);
    }

    public void setFourNodeMiddleLeft(Node<T> node) {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        middle = node;
        if (middle != null)
            middle.setParent(this);
    }

    public void setFourNodeMiddleRight(Node<T> node) {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        secondMiddle = node;
        if (secondMiddle != null)
            secondMiddle.setParent(this);
    }

    public T getFourNodeLeftValue() {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        return leftValue;
    }

    public void setFourNodeLeftValue(T value) {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        this.leftValue = value;
    }

    public T getFourNodeRightValue() {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        return rightValue;
    }

    public void setFourNodeRightValue(T value) {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        this.rightValue = value;
    }

    public T getFourNodeMiddleValue() {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        return middleValue;
    }

    public void setFourNodeMiddleValue(T value) {
        if (!type.equals(NodeType.FourNode))
            throw new UnsupportedOperationException();
        this.middleValue = value;
    }
}