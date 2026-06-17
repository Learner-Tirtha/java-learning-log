/*
Concepts Practiced:
1. ArrayList
2. List Interface
3. Comparable
4. Collections.sort()
5. equals()
6. toString()
7. add(), addAll()
8. remove(), removeAll()
9. contains()
10. get(), set()
11. indexOf()
12. ListIterator
13. Forward and backward traversal
14. Lambda expressions with forEach()
15. Priority Queue
*/
package CoreJava;

import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
public class Collection {
    public static void main(String[] args) {

        // ArrayList implementation of List interface.
        // Stores Player objects dynamically.
        List<Player> Team1 = new ArrayList<>();

        // add(E element)
        // Adds elements at the end of the list.
        Team1.add(new Player("Alice", 123, 45, 14, 1));
        Team1.add(new Player("Bob", 123, 67, 12, 2));
        Team1.add(new Player("Charli", 145, 67, 17, 3));

        List<Player> Team2 = new ArrayList<>();

        Team2.add(new Player("Alice", 123, 45, 14, 1));
        Team2.add(new Player("Bay", 123, 27, 10, 4));
        Team2.add(new Player("Telusko", 145, 37, 12, 5));

        // removeAll(Collection<?> c)
        // Removes all elements from Team1 that are equal
        // to any element in Team2.
        // Uses equals() internally.
        Team1.removeAll(Team2);

        // forEach()
        // Executes the given lambda expression for each element.
        // method of Iteratable interface
        Team1.forEach(P1 -> System.out.println(P1));

        System.out.println("-------");

        // addAll(int index, Collection<? extends E> c)
        // Inserts all elements of Team2 at index 0.
        // Existing elements are shifted to the right.
        Team1.addAll(0, Team2);

        // Collections.sort(List<T>)
        // Sorts the list using compareTo() method
        // defined in Comparable<Player>.
        // It provides the natural ordering 
        //Use compartor by passing the lambda expression in argument override the accept 
        // method of customer functional interface used by compartor
        Collections.sort(Team1);

        Team1.forEach(P1 -> System.out.println(P1));

        // add(int index, E element)
        // Inserts an element at the specified position.
        // Elementin it position shifted right.
        Team1.add(2, new Player("Kim", 125, 45, 15, 6));

        // set(int index, E element)
        // Replaces the element at the specified index.
        // Does not change list size.
        Team1.set(0, new Player("Alien", 53, 34, 9, 7));

        // contains(Object o)
        // Checks whether an equal object exists in the list.
        // Uses equals() internally.
        boolean B = Team1.contains(
                new Player("Kim", 125, 45, 15, 8));

        System.out.println("Output Of Contains: " + B);

        Team1.forEach(P1 -> System.out.println(P1));

        // get(int index)
        // Returns the element at the specified index.
        System.out.println(Team1.get(2).toString());

        // remove(int index)
        // Removes element at index 0.
        // Remaining elements shift left.
        Team1.remove(0);

        Team1.forEach(p1 -> System.out.println(p1));

        // remove(Object o)
        // Removes the first matching object.
        // Uses equals() internally.
        Team2.remove(new Player("Telusko", 145, 37, 12, 5));

        // indexOf(Object o)
        // Returns the index of the first matching element.
        // Returns -1 if not found.
        // Uses equals() internally.
        int index = Team1.indexOf(
                new Player("Kim", 125, 45, 15, 6));

        System.out.println(index);

        // listIterator(int index)
        // Creates a bidirectional iterator.
        // Starting at Team1.size() means iterator starts
        // after the last element, allowing reverse traversal.
        
        Iterator<Player>Iter1=Team1.iterator();
        while(Iter1.hasNext())
        {
            Player p1=Iter1.next();
            if(p1.equals(new Player("Telusko", 145, 37, 12, 5)))
            {
                Iter1.remove();
            }

        }
        ListIterator<Player> Iter =
                Team1.listIterator(Team1.size());
        // hasPrevious()
        // Returns true if there is an element before
        // the current iterator position.
        while (Iter.hasPrevious()) {

            // previous()
            // Moves iterator backward and returns element.
            Player P1 = Iter.previous();

            if (P1.equals(
                    new Player("Alice", 123, 45, 14, 1))) {

                // remove()
                // Removes the last element returned by
                // previous() or next().
                // Safe way to remove while iterating.
                Iter.remove();
            }
        }

        Team1.forEach(p1 -> System.out.println(p1));
    
    //ListIterator also has method nextIndex and perviousIndex method

    // PriorityQueue
// Stores elements according to priority rather than insertion order.
// Here players with higher experience (exp) get higher priority.
Queue<Player> pq =
        new PriorityQueue<>(
                (P1, P2) -> Float.compare(P2.exp, P1.exp)
        );

// offer(E e)
// Inserts an element into the queue.
// Returns true if insertion succeeds.
pq.offer(new Player("Tirtha", 4.5f));
pq.offer(new Player("Krisha", 5.6f));

// add(E e)
// Also inserts an element into the queue.
// Similar to offer() for PriorityQueue.
// if it unable to add throw Exception
pq.add(new Player("Rahul", 3.6f));
pq.add(new Player("Tinu", 2.3f));
pq.add(new Player("Raj", 3.8f));

// iterator()
// Returns an iterator for traversing the queue.
// IMPORTANT:
// PriorityQueue iterator does NOT guarantee priority order.
// It traverses the internal heap structure.
Iterator<Player> It = pq.iterator();

while (It.hasNext()) {
    System.out.println(It.next().exp);
}

// poll()
// Returns and removes the highest-priority element.
// Returns null if queue is empty.
System.out.println(pq.poll());

// remove()
// Returns and removes the highest-priority element.
// Throws NoSuchElementException if queue is empty.
System.out.println(pq.remove());

// peek()
// Returns the highest-priority element without removing it.
// Returns null if queue is empty.
System.out.println(pq.peek());

// element()
// Returns the highest-priority element without removing it.
// Throws NoSuchElementException if queue is empty.
System.out.println(pq.element());

// isEmpty()
// Returns true if the queue contains no elements.
// it is come from collection interface 
System.out.println(pq.isEmpty());

// size()
// Returns the number of elements currently in the queue.
//it is also comes from collection interface 
System.out.println(pq.size());

Deque<Player>tt=new ArrayDeque<>();
tt.addFirst(new Player("Raju",6.7f));
tt.addLast(null);
    
    }
    
}


class Player implements Comparable<Player> {

    String Name;
    double Height;
    double Weight;
    int Age;
    int ID;
    float exp;
    // Constructor
    // Initializes Player object.
    Player(String Name, double Height,
           double Weight, int Age, int ID) {

        this.Name = Name;
        this.Height = Height;
        this.Weight = Weight;
        this.Age = Age;
        this.ID = ID;
    }
    Player(String Name,float exp) {

        this.Name = Name;
        this.exp=exp;
    }

    // toString()
    // Returns a string representation of the object.
    // Automatically called by println().
    @Override
    public String toString() {
        return Name ;
    }

    // equals(Object obj)
    // Defines logical equality for Player objects.
    // Two players are considered equal if their IDs match.
    // Used by contains(), remove(), removeAll(), indexOf().
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Player))
            return false;

        Player Temp = (Player) obj;

        return Temp.ID == this.ID;
    }

    // compareTo(Player p)
    // Defines natural ordering of Player objects.
    // Collections.sort() uses this method.
    // Players are sorted by Weight in ascending order.
    @Override
    public int compareTo(Player P) {
        return Double.compare(this.Weight, P.Weight);
    }


}