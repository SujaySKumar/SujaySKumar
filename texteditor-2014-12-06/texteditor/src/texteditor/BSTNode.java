/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

/**
 *
 * @author Kumar BN
 */
 class BSTNode
     {
         BSTNode left, right;
         String  nameClass;
         int r,g,b;
         /* Constructor */
         public BSTNode()
         {
             left = null;
             right = null;
             nameClass="";
           
         }

         /* Constructor */
         public BSTNode(String  s, int r, int g, int b)
         {
             left = null;
             right = null;
             nameClass=s;
             this.r=r;
             this.b=b;
             this.g=g;
         }

        /* Function to set left node */
         public void setLeft(BSTNode n)
         {
             left = n;
         }

         /* Function to set right node */ 
         public void setRight(BSTNode n)
         {
             right = n;
         }

         /* Function to get left node */
         public BSTNode getLeft()
         {
             return left;
         }

         /* Function to get right node */
         public BSTNode getRight()
         {
             return right;
         }

         /* Function to set data to node */
         public void setName(String d)
         {
             nameClass = d;
         }
         public int getRed(){
             return r;
         }
          public int getGreen(){
             return r;
         }
           public int getBlue(){
             return r;
         }
         /* Function to get data from node */
         public String getData()
         {
             return nameClass;
         }
        
     }
