package org.example;

class AVLTree<K extends Comparable<K>, V>{

    private TreeNode<K, V> root;

    private int size;

    AVLTree(){
        this.root = null;
        this.size = 0;
    }

    public TreeNode<K, V> insert(K key, V value){
        return root = insert(root, key, value);
    }

    public TreeNode<K, V> insert(TreeNode<K, V> node, K key, V value){
        if (node == null) {
            size++;
            return new TreeNode<>(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        }else if (key.compareTo(node.key) > 0 ){
            node.right = insert(node.right, key, value);
        }
        // update height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        if (getBalanceFactor(node) == 2 && getBalanceFactor(node.left) == 1)
            // LL
            return LLRotate(node);
        if (getBalanceFactor(node) == 2 && getBalanceFactor(node.left) == -1){
            // LR
            node.left = RRRotate(node.left);
            return LLRotate(node);
        }
        if (getBalanceFactor(node) == -2 && getBalanceFactor(node.right) == 1){
            // RL
            node.right = LLRotate(node.right);
            return RRRotate(node);
        }
        if (getBalanceFactor(node) == -2 && getBalanceFactor(node.right) == -1)
            // RR
            return RRRotate(node);
        return node;
    }

    /**
     * LL型 --> 右旋
     * @param node 需要旋转的节点
     * @return 返回旋转后的树
     */
    private TreeNode<K, V> LLRotate(TreeNode<K, V> node){
        // The node is left child of @param node
        TreeNode<K, V> oldLeft = node.left;
        // The node is right child of oldLeft
        TreeNode<K, V> oldRight = oldLeft.right;
        oldLeft.right = node;
        node.left = oldRight;
        // update height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        oldLeft.height = Math.max(getHeight(oldLeft.left), getHeight(oldLeft.right)) + 1;
        return oldLeft;
    }

    /**
     * RR型 --> 左旋
     * @param node 待旋转的节点
     * @return 返回旋转后的树
     */
    private TreeNode<K, V> RRRotate(TreeNode<K, V> node){
        // The node is right child of @param node
        TreeNode<K, V> oldRight = node.right;
        // The node is left child of oldRight
        TreeNode<K, V> oldLeft = oldRight.left;
        oldRight.left = node;
        node.right = oldLeft;
        // update height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        oldRight.height = Math.max(getHeight(oldRight.left), getHeight(oldRight.right)) + 1;

        return oldRight;
    }

    /**
     * 获取平衡因子
     * @param node 待处理的节点
     * @return 平衡因子
     */
    private int getBalanceFactor(TreeNode<K, V> node){
        if(node == null) return 0;
        return getHeight(node.left)-getHeight(node.right);
    }

    /**
     * 高度
     * @param node node
     * @return height of this node
     */
    private int getHeight(TreeNode<K, V> node){
        if (node != null) return node.height;
        return -1;
    }

    /**
     * 获取节点
     */
    public TreeNode<K, V> getNode(K key){
        return getNode(root, key);
    }

    public TreeNode<K, V> getNode(TreeNode<K, V> node, K key){
        
    }
}
class TreeNode<K extends Comparable<K>, V>{
     K key;

     V value;

     TreeNode<K, V> left;

     TreeNode<K, V> right;

     int height;

    TreeNode(K key, V value){
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }


}

public class AVL<K extends Comparable<? super K>, V>{
    public static void main(String[] args) {
        AVLTree<Integer, String> avlTree= new AVLTree<>();
        avlTree.insert(3,"a");
        avlTree.insert(2,"b");
        avlTree.insert(1,"c");
        System.out.println(avlTree);
    }
}