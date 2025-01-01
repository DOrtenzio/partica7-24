package com.example.pratica724;

import com.example.pratica724.auto.*;
import com.example.pratica724.utenti.Concessionario;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class ConcessionarioInventarioView {
    @FXML
    private Button b1,b2,b3,bFisso;
    @FXML
    private AnchorPane boxDinamica,boxPulsanti;

    private Concessionario concessionario;

    public void setConcessionario(Concessionario concessionario){
        this.concessionario=concessionario;
        bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
    }

    //fase iniziale
    @FXML
    private void initialize(){
        cambioColorePassaggioMouse(b1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b2,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b3,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");

        entrataAnchor(boxPulsanti,-300,0);
    }

    //metodi
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

        Label labelDescrizione = new Label("Inserisci la descrizione (Opzionale) :");
        labelDescrizione.setLayoutX(301);
        labelDescrizione.setLayoutY(148);
        labelDescrizione.setPrefSize(260, 43);
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
            bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
            entrataAnchor(boxDinamica,0,1200);
            boxDinamica.setVisible(false);
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
            if (usata.isSelected()){
                concessionario.getInventario().aggiungiAuto(new AutoUsata(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),Integer.parseInt(annoImmatricolazione.getText()),alimentazione.getValue(),Integer.parseInt(chilometraggio.getText()),colore.getText(),descrizione.getText()));
            }else{
                concessionario.getInventario().aggiungiAuto(new AutoKm0(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),Integer.parseInt(annoImmatricolazione.getText()), alimentazione.getValue(), colore.getText(), descrizione.getText(),Integer.parseInt(chilometraggio.getText())));
            }
            avvisoVisivo("Ottimo", "42f58d");
            boxDinamica.getChildren().clear();
            bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
            entrataAnchor(boxDinamica,0,1200);
            boxDinamica.setVisible(false);
        });

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
        inserisciButton.setOnAction(e->{
            if (special.isSelected()){
                concessionario.getInventario().aggiungiAuto(new AutoSpeciali(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),alimentazione.getValue(),colore.getText(),descrizione.getText(),aggiunte.getText(),Double.parseDouble(incentivo.getText())));
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
                inserisciButton2.setOnAction(event->{
                    concessionario.getInventario().aggiungiAuto(new AutoDisabili(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),alimentazione.getValue(),colore.getText(),descrizione.getText(),aggiunte.getText(),Double.parseDouble(incentivo.getText()),Double.parseDouble(largh.getText())));
                    avvisoVisivo("Ottimo", "42f58d");
                    boxDinamica.getChildren().clear();
                    bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
                    entrataAnchor(boxDinamica,0,1200);
                    boxDinamica.setVisible(false);
                });
                boxDinamica.getChildren().add(inserisciButton2);
            }
        });

        boxDinamica.getChildren().add(inserisciButton);
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
        String s=bFisso.getText();
        bFisso.setText(string);
        PauseTransition pausa = new PauseTransition(Duration.seconds(3));
        pausa.setOnFinished(e -> {
            bFisso.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
            bFisso.setText(s);
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
}
