package DSA_LoveBabbar.Collection_Framework;

import java.util.*;

public class Basics{

   public  static void main(String[] args) {

//       List<Integer> list = new ArrayList<>();
       ArrayList<Integer> list = new ArrayList<>();
//       Collection<Integer> list = new ArrayList<>();

       list.add(10);
       list.add(20);
       list.add(30);
       System.out.println(list);
       list.add(40);
       System.out.println(list);

       list.remove(2);
       System.out.println(list);

       ArrayList<Integer> list2 = new ArrayList<>();
       list2.add(101);
       list2.add(102);

       list2.add(20);
       System.out.println(list2);
       list.addAll(list2);
       System.out.println(list);

       list.removeAll(list2);
       System.out.println(list);

       list2.clear();
       System.out.println(list2);

       System.out.println(list.size());

//       I want to traverse list using iterator

       Iterator<Integer> iterator = list.iterator();

       while(iterator.hasNext()){
           System.out.println("Element: "+ iterator.next());
       }

       List<Integer> list3 = new ArrayList<>();
       list3.add(100);
       list3.add(17);
       list3.add(18);
       System.out.println(list3.get(2));

       list3.set(0,3);
       System.out.println(list3);

       //toArray

       Object[] arr = list3.toArray();
       for(Object obj : list3){
           System.out.println(obj);
       }

       System.out.println(list3.contains(17));

       list.add(7);
       System.out.println("Printing entire list: "+list);
       list.add(45);
       System.out.println("Printing list: "+list);
       Collections.sort(list);
       System.out.println("After sorting: "+list);
       Collections.reverse(list);
       System.out.println("In desc: "+ list);


       ArrayList<Integer> newlist = (ArrayList<Integer>) list.clone();
       System.out.println("Printing clone new list: "+ newlist);

       ArrayList<Integer> marks = new ArrayList<>();
       marks.ensureCapacity(100);

       System.out.println(list.contains(45));
       System.out.println(marks.isEmpty());

//       Similarly with linked list
//       LinkedList<Integer> list1 = new LinkedList<>();

//       Also
//        Vector<Integer> vec = new Vector<>();

//       And stack with its respective method by using
//       Stack<Integer> st = new Stack<>();
       
//       Deque is faster than Stack, stack is slow so in modern java we use deque because it's act both queue and stack so most of the people prefer deque to get better performance...
    }
}