package codedSolutions.trees;

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
    public Node() {
        key = Integer.MIN_VALUE;
        left = right = null;
    }
}

class Basictree
{
    // Root of Binary Tree
    Node root;
    // Constructors
    Basictree(int key)
    {
        root = new Node(key);
    }
    Basictree()
    {
        root = null;
    }
    public static void main(String[] args)
    {
        Basictree basictree = Basictree.getTree();
        System.out.println("tree root " + basictree.root.key);
    }

    public static Basictree getTree() {
        Basictree basictree = new Basictree();
        /*create root*/
        basictree.root = new Node(1);

        basictree.root.left = new Node(2);
        basictree.root.right = new Node(3);
        basictree.root.left.left = new Node(4);
        basictree.root.left.right = new Node(5);
        basictree.root.right.left = new Node(6);
        basictree.root.right.right = new Node(7);
				/* final tree is
					1
				  /	  \
				2		 3
			   / \	    / \
			  4   5    6   7

		*/
        return basictree;
    }
}
