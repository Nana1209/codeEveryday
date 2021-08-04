import java.util.Deque;
import java.util.LinkedList;

class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack=new LinkedList<>();
        TreeNode node=root;
        while(node!=null){
            stack.addFirst(node);
            node=node.left;
        }
    }

    public int next() {
        TreeNode node=stack.removeFirst();
        TreeNode nr=node.right;
        while(nr!=null){
            stack.addFirst(nr);
            nr=nr.left;
        }
        return node.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
