package com.example.pwmanagerfx.Homescreen;

import com.example.pwmanagerfx.DatabaseConnection;
import com.example.pwmanagerfx.Entry.EntryApplication;
import com.example.pwmanagerfx.Entry.EntryController;
import com.example.pwmanagerfx.Entry.EntryInput;
import com.example.pwmanagerfx.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import com.example.pwmanagerfx.LogIn.LogInApplication;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button closeButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button entryButton;
    @FXML
    private Button editButton;
    @FXML
    private TableView<EntryInput> listView;
    @FXML
    private TableColumn<EntryInput, String> serviceColumn;
    @FXML
    private TableColumn<EntryInput, Integer> entryColumn;
    @FXML
    private TableColumn<EntryInput, String> userColumn;
    @FXML
    private TableColumn<EntryInput, String> passwordColumn;
    @FXML
    private Label humeUser;
    public static String loggedInUsername = "";

    private HomeApplication homeMain;
    private FXMLLoader loader;


    public HomeController() {

    }

    public void setMain(HomeApplication logIn) {
        this.homeMain = logIn;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public void loadEntries() {
        String loggedInUsername = EntryController.loggedInUsername;
        List<EntryInput> entries = DatabaseConnection.getEntriesForUsername(loggedInUsername);
        if (loader != null && loader.getNamespace() != null) {
            TableView<EntryInput> listView = (TableView<EntryInput>) loader.getNamespace().get("listView");
            ObservableList<EntryInput> entryObservableList = FXCollections.observableArrayList(entries);

            listView.setItems(entryObservableList);
            //listView.getItems().clear();
            //listView.getItems().addAll(entries);
        } else {
            System.out.println("Loader or its Namespace is null.");
        }
    }

    public void closeAction(ActionEvent e) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void handleLogOutAction(ActionEvent e) {
        try {
            LogInApplication logInApp = new LogInApplication();
            logInApp.start(new Stage());

            Stage stage = (Stage) logOutButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleEntryAction(ActionEvent e) {
        try {
            EntryApplication entryApplication = new EntryApplication();
            entryApplication.start(new Stage());

            Stage stage = (Stage) entryButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleEditAction(ActionEvent e) {
       EntryInput selectedEntry = listView.getSelectionModel().getSelectedItem();

        if (selectedEntry != null) {

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warnung");
            alert.setHeaderText(null);
            alert.setContentText("Bitte wähle einen Eintrag aus, den du bearbeiten willst!");
            alert.showAndWait();
        }
    }


    public void saveEditedEntry(EntryInput entry){
        EntryInput.updateEntry(entry);
        loadEntries();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loader = new FXMLLoader();
        listView.setEditable(true);
        serviceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        serviceColumn.setOnEditCommit(event -> {
            // Den neuen Wert aus der bearbeiteten Zelle erhalten
            String newValue = event.getNewValue();
            // Das EntryInput-Objekt des bearbeiteten Eintrags abrufen
            EntryInput entry = event.getRowValue();
            // Den neuen Wert in das EntryInput-Objekt setzen
            entry.setService(newValue);
            // Den aktualisierten Eintrag in der Datenbank speichern
            EntryInput.updateEntry(entry);
        });

        userColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        userColumn.setOnEditCommit(event -> {
            // Den neuen Wert aus der bearbeiteten Zelle erhalten
            String newValue = event.getNewValue();
            // Das EntryInput-Objekt des bearbeiteten Eintrags abrufen
            EntryInput entry = event.getRowValue();
            // Den neuen Wert in das EntryInput-Objekt setzen
            entry.setUser(newValue);
            // Den aktualisierten Eintrag in der Datenbank speichern
            EntryInput.updateEntry(entry);
        });

        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordColumn.setOnEditCommit(event -> {
            // Den neuen Wert aus der bearbeiteten Zelle erhalten
            String newValue = event.getNewValue();
            // Das EntryInput-Objekt des bearbeiteten Eintrags abrufen
            EntryInput entry = event.getRowValue();
            // Den neuen Wert in das EntryInput-Objekt setzen
            entry.setPassword(newValue);
            // Den aktualisierten Eintrag in der Datenbank speichern
            EntryInput.updateEntry(entry);
        });

    }
}

