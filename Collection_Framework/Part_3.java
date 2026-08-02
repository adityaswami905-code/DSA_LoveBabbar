package DSA_LoveBabbar.Collection_Framework;

import java.security.Key;
import java.util.*;

public class Part_3 {

     public static void main() {

         Map<String, String> mapping = new HashMap<>();

         mapping.put("in","India");
//         mapping.put("in","India_2");
         mapping.put("en","England");
         mapping.put("us","United States");

         System.out.println(mapping);

         Map<String,String> table = new HashMap<>();

         table.put("br","Brazil");
         System.out.println("Before: "+table);
         table.putAll(mapping);
         System.out.println("After: "+table);

         System.out.println(table.containsValue("England"));

         table.remove("en");
         System.out.println(table);
         System.out.println(table.size());

//         table.clear();
//         System.out.println(table.size());
         table.putIfAbsent("sa","South Africa");
         System.out.println(table);

         System.out.println(table.get("in"));
         System.out.println(table.getOrDefault("sa","NONE"));

         System.out.println(table.containsKey("sa"));
         System.out.println(table.containsValue("Brazil"));

         table.replace("in","Indonesia");
         System.out.println(table);

         Set<String> keySet = table.keySet();
         System.out.println(keySet);

          Collection<String> valueSet =  table.values();
         System.out.println(valueSet);

         Set<Map.Entry<String,String>> entrySet = table.entrySet();
         System.out.println(entrySet);

         List<Student> student = new ArrayList<>();

         student.add(new Student(20,"Vijay",69));
         student.add(new Student(21,"Aditya",75));
         student.add(new Student(19,"Sumit",55));
         student.add(new Student(19,"Rahul",70));

         System.out.println(student);

//         Collections.sort(student);

//           Collections.sort(student, new Comparator<Student>() {
//               @Override
//               public int compare(Student o1, Student o2) {
//                   return o1.weight - o2.weight;
//               }
//           });

         Collections.sort(student,new  WeightComparator());

         // Also lambda expression is use i.e.
//         Collections.sort(student,(o1,o2) -> return o1.weight-o1.weight);

         System.out.println(student);


    }
}
