/**
  OrderedList_inArraySlots, holding Integers
  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        return indexOf_Recursive(findMe, 0, list_iAS.size() - 1);
        // return indexOf_WhileStyle(findMe);
    }

    public int indexOf_Recursive(Integer findMe, int low, int high) {
        int index = (low + high) / 2;
        int result = list_iAS.get(index).compareTo(findMe);

        if (result == 0) return index;

        else if (high <= low) return -1;

        else if (result == -1) return indexOf_Recursive(findMe, index + 1, high);
        else return indexOf_Recursive(findMe, low, index - 1);
    }

    public int indexOf_WhileStyle(Integer findMe) {
        int low = 0;
        int high = list_iAS.size() - 1;

        while (low <= high) {
            int index = (low + high) / 2;
            int result = list_iAS.get(index).compareTo(findMe);

            if (result == 0) return index;
            else if (result == -1) low = index + 1;
            else high = index - 1;
        }
        return - 1;
    }


    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.
      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).
      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
