package com.soft.bst;

import java.util.Comparator;

/**
 * 二分搜索树
 */
public class BST<E extends Comparable<E>>{

    private class Node{
        E e;
        Node left,right;
        Node(E e){
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node,E e){
        if (node == null){
            size++;
            node = new Node(e);
        }
        if (e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }else if (e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e) {

        if (node==null){
            return false;
        }

        if (e.compareTo(node.e)==0){
            return true;
        }else if (e.compareTo(node.e)>0){
            return contains(node.right,e);
        }else{
            return contains(node.left,e);
        }

    }


    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    /**
     * 找到树的最小值
     * @return
     */
    public E miniMum(){
        if (size==0){
            throw new IllegalArgumentException("tree is empty");
        }

        return miniMum(root).e;
    }

    private Node miniMum(Node node){
        if (node.left == null){
            return node;
        }
       return miniMum(node.left);
    }


    /**
     * 找到树的最大值
     * @return
     */
    public E miniMax(){
        if (size==0){
            throw new IllegalArgumentException("tree is empty");
        }

        return miniMax(root).e;
    }

    private Node miniMax(Node node){
        if (node.right == null){
            return node;
        }
        return miniMax(node.right);
    }

    /**
     * 删除最小值
     */
    public E removeMin(){
        E ret = miniMum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){

        if (node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    /**
     * 删除最小值
     */
    public E removeMax(){
        E ret = miniMum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){

        if (node.right==null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }


    public void remove(E e){
        root = remove(root,e);
    }


    private Node remove(Node node,E e){
        if (node==null){
            return null;
        }
        if (e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
        }else if (e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
        }else if (e.compareTo(node.e)==0){
            //相等
            //没有左子树
            if(node.left == null){
                Node rightNode = node.right;
                size--;
                node.right = null;
                return rightNode;
            }

            //没有右子树
            if (node.right==null){
                Node leftNode = node.left;
                size--;
                node.left = null;
                return leftNode;
            }

            Node succeedNode = miniMum(node.right);
            removeMin(node.right);
            succeedNode.right =  node.right;
            succeedNode.left = node.left;
            node.left = node.right = null;
            return succeedNode;
        }
        return node;
    }




    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }


}
