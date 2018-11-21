package com.soft.bst;

import java.util.LinkedList;

/**
 * 二分搜索树
 */
public class BST<E extends Comparable<E>>{

    class Node{
        E e;
        Node left,right;
        Node(E e){
            this.e = e;
        }
    }

    public Node root;
    public int size;

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

    /**
     * 前序遍历 递归版本
     * 根->左->右
     */
    public void preOrderTraverse(Node node){
        if (node!=null){
            System.out.println(node.e);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void preOrderTraverse(){
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if (node!=null){
                System.out.println(node.e);

                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
            }
        }
    }



    /**
     * 中序遍历 递归版本
     * 左->根->右
     */
    public void inOrderTraverse(Node node){
        if (node!=null){
            inOrderTraverse(node.left);
            System.out.println(node.e);
            inOrderTraverse(node.right);
        }
    }

    /**
     * 后序遍历 递归版本
     * 左->右->根
     */
    public void postOrderTraversal(Node node){
        if (node!=null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.e);
        }
    }


    public void levelOrderTraversal(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node  node = queue.poll();
            if (node!=null){
                System.out.println(node.e);
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
            }
        }
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
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
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
