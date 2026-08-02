package DSA_LoveBabbar.Collection_Framework;

import java.util.*;

public class Part_2 {

     public static void main() {

         Queue<Integer> q = new LinkedList<>();
//         q.add(10);
//         q.add(20);
//         q.add(30);
//         Instead of add() most people prefer to the offer() because in case of add we have to handle the exception from user side, specially in case of dsa
         q.offer(10);
         q.offer(20);
         q.offer(30);
         System.out.println(q);

//         Insted of element()[Returns the head of the queue] most people prefer to the peek() same reason i.e. exception handling
         System.out.println("Head element present in queue is: "+q.peek());

//         Instead of remove()[returns and removes the head of the queue] prefer to the poll() due to exception handling
         System.out.println("Head element removed: "+q.poll());
         System.out.println(q);

         Deque<Integer> d = new ArrayDeque<>();
         d.offer(7);
         d.offer(3);
         d.offerFirst(17);
         d.offer(21);
         d.offerLast(18);

         System.out.println(d);

         System.out.println(d.peek());

         System.out.println(d.poll());
         System.out.println(d.pollFirst());
         System.out.println(d.pollLast());

         Deque<Integer> stack = new ArrayDeque<>();
         stack.push(10);
         stack.push(20);
         stack.push(30);
         stack.push(40);
         stack.push(50);
         System.out.println(stack);

         stack.pop();
         System.out.println(stack);
         System.out.println(stack.peek());

//         Sets cannot contains Duplicate Elements
         Set<Integer> set = new HashSet<>();
         set.add(10);
         set.add(10);
         set.add(10);
         set.add(20);
         set.add(30);
         set.add(30);
         System.out.println(set);

//         METHODS -> add(), addAll(), iterator(), remove(), removeAll(), retainAll(), clear(), size(), contains(), containsAll(), toArray(), hashCode()

//         HashSet -> O(1) {Random order of elements};
//         LinkedHashSet -> O(n) {Order of elements are maintained};
//         TreeSet -> O(logn) {Elements are arranged in sort order};

         Set<Integer> set1 = new HashSet<>();
         Set<Integer> set2 = new HashSet<>();

         set1.add(1);
         set1.add(2);
         set1.add(3);
         set1.add(4);

         set2.add(3);
         set2.add(4);
         set2.add(5);
         set2.add(6);

         System.out.println(set1);
         set1.retainAll(set2);
         System.out.println(set1);

         System.out.println(set2);
         System.out.println(set1.containsAll(set2));
    }
}
