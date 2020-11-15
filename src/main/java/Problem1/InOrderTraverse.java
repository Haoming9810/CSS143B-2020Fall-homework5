package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        // homework
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while(p!=null){
            stack.push(p);
            p=p.left;
        }

        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            result.add((Integer) t.val);

            t = t.right;
            while(t!=null){
                stack.push(t);
                t = t.left;
            }
        }

        return result;
    }
}
