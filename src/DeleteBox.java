import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DeleteBox
{
    //Creating deleteStage
    Stage deleteStage = new Stage();
    VBox vbox = new VBox();
    RadioButton mcqbtn;
    RadioButton trueOrFalse;
    RadioButton fillInBlanks;

    public void delete(Stage editStage)
    {
        deleteStage.setTitle("Delete Questions");

        //Creating GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);

        //Creating new Scene
        Scene deleteScene = new Scene(vbox, 800, 800);

        Label deleteLabel = new Label("Select the type of Question: ");
        GridPane.setConstraints(deleteLabel, 0,0, 3, 1);
        deleteLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        Label qnNum = new Label("Enter the question number: ");
        GridPane.setConstraints(qnNum, 0,6, 3, 1);
        qnNum.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

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

        //Textfield for queston no input
        TextField qnNumInput = new TextField();
        qnNumInput.setMaxSize(200, 5);
        qnNumInput.setPromptText("Question Number");
        GridPane.setConstraints(qnNumInput, 2, 7);

        //question Number Submit button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 3, 7);


        grid.getChildren().addAll(deleteLabel, mcqbtn, trueOrFalse, fillInBlanks, qnNum, qnNumInput, submit);

        vbox.getChildren().add(grid);

        submit.setOnAction( (e) -> {

            if(vbox.getChildren().size() == 1)
            {
                if(mcqbtn.isSelected())
                {
                    HandleMcq handleMcq = new HandleMcq();
                    GridPane.setConstraints(handleMcq.mcq(deleteStage), 0, 1);
                    vbox.getChildren().add(handleMcq.mcq(deleteStage));
                }
                else if(trueOrFalse.isSelected())
                {
                    HandleTOF handleTOF = new HandleTOF();
                    GridPane.setConstraints(handleTOF.tof(deleteStage), 0, 1);
                    vbox.getChildren().add(handleTOF.tof(deleteStage));
                }
                else
                {
                    HandleFIB handleFIB = new HandleFIB();
                    GridPane.setConstraints(handleFIB.fib(deleteStage), 0, 1);
                    vbox.getChildren().add(handleFIB.fib(deleteStage));
                }
            }


        });

        deleteStage.setScene(deleteScene);

    }

    public Stage returnStage(Stage editStage)
    {
        EditQns editQns = new EditQns();
        delete(editQns.returnStage());
        return deleteStage;
    }

    public void deleting(Stage editStage)
    {
        delete(editStage);
        deleteStage.show();
    }

    public void closeStage()
    {
        deleteStage.close();
    }

}