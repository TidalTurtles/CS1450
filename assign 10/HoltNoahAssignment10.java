
/*Noah Holt
 * CS1450 Data Structures
 * Tues/Thurs Section
 * Due 2 Dec
 * Assignment 10 (Last One!)
 * This assignment is to explore binary trees and using one to create a song from a 
 * secret file for the parrots. Each one will enter the tree (as birds due) and from 
 * there, we will read the tree the lyrics each bird has.
 *
 * Step 1: create the tree
 * 
 * Step 2: create parrot objects and put in tree
 * 
 * Step 3: print song by traversing tree in level order
 * 
 * Step 4: print names of leaf node parrots
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

 public class HoltNoahAssignment10 {

    public static void main(String[] args) throws IOException {


    } // main method / assignment class

 } //assignment class


 class Parrot {

    //private variables
    private int id;
    private String name;
    private String songPhrase;

    //constructor
    public Parrot(int id, String name, String songPhrase) {

        //set private vars to incoming values
        this.id = id;
        this.name = name;
        this.songPhrase = songPhrase;

    } //constructor parrot / parrot class

    //name getter
    public String getName() {
        return name;
    } //name getter / parrot class

    //song getter
    public String sing() {
        return songPhrase;
    } // song getter / parrot class

    
    public int compareTo(Parrot otherParrot) {
        int compared;

        if(id > otherParrot.id) {
            compared = 1;
        } else if (id < otherParrot.id) {
            compared = -1;
        } else {
            compared = 0;
        }
        return compared;
    }

 } //parrot Class

class BinaryTree {

    //private variables
    private TreeNode root;

    //constructor
    public BinaryTree() {

        root = null;

    } //binary tree method / binary tree class

    //insert parrot
    public boolean insert(Parrot addMe) {

        if(root == null) {
            root.parrot = addMe;
        } else {

            //place holder nodes
            TreeNode parent = null;
            TreeNode current = root;

            //where to place
            while(current.left != null || current.right != null) {

                //determine which way
                if(addMe.compareTo(current.parrot) < 0) { 
                    //going left
                    parent = current;
                    current = current.left;
                } else if(addMe.compareTo(current.parrot) > 0) {
                    //going right
                    parent = current;
                    current = current.right;
                } else {
                    //found duplicate
                    return false;
                }

            } //while not at bottom

            TreeNode creating = new TreeNode(addMe);

            if(addMe.compareTo(parent.parrot) < 0) {
                //place left
                parent.left = creating;
            } else {
                //place right
                parent.right = creating;
            } //place where belongs
            
            
        } // else not putting in root

        return true;

    } //insert / Binary tree class

    public void levelOrder() {

        if(root != null) {

            Queue<TreeNode> treeQueue = new LinkedList<>();
            treeQueue.offer(root);

            while(!treeQueue.isEmpty()) {

                TreeNode placeHolder = treeQueue.remove();
                System.out.println(placeHolder.parrot.sing());

                if(placeHolder.left != null) {
                    treeQueue.offer(placeHolder.left);
                } //maybe add left

                if(placeHolder.right != null) {
                    treeQueue.offer(placeHolder.right);
                } //maybe add right

            } //while not empty

        } //if elements in tree

    } //level order / binary tree class

    public void visitLeaves() {

        

    } //public visit leaves / binary trees class

    private void visitLeaves(TreeNode aNode) {



    } //Private visit leaves / binary tree class

    //private inner node class
    private class TreeNode {

        //private variables
        private Parrot parrot;
        private TreeNode left;
        private TreeNode right;

        //constructor
        public TreeNode(Parrot parrot) {

            this.parrot = parrot;
            left = null;
            right = null;

        } //tree node method / tree node class

    } //private tree node class

} //Binary tree class
