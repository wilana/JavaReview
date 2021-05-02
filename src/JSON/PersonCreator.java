package JSON;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class PersonCreator implements InstanceCreator {
    @Override
    public Object createInstance(Type type) {
        String[] hobbies = {"photos"};
        return null;    // Could return person
    }
}
