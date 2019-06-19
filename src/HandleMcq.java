import java.io.*;

//import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

import java.util.ArrayList;
import java.util.HashMap;

import static javax.script.ScriptEngine.FILENAME;


public class HandleMcq
{
    String sub;
    String question;
    String optn1;
    String optn2;
    String optn3;
    String optn4;
    String answer = "lol";
    TextArea qnDetails;
    int qnNo;

    //HashMap<Integer, Mcq> mathMcq = new HashMap<Integer, Mcq>();
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public Parent mcq(Stage insertStage)
    {
        //Creating Stage
        Stage mcqStage = new Stage();
        mcqStage = insertStage;

        //Creating Vbox
        VBox vbox = new VBox();

        //Creating GridPane
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        grid1.setPadding(new Insets(25, 25, 25, 25));
        grid1.setHgap(10);
        grid1.setVgap(10);
        //grid1.setAlignment(Pos.CENTER);

        grid2.setPadding(new Insets(0, 25, 25, 25));
        grid2.setHgap(10);
        grid2.setVgap(10);
        //grid2.setAlignment(Pos.CENTER);

        //Creating Scene
        Scene mcqScene = new Scene(vbox, 600, 400);

        //Question Details Label
        Label enterQn = new Label("Question Details: ");
        GridPane.setConstraints(enterQn, 0, 0);

        //TextArea for Question:
        qnDetails = new TextArea();
        qnDetails.setFont(Font.font("SanSerif", 12));
        qnDetails.setPromptText("Your question goes here: ");
        GridPane.setConstraints(qnDetails, 0, 1, 2, 1);

        //Label for Options
        Label option = new Label("Options: ");
        GridPane.setConstraints(option, 0, 0);

        Label opt1 = new Label("1:");
        Label opt2 = new Label("   2:");
        Label opt3 = new Label("3:");
        Label opt4 = new Label("   4:");
        GridPane.setConstraints(opt1, 1, 1);
        GridPane.setConstraints(opt2, 3, 1);
        GridPane.setConstraints(opt3, 1, 2);
        GridPane.setConstraints(opt4, 3, 2);

        TextField option1 = new TextField();
        TextField option2 = new TextField();
        TextField option3 = new TextField();
        TextField option4 = new TextField();


        GridPane.setConstraints(option1, 2, 1);
        GridPane.setConstraints(option2, 4, 1);
        GridPane.setConstraints(option3, 2, 2);
        GridPane.setConstraints(option4, 4, 2);

        //ApplyChanges button
        Button apply = new Button("Apply Changes");
        apply.setOnAction( e -> {
            qnNo = HomePage.mathMcq.size() + 1;
            arrayList.add(qnNo);
            question = qnDetails.getText();
            optn1 = option1.getText();
            optn2 = option2.getText();
            optn3 = option3.getText();
            optn4 = option4.getText();
            //answer =
            updateHashMap();
        });


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

        grid2.getChildren().addAll(option, opt1, option1, opt2, option2, opt3, option3, opt4, option4);
        grid1.getChildren().addAll(enterQn, qnDetails);

        vbox.getChildren().addAll(grid1, grid2, hbox);

        return vbox;
    }

    public void setSub(String subject)
    {
        sub = subject;
    }


    public void updateHashMap()
    {
        Mcq mcq = new Mcq(question, optn1, optn2, optn3, optn4, answer);
        HomePage.mathMcq.put(qnNo, mcq);



        try
        {
            FileOutputStream fos = new FileOutputStream("/home/bhanu/Documents/sample.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(HomePage.mathMcq);
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }

        try
        {
            FileWriter fw = new FileWriter("/home/bhanu/Documents/sample1.txt");
            //BufferedWriter bw = new BufferedWriter(fw);
            // System.out.println(HomePage.mathMcq.size());
            for (int i=1;i<=HomePage.mathMcq.size();i++)
            {
                fw.write(i+ "\n");
                fw.write(HomePage.mathMcq.get(i).question+"\n");
                //bw.newLine();
                fw.write(HomePage.mathMcq.get(i).opt1+"\n");
                //bw.newLine();
                fw.write(HomePage.mathMcq.get(i).opt2+"\n");
                //bw.newLine();
                fw.write(HomePage.mathMcq.get(i).opt3+"\n");
                //bw.newLine();
                fw.write(HomePage.mathMcq.get(i).opt4+"\n");
                //bw.newLine();
                //  fw.write(HomePage.mathMcq.get(i).answer+"\n");
                //bw.newLine();

            }
            fw.close();

        }catch (Exception e)
        {
            System.out.println("Exception: "+e);
        }

    }


    public void handleModify()
    {
        ModifyBox modifyBox = new ModifyBox();
        //qnNo = modifyBox.getQnNo();
        qnDetails.setText(HomePage.mathMcq.get(qnNo).question);



    }



}
