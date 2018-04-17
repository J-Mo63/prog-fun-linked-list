/**
 * This class maintains an arbitrary length list of integers.
 * 
 * In this version:
 * 1. The size of the list is *VARIABLE* after the object is created.
 * 2. The code assumes there is at least one element in the list.
 * 
 * This class introduces the use of structural recursion.
 * 
 * @author Raymond Lister 
 * @version May 2016
 * 
 */
public class ListOfNVersion03
{   
    private int thisNumber;              // the number stored in this node
    private ListOfNVersion03 next;  // forms a linked list of objects

    private final int nodeID;            // a unique ID for each object in the list

    private static int nodeCount = 0;    // the number of list objects that have been created

    /**
     * @param  num   the value to be stored in this object
     */
    public ListOfNVersion03(int num)
    {
        thisNumber = num;
        next = null;

        ++nodeCount;
        nodeID = nodeCount;

    } // constructor(int num)

    /**
     * @param  num   the multiple values to be stored in the list, in that order
     */
    public ListOfNVersion03(int [] num)
    {
        this(num[0]);  // in this context, "this" invokes the other constructor        

        for (int i=1 ; i<num.length ; ++i)
            insertLast(num[i]);

    } // constructor(int [] num)

    /**
     * @return     the number of elements stored in this list 
     */
    public int getListSize()
    {
        if ( next == null )
            return 1;
        else
            return 1 + next.getListSize();

    } // method getListSize

    /**
     * @return     the last element in the list
     */
    public int getLast()
    {
        if ( next == null )
            return thisNumber;
        else
            return next.getLast();

    } // method getLast

    /**
     * prints this object
     */
    public void printNode()
    {
        System.out.print("[" + nodeID + "," + thisNumber + "]->");

    } // method printNode
    
    /**
     * prints this object and moves to a new line
     */
    public void printNodeLn()
    {
        printNode();
        System.out.println();

    } // method printNodeLn

    /**
     * prints the tail of a list
     */
    private void printListTail()
    {
        printNode();

        if ( next != null )
            next.printListTail();

    } // method printListTail

    /**
     * prints the contents of the list, in order from first to last
     */
    public void printList()
    {
        printNode();

        if ( next != null )
            next.printListTail();

    } // method printList

    /**
     * This method is NOT examinable in this test.
     * 
     * prints the contents of the list, in order from first to last, and
     * then moves the cursor to the next line
     */
    public void printlnList()
    {
        printList();
        System.out.println();

    } // method printlnList

    /**
     * @return     the number of times the element occurs in the list
     * 
     * @param  element   the element to be counted
     */
    public int countElement(int element)
    {
        int tailCount = 0; 

        if ( next != null )
            tailCount = next.countElement(element);

        if ( thisNumber == element )
            return 1 + tailCount;
        else
            return tailCount;

    } // method countElement 

    /**
     * @return     the number of times the replacement was made
     * 
     * @param  replaceThis   the element to be replaced
     * @param  withThis      the replacement
     */
    public int replaceAll(int replaceThis, int withThis)
    {
        int replaceCount = 0; 

        if ( next != null )
            replaceCount = next.replaceAll(replaceThis, withThis);

        if ( thisNumber == replaceThis )
        {
            thisNumber = withThis;
            return 1 + replaceCount;
        }
        else
            return replaceCount;

    } // method replaceAll

    /**
     * @return a reference to the first object in the list that contains the parameter value, or null if it is not found
     * 
     * @param  findThis   the value to be found
     */
    public ListOfNVersion03 findUnSorted(int findThis)
    {  
        // This algorithm is known as "linear search"

        if ( thisNumber == findThis )
            return this;

        if ( next != null )
            return next.findUnSorted(findThis);

        return null;

    } // method findUnSorted 

    /**
     * @return     the reference to the object containing the smallest element in the list
     */
    public ListOfNVersion03 minRef()
    {
        // add and/or modify code to complete the method 
        ListOfNVersion03 minOfTail;

        if ( next == null )
            return this;

        minOfTail = next.minRef();

        if ( thisNumber <= minOfTail.thisNumber )
            return this; 
        else
            return minOfTail;

    } // method minRef

    /**
     * Inserts an element in the last position. The pre-existing elements in the
     * list are unaffected.
     * 
     * @param  newElement   the element to be inserted
     */
    public void insertLast(int newElement)
    { 
        if ( next == null )
            next = new ListOfNVersion03(newElement);
        else
            next.insertLast(newElement);

    } // method insertLast

    /**
     * stringifies this object
     */
    public String toStringNode()
    {
        return "[" + nodeID + "," + thisNumber + "]->";

    } // method toStringNode


    /**
     * form a string from the tail of a list
     */
    private String toStringTail()
    {
        String s = toStringNode();

        if ( next != null )
            s = s + next.toStringTail();

        return s;

    } // method toStringTail

    /**
     * @return     A summary of the contents of the whole list.
     */
    public String toString()
    {
        String s = toStringNode();

        if ( next != null )
            s = s + next.toStringTail();

        return s;

    } // method toString

    /**
     * @return     the sum of the elements of the array
     */
    public int sum()
    {
        // add and/or modify code to complete the method 

        if ( next == null )
            return thisNumber;
        else
            return thisNumber + next.sum();

    } // method sum 

    /**
     * @return     the number of times the replacement was made (i.e. 0 or 1)
     * 
     * @param  replaceThis   the element to be replaced
     * @param  withThis      the replacement
     */
    public int replaceOnce(int replaceThis, int withThis)
    {        
        // add and/or modify code to complete the method 

        if ( thisNumber == replaceThis )
        {
            thisNumber = withThis;
            return 1;
        }

        if ( next != null )
            return next.replaceOnce(replaceThis, withThis);
        else
            return 0;

    } // method replaceOnce 

    /**
     * @return     the value of the smallest element in the list
     */
    public int minVal()
    {
        // add and/or modify code to complete the method 
        int minOfTail;

        if ( next == null )
            return thisNumber;

        minOfTail = next.minVal();

        if ( thisNumber <= minOfTail )
            return thisNumber; 
        else
            return minOfTail;

    } // method minVal

    /**
     * Inserts an element in the first position. The elements already in the
     * list are pushed up one place.
     * 
     * @param  newElement   the element to be inserted
     */
    public void insertFirst(int newElement)
    {  
        ListOfNVersion03 temp = new ListOfNVersion03(thisNumber);
        temp.next = next;
        next = temp;
        thisNumber = newElement;

    } // method insertFirst
    
    /**
     * Inserts an element into a sorted list. NOTE: The pre-existing elements in the
     * list are sorted and the list remains sorted (ascending order).
     * 
     * @param  newElement   the element to be inserted
     */
    public void insertSorted(int newElement)
    { 

        if ( next == null )
        {
            next = new ListOfNVersion03(newElement);
        }
        else
        {
            next.insertSorted(newElement);
        }
        
        if (thisNumber > next.thisNumber){
                int temp = next.thisNumber;
                next.thisNumber = thisNumber;
                thisNumber = temp;
        }

    } // method insertSorted

    /**
     * No change if there is only one element in the list. Otherwise, it moves up one place all
     * elements in the list, by overwriting each "thisNumber" with "next.thisNumber", thus
     * removing the first value in the list. The last node in the list is removed.
     */
    public void shuffleUp()
    {
        
        if (next == null){
            //Nothing doing
        }
        else if ( next.next == null )
        {
            thisNumber = next.thisNumber;
            next = null;
        }
        else
        {
            thisNumber = next.thisNumber;
            next.shuffleUp();
        }
            
    } // method shuffleUp

    /*
     * @return     the number of deletions made (i.e. 0 or 1)
     * 
     * @param  element       the element to be deleted
     * @param  predecessor   a reference to the previous node in the linked list
     *                       i.e. the node where "next" points to this node
     */
    private int delete2(int element, ListOfNVersion03 predecessor)
    {  
        
        if (thisNumber == element){
            
            if (next != null){
                predecessor.next = next;
            }
            else{
                predecessor.next = null;
            }
            
            return 1;
            
        }
        else{
            
            if (next != null){
                return next.delete2(element, this);
            }
            else{
                return 0;
            }
            
        }

    } // method delete2

    /**
     * @return     the number of deletions made (i.e. 0 or 1)
     * 
     * @param  element   the element to be deleted
     */
    public int delete(int element)
    {  
        if ( (thisNumber == element) && (next == null) )
        {
            System.out.println("Error when attempting to delete '" + element + "'. The list must contain at least one element");
            return 0;
        }

        if ( thisNumber == element )
        {
            // if thisNumber == element is true then the first "if" statement implies that next != null
            thisNumber = next.thisNumber;
            next = next.next;
            return 1;
        }

        if ( next == null )
        {
            // if next == null is true then the first "if" statement implies that thisNumber != element
            return 0;
        }

        return next.delete2(element, this);

    } // method delete


} // class ListOfNVersion03