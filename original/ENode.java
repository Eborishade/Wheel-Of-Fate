package original;

/**
* @since Jan 24, 2020 
* @author Emmanuel Borishade
*
*Program Description: Node for a Linked List 
*
*Program Objective:
* Create a Node for use in a Linked List of Strings
*/
public class ENode{ 
 private String current;
 private ENode next;
 private ENode prev;

 public ENode(String c){
     current = c;
 }

 
 /** 
  * @param n
  */
 public void setNext(ENode n){
     next = n;
 }
 
 /** 
  * @param p
  */
 public void setPrev(ENode p){
     prev = p;
 }


  /** 
  * @return String
  */
 public String getVal(){
     return current;
 }

 /** 
  * @return ENode
  */
 public ENode getNext(){
     return next;
 }
 
 /** 
  * @return ENode
  */
 public ENode getPrev(){
     return prev;
 }
  
}