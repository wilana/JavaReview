package DataStructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class DataStructExample {
    public static void main(String[] args) {

        Student st1 = new Student ("st1", 101);
        Student st2 = new Student ("st2", 102);
        Student st3 = new Student ("st3", 103);
        Student st4 = new Student ("st4", 104);


        // COLLECTIONS - Represents a group of objects,
        //          unsynchronized (efficient for single thread, otherwise wrap Collections.sychronizedList(list) )
        //

        /* LISTS (Unordered collection)
            - Allows for duplicate objects
            - Objects are stored in order added, unless specific position is specified

            ArrayList: good for accessing elements, but not adding in any location
            LinkedList: good for adding elements anywhere, but slow to traverse (need to reach element before to find)
            */

        // Add
        // addAll
        // remove
        // removeAll
        // sorting
        // Binary Search: only works on sorted list, if negative - not found, otherwise returns the index number
        // Sequential Search:

        /* SETS (don't allow duplicate objects, NO ORDER)
            HashSet: like an ArrayList but no duplicates (in hashed order - thus not predictable)
            TreeSet: like an ordered HashSet (note use of Comparator interface in custom class)
         */

        // Hashsets:
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(st1, st2, st3, st4));
        hashSet.remove(st2);


      // TreeSets: The student class implements Comparable<Student> in this example, which requires a compareTo() method that needs
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(st1);


        /* MAPS (unique keys are associated to values)
            - OneToOne: if both keys and values are unique
            - OneToMany: if only the keys are unique

            HashMap: not sorted, unique key with a value
            TreeMap: sorted by keys
         */
        /* Hash Map (combine key value pairs)

         */

        /* Tree Map
         */





        // INTERFACES

        /*
            SUBCLASS
                - inherits all non-abstract methods and instance variables

            INTERFACE
                - Defines what methods a class must have

             Functional Interfaces
                - only 1 abstract method
                - Examples:
                    Predicate ( 1 argument = boolean )
                    Consumer ( 1 argument = consumed/no return )
                    Function ( 1 argument = a result )
                    Supplier ( 0 arguments = result )
                    UnaryOperator ( 1 argument = single value )
                    BinaryOperator ( 2 arguments = return 1 )

            Anonymous Inner Class
                - Like an EventListener or ActionEvent
                - An unnamed class, defined within it's usage (same file, no name)
                - good to use with a lambda
                    -> lambda is a method without a name (anonymous method)
         */

    }
}
