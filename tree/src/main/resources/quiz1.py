class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTree(object):
    def __init__(self, root):
        self.root = Node(root)

    def search(self, find_val):
        if self.root is not None:
            return self.preorder_search(self.root, find_val)
        return False

    def print_tree(self):
        traversal = ""
        if self.root is not None:
            traversal = self.preorder_print(self.root, traversal)
        return traversal

    def preorder_search(self, start, find_val):
        if start.value is find_val:
            return True
        if start.left is not None:
            ret = self.preorder_search(start.left, find_val)
            if ret is True:
                return ret
        if start.right is not None:
            ret = self.preorder_search(start.right, find_val)
            if ret is True:
                return ret
        return False

    def preorder_print(self, start, traversal):
        traversal = traversal + str(start.value)
        if start.left is not None:
            traversal = traversal + "-"
            traversal = self.preorder_print(start.left, traversal)
        if start.right is not None:
            traversal = traversal + "-"
            traversal = self.preorder_print(start.right, traversal)
        return traversal

# Set up tree
tree = BinaryTree(1)
tree.root.left = Node(2)
tree.root.right = Node(3)
tree.root.left.left = Node(4)
tree.root.left.right = Node(5)

# Test search
# Should be True
print tree.search(4)
# Should be False
print tree.search(6)

# Test print_tree
# Should be 1-2-4-5-3
print tree.print_tree()