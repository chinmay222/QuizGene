import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class InsertBox
{

    //Creating editStage
    Stage insertStage = new Stage();
    VBox vbox = new VBox();
    RadioButton mcqbtn;
    RadioButton trueOrFalse;
    RadioButton fillInBlanks;

    public void insert(Stage editStage, String sub)
   {
       insertStage.setTitle("Insert Questions");

       //Creating GridPane
       GridPane grid = new GridPane();
       grid.setPadding(new Insets(25, 25, 25, 25));
       grid.setHgap(10);
       grid.setVgap(10);
       //grid.setAlignment(Pos.CENTER);

       //Creating new Scene
       Scene insertScene = new Scene(vbox, 800, 800);

       Label insertLabel = new Label("Select the type of Question: ");
       GridPane.setConstraints(insertLabel, 0,0, 3, 1);
       insertLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

       ToggleGroup toggleGroup = new ToggleGroup();
       mcqbtn = new RadioButton("MCQ");
       mcqbtn.setToggleGroup(toggleGroup);
       mcqbtn.setSelected(true);
       GridPane.setConstraints(mcqbtn, 2, 1);

       trueOrFalse = new RadioButton("True/False");
       trueOrFalse.setToggleGroup(toggleGroup);
       GridPane.setConstraints(trueOrFalse, 2, 2);

       fillInBlanks = new RadioButton("Fill in the Blanks");
       fillInBlanks.setToggleGroup(toggleGroup);
       GridPane.setConstraints(fillInBlanks, 2, 3);

       //Submit Button
       Button submit = new Button("Submit");
       GridPane.setConstraints(submit, 3, 4);

       grid.getChildren().addAll(insertLabel, mcqbtn, trueOrFalse, fillInBlanks, submit);

       vbox.getChildren().add(grid);

       submit.setOnAction( (e) -> {

           if(vbox.getChildren().size() == 1)
           {
               if(mcqbtn.isSelected())
               {
                   HandleMcq handleMcq = new HandleMcq();
                   handleMcq.setSub(sub);
                   GridPane.setConstraints(handleMcq.mcq(insertStage), 0, 1);
                   vbox.getChildren().add(handleMcq.mcq(insertStage));
               }
               else if(trueOrFalse.isSelected())
               {
                   HandleTOF handleTOF = new HandleTOF();
                   GridPane.setConstraints(handleTOF.tof(insertStage), 0, 1);
                   vbox.getChildren().add(handleTOF.tof(insertStage));
               }
               else
               {
                   HandleFIB handleFIB = new HandleFIB();
                   GridPane.setConstraints(handleFIB.fib(insertStage), 0, 1);
                   vbox.getChildren().add(handleFIB.fib(insertStage));
               }
           }


       });

       insertStage.setScene(insertScene);

   }

    public Stage returnStage(Stage editStage)
    {
        EditQns editQns = new EditQns();
       // insert(editQns.returnStage());
        return insertStage;
    }

    public void inserting(Stage editStage, String sub)
    {
        insert(editStage, sub);
        insertStage.show();
    }

    public void closeStage()
    {
        insertStage.close();
    }

}

