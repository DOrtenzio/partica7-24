package com.example.pratica724;

import com.example.pratica724.auto.*;
import com.example.pratica724.utenti.Concessionario;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class ConcessionarioInventarioView {
    @FXML
    private Button b1,b2,b3,b4,b5,bFisso;
    @FXML
    private AnchorPane boxDinamica,boxPulsanti;

    private Concessionario concessionario;
    private InventarioAuto inventarioAuto;

    public void setConcessionario(Concessionario concessionario){
        this.concessionario=concessionario;
        bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
        this.inventarioAuto=concessionario.getInventario();
    }

    //fase iniziale
    @FXML
    private void initialize(){
        cambioColorePassaggioMouse(b1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b2,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b3,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b4,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b5,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");


        entrataAnchor(boxPulsanti,-300,0);
    }

    //metodi
    @FXML
    public void aggiungiAuto(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Inserisci una nuova auto");
        boxDinamica.getChildren().clear();
        entrataAnchor(boxDinamica,1200,0);

        //Pulsanti selezione tipo
        Label label = new Label("Seleziona una delle seguenti opzioni:"); // Creazione del Label
        label.setLayoutX(18.0);
        label.setLayoutY(21.0);
        label.setPrefHeight(39.0);
        label.setPrefWidth(579.0);
        label.setFont(new Font("Pivot Classic", 18.0));

        // Creazione del primo Button
        Button autoNuova = new Button("Auto Nuova");
        autoNuova.setLayoutX(18.0);
        autoNuova.setLayoutY(75.0);
        autoNuova.setPrefHeight(39.0);
        autoNuova.setPrefWidth(168.0);
        autoNuova.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        autoNuova.setTextFill(javafx.scene.paint.Color.web("#30323D"));
        autoNuova.setFont(new Font("Pivot Classic", 12.0));
        cambioColorePassaggioMouse(autoNuova,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        autoNuova.setOnAction(e->{
            boxDinamica.getChildren().clear();
            entrataAnchor(boxDinamica,1200,0);
            try {
                autoNuova();
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        // Creazione del secondo Button
        Button autoUsata = new Button("Auto Usata");
        autoUsata.setLayoutX(225.0);
        autoUsata.setLayoutY(75.0);
        autoUsata.setPrefHeight(39.0);
        autoUsata.setPrefWidth(168.0);
        autoUsata.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        autoUsata.setTextFill(javafx.scene.paint.Color.web("#30323D"));
        autoUsata.setFont(new Font("Pivot Classic", 12.0));
        cambioColorePassaggioMouse(autoUsata,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        autoUsata.setOnAction(e->{
            boxDinamica.getChildren().clear();
            entrataAnchor(boxDinamica,1200,0);
            try {
                autoUsata();
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        // Creazione del terzo Button
        Button autoSpeciale = new Button("Auto Speciale");
        autoSpeciale.setLayoutX(430.0);
        autoSpeciale.setLayoutY(75.0);
        autoSpeciale.setPrefHeight(39.0);
        autoSpeciale.setPrefWidth(168.0);
        autoSpeciale.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        autoSpeciale.setTextFill(javafx.scene.paint.Color.web("#30323D"));
        autoSpeciale.setFont(new Font("Pivot Classic", 12.0));
        cambioColorePassaggioMouse(autoSpeciale,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        autoSpeciale.setOnAction(e->{
            boxDinamica.getChildren().clear();
            entrataAnchor(boxDinamica,1200,0);
            try {
                autoSpeciale();
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        // Aggiunta degli elementi al pannello
        boxDinamica.getChildren().addAll(label, autoNuova, autoUsata, autoSpeciale);
    }

    //Aggiunte
    @FXML
    private void autoNuova(){
        // Label 1
        Label label1 = new Label("Inserisci le informazioni richieste:");
        label1.setLayoutX(18);
        label1.setLayoutY(21);
        label1.setPrefSize(579, 39);
        label1.setFont(new Font("Pivot Classic", 18));
        boxDinamica.getChildren().add(label1);

        // Label 2
        Label label2 = new Label("Inserisci la marca");
        label2.setLayoutX(19);
        label2.setLayoutY(45);
        label2.setPrefSize(260, 43);
        label2.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label2);

        // TextField 1
        TextField marca = new TextField();
        marca.setLayoutX(19);
        marca.setLayoutY(92);
        marca.setPrefSize(260, 12);
        marca.setPromptText("Fiat");
        marca.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        marca.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(marca);

        // Label 3
        Label label3 = new Label("Inserisci gli optional");
        label3.setLayoutX(301);
        label3.setLayoutY(45);
        label3.setPrefSize(260, 43);
        label3.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label3);

        // TextField 2
        TextField optional = new TextField();
        optional.setLayoutX(301);
        optional.setLayoutY(92);
        optional.setPrefSize(260, 12);
        optional.setPromptText("xxxxxxxx-xxxxxxx-xxxxxxx");
        optional.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        optional.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(optional);

        // Label 4
        Label label4 = new Label("Inserisci il colore");
        label4.setLayoutX(19);
        label4.setLayoutY(324);
        label4.setPrefSize(260, 43);
        label4.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label4);

        // TextField 3
        TextField colore = new TextField();
        colore.setLayoutX(19);
        colore.setLayoutY(371);
        colore.setPrefSize(260, 12);
        colore.setPromptText("Rosso");
        colore.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        colore.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(colore);

        // Label 5
        Label label5 = new Label("Inserisci l'alimentazione");
        label5.setLayoutX(19);
        label5.setLayoutY(252);
        label5.setPrefSize(260, 43);
        label5.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label5);

        // Label 6
        Label label6 = new Label("Inserisci il prezzo");
        label6.setLayoutX(19);
        label6.setLayoutY(183);
        label6.setPrefSize(260, 43);
        label6.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label6);

        // TextField 4
        TextField prezzo = new TextField();
        prezzo.setLayoutX(19);
        prezzo.setLayoutY(230);
        prezzo.setPrefSize(260, 12);
        prezzo.setPromptText("19.000");
        prezzo.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        prezzo.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(prezzo);

        // Label 7
        Label label7 = new Label("Inserisci il modello");
        label7.setLayoutX(19);
        label7.setLayoutY(114);
        label7.setPrefSize(260, 43);
        label7.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label7);

        // TextField 5
        TextField modello = new TextField();
        modello.setLayoutX(19);
        modello.setLayoutY(161);
        modello.setPrefSize(260, 12);
        modello.setPromptText("Panda");
        modello.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        modello.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(modello);

        Label labelDescrizione = new Label("Descrizione (Opzionale) :");
        labelDescrizione.setLayoutX(301);
        labelDescrizione.setLayoutY(130);
        labelDescrizione.setPrefSize(260, 20);
        labelDescrizione.toFront();
        labelDescrizione.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(labelDescrizione);

        // TextArea
        TextArea descrizione = new TextArea();
        descrizione.setLayoutX(301);
        descrizione.setLayoutY(161);
        descrizione.setPrefSize(260, 167);
        descrizione.setPromptText("Modello speciale 50 anni");
        descrizione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        descrizione.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(descrizione);

        // ChoiceBox
        ChoiceBox<String> alimentazione = new ChoiceBox<>();
        alimentazione.setLayoutX(19);
        alimentazione.setLayoutY(295);
        alimentazione.setPrefSize(260, 26);
        alimentazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        alimentazione.getItems().addAll("Benzina", "Diesel", "Elettrico", "Mild-Hybrid",
                "Full-Hybrid", "Plug-in Hybrid", "Idrogeno");

        boxDinamica.getChildren().add(alimentazione);

        // Button
        Button button = new Button("Inserisci");
        button.setLayoutX(322);
        button.setLayoutY(351);
        button.setPrefSize(219, 39);
        button.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; " +
                "-fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setFont(new Font("Pivot Classic", 12));
        button.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        cambioColorePassaggioMouse(button,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setOnAction(e->{
            concessionario.getInventario().aggiungiAuto(new AutoNuova(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),alimentazione.getValue(),colore.getText(),descrizione.getText(),optional.getText()));
            avvisoVisivo("Ottimo", "42f58d");
            boxDinamica.getChildren().clear();
            entrataAnchor(boxDinamica,0,1200);
            boxDinamica.setVisible(false);
            boxDinamica.setDisable(true);
            bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
        });

        boxDinamica.getChildren().add(button);
    }
    @FXML
    private void autoUsata() {
        // Label 1
        Label label1 = new Label("Seleziona una delle seguenti opzioni ed inserisci:");
        label1.setLayoutX(18);
        label1.setLayoutY(21);
        label1.setPrefSize(579, 39);
        label1.setFont(new Font("Pivot Classic", 18));
        boxDinamica.getChildren().add(label1);

        // RadioButton 1 - Usata
        ToggleGroup toggle = new ToggleGroup();
        RadioButton usata = new RadioButton("Usata");
        usata.setLayoutX(39);
        usata.setLayoutY(67);
        usata.setFont(new Font("Pivot Classic", 12));
        usata.setToggleGroup(toggle);
        usata.setSelected(true);
        boxDinamica.getChildren().add(usata);

        // RadioButton 2 - Km0
        RadioButton km0 = new RadioButton("Km0");
        km0.setLayoutX(160);
        km0.setLayoutY(67);
        km0.setFont(new Font("Pivot Classic", 12));
        km0.setToggleGroup(toggle);
        boxDinamica.getChildren().add(km0);

        // Other Labels, TextFields, and Components
        Label marcaLabel = new Label("Inserisci la marca");
        marcaLabel.setLayoutX(19);
        marcaLabel.setLayoutY(96);
        marcaLabel.setPrefSize(260, 43);
        marcaLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(marcaLabel);

        TextField marca = new TextField();
        marca.setLayoutX(19);
        marca.setLayoutY(143);
        marca.setPrefSize(260, 12);
        marca.setPromptText("Fiat");
        marca.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        marca.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(marca);

        Label modelloLabel = new Label("Inserisci il modello");
        modelloLabel.setLayoutX(19);
        modelloLabel.setLayoutY(165);
        modelloLabel.setPrefSize(260, 43);
        modelloLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(modelloLabel);

        TextField modello = new TextField();
        modello.setLayoutX(19);
        modello.setLayoutY(212);
        modello.setPrefSize(260, 12);
        modello.setPromptText("Panda");
        modello.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        modello.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(modello);

        Label prezzoLabel = new Label("Inserisci il prezzo");
        prezzoLabel.setLayoutX(19);
        prezzoLabel.setLayoutY(234);
        prezzoLabel.setPrefSize(260, 43);
        prezzoLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(prezzoLabel);

        TextField prezzo = new TextField();
        prezzo.setLayoutX(19);
        prezzo.setLayoutY(281);
        prezzo.setPrefSize(260, 12);
        prezzo.setPromptText("19.000");
        prezzo.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        prezzo.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(prezzo);

        Label alimentazioneLabel = new Label("Inserisci l'alimentazione");
        alimentazioneLabel.setLayoutX(19);
        alimentazioneLabel.setLayoutY(303);
        alimentazioneLabel.setPrefSize(260, 43);
        alimentazioneLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(alimentazioneLabel);

        ChoiceBox<String> alimentazione = new ChoiceBox<>();
        alimentazione.setLayoutX(19);
        alimentazione.setLayoutY(346);
        alimentazione.setPrefSize(260, 26);
        alimentazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        alimentazione.getItems().addAll("Benzina", "Diesel", "Elettrico", "Mild-Hybrid", "Full-Hybrid", "Plug-in Hybrid", "Idrogeno");
        boxDinamica.getChildren().add(alimentazione);

        Label coloreLabel = new Label("Inserisci il colore");
        coloreLabel.setLayoutX(19);
        coloreLabel.setLayoutY(372);
        coloreLabel.setPrefSize(260, 43);
        coloreLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(coloreLabel);

        TextField colore = new TextField();
        colore.setLayoutX(19);
        colore.setLayoutY(413);
        colore.setPrefSize(260, 12);
        colore.setPromptText("Rosso");
        colore.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        colore.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(colore);


        // Label: Chilometraggio
        Label chilometraggioLabel = new Label("Inserisci il chilometraggio");
        chilometraggioLabel.setLayoutX(301);
        chilometraggioLabel.setLayoutY(120);
        chilometraggioLabel.setPrefSize(260, 43);
        chilometraggioLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(chilometraggioLabel);

        // Label: Descrizione (Opzionale)
        Label descrizioneLabel = new Label("Descrizione (Opzionale)");
        descrizioneLabel.setLayoutX(302);
        descrizioneLabel.setLayoutY(185);
        descrizioneLabel.setPrefSize(260, 43);
        descrizioneLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(descrizioneLabel);

        // Label: Anno d'Immatricolazione
        Label immatricolazioneLabel = new Label("Inserisci l'anno d'Immatricolazione");
        immatricolazioneLabel.setLayoutX(301);
        immatricolazioneLabel.setLayoutY(45);
        immatricolazioneLabel.setPrefSize(260, 43);
        immatricolazioneLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(immatricolazioneLabel);

        TextField annoImmatricolazione = new TextField();
        annoImmatricolazione.setLayoutX(301);
        annoImmatricolazione.setLayoutY(92);
        annoImmatricolazione.setPrefSize(260, 12);
        annoImmatricolazione.setPromptText("2010");
        annoImmatricolazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        annoImmatricolazione.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(annoImmatricolazione);

        TextArea descrizione = new TextArea();
        descrizione.setLayoutX(301);
        descrizione.setLayoutY(231);
        descrizione.setPrefSize(260, 155);
        descrizione.setPromptText("Modello speciale 50 anni");
        descrizione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        descrizione.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(descrizione);

        TextField chilometraggio = new TextField();
        chilometraggio.setLayoutX(301);
        chilometraggio.setLayoutY(161);
        chilometraggio.setPrefSize(260, 12);
        chilometraggio.setPromptText("200.000");
        chilometraggio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        chilometraggio.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(chilometraggio);

        // Button
        Button inserisciButton = new Button("Inserisci");
        inserisciButton.setLayoutX(322);
        inserisciButton.setLayoutY(406);
        inserisciButton.setPrefSize(219, 39);
        inserisciButton.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; " +
                "-fx-border-width: 1.2; -fx-border-radius: 32;");
        inserisciButton.setFont(new Font("Pivot Classic", 12));
        inserisciButton.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        inserisciButton.setOnAction(e->{
            try {
                if (usata.isSelected()){
                    concessionario.getInventario().aggiungiAuto(new AutoUsata(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),Integer.parseInt(annoImmatricolazione.getText()),alimentazione.getValue(),Integer.parseInt(chilometraggio.getText()),colore.getText(),descrizione.getText()));
                }else{
                    concessionario.getInventario().aggiungiAuto(new AutoKm0(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),Integer.parseInt(annoImmatricolazione.getText()), alimentazione.getValue(), colore.getText(), descrizione.getText(),Integer.parseInt(chilometraggio.getText())));
                }
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
            avvisoVisivo("Ottimo", "42f58d");
            boxDinamica.getChildren().clear();
            bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
            entrataAnchor(boxDinamica,0,1200);
            boxDinamica.setVisible(false);
            boxDinamica.setDisable(true);
        });
        cambioColorePassaggioMouse(inserisciButton,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");

        boxDinamica.getChildren().add(inserisciButton);
    }
    @FXML
    private void autoSpeciale() {
        // Label 1
        Label label1 = new Label("Seleziona una delle seguenti opzioni ed inserisci:");
        label1.setLayoutX(18);
        label1.setLayoutY(21);
        label1.setPrefSize(579, 39);
        label1.setFont(new Font("Pivot Classic", 18));
        boxDinamica.getChildren().add(label1);

        // RadioButton 1 - speciali
        ToggleGroup toggle = new ToggleGroup();
        RadioButton special = new RadioButton("Speciale");
        special.setLayoutX(39);
        special.setLayoutY(67);
        special.setFont(new Font("Pivot Classic", 12));
        special.setToggleGroup(toggle);
        special.setSelected(true);
        boxDinamica.getChildren().add(special);

        // RadioButton 2 - disabili
        RadioButton disabili = new RadioButton("Disabili");
        disabili.setLayoutX(160);
        disabili.setLayoutY(67);
        disabili.setFont(new Font("Pivot Classic", 12));
        disabili.setToggleGroup(toggle);
        boxDinamica.getChildren().add(disabili);

        Label marcaLabel = new Label("Inserisci la marca");
        marcaLabel.setLayoutX(19);
        marcaLabel.setLayoutY(96);
        marcaLabel.setPrefSize(260, 43);
        marcaLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(marcaLabel);

        TextField marca = new TextField();
        marca.setLayoutX(19);
        marca.setLayoutY(143);
        marca.setPrefSize(260, 12);
        marca.setPromptText("Fiat");
        marca.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        marca.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(marca);

        Label modelloLabel = new Label("Inserisci il modello");
        modelloLabel.setLayoutX(19);
        modelloLabel.setLayoutY(165);
        modelloLabel.setPrefSize(260, 43);
        modelloLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(modelloLabel);

        TextField modello = new TextField();
        modello.setLayoutX(19);
        modello.setLayoutY(212);
        modello.setPrefSize(260, 12);
        modello.setPromptText("Panda");
        modello.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        modello.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(modello);

        Label prezzoLabel = new Label("Inserisci il prezzo");
        prezzoLabel.setLayoutX(19);
        prezzoLabel.setLayoutY(234);
        prezzoLabel.setPrefSize(260, 43);
        prezzoLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(prezzoLabel);

        TextField prezzo = new TextField();
        prezzo.setLayoutX(19);
        prezzo.setLayoutY(281);
        prezzo.setPrefSize(260, 12);
        prezzo.setPromptText("19.000");
        prezzo.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        prezzo.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(prezzo);

        Label alimentazioneLabel = new Label("Inserisci l'alimentazione");
        alimentazioneLabel.setLayoutX(19);
        alimentazioneLabel.setLayoutY(303);
        alimentazioneLabel.setPrefSize(260, 43);
        alimentazioneLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(alimentazioneLabel);

        ChoiceBox<String> alimentazione = new ChoiceBox<>();
        alimentazione.setLayoutX(19);
        alimentazione.setLayoutY(346);
        alimentazione.setPrefSize(260, 26);
        alimentazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        alimentazione.getItems().addAll("Benzina", "Diesel", "Elettrico", "Mild-Hybrid", "Full-Hybrid", "Plug-in Hybrid", "Idrogeno");
        boxDinamica.getChildren().add(alimentazione);

        Label coloreLabel = new Label("Inserisci il colore");
        coloreLabel.setLayoutX(19);
        coloreLabel.setLayoutY(372);
        coloreLabel.setPrefSize(260, 43);
        coloreLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(coloreLabel);

        TextField colore = new TextField();
        colore.setLayoutX(19);
        colore.setLayoutY(413);
        colore.setPrefSize(260, 12);
        colore.setPromptText("Rosso");
        colore.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        colore.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(colore);


        // Label: Chilometraggio
        Label aggiunteLabel = new Label("Inserisci le aggiunte");
        aggiunteLabel.setLayoutX(301);
        aggiunteLabel.setLayoutY(120);
        aggiunteLabel.setPrefSize(260, 43);
        aggiunteLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(aggiunteLabel);

        // Label: Descrizione (Opzionale)
        Label descrizioneLabel = new Label("Descrizione (Opzionale)");
        descrizioneLabel.setLayoutX(302);
        descrizioneLabel.setLayoutY(185);
        descrizioneLabel.setPrefSize(260, 43);
        descrizioneLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(descrizioneLabel);

        // Label: Anno d'Immatricolazione
        Label incentivoLabel = new Label("Inserisci l'incentivo, se presente");
        incentivoLabel.setLayoutX(301);
        incentivoLabel.setLayoutY(45);
        incentivoLabel.setPrefSize(260, 43);
        incentivoLabel.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(incentivoLabel);

        TextField incentivo = new TextField();
        incentivo.setLayoutX(301);
        incentivo.setLayoutY(92);
        incentivo.setPrefSize(260, 12);
        incentivo.setPromptText("5000");
        incentivo.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        incentivo.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(incentivo);

        TextArea descrizione = new TextArea();
        descrizione.setLayoutX(301);
        descrizione.setLayoutY(231);
        descrizione.setPrefSize(260, 155);
        descrizione.setPromptText("Modello speciale 50 anni");
        descrizione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        descrizione.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(descrizione);

        TextField aggiunte = new TextField();
        aggiunte.setLayoutX(301);
        aggiunte.setLayoutY(161);
        aggiunte.setPrefSize(260, 12);
        aggiunte.setPromptText("Rampa-Porta Carrozzina-...");
        aggiunte.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        aggiunte.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(aggiunte);

        // Button
        Button inserisciButton = new Button("Inserisci");
        inserisciButton.setLayoutX(322);
        inserisciButton.setLayoutY(406);
        inserisciButton.setPrefSize(219, 39);
        inserisciButton.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; " +
                "-fx-border-width: 1.2; -fx-border-radius: 32;");
        inserisciButton.setFont(new Font("Pivot Classic", 12));
        inserisciButton.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        cambioColorePassaggioMouse(inserisciButton,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        inserisciButton.setOnAction(e->{
            try {
                if (special.isSelected()){
                    concessionario.getInventario().aggiungiAuto(new AutoSpeciali(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),alimentazione.getValue(),colore.getText(),descrizione.getText(),aggiunte.getText(),Double.parseDouble(incentivo.getText())));
                    avvisoVisivo("Ottimo", "42f58d");
                    boxDinamica.getChildren().clear();
                    bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
                    entrataAnchor(boxDinamica,0,1200);
                    boxDinamica.setVisible(false);
                    boxDinamica.setDisable(true);
                }else{
                    boxDinamica.getChildren().clear();

                    Label larghLabel = new Label("Inserisci la larghezza massi di una carrozzina ");
                    larghLabel.setLayoutX(19);
                    larghLabel.setLayoutY(96);
                    larghLabel.setPrefSize(300, 43);
                    larghLabel.setFont(new Font("Pivot Classic", 14));
                    boxDinamica.getChildren().add(larghLabel);

                    TextField largh = new TextField();
                    largh.setLayoutX(19);
                    largh.setLayoutY(143);
                    largh.setPrefSize(260, 12);
                    largh.setPromptText("150 cm");
                    largh.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                            "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
                    largh.setFont(new Font("Goudy Old Style", 12));
                    boxDinamica.getChildren().add(largh);

                    // Button
                    Button inserisciButton2 = new Button("Conferma");
                    inserisciButton2.setLayoutX(330);
                    inserisciButton2.setLayoutY(143);
                    inserisciButton2.setPrefSize(219, 39);
                    inserisciButton2.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; " +
                            "-fx-border-width: 1.2; -fx-border-radius: 32;");
                    inserisciButton2.setFont(new Font("Pivot Classic", 12));
                    inserisciButton2.setTextFill(javafx.scene.paint.Color.web("#30323d"));
                    cambioColorePassaggioMouse(inserisciButton2,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
                    inserisciButton2.setOnAction(event->{
                        concessionario.getInventario().aggiungiAuto(new AutoDisabili(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),alimentazione.getValue(),colore.getText(),descrizione.getText(),aggiunte.getText(),Double.parseDouble(incentivo.getText()),Double.parseDouble(largh.getText())));
                        avvisoVisivo("Ottimo", "42f58d");
                        boxDinamica.getChildren().clear();
                        bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
                        entrataAnchor(boxDinamica,0,1200);
                        boxDinamica.setVisible(false);
                        boxDinamica.setDisable(true);
                    });
                    boxDinamica.getChildren().add(inserisciButton2);
                }
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        boxDinamica.getChildren().add(inserisciButton);
    }

    //Cancellazione
    @FXML
    public void cancellaAuto(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Rimuovi un'auto");
        boxDinamica.getChildren().clear();
        entrataAnchor(boxDinamica,1200,0);

        // ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(14.0);
        scrollPane.setLayoutY(60.0);
        scrollPane.setPrefSize(590.0, 387.0);
        scrollPane.setStyle("-fx-background-color: #F4FAFF;");

        // VBox inside ScrollPane
        VBox vBox = new VBox();
        vBox.setPrefSize(572.0, 408.0);
        vBox.setStyle("-fx-background-color: #F4FAFF;");

        if (inventarioAuto.getInventario().size()%2==0){
            for (int i=0;i<inventarioAuto.getInventario().size();i+=2){
                HBox hBox1 = aggiungiRiga(inventarioAuto.getInventario().get(i),inventarioAuto.getInventario().get(i+1),vBox);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
        }else{
            for (int i=0;i<inventarioAuto.getInventario().size()-1;i+=2){
                HBox hBox1 = aggiungiRiga(inventarioAuto.getInventario().get(i),inventarioAuto.getInventario().get(i+1),vBox);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
            HBox hBox2 = aggiungiRigaSola(inventarioAuto.getInventario().getLast(),vBox);
            vBox.getChildren().add(hBox2);
        }
        Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
        spazio2.setPrefSize(572.0, 50.0);
        vBox.getChildren().add(spazio2);

        scrollPane.setContent(vBox);

        Label labelTitolo = new Label("Seleziona l'auto da cancellare : ");
        labelTitolo.setLayoutX(22.0);
        labelTitolo.setLayoutY(14.0);
        labelTitolo.setPrefSize(575.0, 31.0);
        labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");
        // Aggiunta degli elementi al pannello
        boxDinamica.getChildren().addAll(labelTitolo,scrollPane);
    }

    //Metodi x cancellare
    @FXML
    private HBox aggiungiRiga(Auto auto1, Auto auto2,VBox vbox) {
        HBox hBox = new HBox();
        hBox.setPrefSize(582.0, 162.0);

        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(271.0, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        Label modelloLabel = new Label(auto1.getModello());
        modelloLabel.setLayoutX(14.0);
        modelloLabel.setLayoutY(14.0);
        modelloLabel.setPrefSize(148.0, 29.0);
        modelloLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        Label marchioLabel = new Label(auto1.getMarca());
        marchioLabel.setLayoutX(14.0);
        marchioLabel.setLayoutY(43.0);
        marchioLabel.setPrefSize(107.0, 17.0);
        marchioLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label alimentazioneLabel = new Label(auto1.getAlimentazione());
        alimentazioneLabel.setLayoutX(183.0);
        alimentazioneLabel.setLayoutY(20.0);
        alimentazioneLabel.setRotate(26.1);
        alimentazioneLabel.setPrefSize(86.0, 17.0);
        alimentazioneLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button selezionaButton = new Button("Seleziona");
        selezionaButton.setLayoutX(169.0);
        selezionaButton.setLayoutY(122.0);
        selezionaButton.setPrefSize(83.0, 28.0);
        selezionaButton.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        selezionaButton.setOnAction(e->{
            try {
                cancellaSelezionata(auto1);
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });
        cambioColorePassaggioMouse(selezionaButton,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");

        Button vediMeglio = new Button("+");
        vediMeglio.setLayoutX(127.0);
        vediMeglio.setLayoutY(122.0);
        vediMeglio.setPrefSize(35.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioCancellato(vbox,auto1);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(14.0);
        tipoLabel.setLayoutY(122.0);
        tipoLabel.setPrefSize(116.0, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 16.0;");

        pane1.getChildren().addAll(modelloLabel, marchioLabel, alimentazioneLabel, selezionaButton, vediMeglio, tipoLabel);

        // Second Pane (spacer)
        Pane pane2 = new Pane();
        pane2.setPrefSize(46.0, 162.0);
        pane2.setStyle("-fx-background-color: #F4FAFF;");

        // Third Pane
        Pane pane3 = new Pane();
        pane3.setPrefSize(271.0, 162.0);
        pane3.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
        Label marchioLabel1 = new Label(auto2.getMarca());
        marchioLabel1.setLayoutX(14.0);
        marchioLabel1.setLayoutY(43.0);
        marchioLabel1.setPrefSize(107.0, 17.0);
        marchioLabel1.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label modelloLabel1 = new Label(auto2.getModello());
        modelloLabel1.setLayoutX(14.0);
        modelloLabel1.setLayoutY(14.0);
        modelloLabel1.setPrefSize(148.0, 29.0);
        modelloLabel1.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");


        Label alimentazioneLabel1 = new Label(auto2.getAlimentazione());
        alimentazioneLabel1.setLayoutX(183.0);
        alimentazioneLabel1.setLayoutY(20.0);
        alimentazioneLabel1.setRotate(26.1);
        alimentazioneLabel1.setPrefSize(86.0, 17.0);
        alimentazioneLabel1.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button selezionaButton1 = new Button("Seleziona");
        selezionaButton1.setLayoutX(169.0);
        selezionaButton1.setLayoutY(122.0);
        selezionaButton1.setPrefSize(83.0, 28.0);
        selezionaButton1.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(selezionaButton1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        selezionaButton1.setOnAction(e->{
            try {
                cancellaSelezionata(auto2);
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        Button vediMeglio2 = new Button("+");
        vediMeglio2.setLayoutX(127.0);
        vediMeglio2.setLayoutY(122.0);
        vediMeglio2.setPrefSize(35.0, 28.0);
        vediMeglio2.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio2,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio2.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioCancellato(vbox,auto2);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel1 = new Label(auto2.getClass().getSimpleName());
        tipoLabel1.setLayoutX(14.0);
        tipoLabel1.setLayoutY(122.0);
        tipoLabel1.setPrefSize(116.0, 28.0);
        tipoLabel1.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 16.0;");

        pane3.getChildren().addAll(modelloLabel1,marchioLabel1,alimentazioneLabel1,selezionaButton1,vediMeglio2);
        hBox.getChildren().addAll(pane1, pane2, pane3);

        return hBox;
    }
    @FXML
    private HBox aggiungiRigaSola(Auto auto1, VBox vbox) {
        HBox hBox = new HBox();
        hBox.setPrefSize(582.0, 162.0);

        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(271.0, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        Label modelloLabel = new Label(auto1.getModello());
        modelloLabel.setLayoutX(14.0);
        modelloLabel.setLayoutY(14.0);
        modelloLabel.setPrefSize(148.0, 29.0);
        modelloLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        Label marchioLabel = new Label(auto1.getMarca());
        marchioLabel.setLayoutX(14.0);
        marchioLabel.setLayoutY(43.0);
        marchioLabel.setPrefSize(107.0, 17.0);
        marchioLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label alimentazioneLabel = new Label(auto1.getAlimentazione());
        alimentazioneLabel.setLayoutX(183.0);
        alimentazioneLabel.setLayoutY(20.0);
        alimentazioneLabel.setRotate(26.1);
        alimentazioneLabel.setPrefSize(86.0, 17.0);
        alimentazioneLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button selezionaButton = new Button("Seleziona");
        selezionaButton.setLayoutX(169.0);
        selezionaButton.setLayoutY(122.0);
        selezionaButton.setPrefSize(83.0, 28.0);
        selezionaButton.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(selezionaButton,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        selezionaButton.setOnAction(e->{
            try {
                cancellaSelezionata(auto1);
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        Button vediMeglio = new Button("+");
        vediMeglio.setLayoutX(127.0);
        vediMeglio.setLayoutY(122.0);
        vediMeglio.setPrefSize(35.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioCancellato(vbox,auto1);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(14.0);
        tipoLabel.setLayoutY(122.0);
        tipoLabel.setPrefSize(116.0, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 16.0;");

        pane1.getChildren().addAll(modelloLabel, marchioLabel, alimentazioneLabel, selezionaButton, vediMeglio, tipoLabel);

        hBox.getChildren().addAll(pane1);

        return hBox;
    }
    @FXML
    private void cancellaSelezionata(Auto auto){
        if(inventarioAuto.rimuoviAuto(auto)){
            avvisoVisivo("Cancellata", "42f58d");
            boxDinamica.getChildren().clear();
            bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
            entrataAnchor(boxDinamica,0,1200);
            boxDinamica.setVisible(false);
            boxDinamica.setDisable(true);
        }else{
            avvisoVisivo("Auto non trovata","bc0000");
        }
    }
    @FXML
    private void mostraMeglioCancellato(VBox vbox,Auto auto){
        vbox.getChildren().clear();

        HBox hbox1 = new HBox();
        hbox1.setAlignment(javafx.geometry.Pos.CENTER);
        hbox1.setPrefHeight(100.0);
        hbox1.setPrefWidth(200.0);

        Label label1 = new Label(auto.getModello()+"  -  "+auto.getMarca());
        label1.setPrefHeight(66.0);
        label1.setPrefWidth(356.0);
        label1.setFont(Font.font("Pivot Classic", 32.0));

        Pane spacer1 = new Pane();
        spacer1.setPrefHeight(66.0);
        spacer1.setPrefWidth(87.0);

        Button button1 = new Button("<--");
        button1.setPrefHeight(39.0);
        button1.setPrefWidth(113.0);
        button1.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button1.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        button1.setFont(Font.font("Pivot Classic", 12.0));
        cambioColorePassaggioMouse(button1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button1.setOnAction(e->{
            vbox.getChildren().clear();
            entrataAnchor(boxDinamica,0,1200);
            cancellaAuto();
            entrataAnchor(boxDinamica,1200,0);
        });

        hbox1.getChildren().addAll(label1, spacer1, button1);

        // Pane Spacer
        Pane paneSpacer = new Pane();
        paneSpacer.setPrefHeight(11.0);
        paneSpacer.setPrefWidth(572.0);

        // Second HBox
        HBox hbox2 = new HBox();
        hbox2.setPrefHeight(100.0);
        hbox2.setPrefWidth(200.0);

        Pane spacer2 = new Pane();
        spacer2.setPrefHeight(206.0);
        spacer2.setPrefWidth(181.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(206.0);
        imageView.setFitWidth(371.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(ConcessionarioInventarioView.class.getResource("/com/example/pratica724/img/logo.png").toString()));

        hbox2.getChildren().addAll(spacer2, imageView);

        // Labels
        Label label2 = new Label("Specifiche");
        label2.setLayoutX(10.0);
        label2.setLayoutY(10.0);
        label2.setPrefHeight(57.0);
        label2.setPrefWidth(569.0);
        label2.setFont(Font.font("Pivot Classic", 32.0));

        Label label3 = new Label(auto.toString());
        label3.setPrefHeight(800.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }

    //RICERCA
    @FXML
    public void ricercaAuto(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Ricerca auto");
        boxDinamica.getChildren().clear();
        entrataAnchor(boxDinamica,1200,0);
        try {
            ricercaAutoInserimento();
        } catch (Exception e) {
            avvisoVisivo("Errore","bc0000");
        }
    }
    @FXML
    private void ricercaAutoInserimento(){
        // Label 1
        Label label1 = new Label("Inserisci le informazioni richieste:");
        label1.setLayoutX(18);
        label1.setLayoutY(21);
        label1.setPrefSize(579, 39);
        label1.setFont(new Font("Pivot Classic", 18));
        boxDinamica.getChildren().add(label1);

        // Label 2
        Label label2 = new Label("Inserisci la marca");
        label2.setLayoutX(19);
        label2.setLayoutY(45);
        label2.setPrefSize(260, 43);
        label2.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label2);

        // TextField 1
        TextField marca = new TextField();
        marca.setLayoutX(19);
        marca.setLayoutY(92);
        marca.setPrefSize(260, 12);
        marca.setPromptText("Fiat");
        marca.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        marca.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(marca);

        // Label 4
        Label label4 = new Label("Inserisci il colore");
        label4.setLayoutX(301);
        label4.setLayoutY(114);
        label4.setPrefSize(260, 43);
        label4.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label4);

        // TextField 3
        TextField colore = new TextField();
        colore.setLayoutX(301);
        colore.setLayoutY(161);
        colore.setPrefSize(260, 12);
        colore.setPromptText("Rosso");
        colore.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        colore.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(colore);

        // Label 5
        Label label5 = new Label("Inserisci l'alimentazione");
        label5.setLayoutX(19);
        label5.setLayoutY(182);
        label5.setPrefSize(260, 43);
        label5.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label5);

        // Label 7
        Label label7 = new Label("Inserisci il modello");
        label7.setLayoutX(19);
        label7.setLayoutY(114);
        label7.setPrefSize(260, 43);
        label7.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label7);

        // TextField 5
        TextField modello = new TextField();
        modello.setLayoutX(19);
        modello.setLayoutY(161);
        modello.setPrefSize(260, 12);
        modello.setPromptText("Panda");
        modello.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        modello.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(modello);

        // ChoiceBox
        ChoiceBox<String> alimentazione = new ChoiceBox<>();
        alimentazione.setLayoutX(19);
        alimentazione.setLayoutY(229);
        alimentazione.setPrefSize(260, 26);
        alimentazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        alimentazione.getItems().addAll("Benzina", "Diesel", "Elettrico", "Mild-Hybrid",
                "Full-Hybrid", "Plug-in Hybrid", "Idrogeno");

        boxDinamica.getChildren().add(alimentazione);

        // Label 3
        Label label3 = new Label("Inserisci l'anno d'immatricolazione");
        label3.setLayoutX(301);
        label3.setLayoutY(45);
        label3.setPrefSize(260, 43);
        label3.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label3);

        // TextField 2
        TextField annoImmatricolazione = new TextField();
        annoImmatricolazione.setLayoutX(301);
        annoImmatricolazione.setLayoutY(92);
        annoImmatricolazione.setPrefSize(260, 12);
        annoImmatricolazione.setPromptText("2010");
        annoImmatricolazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        annoImmatricolazione.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(annoImmatricolazione);

        // Button
        Button button = new Button("Ricerca");
        button.setLayoutX(19);
        button.setLayoutY(351);
        button.setPrefSize(580, 39);
        button.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setFont(new Font("Pivot Classic", 12));
        button.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        cambioColorePassaggioMouse(button,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setOnAction(e->{
            try {
                mostraAutoTrovate(inventarioAuto.ricerca(marca.getText(),modello.getText(),Integer.parseInt(annoImmatricolazione.getText()),alimentazione.getValue(),colore.getText()));
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }

        });
        boxDinamica.getChildren().add(button);
    }
    @FXML
    public void mostraAutoTrovate( ArrayList<Auto> autoTrovate){
        entrataAnchor(boxDinamica,0,1200);
        bFisso.setText("Auto ricercate");
        boxDinamica.getChildren().clear();
        entrataAnchor(boxDinamica,1200,0);

        if (autoTrovate == null || autoTrovate.isEmpty()) {
            avvisoVisivo("Nessuna auto trovata", "bc0000");
            return;
        }else {
            // ScrollPane
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setLayoutX(14.0);
            scrollPane.setLayoutY(60.0);
            scrollPane.setPrefSize(590.0, 387.0);
            scrollPane.setStyle("-fx-background-color: #F4FAFF;");

            // VBox inside ScrollPane
            VBox vBox = new VBox();
            vBox.setPrefSize(572.0, 408.0);
            vBox.setStyle("-fx-background-color: #F4FAFF;");

            if (autoTrovate.size() % 2 == 0) {
                for (int i = 0; i < autoTrovate.size(); i += 2) {
                    HBox hBox1 = aggiungiRigaVistaRicerca(autoTrovate.get(i), autoTrovate.get(i + 1), vBox, autoTrovate);
                    Pane spazio = new Pane();
                    spazio.setPrefSize(572.0, 50.0);

                    vBox.getChildren().addAll(hBox1, spazio);
                }
            } else {
                for (int i = 0; i < autoTrovate.size() - 1; i += 2) {
                    HBox hBox1 = aggiungiRigaVistaRicerca(autoTrovate.get(i), autoTrovate.get(i + 1), vBox, autoTrovate);
                    Pane spazio = new Pane();
                    spazio.setPrefSize(572.0, 50.0);

                    vBox.getChildren().addAll(hBox1, spazio);
                }
                HBox hBox2 = aggiungiRigaSolaVistaRicerca(autoTrovate.getLast(), vBox, autoTrovate);
                vBox.getChildren().add(hBox2);
            }
            Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
            spazio2.setPrefSize(572.0, 50.0);
            vBox.getChildren().add(spazio2);

            scrollPane.setContent(vBox);

            Label labelTitolo = new Label("Ecco le auto trovate: ");
            labelTitolo.setLayoutX(22.0);
            labelTitolo.setLayoutY(14.0);
            labelTitolo.setPrefSize(575.0, 31.0);
            labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");
            // Aggiunta degli elementi al pannello
            boxDinamica.getChildren().addAll(labelTitolo, scrollPane);
        }
    }

    @FXML
    private HBox aggiungiRigaVistaRicerca(Auto auto1, Auto auto2,VBox vbox,ArrayList<Auto> autoTrovate) {
        HBox hBox = new HBox();
        hBox.setPrefSize(582.0, 162.0);

        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(271.0, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        Label modelloLabel = new Label(auto1.getModello());
        modelloLabel.setLayoutX(14.0);
        modelloLabel.setLayoutY(14.0);
        modelloLabel.setPrefSize(148.0, 29.0);
        modelloLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        Label marchioLabel = new Label(auto1.getMarca());
        marchioLabel.setLayoutX(14.0);
        marchioLabel.setLayoutY(43.0);
        marchioLabel.setPrefSize(107.0, 17.0);
        marchioLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label alimentazioneLabel = new Label(auto1.getAlimentazione());
        alimentazioneLabel.setLayoutX(183.0);
        alimentazioneLabel.setLayoutY(20.0);
        alimentazioneLabel.setRotate(26.1);
        alimentazioneLabel.setPrefSize(86.0, 17.0);
        alimentazioneLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button vediMeglio = new Button("+");
        vediMeglio.setLayoutX(127.0);
        vediMeglio.setLayoutY(122.0);
        vediMeglio.setPrefSize(55.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioRicerca(vbox,auto1,autoTrovate);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(14.0);
        tipoLabel.setLayoutY(122.0);
        tipoLabel.setPrefSize(116.0, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modelloLabel, marchioLabel, alimentazioneLabel, vediMeglio, tipoLabel);

        // Second Pane (spacer)
        Pane pane2 = new Pane();
        pane2.setPrefSize(46.0, 162.0);
        pane2.setStyle("-fx-background-color: #F4FAFF;");

        // Third Pane
        Pane pane3 = new Pane();
        pane3.setPrefSize(271.0, 162.0);
        pane3.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
        Label marchioLabel1 = new Label(auto2.getMarca());
        marchioLabel1.setLayoutX(14.0);
        marchioLabel1.setLayoutY(43.0);
        marchioLabel1.setPrefSize(107.0, 17.0);
        marchioLabel1.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label modelloLabel1 = new Label(auto2.getModello());
        modelloLabel1.setLayoutX(14.0);
        modelloLabel1.setLayoutY(14.0);
        modelloLabel1.setPrefSize(148.0, 29.0);
        modelloLabel1.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");


        Label alimentazioneLabel1 = new Label(auto2.getAlimentazione());
        alimentazioneLabel1.setLayoutX(183.0);
        alimentazioneLabel1.setLayoutY(20.0);
        alimentazioneLabel1.setRotate(26.1);
        alimentazioneLabel1.setPrefSize(86.0, 17.0);
        alimentazioneLabel1.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button vediMeglio2 = new Button("+");
        vediMeglio2.setLayoutX(127.0);
        vediMeglio2.setLayoutY(122.0);
        vediMeglio2.setPrefSize(55.0, 28.0);
        vediMeglio2.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio2,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio2.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioRicerca(vbox,auto2,autoTrovate);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel1 = new Label(auto2.getClass().getSimpleName());
        tipoLabel1.setLayoutX(14.0);
        tipoLabel1.setLayoutY(122.0);
        tipoLabel1.setPrefSize(116.0, 28.0);
        tipoLabel1.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane3.getChildren().addAll(modelloLabel1,marchioLabel1,alimentazioneLabel1,vediMeglio2);
        hBox.getChildren().addAll(pane1, pane2, pane3);

        return hBox;
    }
    @FXML
    private HBox aggiungiRigaSolaVistaRicerca(Auto auto1, VBox vbox,ArrayList<Auto> autoTrovate) {
        HBox hBox = new HBox();
        hBox.setPrefSize(582.0, 162.0);

        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(271.0, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        Label modelloLabel = new Label(auto1.getModello());
        modelloLabel.setLayoutX(14.0);
        modelloLabel.setLayoutY(14.0);
        modelloLabel.setPrefSize(148.0, 29.0);
        modelloLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        Label marchioLabel = new Label(auto1.getMarca());
        marchioLabel.setLayoutX(14.0);
        marchioLabel.setLayoutY(43.0);
        marchioLabel.setPrefSize(107.0, 17.0);
        marchioLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label alimentazioneLabel = new Label(auto1.getAlimentazione());
        alimentazioneLabel.setLayoutX(183.0);
        alimentazioneLabel.setLayoutY(20.0);
        alimentazioneLabel.setRotate(26.1);
        alimentazioneLabel.setPrefSize(86.0, 17.0);
        alimentazioneLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button vediMeglio = new Button("+");
        vediMeglio.setLayoutX(127.0);
        vediMeglio.setLayoutY(122.0);
        vediMeglio.setPrefSize(55.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioRicerca(vbox,auto1,autoTrovate);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(14.0);
        tipoLabel.setLayoutY(122.0);
        tipoLabel.setPrefSize(116.0, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modelloLabel, marchioLabel, alimentazioneLabel, vediMeglio, tipoLabel);

        hBox.getChildren().addAll(pane1);

        return hBox;
    }
    @FXML
    private void mostraMeglioRicerca(VBox vbox,Auto auto,ArrayList<Auto> autoTrovate){
        vbox.getChildren().clear();

        HBox hbox1 = new HBox();
        hbox1.setAlignment(javafx.geometry.Pos.CENTER);
        hbox1.setPrefHeight(100.0);
        hbox1.setPrefWidth(200.0);

        Label label1 = new Label(auto.getModello()+"  -  "+auto.getMarca());
        label1.setPrefHeight(66.0);
        label1.setPrefWidth(356.0);
        label1.setFont(Font.font("Pivot Classic", 32.0));

        Pane spacer1 = new Pane();
        spacer1.setPrefHeight(66.0);
        spacer1.setPrefWidth(87.0);

        Button button1 = new Button("<--");
        button1.setPrefHeight(39.0);
        button1.setPrefWidth(113.0);
        button1.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button1.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        button1.setFont(Font.font("Pivot Classic", 12.0));
        cambioColorePassaggioMouse(button1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button1.setOnAction(e->{
            vbox.getChildren().clear();
            entrataAnchor(boxDinamica,0,1200);
            mostraAutoTrovate(autoTrovate);
            entrataAnchor(boxDinamica,1200,0);
        });

        hbox1.getChildren().addAll(label1, spacer1, button1);

        // Pane Spacer
        Pane paneSpacer = new Pane();
        paneSpacer.setPrefHeight(11.0);
        paneSpacer.setPrefWidth(572.0);

        // Second HBox
        HBox hbox2 = new HBox();
        hbox2.setPrefHeight(100.0);
        hbox2.setPrefWidth(200.0);

        Pane spacer2 = new Pane();
        spacer2.setPrefHeight(206.0);
        spacer2.setPrefWidth(181.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(206.0);
        imageView.setFitWidth(371.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(ConcessionarioInventarioView.class.getResource("/com/example/pratica724/img/logo.png").toString()));

        hbox2.getChildren().addAll(spacer2, imageView);

        // Labels
        Label label2 = new Label("Specifiche");
        label2.setLayoutX(10.0);
        label2.setLayoutY(10.0);
        label2.setPrefHeight(57.0);
        label2.setPrefWidth(569.0);
        label2.setFont(Font.font("Pivot Classic", 32.0));

        Label label3 = new Label(auto.toString());
        label3.setPrefHeight(800.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }

    //Mostra
    @FXML
    public void mostraTutto(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Auto disponibili");
        boxDinamica.getChildren().clear();
        entrataAnchor(boxDinamica,1200,0);

        // ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(14.0);
        scrollPane.setLayoutY(60.0);
        scrollPane.setPrefSize(590.0, 387.0);
        scrollPane.setStyle("-fx-background-color: #F4FAFF;");

        // VBox inside ScrollPane
        VBox vBox = new VBox();
        vBox.setPrefSize(572.0, 408.0);
        vBox.setStyle("-fx-background-color: #F4FAFF;");

        if (inventarioAuto.getInventario().size()%2==0){
            for (int i=0;i<inventarioAuto.getInventario().size();i+=2){
                HBox hBox1 = aggiungiRigaVista(inventarioAuto.getInventario().get(i),inventarioAuto.getInventario().get(i+1),vBox);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
        }else{
            for (int i=0;i<inventarioAuto.getInventario().size()-1;i+=2){
                HBox hBox1 = aggiungiRigaVista(inventarioAuto.getInventario().get(i),inventarioAuto.getInventario().get(i+1),vBox);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
            HBox hBox2 = aggiungiRigaSolaVista(inventarioAuto.getInventario().getLast(),vBox);
            vBox.getChildren().add(hBox2);
        }
        Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
        spazio2.setPrefSize(572.0, 50.0);
        vBox.getChildren().add(spazio2);

        scrollPane.setContent(vBox);

        Label labelTitolo = new Label("Ecco tutte le auto: ");
        labelTitolo.setLayoutX(22.0);
        labelTitolo.setLayoutY(14.0);
        labelTitolo.setPrefSize(575.0, 31.0);
        labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");
        // Aggiunta degli elementi al pannello
        boxDinamica.getChildren().addAll(labelTitolo,scrollPane);
    }
    @FXML
    private void mostraMeglio(VBox vbox,Auto auto){
        entrataAnchor(boxDinamica,1200,0);
        vbox.getChildren().clear();

        HBox hbox1 = new HBox();
        hbox1.setAlignment(javafx.geometry.Pos.CENTER);
        hbox1.setPrefHeight(100.0);
        hbox1.setPrefWidth(200.0);

        Label label1 = new Label(auto.getModello()+"  -  "+auto.getMarca());
        label1.setPrefHeight(66.0);
        label1.setPrefWidth(356.0);
        label1.setFont(Font.font("Pivot Classic", 32.0));

        Pane spacer1 = new Pane();
        spacer1.setPrefHeight(66.0);
        spacer1.setPrefWidth(87.0);

        Button button1 = new Button("<--");
        button1.setPrefHeight(39.0);
        button1.setPrefWidth(113.0);
        button1.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button1.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        button1.setFont(Font.font("Pivot Classic", 12.0));
        cambioColorePassaggioMouse(button1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button1.setOnAction(e->{
            vbox.getChildren().clear();
            entrataAnchor(boxDinamica,0,1200);
            mostraTutto();
            entrataAnchor(boxDinamica,1200,0);
        });

        hbox1.getChildren().addAll(label1, spacer1, button1);

        // Pane Spacer
        Pane paneSpacer = new Pane();
        paneSpacer.setPrefHeight(11.0);
        paneSpacer.setPrefWidth(572.0);

        // Second HBox
        HBox hbox2 = new HBox();
        hbox2.setPrefHeight(100.0);
        hbox2.setPrefWidth(200.0);

        Pane spacer2 = new Pane();
        spacer2.setPrefHeight(206.0);
        spacer2.setPrefWidth(181.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(206.0);
        imageView.setFitWidth(371.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(ConcessionarioInventarioView.class.getResource("/com/example/pratica724/img/logo.png").toString()));

        hbox2.getChildren().addAll(spacer2, imageView);

        // Labels
        Label label2 = new Label("Specifiche");
        label2.setLayoutX(10.0);
        label2.setLayoutY(10.0);
        label2.setPrefHeight(57.0);
        label2.setPrefWidth(569.0);
        label2.setFont(Font.font("Pivot Classic", 32.0));

        Label label3 = new Label(auto.toString());
        label3.setPrefHeight(800.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }
    @FXML
    private HBox aggiungiRigaVista(Auto auto1, Auto auto2,VBox vbox) {
        HBox hBox = new HBox();
        hBox.setPrefSize(582.0, 162.0);

        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(271.0, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        Label modelloLabel = new Label(auto1.getModello());
        modelloLabel.setLayoutX(14.0);
        modelloLabel.setLayoutY(14.0);
        modelloLabel.setPrefSize(148.0, 29.0);
        modelloLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        Label marchioLabel = new Label(auto1.getMarca());
        marchioLabel.setLayoutX(14.0);
        marchioLabel.setLayoutY(43.0);
        marchioLabel.setPrefSize(107.0, 17.0);
        marchioLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label alimentazioneLabel = new Label(auto1.getAlimentazione());
        alimentazioneLabel.setLayoutX(183.0);
        alimentazioneLabel.setLayoutY(20.0);
        alimentazioneLabel.setRotate(26.1);
        alimentazioneLabel.setPrefSize(86.0, 17.0);
        alimentazioneLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button vediMeglio = new Button("+");
        vediMeglio.setLayoutX(127.0);
        vediMeglio.setLayoutY(122.0);
        vediMeglio.setPrefSize(55.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglio(vbox,auto1);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(14.0);
        tipoLabel.setLayoutY(122.0);
        tipoLabel.setPrefSize(116.0, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modelloLabel, marchioLabel, alimentazioneLabel, vediMeglio, tipoLabel);

        // Second Pane (spacer)
        Pane pane2 = new Pane();
        pane2.setPrefSize(46.0, 162.0);
        pane2.setStyle("-fx-background-color: #F4FAFF;");

        // Third Pane
        Pane pane3 = new Pane();
        pane3.setPrefSize(271.0, 162.0);
        pane3.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
        Label marchioLabel1 = new Label(auto2.getMarca());
        marchioLabel1.setLayoutX(14.0);
        marchioLabel1.setLayoutY(43.0);
        marchioLabel1.setPrefSize(107.0, 17.0);
        marchioLabel1.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label modelloLabel1 = new Label(auto2.getModello());
        modelloLabel1.setLayoutX(14.0);
        modelloLabel1.setLayoutY(14.0);
        modelloLabel1.setPrefSize(148.0, 29.0);
        modelloLabel1.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");


        Label alimentazioneLabel1 = new Label(auto2.getAlimentazione());
        alimentazioneLabel1.setLayoutX(183.0);
        alimentazioneLabel1.setLayoutY(20.0);
        alimentazioneLabel1.setRotate(26.1);
        alimentazioneLabel1.setPrefSize(86.0, 17.0);
        alimentazioneLabel1.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button vediMeglio2 = new Button("+");
        vediMeglio2.setLayoutX(127.0);
        vediMeglio2.setLayoutY(122.0);
        vediMeglio2.setPrefSize(55.0, 28.0);
        vediMeglio2.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio2,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio2.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglio(vbox,auto2);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel1 = new Label(auto2.getClass().getSimpleName());
        tipoLabel1.setLayoutX(14.0);
        tipoLabel1.setLayoutY(122.0);
        tipoLabel1.setPrefSize(116.0, 28.0);
        tipoLabel1.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane3.getChildren().addAll(modelloLabel1,marchioLabel1,alimentazioneLabel1,vediMeglio2);
        hBox.getChildren().addAll(pane1, pane2, pane3);

        return hBox;
    }
    @FXML
    private HBox aggiungiRigaSolaVista(Auto auto1, VBox vbox) {
        HBox hBox = new HBox();
        hBox.setPrefSize(582.0, 162.0);

        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(271.0, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        Label modelloLabel = new Label(auto1.getModello());
        modelloLabel.setLayoutX(14.0);
        modelloLabel.setLayoutY(14.0);
        modelloLabel.setPrefSize(148.0, 29.0);
        modelloLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        Label marchioLabel = new Label(auto1.getMarca());
        marchioLabel.setLayoutX(14.0);
        marchioLabel.setLayoutY(43.0);
        marchioLabel.setPrefSize(107.0, 17.0);
        marchioLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 12.0;");

        Label alimentazioneLabel = new Label(auto1.getAlimentazione());
        alimentazioneLabel.setLayoutX(183.0);
        alimentazioneLabel.setLayoutY(20.0);
        alimentazioneLabel.setRotate(26.1);
        alimentazioneLabel.setPrefSize(86.0, 17.0);
        alimentazioneLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button vediMeglio = new Button("+");
        vediMeglio.setLayoutX(127.0);
        vediMeglio.setLayoutY(122.0);
        vediMeglio.setPrefSize(55.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglio(vbox,auto1);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(14.0);
        tipoLabel.setLayoutY(122.0);
        tipoLabel.setPrefSize(116.0, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modelloLabel, marchioLabel, alimentazioneLabel, vediMeglio, tipoLabel);

        hBox.getChildren().addAll(pane1);

        return hBox;
    }

    //Animazione
    @FXML
    private void cambioColorePassaggioMouse(Button button, String style1, String style2){
        button.setOnMouseMoved(event -> {
            button.setStyle(style1);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(style2);
        });
    }
    @FXML
    private void avvisoVisivo(String string, String colore){
        bFisso.setStyle("-fx-background-color: #"+colore+"; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
        //String s=bFisso.getText();
        bFisso.setText(string);
        PauseTransition pausa = new PauseTransition(Duration.seconds(3));
        pausa.setOnFinished(e -> {
            bFisso.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
            bFisso.setText("Benvenuto/a");
        });
        pausa.play();
    }

    @FXML
    private void entrataAnchor(AnchorPane anchorPane, int xIn, int xFin) {
        anchorPane.setTranslateX(xIn);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), anchorPane);
        translateTransition.setFromX(xIn);
        translateTransition.setToX(xFin);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    //cambio schermata
    @FXML
    private void tornaHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("concessionario-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.getIcons().add(new Image(HelloApplication.class.getResource("/com/example/pratica724/img/logo.png").toString()));
        stage.setScene(scene);

        ConcessionarioController concessionarioController=fxmlLoader.getController();
        concessionarioController.setConcessionario(this.concessionario);
        concessionarioController.setFirstView(false);
        concessionarioController.initializeAComando();
    }
}
