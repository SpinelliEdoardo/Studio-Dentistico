package com.example.dentista.dentista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ListaGiornalieraController {
    String DataListaPazienti = "ListaPazienti.txt";
    File file = new File(DataListaPazienti);
    ArrayList<Paziente> pazienti = new ArrayList<>();
    ObservableList<String> items = FXCollections.observableArrayList();

    List<Integer> giorni = new ArrayList<>();
    @FXML
    private Label giornoLista;
    @FXML
    private Button chiama;
    @FXML
    private ListView<String> listaGiornaliera;

    //lista dei pazienti
    @FXML
    public void inizializzaLista() {
        /*for(Paziente paziente : pazienti){
           items.add(paziente.getCognome() + " " + paziente.getNome() + " " + paziente.getEta() + " " + paziente.getPatologia());
        }*/

        lettura(file, pazienti, giornoLista, DataListaPazienti, items);
        scrittura(pazienti);

        listaGiornaliera.setItems(items);
    }


    //dentista
    public void dentista() {
        ArrayList<Paziente> pazienti = new ArrayList<>();
        lettura(file, pazienti, giornoLista, DataListaPazienti, items);
        listaGiornaliera.getItems().remove(0);
        giorni.get(0);

        if (pazienti.get(0).getDataRegistrazione() == giorni.get(0)) {
            chiama.setText("chiama");
            pazienti.remove(0);
            listaGiornaliera.getItems().remove(0);
            scrittura(pazienti);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Avanzamento Giorno");
            alert.setContentText("Avanza il giorno");
            alert.show();
            chiama.setText("avanza giorno");
            giorni.remove(0);
            items.clear();
        }
    }


    public void lettura(File file, ArrayList<Paziente> pazienti, Label giornoLista, String DataListaPazienti, ObservableList<String> items) {
        giorni.clear();
        int i = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] string = line.split(",");


                giorni.add(Integer.parseInt(string[5]));


                int minimo = Collections.min(giorni);
                /*
                List<Integer> giorniCopy = new ArrayList<>(giorni);
                Collections.sort(giorniCopy);
                */


                pazienti.add(new Paziente(string[0], string[1], Integer.parseInt(string[2]), string[3], string[4], Integer.parseInt(string[5])));

                if (minimo == giorni.get(i)) {
                    items.add(pazienti.get(i).toString() + ":GIORNO\n");
                }
                i++;


                pazienti.sort(Comparator.comparingInt(Paziente::getDataRegistrazione));


                giornoLista.setText(Integer.toString(minimo));

            }
            scanner.close();
            Collections.sort(giorni);


        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }
    }

    public void scrittura(ArrayList<Paziente> pazienti) {
        try {
            FileWriter fileWriter = new FileWriter(DataListaPazienti);
            for (Paziente paziente : pazienti) {
                fileWriter.write(paziente.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }
    }
}
