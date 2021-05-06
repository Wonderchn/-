package com.hongna.leetcode.Tree.BinarySearchTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST <E extends Comparable<E>>{
    private class Node{
        private E e;
        private Node left, right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);

    }

    //向以node为根的二分搜索树中插入元素E,递归算法
    //  返回插入新节点后  当前二分搜索树的根
    private Node add(Node node, E e){
        if (node == null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e)<0){
           node.left =  add(node.left, e);
        }
        // e. compartTo(node.e) >0
        else if(e. compareTo(node.e) >0)
            {
            node.right = add(node.right,e);

        }
        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 此方法表明的是在以当前的node为根的二叉树下查询 e的值
     * 如果查到 返回true
     * 否则 false
     * @param node
     * @param e
     * @return
     */
    public boolean contains(Node node , E e){
        if (node == null){
            return false;
        }
        if (e.compareTo(node.e) < 0){
            return contains(node.left, e);

        }
        else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }
        else {
            return contains(node.right,e);
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q .isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left !=null){
                q.add(cur.left);
            }
            if (cur.right != null){
                q.add(cur.right);
            }
        }
    }
    public E miniMum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return miniMum(root).e;
    }
    //寻找二分搜索树的最小元素
    private Node miniMum(Node node){
        if (node .left == null){
            return node;
        }
        return miniMum(node.left);
    }

    public E miniMumNR(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return miniMumNR(root).e;
    }

    private Node miniMumNR(Node node){

        while (node .left != null){
            Node cur ;
            node = node.left;
        }
      return node;

    }

    //寻找二分搜索树的最大元素
    public E maxiMum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxiMum(root).e;
    }

    //返回以Node为根的耳根搜索树的最大值所在的节点
    private Node maxiMum(Node node){
        if(node.right == null){
            return node;
        }
        return maxiMum(node.right);
    }

    /**
     * 删除二分搜索树最小节点，返回最小值
     * @return
     */
    public E removeMin(){
        E ret = miniMum();
        root = removeMin(root);
        return ret;
    }


    //删除掉以node为根的二分搜索树的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node . left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值最大节点
    public E removeMax(){
        E ret = maxiMum();
        root = removeMax(root);
        return ret;
    }
    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节点新的二分搜索树的根
    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node .right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
       root =  remove(root,e);
    }

    private Node remove(Node node,E e){
        if (node == null){
            return null;
        }
        if (e.compareTo(node.e) < 0){
           node.left= remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e) >0){
            node.right = remove(node.right, e);
            return node;
        }
        else{
            // e == node.e
            //此时删除node节点
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size -- ;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size -- ;
                return leftNode;

            }

            //待删除节点自由子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = miniMum(node.right);
            successor.right = removeMin(node.right);

            size ++;
            successor.left = node.left;

            node.left = node.right = null;
            size -- ;

            return successor;
        }
    }


    // 二分搜索树的谦虚遍历
    public void preOrder(){
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node){
        //递归中止
        if (node == null){
            return;
        }

        // 分解成更小的解决问题
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //二分搜索树的非递归前序遍历
    private void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrder(){
        inOrder(root);
    }


    /**
     * 此方法是说 在以node为根的二叉树中 中序遍历()
     * @param node
     */
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if (node == null){
            res.append("null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e +"\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }


    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i <depth;i++){
            res.append("--");
        }
        return res.toString();

    }
}
