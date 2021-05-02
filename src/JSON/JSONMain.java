package JSON;

public class JSONMain {
    public static void main(String[] args) {
        Person person = DeserializeJSON.getPersonFromJSON();
        System.out.println(person);
    }
}
