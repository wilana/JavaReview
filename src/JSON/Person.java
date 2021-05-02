package JSON;

public class Person {
    private String name;
    private int age;
    private String[] hobbies;
    private boolean isProfessor;

    public Person(String name, int age, String[] hobbies, boolean isProfessor) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.isProfessor = isProfessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public boolean isProfessor() {
        return isProfessor;
    }

    public void setProfessor(boolean professor) {
        isProfessor = professor;
    }
}
