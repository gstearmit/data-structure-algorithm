package ir.sk.datastructure.linklist;

/**
 * In a sorted list, the items are arranged in sorted order by key value.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SortedLinkList<T extends Comparable> {

    private Link<T> first;                 // ref to first item

    public SortedLinkList() {
        first = null;
    }

    public boolean isEmpty()            // true if no links
    {
        return (first == null);
    }

    public void insert(T key)        // insert, in order
    {
        Link<T> newLink = new Link(key);    // make new link
        Link<T> previous = null;            // start at first
        Link<T> current = first;
        // until end of list,
        while (current != null && key.compareTo(current.data) > 0) {                             // or key > current,
            previous = current;
            current = current.next;       // go to next item
        }
        if (previous == null)               // at beginning of list
            first = newLink;              // first --> newLink
        else                             // not at beginning
            previous.next = newLink;      // old prev --> newLink
        newLink.next = current;          // newLink --> old currnt
    }  // end insert()

    public Link<T> remove()           // return & delete first link
    {                           // (assumes non-empty list)
        Link<T> temp = first;               // save first
        first = first.next;              // delete first
        return temp;                     // return value
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while (current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
}
