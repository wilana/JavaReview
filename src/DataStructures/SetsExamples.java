package DataStructures;

import java.util.*;

public class SetsExamples {
    public static void main(String[] args) {
        HashSet<String> companyNames = new HashSet<>();
        companyNames.add("IBM");
        companyNames.add("Apple");
        companyNames.add("Google");
        companyNames.add("Apple");

        System.out.println(companyNames);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("IBM");
        treeSet.add("Apple");
        treeSet.add("Google");
        treeSet.add("Apple");
        System.out.println(treeSet);

        //using our simple Student class
        Student st1 = new Student("Cam", 1001);
        Student st2 = new Student("Sky", 1002);
        Student st3 = new Student("Anita",1003);

        TreeSet<Student> students = new TreeSet<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);

        System.out.println(students);

        ArrayList<Student> arrayListOfStudents = new ArrayList<>();
        arrayListOfStudents.add(st1);
        arrayListOfStudents.add(st2);
        arrayListOfStudents.add(st3);
        System.out.println("ArrayList: "+arrayListOfStudents);
        Collections.sort(arrayListOfStudents);
        System.out.println("Sorted ArrayList: "+arrayListOfStudents);

        Collections.sort(arrayListOfStudents, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getStudentNum(),s2.getStudentNum());
            }
        });
        System.out.println("Sorted ArrayList: "+arrayListOfStudents);
        Collections.sort(arrayListOfStudents, Comparator.comparingDouble(Student::getAvgGrade));
        System.out.println(arrayListOfStudents);
    }
}
