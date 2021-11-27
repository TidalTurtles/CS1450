
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

    //comparitor
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

    } //compare / parrot class

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

        return true;

    } //insert / Binary tree class

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
