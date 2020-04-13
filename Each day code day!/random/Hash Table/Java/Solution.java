/*

For this exercise, you should write a hash table in which both the keys and 
the values are of type String. (This is not an exercise in generic programming; 
do not try to write a generic class.) Write an implementation of hash tables from scratch. 
Define the following methods: get(key), put(key,value), remove(key), containsKey(key), and size().
 Remember that every object, obj, has a method obj.hashCode() that can be used for computing a 
 hash code for the object, so at least you don't have to define your own hash function. 
 Do not use any of Java's built-in generic types; create your own linked lists using nodes as covered in Subsection 
9.2.2. However, you are not required to increase the size of the table when it becomes too full.


*/

public class Solution {
    public static void main(String[] args) {

        HashTable table = new HashTable(2); // Initial size of table is 2.
        String key, value;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("   1. test put(key,value)");
            System.out.println("   2. test get(key)");
            System.out.println("   3. test containsKey(key)");
            System.out.println("   4. test remove(key)");
            System.out.println("   5. show complete contents of hash table.");
            System.out.println("   6. EXIT");
            System.out.print("Enter your command:  ");
            switch (TextIO.getlnInt()) {
                case 1:
                    System.out.print("\n   Key = ");
                    key = TextIO.getln();
                    System.out.print("   Value = ");
                    value = TextIO.getln();
                    table.put(key, value);
                    break;
                case 2:
                    System.out.print("\n   Key = ");
                    key = TextIO.getln();
                    System.out.println("   Value is " + table.get(key));
                    break;
                case 3:
                    System.out.print("\n   Key = ");
                    key = TextIO.getln();
                    System.out.println("   containsKey(" + key + ") is " + table.containsKey(key));
                    break;
                case 4:
                    System.out.print("\n   Key = ");
                    key = TextIO.getln();
                    table.remove(key);
                    break;
                case 5:
                    table.dump();
                    break;
                case 6:
                    return; // End program by returning from main()
                default:
                    System.out.println("   Illegal command.");
                    break;
            }
            System.out.println("\nHash table size is " + table.size());
        }
    }

}



public class HashTable {
    /**
     * Keys that have the same hash code are placed together in a linked list. This
     * private nested class is used internally to implement linked lists. A ListNode
     * holds a (key,value) pair.
     */

    private static class ListNode {
        String key;
        String value;
        ListNode next;
    }

    private ListNode[] table; // The hash table, represented as
                              // an array of linked lists.
    private int count;

    public HashTable() {
        table = ListNode[64];
    }

    public HashTable(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Illegal table size");
        table = ListNode[capacity];
    }

    // looking up the table
    void dump(){
        System.out.println();
        for(int i=0; i< table.length;i++){
            System.out.print(i+":");
            ListNode list = table[i]; // for traversing list at each index
            whlie(list!==null){
                System.out.print("  (" + list.key + "," + list.value + ")");
                list = list.next;
             }
             System.out.println();
            }
        }

    }

    /**
     * Associate the specified value with the specified key. Precondition: The key
     * is not null.
     */
    public void put(String key, String value) {
        assert key != null : "The key must be non-null";
        int bucket = hash(key);

        ListNode list = table[bucket];

        while (list != null) {
            // search the nodes in the lists
            if (list.key.equals(key))
                break;
            list = list.next;
        }

        // At this point, either list is null, or list.key.equals(key).

        if (list != null) {
            list.value = value;
        } else {
            // Since list == null, the key is not already in the list.
            // Add a new node at the head of the list to contain the
            // new key and its associated value.

            if (count > 0.75 * table.length) {
                resize();
                bucket = hash(key); // since it depends on table length;
            }
            // begin a new list
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;
            count++;

        }
    }

    /**
     * Retrieve the value associated with the specified key in the table, if there
     * is any. If not, the value null will be returned.
     * 
     * @param key The key whose associated value we want to find
     * @return the associated value, or null if there is no associated value
     */

    public void get(String key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return list.value;
            list = list.next;
        }

        return null;
    }

    public void remove(String key) {
        int bucket = hash(key);

        if (table[bucket] == null) {
            return null;
        }

        if (table[bucket].key.equals(key)) {
            // If the key is the first node on the list, then
            // table[bucket] must be changed to eliminate the
            // first node from the list.
            table[bucket] = table[bucket].next;
            count--;
            return;
        }

        // We have to remove a node from somewhere in the middle
        // of the list, or at the end. Use a pointer to traverse
        // the list, looking for a node that contains the
        // specified key, and remove it if it is found.

        ListNode prev = table[bucket]; // The node that precedes
                                       // curr in the list. Prev.next
                                       // is always equal to curr.
        ListNode curr = prev.next; // For traversing the list,
                                   // starting from the second node.
        while (curr != null && !curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }

        /*
         * If we get to this point, then either curr is null,or curr.key is equal to
         * key. In the latter case, we have to remove curr from the list. Do this by
         * making prev.next point to the node after curr, instead of to curr. If curr is
         * null, it means that the key was not found in the table, so there is nothing
         * to do.
         */

        if (curr != null) {
            prev.next = curr.next;
            count--;
        }
    }

    /**
     * Test whether the specified key has an associated value in the table.
     * 
     * @param key The key that we want to search for.
     * @return true if the key exists in the table, false if not
     */
    public void containsKey(String key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }
        return false;
    }

    /**
     * Return the number of key/value pairs in the table.
     */
    public int size() {
        return count;
    }

    /**
     * Compute a hash code for the key; key cannot be null. The hash code depends on
     * the size of the table as well as on the value returned by key.hashCode().
     */
    private int hash(Object key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

    /**
     * Double the size of the table, and redistribute the key/value pairs to their
     * proper locations in the new table.
     */
    private void resize() {
        ListNode[] newtable = new ListNode[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            // Move all the nodes in linked list number i into the new table.
            // No new ListNodes are created. The existing ListNode for each
            // key/value pair is moved to the newtable. This is done by
            // changing the "next" pointer in the node and by making a pointer
            // in the new table point to the node.
            ListNode list = table[i]; // For traversing linked list number i.
            while (list != null) {
                // Move the node pointed to by list to the new table.
                ListNode next = list.next; // The is the next node in the list.
                // Remember it, before changing the value of list!
                int hash = (Math.abs(list.key.hashCode())) % newtable.length;
                // hash is the hash code of list.key that is
                // appropriate for the new table size. The
                // next two lines add the node pointed to by list
                // onto the head of the linked list in the new table
                // at position number hash.
                list.next = newtable[hash];
                newtable[hash] = list;
                list = next; // Move on to the next node in the OLD table.
            }
        }
        table = newtable; // Replace the table with the new table.
    } // end resize()

}
