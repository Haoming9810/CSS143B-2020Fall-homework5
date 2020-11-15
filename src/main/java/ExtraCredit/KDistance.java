package ExtraCredit;

import Problem1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KDistance {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> output = new ArrayList<>();
        findTargetDepth(output, root, target, K, 0);
        return output;
    }

    private static int findTargetDepth(List<Integer> output, TreeNode root, TreeNode target, int k, int depth) {
        if (root == null) {
            return -1;
        }

        if (root == target) {
            // collect all nodes under target node within dist k
            collectNodes(output, root, k);
            return depth;
        }

        // search left
        int targetDepth = findTargetDepth(output, root.left, target, k, depth + 1);
        if (targetDepth != -1) {
            // is current node at the dist K from target
            if ((targetDepth - depth) == k) {
                output.add((Integer) root.val);
            } else {
                // collect nodes on the right side
                collectNodes(output, root.right, k - (targetDepth - depth) - 1);
            }
            return targetDepth;
        }

        // if not found, search right
        targetDepth = findTargetDepth(output, root.right, target, k, depth + 1);
        if (targetDepth != -1) {
            // is current node at the dist K from target
            if ((targetDepth - depth) == k) {
                output.add((Integer) root.val);
            } else {
                // collect nodes on the left side
                collectNodes(output, root.left, k - (targetDepth - depth) - 1);
            }
            return targetDepth;
        }

        // not found
        return -1;
    }

    private static void collectNodes(List<Integer> output, TreeNode root, int k) {
        if (root == null || k < 0) {
            return;
        }

        if (k-- == 0) {
            output.add((Integer) root.val);
            return;
        }

        collectNodes(output, root.left, k);
        collectNodes(output, root.right, k);
    }
}
