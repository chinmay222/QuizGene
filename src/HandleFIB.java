import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HandleFIB
{
    public Parent fib(Stage insertStage)
    {
        //Creating Stage
        Stage fibStage = new Stage();
        fibStage = insertStage;

        //Creating Vbox
        VBox vbox = new VBox();

        //Creating GridPane
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        grid1.setPadding(new Insets(25, 25, 25, 25));
        grid1.setHgap(10);
        grid1.setVgap(10);

        grid2.setPadding(new Insets(0, 25, 25, 25));
        grid2.setHgap(10);
        grid2.setVgap(10);

        //Creating Scene
        Scene fibScene = new Scene(vbox, 600, 400);

        //Question Details Label
        Label enterQn = new Label("Question Details: ");
        GridPane.setConstraints(enterQn, 0, 0);

        //TextArea for Question:
        TextArea qnDetails = new TextArea();
        qnDetails.setFont(Font.font("SanSerif", 12));
        qnDetails.setPromptText("Your question goes here: ");
        GridPane.setConstraints(qnDetails, 0, 1, 2, 1);

        //Label for Options
        Label answer = new Label("Answer: ");
        GridPane.setConstraints(answer, 0, 0);

        //Answer TextField
        TextField answerText = new TextField();
        GridPane.setConstraints(answerText, 1, 0);

        //ApplyChanges button
        Button apply = new Button("Apply Changes");

        //AnotherEdit Button
        Button anotherEdit = new Button("Make Another Edit");
        anotherEdit.setOnAction(e ->
        {
            Stage stage;
            HomePage homePage = new HomePage();
            homePage.display();
            insertStage.close();
        });


        //Text for space
        Text forSpace = new Text("");

        //Hbox for applychanges and back
        HBox hbox = new HBox();
        hbox.getChildren().addAll(forSpace, apply, anotherEdit);
        //hbox.setAlignment(Pos.);
        hbox.setPadding(new Insets(10, 25, 25, 25));
        hbox.setSpacing(70);

        grid2.getChildren().addAll(answer, answerText);
        grid1.getChildren().addAll(enterQn, qnDetails);

        vbox.getChildren().addAll(grid1, grid2, hbox);

        return vbox;
    }
}
