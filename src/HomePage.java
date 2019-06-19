import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class HomePage
{

    static HashMap<Integer, Mcq> mathMcq = new HashMap<Integer, Mcq>();
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    //Creating New Stage
    Stage homeStage = new Stage();

    public void displayHome()
    {
        homeStage.setTitle("Home Page");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);



        //Creating New Scene
        Scene homeScene = new Scene(grid, 600, 400);

        //Home Text
        Text homeText = new Text("Automatic Quiz Test Generator");
        HBox homeTextHbox = new HBox(10);
        homeTextHbox.getChildren().add(homeText);
        GridPane.setConstraints(homeTextHbox, 0,0, 3, 1);
        homeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        //Options Label
        Label options = new Label("Options: ");
        GridPane.setConstraints(options, 0, 3);
        options.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));


        //Edit button
        Button editBtn = new Button("Edit Questions");
        GridPane.setConstraints(editBtn, 1, 4);
        editBtn.setOnAction( e -> {
            EditQns edit = new EditQns();
            homeStage.close();
            edit.editingDuplicate(homeStage);
        });


        //Generate Test Button
        Button generateBtn = new Button("Generate Test ");
        GridPane.setConstraints(generateBtn, 1, 5);
        generateBtn.setOnAction( e -> {
            GenerateTest generateTest = new GenerateTest();
            homeStage.close();
            generateTest.generate(homeStage);


        });

        //logout button
        Button logoutBtn = new Button("LogOut");
        GridPane.setConstraints(logoutBtn, 3, 6);
        logoutBtn.setOnAction( e -> {
            homeStage.close();
        });


        grid.getChildren().addAll(homeTextHbox, options, editBtn, generateBtn, logoutBtn);





        homeStage.setScene(homeScene);

    }

    public Stage returnStage()
    {
        displayHome();
        return homeStage;
    }

    public void display()
    {
        try
        {
            FileInputStream fis = new FileInputStream("/home/bhanu/Documents/sample.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int i=1;

                mathMcq = (HashMap)ois.readObject();
                i++;

            ois.close();
            fis.close();


        }
        catch (Exception e)
        {
            System.out.println("Exception: "+ e);
        }
        displayHome();
        homeStage.show();
    }
}
