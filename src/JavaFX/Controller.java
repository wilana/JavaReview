package JavaFX;

import DataStructures.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

public class Controller implements Initializable {

    // Make sure to fill in the ?
    @FXML
    private ListView<Student> listView;

    @FXML
    private VBox vBox;

    @FXML
    private Label avgGradeLabel;

    @FXML
    private Label bestStudentLabel;

    @FXML
    private Button button;

    // implement initializable to load items into views
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // listView.getItems()
        getStudents();

        updateScene();

        // create dynamic check boxes - 1) get all letter grades
        List<String> letterGrades = listView.getItems().stream()
                            .map(Student::getAvgLetterGrade)
                            .distinct()     // instead of set, only allow unique
                            .sorted()       // get in alphabetical order
                            .collect(Collectors.toList());

        for (String letterGrade : letterGrades)
        {
            vBox.getChildren().add(new CheckBox("Grade " + letterGrade));
        }

        for (Node node: vBox.getChildren())
        {
            ((CheckBox) node).setSelected(true);    // all are selected by default
        }


        //LAMBDA LISTENERS:

        /*
        comboBox.getSelectionModel ().selectedItemProperty.addListener(
            ((observableValue, oldValue, selectedValue) -> {updateLabels();});
         */

    }

    public void updateScene()
    {
        avgGradeLabel.setText(String.format("Average Grade: %.2f%%",
                listView.getItems().stream()
                        .mapToDouble(Student::getAvgGrade)
                        .average().getAsDouble()));


    }

    private void getStudents()
    {
        Student st1 = new Student ("st1", 101);
        Student st2 = new Student ("st2", 102);
        Student st3 = new Student ("st3", 103);
        Student st4 = new Student ("st4", 104);

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
        OptionalDouble avgGrade = arrayList.stream()
                .mapToDouble(Student::getAvgGrade)
                .average();

        listView.getItems().addAll(arrayList);
    }
}
