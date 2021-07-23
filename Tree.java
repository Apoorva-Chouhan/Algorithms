/* Class containing left and right child of current
node and key value*/
class Node
{
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

class Tree
{
	// Root of Binary Tree
	Node root;
	// Constructors
	Tree(int key)
	{
		root = new Node(key);
	}
	Tree()
	{
		root = null;
	}
	public static void main(String[] args)
	{
		Tree tree = Tree.getTree();
		System.out.println("tree root " + tree.root.key);
	}

	public static Tree getTree() {
		Tree tree = new Tree();
		/*create root*/
		tree.root = new Node(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
				/* final tree is 
					1
				  /	  \
				2		 3
			   / \	    / \
			  4   5    6   7
		
		*/
		return tree;
	}
}
