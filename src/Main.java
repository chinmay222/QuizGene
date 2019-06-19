import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

public class Main extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception
    {
        //window
        Stage window;
        window = primaryStage;
        window.setTitle("Login Page");

        //GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        //Welcome Text
        Text welcome =new Text("Welcome");
        GridPane.setConstraints(welcome, 0, 0);
        welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        //Username Label
        Label username = new Label("UserName: ");
        GridPane.setConstraints(username, 0, 1);

        //Password Label
        Label password = new Label("Password: ");
        GridPane.setConstraints(password, 0, 2);

        //Username Textfield
        TextField usernameInput = new TextField("Bhanu");
        GridPane.setConstraints(usernameInput, 1, 1);
        usernameInput.setPromptText("username");


        //password input PasswordField
        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 2);
        passwordInput.setPromptText("password");

        //Error message
        Text error = new Text();
        HBox errorHbox = new HBox(10);
        errorHbox.getChildren().add(error);
        errorHbox.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setConstraints(errorHbox, 0, 6, 2, 1);

        //Hbox for sign in button
        HBox signInBtnHbox = new HBox(10);
        Button signInBtn = new Button("Sign In");
        signInBtnHbox.getChildren().add(signInBtn);
        signInBtnHbox.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setConstraints(signInBtnHbox, 1, 4);

        signInBtn.setOnAction( e -> {
            if (usernameInput.getText().isEmpty())
            {
                error.setText("Please enter the username");
                error.setFill(RED);
            }
            else if(passwordInput.getText().isEmpty())
            {
                error.setText("Please enter the password");
                error.setFill(RED);
            }
            else if(usernameInput.getText().equals("Bhanu") && passwordInput.getText().equals("123"))
            {
                HomePage home = new HomePage();
                home.display();
                window.close();

            }
            else
            {
                error.setText("Incorrect username or password");
                error.setFill(RED);
            }
        });

        passwordInput.setOnKeyPressed( e ->
        {
            if(e.getCode() == KeyCode.ENTER)
            {
                if (usernameInput.getText().isEmpty())
                {
                    error.setText("Please enter the username");
                    error.setFill(RED);
                }
                else if(passwordInput.getText().isEmpty())
                {
                    error.setText("Please enter the password");
                    error.setFill(RED);
                }
                else if(usernameInput.getText().equals("Bhanu") && passwordInput.getText().equals("123"))
                {
                    HomePage home = new HomePage();
                    home.display();
                    window.close();
                }
                else
                {
                    error.setText("Incorrect username or password");
                    error.setFill(RED);
                }
            }
        });

        signInBtn.setOnKeyPressed( e ->
        {
            if(e.getCode() == KeyCode.ENTER)
            {
                if (usernameInput.getText().isEmpty())
                {
                    error.setText("Please enter the username");
                    error.setFill(RED);
                }
                else if(passwordInput.getText().isEmpty())
                {
                    error.setText("Please enter the password");
                    error.setFill(RED);
                }
                else if(usernameInput.getText().equals("Bhanu") && passwordInput.getText().equals("123"))
                {
                    HomePage home = new HomePage();
                    home.display();
                    window.close();
                }
                else
                {
                    error.setText("Incorrect username or password");
                    error.setFill(RED);
                }
            }
        });

        grid.getChildren().addAll(welcome, username, usernameInput, password, passwordInput, signInBtnHbox, errorHbox);

        //Main Scene
        Scene scene = new Scene(grid, 350, 280);
        window.setScene(scene);
        window.show();


    }
}
