
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GenerateTest
{
    //creating generateStage
    Stage generateStage = new Stage();
    Scene generateScene;

    public void generate(Stage homeStage)
    {
        //creating gridpane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        generateScene = new Scene(grid, 600, 400);

        //Navigation Button for home
        Button navHome = new Button("Go to Home");
        GridPane.setConstraints(navHome, 2, 0);
        navHome.setOnAction( e -> {
            generateStage.close();
            homeStage.show();
        });

        generateStage.setTitle("Generate Test");
        Text generateText = new Text("Generate Test");
        GridPane.setConstraints(generateText, 0,1, 3, 1);
        generateText.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        //Math Mcq Label
        Label mathMcq = new Label("Mathematics Mcq's:");
        GridPane.setConstraints(mathMcq, 0, 3);
        mathMcq.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));

        //Math t/f Label
        Label mathTof = new Label("Mathematics Tof's ");
        GridPane.setConstraints(mathTof, 0, 4);
        mathTof.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));

        //math fib Label
        Label mathFib = new Label("Mathematics Tof's ");
        GridPane.setConstraints(mathFib, 0, 5);
        mathFib.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));

        //phy mcq Label
        Label phyMcq = new Label("Physics Mcq's");
        GridPane.setConstraints(phyMcq, 0, 7);
        phyMcq.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));

        //phy tof Label
        Label phyTof = new Label("Physics Tof's ");
        GridPane.setConstraints(phyTof, 0, 8);
        phyTof.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));

        //phy Fib Label
        Label phyFib = new Label("Physics Fib's ");
        GridPane.setConstraints(phyFib, 0, 9);
        phyFib.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));

        //math mcq Text Area
        TextField mathMcqText = new TextField();
        GridPane.setConstraints(mathMcqText,1, 3);

        TextField mathFibText = new TextField();
        GridPane.setConstraints(mathFibText, 1, 4);

        TextField mathTofText = new TextField();
        GridPane.setConstraints(mathTofText, 1, 5);


        //math mcq Text Area
        TextField phyMcqText = new TextField();
        GridPane.setConstraints(phyMcqText,1, 7);

        TextField phyFibText = new TextField();
        GridPane.setConstraints(phyFibText, 1, 8);

        TextField phyTofText = new TextField();
        GridPane.setConstraints(phyTofText, 1, 9);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 2, 11);

        grid.getChildren().addAll(navHome, generateText, mathMcq, mathMcqText, mathTof, mathTofText, mathFib, mathFibText, phyMcq, phyMcqText, phyTof, phyTofText, phyFib, phyFibText, submit);

        generateStage.setScene(generateScene);
        generateStage.show();
    }

}