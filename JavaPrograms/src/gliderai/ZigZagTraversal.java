package gliderai;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class ZigZagTraversal {

    public static int[] getLevelSpiral(TreeNode root) {
        if (root == null)
            return new int[0];

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // Start with left to right

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> levelNodes = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    levelNodes.addLast(node.val); // Left to Right
                } else {
                    levelNodes.addFirst(node.val); // Right to Left
                }

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            result.addAll(levelNodes);
            leftToRight = !leftToRight; // Toggle direction
        }

        return result.stream().mapToInt(i -> i).toArray(); // Convert List to int[]
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of edges

        Map<Integer, TreeNode> nodes = new HashMap<>();
        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            char direction = sc.next().charAt(0); // 'L' or 'R'

            nodes.putIfAbsent(parent, new TreeNode(parent));
            nodes.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = nodes.get(parent);
            TreeNode childNode = nodes.get(child);

            if (direction == 'L') {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            if (root == null)
                root = parentNode;
        }

        sc.close();
        int[] zigzagOrder = getLevelSpiral(root);
        System.out.println(Arrays.toString(zigzagOrder));
    }

}
