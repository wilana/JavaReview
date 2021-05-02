package Streams;

import DataStructures.Student;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamsExample {
    public static void main(String[] args) {
        Student st1 = new Student ("st1", 101);
        Student st2 = new Student ("st2", 102);
        Student st3 = new Student ("st3", 103);
        Student st4 = new Student ("st4", 104);

        /* Streams: a sequence of elements that perform tasks
            - a tighter way to analyze rather than a for loop
            - works well with multithreaded applications
            - requires functional interfaces
         */

        // A stream can be created from a List or Array
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(st1, st2, st3, st4));

        // give students random grade
        SecureRandom sr = new SecureRandom();
        for (Student student:arrayList)
        {
            student.addCourse("Comp1030", sr.nextInt(30)+70);
            student.addCourse("Comp1008", sr.nextInt(30)+70);
            student.addCourse("Comp1011", sr.nextInt(30)+70);
        }

        // Average
        OptionalDouble avgGrade = arrayList.stream()    // stream created
                .mapToDouble(Student::getAvgGrade)      // pipeline
                .average();     // TERMINAL OPERATION (also a reduction bc it reduces stream to one element)

        if (avgGrade.isPresent())
            System.out.printf("The average grade for all students is %.2f%%%n" + avgGrade.getAsDouble());

        // Creating stream from array
        Student[] array = {st1, st2, st3, st4};
        // Count of Students containing "st"
        Arrays.stream(array)    // builds stream
                // Predicate = something that is true or false
                .filter(student -> student.getName().contains("st"))    // removes students that don't match
                .count();   // terminal


        // Display all names
        arrayList.stream()
                .map(Student::getName)  // will convert stream from one data type to another
                .forEach(System.out::println);


        /*
            employees with salary of at least $2500
            Arrays.stream(employees)    .filter (e -> e.getSalary() >= 2500)
                                        .map(Employee::getName)
                                        .sorted()
                                        .forEach(System.out::println);
         */
        // Filter is a predicate
    }
}

