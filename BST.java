// implement your code in this file
import java.util.*;
public class BST extends BinTree{
    public BST(){
        super();
    }

    public void insertNode(int node){
        BinNode newNode = new BinNode(node);
        if (this.root == null) {
            this.root = newNode;            
        } else {
            insertNode(this.root, newNode);
        }
    }

    private void insertNode(BinNode parent, BinNode newNode){
        if (parent.node < newNode.node) {
            if (parent.rightChild == null) {
                parent.rightChild = newNode;
            } else {
                insertNode(parent.rightChild, newNode);
            }
        } else if (parent.node > newNode.node) {
            if (parent.leftChild == null) {
                parent.leftChild = newNode;
            } else {
                insertNode(parent.leftChild, newNode);
            }
        }
    }
}
