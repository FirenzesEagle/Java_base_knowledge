package me.liumingbo.bases;

// AvlTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// boolean contains( x )  --> Return true if x is present
// boolean remove( x )    --> Return true if x was present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import java.nio.BufferUnderflowException;

/**
 * Created by FirenzesEagle on 2016/12/2.
 * Email:liumingbo2008@gmail.com
 */
public class AvlTree<AnyType extends Comparable<? super AnyType>> {
    private static class AvlNode<AnyType> {
        AnyType element;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height;

        //Constructors
        AvlNode(AnyType theElement) {
            this(theElement, null, null);
        }

        AvlNode(AnyType theElement, AvlNode<AnyType> it, AvlNode<AnyType> rt) {
            element = theElement;
            left = it;
            right = rt;
            height = 0;
        }
    }

    /**
     * The tree root.
     */
    private AvlNode<AnyType> root;

    private static final int ALLOWED_IMBALANCE = 1;

    public AvlTree() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if x is found.
     */
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    public void checkBalance() {
        checkBalance(root);
    }

    private int checkBalance(AvlNode<AnyType> t) {
        if (t == null)
            return -1;

        if (t != null) {
            int hl = checkBalance(t.left);
            int hr = checkBalance(t.right);
            if (Math.abs(height(t.left) - height(t.right)) > 1 ||
                    height(t.left) != hl || height(t.right) != hr)
                System.out.println("OOPS!!");
        }

        return height(t);
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the tree.
     */
    private void printTree(AvlNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return new AvlNode<AnyType>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else
            ;  // Duplicate; do nothing
        return balance(t);
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private AvlNode<AnyType> remove(AnyType x, AvlNode<AnyType> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return balance(t);
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return true if x is found in subtree.
     */
    private boolean contains(AnyType x, AvlNode<AnyType> t) {
        while (t != null) {
            int compareResult = x.compareTo(t.element);

            if (compareResult < 0)
                t = t.left;
            else if (compareResult > 0)
                t = t.right;
            else
                return true;    // Match
        }

        return false;   // No match
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     */
    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMin(root).element;
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item of null if empty.
     */
    public AnyType findMax() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMax(root).element;
    }

    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        if (height(t.left) - height((t.right)) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
            if (height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     * Update heights, then return new root.
     */
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     * Update heights, then return new root.
     */
    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root.
     */
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     * Update heights, then return new root.
     */
    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    private AvlNode<AnyType> findMin(AvlNode<AnyType> t) {
        if (t == null)
            return t;

        while (t.left != null)
            t = t.left;
        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private AvlNode<AnyType> findMax(AvlNode<AnyType> t) {
        if (t == null)
            return t;

        while (t.right != null)
            t = t.right;
        return t;
    }

    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    // Test program
    public static void main(String[] args) {
        AvlTree<Integer> t = new AvlTree<>();
        final int SMALL = 40;
        final int NUMS = 1000000;  // must be even
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            //    System.out.println( "INSERT: " + i );
            t.insert(i);
            if (NUMS < SMALL)
                t.checkBalance();
        }

        for (int i = 1; i < NUMS; i += 2) {
            //   System.out.println( "REMOVE: " + i );
            t.remove(i);
            if (NUMS < SMALL)
                t.checkBalance();
        }
        if (NUMS < SMALL)
            t.printTree();
        if (t.findMin() != 2 || t.findMax() != NUMS - 2)
            System.out.println("FindMin or FindMax error!");

        for (int i = 2; i < NUMS; i += 2)
            if (!t.contains(i))
                System.out.println("Find error1!");

        for (int i = 1; i < NUMS; i += 2) {
            if (t.contains(i))
                System.out.println("Find error2!");
        }
    }
}
