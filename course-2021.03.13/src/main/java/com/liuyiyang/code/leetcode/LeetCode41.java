package com.liuyiyang.code.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode41 {
    public static void main(String[] args) {
        boolean[] array = new boolean[5];
        System.out.print(array);
        countLargestGroup(13);
    }

    public int maximalSquare(char[][] matrix) {
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0 && j > 0) {
                    matrix[i][j] = (char) (Math.min(matrix[i - 1][j - 1] - '0', Math.min(matrix[i - 1][j] - '0', matrix[i][j - 1] - '0')) + matrix[i][j]);
                }
                maxLength = Math.max(maxLength, matrix[i][j] - '0');
            }
        }
        return maxLength * maxLength;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 每一层的结果
        List<List<Integer>> levels = new ArrayList();
        // 队列，先进先出，根节点为第一层
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层的遍历结果
            List<Integer> currentLevel = queue.stream().map(node -> node.val).collect(Collectors.toList());
            levels.add(currentLevel);
            // 添加下一层
            for (int i = 0; i < currentLevel.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return levels;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public List<Integer> traversal(TreeNode node, List<Integer> res) {
        if (node == null) {
            return res;
        }
        traversal(node.left, res);
        res.add(node.val);
        traversal(node.right, res);
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 遍历当前节点时，先看看有没有左节点，有的话，先遍历左节点
            TreeNode node = stack.peek();
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }

            // 没有更左的了，从栈中取出栈顶结点，遍历
            node = stack.pop();
            res.add(node.val);

            // 遍历完，再看看该节点有没有右子树，有的话，先遍历右子树，再遍历父节点
            if (node.right != null) {
                // 把右子树的根节点压入栈顶
                stack.push(node.right);
            }
        }

        return res;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence == null) {
            return sentence;
        }
        dictionary.sort((o1, o2) -> o1.length() - o2.length());
        String[] sentences = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            for (String root : dictionary) {
                if (sentences[i].startsWith(root)) {
                    sentences[i] = root;
                    break;
                }
            }
            sb.append(sentences[i]);
        }
        return sb.toString();
    }

    public String sortString(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = map.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder(charArray.length);
        for (int i = 0, increase = 1; ; i += increase) {
            char c = list.get(i);
            if (map.containsKey(c)) {
                sb.append(c);
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
            if (map.isEmpty()) {
                return sb.reverse().toString();
            }
            if (i == 0 && increase == -1 || i == list.size() - 1 && increase == 1) {
                increase = -increase;
            }
        }
    }

    public int arrangeCoins(int n) {
        int k = Double.valueOf(Math.sqrt(2 * n + 0.25) - 0.5).intValue();
        while (k * (k + 1) / 2 < n) {
            k++;
        }
        return k;
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> line = new ArrayDeque<>();
        line.offer(root);
        Queue<Node> nextLine = new ArrayDeque<>();
        while (!line.isEmpty()) {
            Node left = line.poll();
            Node right = line.peek();
            left.next = right;
            if (left.left != null) {
                nextLine.offer(left.left);
            }
            if (left.right != null) {
                nextLine.offer(left.right);
            }
            if (line.isEmpty()) {
                line = nextLine;
            }
        }
        return root;
    }

    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap();
        while (n > 0) {
            int val = calculate(n--);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int maxValue = 0, size = 0;
        for (Integer value : map.values()) {
            if (value > maxValue) {
                maxValue = value;
                size = 1;
            } else if (value == maxValue) {
                size++;
            }
        }
        return size;
    }

    private static int calculate(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
