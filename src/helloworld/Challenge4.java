package helloworld;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Challenge4 {
    private static TextField textFieldRanking;

    private static TextField textFieldName;

    private static TextField textFieldCountry;

    public static void main(String[] args) {
        //Launches the GUI
        launchFX();
    }

    public static void launchFX(){
        new JFXPanel();

        Platform.runLater(() -> initialiseGUI());
    }
    private static void initialiseGUI(){
        //Sets the stage for the GUI so text and textFields can be contained
        Stage stage = new Stage();
        stage.setTitle("Top Universities by Daniel");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
        stage.setOnCloseRequest((WindowEvent we) -> terminate());

        //Sets and displays where the text is in the GUI
        Text t = new Text();
        String message = "Enter details of top university";
        t.setX(110);
        t.setY(30);
        t.setText(message);
        rootPane.getChildren().add(t);

        //Sets and displays where a text field is in the GUI with prompt text in the field
        textFieldRanking = new TextField();
        textFieldRanking.setLayoutX(110);
        textFieldRanking.setLayoutY(50);
        textFieldRanking.setPrefWidth(200);
        textFieldRanking.setPromptText("Enter ranking");
        rootPane.getChildren().add(textFieldRanking);

        textFieldName = new TextField();
        textFieldName.setLayoutX(110);
        textFieldName.setLayoutY(80);
        textFieldName.setPrefWidth(200);
        textFieldName.setPromptText("Enter name");
        rootPane.getChildren().add(textFieldName);

        textFieldCountry = new TextField();
        textFieldCountry.setLayoutX(110);
        textFieldCountry.setLayoutY(110);
        textFieldCountry.setPrefWidth(200);
        textFieldCountry.setPromptText("Enter country");
        rootPane.getChildren().add(textFieldCountry);

        //Sets and displays a button in the GUI
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(110);
        btn.setLayoutY(350);
        btn.setOnAction((ActionEvent ae) -> printHello());
        rootPane.getChildren().add(btn);

        //Displays an image
        Image image = new Image("lion.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setLayoutX(180);
        iv1.setLayoutY(300);
        iv1.setFitWidth(500);
        iv1.setPreserveRatio(true);
        rootPane.getChildren().add(iv1);
    }

    private static void printHello() {
        //Prints out the text found in text fields in the console
        String rank = textFieldRanking.getText();
        String name = textFieldName.getText();
        String country = textFieldCountry.getText();
        System.out.println(rank + "\n" + name +"\n" + country);
    }

    private static void terminate()
    {
        //Exits the GUI safely and prints a message in the console
        System.out.println("Successful exit");
        System.exit(0);
    }
}
