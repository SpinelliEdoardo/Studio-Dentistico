package com.example.dentista.dentista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ListaController {
    String DataListaPazienti = "ListaPazienti.txt";
    File file = new File(DataListaPazienti);
    Paziente paziente;

    public ArrayList<Paziente> pazienti = new ArrayList<>();


    @FXML
    private ListView<String> listaPazienti;

    //lista dei pazienti
    @FXML
    public void inizializzaLista(){
        ObservableList<String> items = FXCollections.observableArrayList();
        /*for(Paziente paziente : pazienti){
           items.add(paziente.getCognome() + " " + paziente.getNome() + " " + paziente.getEta() + " " + paziente.getPatologia());
        }*/


        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                items.add(line);
            }
            scanner.close();
            listaPazienti.setItems(items);
        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }
    }




    //dentista
    public void dentista() {

        try {
            listaPazienti.getItems().remove(0);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] string = line.split(",");
                pazienti.add(new Paziente(string[0], string[1], Integer.parseInt(string[2]), string[3], string[4], Integer.parseInt(string[5])));
            }
            scanner.close();

            pazienti.remove(0);

            FileWriter fileWriter = new FileWriter(DataListaPazienti);
            for (Paziente paziente : pazienti) {
                fileWriter.write(paziente.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }

        Stage stage;
        stage = (Stage) listaPazienti.getScene().getWindow();
        stage.close();
    }
}