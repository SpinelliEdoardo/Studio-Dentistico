package com.example.dentista.dentista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class HelloController {
    //registrazione
    @FXML
    public void registrazione() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registrazione.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 590, 390));
        stage.setTitle("Registrazione");
        stage.setResizable(false);
        RegistrazioneController controller = loader.getController();
        controller.inizializza();
        stage.show();
    }

    //lista pazienti
    @FXML
    public void listaPazienti() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listaPazienti.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 590, 390));
        stage.setTitle("Lista pazienti");
        stage.setResizable(false);
        ListaController controller = loader.getController();
        controller.inizializzaLista();
        stage.show();
    }

    @FXML
    public void listaGiornaliera() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listaGiornaliera.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 590, 390));
        stage.setTitle("Lista pazienti giornaliera");
        stage.setResizable(false);
        ListaGiornalieraController controller = loader.getController();
        controller.inizializzaLista();
        stage.show();
    }
}

