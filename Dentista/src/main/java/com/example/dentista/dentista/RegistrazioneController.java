package com.example.dentista.dentista;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RegistrazioneController {
    String DataListaPazienti = "ListaPazienti.txt";
    File file = new File(DataListaPazienti);
    public ArrayList<Paziente> pazienti = new ArrayList<>();


    //registrazione
    @FXML
    private AnchorPane registrazione;

    public void inizializza() {
        this.pazienti = pazienti;
    }

    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField eta;
    @FXML
    private TextField codiceFiscale;
    @FXML
    private TextArea patologia;

    @FXML
    private TextField giorno;

    public void reset() {
        nome.setText("");
        cognome.setText("");
        eta.setText("");
        codiceFiscale.setText("");
        patologia.setText("");
        giorno.setText("");
    }

    public void esci() {
        Stage stage;
        stage = (Stage) registrazione.getScene().getWindow();
        stage.close();
    }
    // Python >> if sas is True or giglo is False:
    public void invia() {
        if (nome.getText().isEmpty() || cognome.getText().isEmpty() || eta.getText().isEmpty() || codiceFiscale.getText().isEmpty() || patologia.getText().isEmpty() || giorno.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setContentText("Compila tutti i campi");
            alert.show();
        } else {
            int eta_ = 0;
            LocalDate dataCorrente = LocalDate.now();
            int giorno_ = dataCorrente.getDayOfMonth();
            try {
                eta_ = Integer.parseInt(eta.getText());
                giorno_ = Integer.parseInt(giorno.getText());
                pazienti.add(new Paziente(nome.getText(), cognome.getText(), eta_, codiceFiscale.getText(), patologia.getText(), giorno_));

                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter fileWriter = new FileWriter(DataListaPazienti, true);
                    for (Paziente paziente : pazienti) {
                        fileWriter.write(paziente.toString() + "\n");
                    }
                    fileWriter.close();

                } catch (IOException e) {
                    System.out.println("Errore con il file " + DataListaPazienti);
                    e.printStackTrace();
                }

                nome.setText("");
                cognome.setText("");
                eta.setText("");
                codiceFiscale.setText("");
                patologia.setText("");
                giorno.setText("");

                Stage stage;
                stage = (Stage) registrazione.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setContentText("L'eta' dev'essere un numero");
                alert.show();
            }
        }
    }
}