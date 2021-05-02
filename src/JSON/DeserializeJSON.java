package JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class DeserializeJSON {

    // step 1 : import from maven (com.google.code.gson:gson:2.8.6)


    public static Person getPersonFromJSON()
    {
        Person person = null;

        // try with resources = object created in () auto closes
        try (
                // File Reader starts at root, requires relative path to file
                FileReader fileReader = new FileReader("src/JSON/example.json");
                JsonReader jsonReader = new JsonReader(fileReader);

                )
        {
            // trying to validate person - loop over if array
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Person.class, new PersonCreator());

            // back to normal, get gson, get info
            Gson gson = new Gson();
            person = gson.fromJson(jsonReader, Person.class);
        }catch (Exception e){

        }

        return person;
    }
}
