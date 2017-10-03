package helloworld;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;
import java.util.ArrayList;

public class Challenge7 {
    private static TextField textFieldRanking;
    private static TextField textFieldName;
    private static TextField textFieldCountry;
    private static ListView<University> uniListView;
    private static ArrayList<University> uniArrList = new ArrayList<University>();
    private static University currentlySelectedUniversity = null;

    public static void main(String[] args) {
        //Launches the GUI
        launchFX();
    }

    public static void launchFX(){
        //Initialise JavaFX
        new JFXPanel();

        // Runs initialisation on the JavaFX thread
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

        //Adds a visible list of data items that can be selected
        uniListView = new ListView<University>();
        uniListView.setLayoutX(700);
        uniListView.setLayoutY(50);
        uniListView.setOnMouseClicked((MouseEvent me) ->
            currentlySelectedUniversity = uniListView.getSelectionModel().getSelectedItem()
        );
        rootPane.getChildren().add(uniListView);
        updateListView();


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

        //Sets and displays a button that adds to the list in the GUI
        Button btn = new Button();
        btn.setText("Add");
        btn.setLayoutX(110);
        btn.setLayoutY(350);
        btn.setOnAction((ActionEvent ae) -> addNewItem());
        rootPane.getChildren().add(btn);

        //Sets and displays a button that deletes items in the list in the GUI
        Button newBtn = new Button();
        newBtn.setText("Delete");
        newBtn.setLayoutX(110);
        newBtn.setLayoutY(400);
        newBtn.setOnAction((ActionEvent ae) -> deleteItem());
        rootPane.getChildren().add(newBtn);
    }


    private static void addNewItem(){
        int ranking = Integer.parseInt(textFieldRanking.getText());
        String name = textFieldName.getText();
        String country = textFieldCountry.getText();
        uniArrList.add(new University(ranking, name, country));

        updateListView();
    }

    private static void updateListView(){
        uniListView.getItems().clear();
        for(University uni : uniArrList){
            uniListView.getItems().add(uni);
        }
    }

    private static void deleteItem(){
        //Removes an item once selected in the list
        uniArrList.remove(currentlySelectedUniversity);
        updateListView();
    }

    private static void terminate()
    {
        //Exits the GUI safely and prints a message in the console
        System.out.println("Successful exit");
        System.exit(0);
    }
}
