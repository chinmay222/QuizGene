import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ModifyBox
{
    //Creating editStage
    Stage modifyStage = new Stage();
    VBox vbox = new VBox();
    RadioButton mcqbtn;
    RadioButton trueOrFalse;
    RadioButton fillInBlanks;
    int qnNo;
    TextField qnNumInput;

    public void modify(Stage editStage)
    {
        modifyStage.setTitle("Modify Questions");

        //Creating GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);

        //Creating new Scene
        Scene modifyScene = new Scene(vbox, 800, 800);

        Label modifyLabel = new Label("Select the type of Question: ");
        GridPane.setConstraints(modifyLabel, 0,0, 3, 1);
        modifyLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

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
        qnNumInput = new TextField();
        qnNumInput.setMaxSize(200, 5);
        qnNumInput.setPromptText("Question Number");
        GridPane.setConstraints(qnNumInput, 2, 7);

        //question Number Submit button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 3, 7);

        submit.setOnAction( e -> {
            qnNo = Integer.parseInt(qnNumInput.getText());
            HandleMcq handleMcq = new HandleMcq();
            handleMcq.handleModify();

        });


        grid.getChildren().addAll(modifyLabel, mcqbtn, trueOrFalse, fillInBlanks, qnNum, qnNumInput, submit);

        vbox.getChildren().add(grid);

        submit.setOnAction( (e) -> {

            if(vbox.getChildren().size() == 1)
            {
                if(mcqbtn.isSelected())
                {
                    HandleMcq handleMcq = new HandleMcq();
                    GridPane.setConstraints(handleMcq.mcq(modifyStage), 0, 1);
                    vbox.getChildren().add(handleMcq.mcq(modifyStage));
                    handleMcq.handleModify();
                }
                else if(trueOrFalse.isSelected())
                {
                    HandleTOF handleTOF = new HandleTOF();
                    GridPane.setConstraints(handleTOF.tof(modifyStage), 0, 1);
                    vbox.getChildren().add(handleTOF.tof(modifyStage));
                }
                else
                {
                    HandleFIB handleFIB = new HandleFIB();
                    GridPane.setConstraints(handleFIB.fib(modifyStage), 0, 1);
                    vbox.getChildren().add(handleFIB.fib(modifyStage));
                }
            }


        });

        modifyStage.setScene(modifyScene);

    }

    public Stage returnStage(Stage editStage)
    {
        EditQns editQns = new EditQns();
        modify(editQns.returnStage());
        return modifyStage;
    }

    public void modifying(Stage editStage)
    {
        modify(editStage);
        modifyStage.show();
    }

    public void closeStage()
    {
        modifyStage.close();
    }

    public int getQnNo()
    {
        return Integer.parseInt(qnNumInput.getText());
    }
}
