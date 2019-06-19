import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class EditQns
{

    //Creating editStage
    Stage editStage = new Stage();
    String sub;


    public void editing(Stage homeStage)
    {
        editStage.setTitle("Edit Page");

        //Creating GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);



        //Navigation Button for home
        Button navHome = new Button("Go to Home");
        GridPane.setConstraints(navHome, 2, 0);
        navHome.setOnAction( e -> {
            editStage.close();
            homeStage.show();
        });

        //Subject Label
        Label subject = new Label("Select Subject: ");
        GridPane.setConstraints(subject, 0, 2);
        subject.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));


        //
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton math = new RadioButton("Mathematics");
        math.setToggleGroup(toggleGroup);
        math.setSelected(true);
        GridPane.setConstraints(math, 1, 3);
        math.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));


        RadioButton phy = new RadioButton("Physics");
        phy.setToggleGroup(toggleGroup);
        GridPane.setConstraints(phy, 1, 4);
        phy.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));


        //Edit options Label
        Label editOptions = new Label("Edit Options: ");
        GridPane.setConstraints(editOptions, 0, 6);
        editOptions.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));


        //Insert Button
        Button insertBtn = new Button("Insert");
        GridPane.setConstraints(insertBtn, 1, 7);
        insertBtn.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));
        insertBtn.setOnAction( e -> {
            InsertBox insertBox = new InsertBox();
            editStage.close();
            if(math.isSelected())
            {
                sub = "Mathematics";
            }
            else
            {
                sub = "Physics";
            }
            insertBox.inserting(editStage, sub);
        });


        //Modify Button
        Button modifyBtn = new Button("Modify");
        GridPane.setConstraints(modifyBtn, 1, 8);
        modifyBtn.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));
        modifyBtn.setOnAction( e -> {
            ModifyBox modifyBox = new ModifyBox();
            editStage.close();
            modifyBox.modifying(editStage);
        });


        //Deleta Button
        Button deleteBtn = new Button("Delete");
        GridPane.setConstraints(deleteBtn, 1, 9);
        deleteBtn.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));
        deleteBtn.setOnAction( e -> {
            DeleteBox deleteBox = new DeleteBox();
            editStage.close();
            deleteBox.deleting(editStage);
        });


        grid.getChildren().addAll(navHome, subject, math, phy, editOptions, insertBtn, modifyBtn, deleteBtn);

        //Creating editScene
        Scene editScene = new Scene(grid, 600, 400);


        editStage.setScene(editScene);
    }

    public Stage returnStage()
    {
        HomePage homePage = new HomePage();
        editing(homePage.returnStage());
        return editStage;
    }

    public void editingDuplicate(Stage homeStage)
    {
        editing(homeStage);
        editStage.show();
    }

}
