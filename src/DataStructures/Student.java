package DataStructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.OptionalDouble;

public class Student implements Comparable<Student>{
    private String name;
    private int studentNum;
    private HashMap<String, Integer> courses;

    public Student(String name, int studentNum) {
        this.name = name;
        this.studentNum = studentNum;
        courses = new HashMap<>();
    }

    public void addCourse(String courseCode, Integer grade)
    {
        if (grade >=0 && grade<= 100)
            courses.put(courseCode, grade);
    }

    public HashMap<String, Integer> getCourses() {
        return courses;
    }

    public double getAvgGrade() {
        Collection<Integer> grades = courses.values();
        OptionalDouble avg = grades.stream()
                .mapToDouble(grade -> new Double(grade))
                .average();

        if (avg.isPresent())
            return avg.getAsDouble();
        else
            return 0;
    }

    public String getAvgLetterGrade()
    {
        Double avg = getAvgGrade();
        if (avg > 80)
            return "A";
        if (avg > 70)
            return "B";
        if (avg > 60)
            return "C";
        if (avg > 50)
            return "D";
        else
            return "F";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    // +1 numbers first, 0 ties or equal, -1 numbers last (101, 102, 103)
        // no duplicate student numbers
    @Override
    public int compareTo(Student otherStudent) {
        return this.studentNum-otherStudent.studentNum;
    }

    @Override
    public String toString() {
        // note: %-10s leaves 10 spaces for the string, left justified
        return String.format("%d - %-10s, average: %.2f%%", studentNum, name, getAvgGrade());
    }
}
