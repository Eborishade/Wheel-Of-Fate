package original;

/**
 * @since Jan 24, 2020
 * @author Emmanuel Borishade
 * 
 *         Program Description: Custom Linked List using ENodes
 * 
 *         Program Objective: Create a working linked list of Strings that can
 *         be applied anywhere using Nodes that keep track of both head and
 *         tail.
 * 
 *         see javadocs for list of methods
 */

public class EList implements List210{
 private ENode head;
 private ENode tail;

 //Default ctor
 public EList(){}

 //copy ctor
 public EList(EList l){
    if (l == null){
        head = tail = null;
    } else {
        int length = l.numItems();
        ENode n; 
        for (int x = 1; x <= length; x++){
            n = new ENode(l.get(x));

            if (head == null){
                head = n;
                tail = n; 
            } else {
            
            n.setPrev(tail);
            tail.setNext(n);
            tail = n;
            }
        }
    }
    
 }

 
 /** 
  * @param str
  */
 //methods to add nodes to the list
 public void addToEnd(String str){
    ENode n = new ENode(str);

    //if the list is empty, head and tail point to new node
    if (head == null){
        head = n;
        tail = n; 
    } else {
        //otherwise, since we are adding to the end, tail points to n, n points to tail,
        //then tail is set to n
        //because n points to previous instance of tail, garbage collection leaves it alone!
        n.setPrev(tail);
        tail.setNext(n);
        tail = n;
    }
 }
 

 /** 
  * @param str
  */
 public void addToBeginning(String str){
    ENode n = new ENode(str);

    //if the list is empty, head and tail point to new node
    if (head == null){
        head = n;
        tail = n; 
    } else {
        //otherwise, since we are adding to the end, tail points to n, n points to tail,
        //then tail is set to n
        //because n points to previous instance of tail, garbage collection leaves it alone!
        n.setNext(head);
        head.setPrev(n);
        head = n;
    }
 }



// getting or finding methods
 
 /** 
  * @param str
  * @return boolean
  */
 public boolean get(String str){
    ENode node = head;
    while (node != null){
        if ( node.getVal().equals(str) ){
            return true;
        }
        node = node.getNext(); 
    }
    return false; 
 }
 

 /** 
  * @param i
  * @return String
  */
 public String get(int i){ //works like an array, 0 is first
    if (head == null){
        return "";
    }
    ENode node = head;
    for (int x = 1; x < i; x++){
        node = node.getNext(); 
    }
    return node.getVal(); 
 }
 

 /** 
  * @return String
  */
 public String getFirst(){
     if (head == null){
         return "";
     }
    return head.getVal();
 }
 

 /** 
  * @return String
  */
 public String getLast(){
    if (head == null){
        return "";
    }
    return tail.getVal();
 }



 // removal methods; return true if successful
 
 /** 
  * @param str
  * @return boolean
  */
 public boolean remove( String str){
    ENode node = head;
    ENode prev;
    ENode next;

    //if empty
    if (head == null){
        return false;
    }

    //if node is only node
    if (node.getVal().equals(str)){
        head = null;
        return true;
    }

    //will check to see if the str is in the list
    while ( node != null && !(node.getVal().equals(str)) ){
        node = node.getNext();
    }
    if (node == null){
        return false;
    } else {
        prev = node.getPrev();
        next = node.getNext();

        //if node is in between 2 nodes
        if (prev != null && next != null){
            prev.setNext(next);
            next.setPrev(prev);
        }
        //if prev == null, node was the head, next is new head
        else if (prev == null){
            next.setPrev(null);
            head = next;
        }
        //if next == null, node was tail, prev is new tail
        else if (next == null){
            prev.setNext(null);
            tail = prev;
        }
        return true;
    }
 }

 

 
 /** 
  * @param i
  * @return boolean
  */
 public boolean remove(int i){
    ENode node = head;
    ENode prev;
    ENode next;
    int size = numItems();

    if (i > size){
        return false;
    }   //if empty

    if (head == null){
        return false;
    }

    //if node is only node
    if (head.getNext()==null){
        head = null;
        return true;
    }

    //node is now at position i
    for (int x = 1; x < i; x++){
        node = node.getNext(); 
    }

    if (node == null){
        return false;
    } else {
        prev = node.getPrev();
        next = node.getNext();

        if (prev != null && next != null){
            prev.setNext(next);
            next.setPrev(prev);
        }
        //if prev == null, node was the head, next is new head
        else if (prev == null){
            next.setPrev(null);
            head = next;
        }
        //if next == null, node was tail, prev is new tail
        else if (next == null){
            prev.setNext(null);
            tail = prev;
        }
        return true;
       
    }
 }



 // etc - fun methods without a category
 
 /** 
  * @return int
  */
 public int numItems(){
    ENode node = head;
    int items = 0;
    while (node != null){
        items++;
        node = node.getNext();
    }
    return items;
 }


 public void clear(){
    head = null;
    tail = null;
 }


 public void reverse(){
    // node's next will point to prev, and prev will point to temp
    //temp will be value originally after node
    // moving left to right, temp is furthest right at all times
    if (tail != null){
        ENode temp = tail;
        ENode node = tail.getPrev(); 

        tail.setNext(node);
        tail.setPrev(null);
        head = tail;
        
        while (node != null){
            temp = tail;
            node.setNext(node.getPrev());
            node.setPrev(temp);
            tail = node;
            node = node.getNext();
        }
    }
 }

 
 /** 
  * @return boolean
  */
 public boolean isEmpty(){
     if (head == null && tail == null){
         return true;
     }
     return false;
 }

 
 /** 
  * @return String
  */
 public String toString(){
    if(head == null){
        return "";
    }

    ENode printer = head;
    String toReturn = "[";

    //will stop one before final so as to fix formatting
    while (printer.getNext() != null){
        toReturn+= printer.getVal() + ", ";
        printer = printer.getNext();
    }
    //one more value must be added to be complete
    toReturn+= printer.getVal();

    return toReturn+"]";    
 }





//Status: Working! No errors found

}