package Problem3;

import Problem1.TreeNode;

public class InsertInBST {
    public static TreeNode<Integer> insert(TreeNode<Integer> root, int valToInsert) {
        if (root == null)
            return new TreeNode(valToInsert);


        if (valToInsert > root.val)
            root.right = insert(root.right, valToInsert);

        else
            root.left = insert(root.left, valToInsert);
        return root;

    }
}
