package SubClasses;

import java.util.*;

public class ExampleTesting {
    public static void main(String[] args) {
        HashSet<Person> friends = new HashSet<>();
        ArrayList<Person> arrayList = new ArrayList<>();

        NewStudent sky1 = new NewStudent("Sleepy","Guy","705-555-1234",1001);
        NewStudent jacob = new NewStudent("Quick","Thinker","426-455-8763", 999);
        NewStudent stella = new NewStudent("Ella","OneHundred","905-455-8763", 998);
        sky1.addCourse("COMP 1011", 78);
        stella.addCourse("COMP 1030", 100);
        stella.addCourse("COMP 1008", 100);
        stella.addCourse("COMP 1011", 99);

        friends.add(sky1);
        arrayList.add(sky1);

        ArrayList<NewStudent> underGrads = new ArrayList<>();
        underGrads.add(sky1);
        underGrads.add(jacob);
        underGrads.add(stella);

        UnderGradComparator ugc = new UnderGradComparator();
        System.out.println(underGrads);
        Collections.sort(underGrads, ugc);
        System.out.println(underGrads);

        //anonymous inner class - we do not give the class a name
        Collections.sort(underGrads, new Comparator<NewStudent>() {
            @Override
            public int compare(NewStudent s1, NewStudent s2) {
                return s1.getLastName().compareTo(s2.getLastName());
            }
        });
        System.out.println(underGrads);

        //lamba expression IS an anonymous inner class, but with removal
        //of the redundant pieces.  These only work for functional interfaces.
        //a Functional interface has only 1 method
        Collections.sort(underGrads, Comparator.comparingInt(s -> s.getCourses().keySet().size()));
        // |-> was originally (underGrads, (s1, s2) -> {
        //            return s1.getCourses().keySet().size() -
        //                    s2.getCourses().keySet().size();});
        System.out.println(underGrads);


        TreeSet<NewStudent> classList = new TreeSet<>();
        classList.add(sky1);
        classList.add(jacob);

    }
}
