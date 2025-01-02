package com.example.pratica724;

import com.example.pratica724.auto.Auto;
import com.example.pratica724.auto.AutoUsata;
import com.example.pratica724.auto.InventarioAuto;
import com.example.pratica724.auto.RegistroAcquisti;
import com.example.pratica724.utenti.Concessionario;
import com.example.pratica724.utenti.Privato;
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
import java.util.Arrays;

public class ClienteController {
    @FXML
    private AnchorPane vistaPrincipale, vistaConfronti,vistaInfo,vistaDinamica;
    @FXML
    private Button bIndietro,bAvanti,bInserisci,bFisso,b1,b11;
    @FXML
    private TextField t1,t2,t3,t4,t5,t6,t7;

    private Concessionario concessionario;
    private Privato privato;

    private boolean isFirstView;
    private boolean [] filtriSelezionati=new boolean[5];
    private InventarioAuto inventarioAuto;
    private RegistroAcquisti registroAcquisti;

    //set informazioni
    public void setConcessionario(Concessionario concessionario){
        this.concessionario=concessionario;
        this.inventarioAuto=concessionario.getInventario();
        this.registroAcquisti=concessionario.getRegistroAcquisti();
    }
    public void setFirstView( boolean isFirstView ) { this.isFirstView=isFirstView; }
    public void setPrivato (Privato privato){ this.privato=privato; }

    //Metodi iniziali
    @FXML
    public void initializeAComando(){
        if (isFirstView) {
            entrataAnchor(vistaInfo, -300, 0);
            isFirstView=false;
        }else{
            vistaInfo.setDisable(true);
            vistaInfo.setVisible(false);

            bIndietro.setVisible(true);
            bAvanti.setVisible(true);
            vistaPrincipale.setDisable(false);
            vistaPrincipale.setVisible(true);
            entrataAnchor(vistaPrincipale,-300,0);
        }
        cambioColorePassaggioMouse(bIndietro,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(bAvanti,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(bInserisci,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
    }
    @FXML
    private void setInfoPrivato(){
        boolean isOk=true;
        privato.setNomeUtente(t1.getText());
        privato.setLocazione(t2.getText());
        privato.setEmail(t3.getText());
        privato.setTelefono(t4.getText());
        privato.setCodiceFiscale(t7.getText());
        privato.setNumeroCie(t6.getText());
        privato.setNomeCognome(t5.getText());

        //TODO: INSERIRE CONTROLLO

        if (!isOk)
            avvisoVisivo("Errore","bc0000");
        else {
            setAutoPrivato();
        }
    }
    @FXML
    private void setAutoPrivato(){
        vistaInfo.getChildren().clear();

        // Label 1
        Label label1 = new Label("Inserisci le informazioni richieste:");
        label1.setLayoutX(18);
        label1.setLayoutY(21);
        label1.setPrefSize(579, 39);
        label1.setFont(new Font("Pivot Classic", 18));
        vistaInfo.getChildren().add(label1);

        // Other Labels, TextFields, and Components
        Label marcaLabel = new Label("Inserisci la marca");
        marcaLabel.setLayoutX(19);
        marcaLabel.setLayoutY(45);
        marcaLabel.setPrefSize(260, 43);
        marcaLabel.setFont(new Font("Pivot Classic", 14));
        vistaInfo.getChildren().add(marcaLabel);

        TextField marca = new TextField();
        marca.setLayoutX(19);
        marca.setLayoutY(92);
        marca.setPrefSize(260, 12);
        marca.setPromptText("Fiat");
        marca.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        marca.setFont(new Font("Goudy Old Style", 12));
        vistaInfo.getChildren().add(marca);

        Label modelloLabel = new Label("Inserisci il modello");
        modelloLabel.setLayoutX(19);
        modelloLabel.setLayoutY(120);
        modelloLabel.setPrefSize(260, 43);
        modelloLabel.setFont(new Font("Pivot Classic", 14));
        vistaInfo.getChildren().add(modelloLabel);

        TextField modello = new TextField();
        modello.setLayoutX(19);
        modello.setLayoutY(167);
        modello.setPrefSize(260, 12);
        modello.setPromptText("Panda");
        modello.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        modello.setFont(new Font("Goudy Old Style", 12));
        vistaInfo.getChildren().add(modello);

        Label alimentazioneLabel = new Label("Inserisci l'alimentazione");
        alimentazioneLabel.setLayoutX(19);
        alimentazioneLabel.setLayoutY(195);
        alimentazioneLabel.setPrefSize(260, 43);
        alimentazioneLabel.setFont(new Font("Pivot Classic", 14));
        vistaInfo.getChildren().add(alimentazioneLabel);

        ChoiceBox<String> alimentazione = new ChoiceBox<>();
        alimentazione.setLayoutX(19);
        alimentazione.setLayoutY(242);
        alimentazione.setPrefSize(260, 26);
        alimentazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        alimentazione.getItems().addAll("Benzina", "Diesel", "Elettrico", "Mild-Hybrid", "Full-Hybrid", "Plug-in Hybrid", "Idrogeno");
        vistaInfo.getChildren().add(alimentazione);

        Label coloreLabel = new Label("Inserisci il colore");
        coloreLabel.setLayoutX(19);
        coloreLabel.setLayoutY(270);
        coloreLabel.setPrefSize(260, 43);
        coloreLabel.setFont(new Font("Pivot Classic", 14));
        vistaInfo.getChildren().add(coloreLabel);

        TextField colore = new TextField();
        colore.setLayoutX(19);
        colore.setLayoutY(317);
        colore.setPrefSize(260, 12);
        colore.setPromptText("Rosso");
        colore.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        colore.setFont(new Font("Goudy Old Style", 12));
        vistaInfo.getChildren().add(colore);


        // Label: Chilometraggio
        Label chilometraggioLabel = new Label("Inserisci il chilometraggio");
        chilometraggioLabel.setLayoutX(301);
        chilometraggioLabel.setLayoutY(120);
        chilometraggioLabel.setPrefSize(260, 43);
        chilometraggioLabel.setFont(new Font("Pivot Classic", 14));
        vistaInfo.getChildren().add(chilometraggioLabel);

        // Label: Descrizione (Opzionale)
        Label descrizioneLabel = new Label("Descrizione (Opzionale)");
        descrizioneLabel.setLayoutX(302);
        descrizioneLabel.setLayoutY(185);
        descrizioneLabel.setPrefSize(260, 43);
        descrizioneLabel.setFont(new Font("Pivot Classic", 14));
        vistaInfo.getChildren().add(descrizioneLabel);

        // Label: Anno d'Immatricolazione
        Label immatricolazioneLabel = new Label("Inserisci l'anno d'Immatricolazione");
        immatricolazioneLabel.setLayoutX(301);
        immatricolazioneLabel.setLayoutY(45);
        immatricolazioneLabel.setPrefSize(260, 43);
        immatricolazioneLabel.setFont(new Font("Pivot Classic", 14));
        vistaInfo.getChildren().add(immatricolazioneLabel);

        TextField annoImmatricolazione = new TextField();
        annoImmatricolazione.setLayoutX(301);
        annoImmatricolazione.setLayoutY(92);
        annoImmatricolazione.setPrefSize(260, 12);
        annoImmatricolazione.setPromptText("2010");
        annoImmatricolazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        annoImmatricolazione.setFont(new Font("Goudy Old Style", 12));
        vistaInfo.getChildren().add(annoImmatricolazione);

        TextArea descrizione = new TextArea();
        descrizione.setLayoutX(301);
        descrizione.setLayoutY(231);
        descrizione.setPrefSize(260, 155);
        descrizione.setPromptText("Modello speciale 50 anni");
        descrizione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        descrizione.setFont(new Font("Goudy Old Style", 12));
        vistaInfo.getChildren().add(descrizione);

        TextField chilometraggio = new TextField();
        chilometraggio.setLayoutX(301);
        chilometraggio.setLayoutY(161);
        chilometraggio.setPrefSize(260, 12);
        chilometraggio.setPromptText("200.000");
        chilometraggio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        chilometraggio.setFont(new Font("Goudy Old Style", 12));
        vistaInfo.getChildren().add(chilometraggio);

        // Button
        Button inserisciButton = new Button("Fine");
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
                privato.setAutoAttuale(new AutoUsata(marca.getText(),modello.getText(),0.0,Integer.parseInt(annoImmatricolazione.getText()), alimentazione.getValue(), Integer.parseInt(chilometraggio.getText()), colore.getText(), descrizione.getText()));
                avvisoVisivo("Ottimo", "42f58d");
                vistaInfo.getChildren().clear();
                bFisso.setText("Benvenuto/a "+privato.getNomeUtente());
                entrataAnchor(vistaInfo,0,1200);

                vistaInfo.setVisible(false);
                vistaInfo.setDisable(true);
                bIndietro.setVisible(true);
                bAvanti.setVisible(true);
                vistaPrincipale.setDisable(false);
                vistaPrincipale.setVisible(true);
                entrataAnchor(vistaPrincipale,-300,0);
                schermataPrincipale(inventarioAuto.getInventario());

                cambioColorePassaggioMouse(b1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
                cambioColorePassaggioMouse(b11,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }

        });

        vistaInfo.getChildren().add(inserisciButton);
    }

    //Schermata principale
    @FXML
    public void schermataPrincipale(ArrayList<Auto> autoVisibili){
        bFisso.setText("Rimuovi un'auto");
        vistaDinamica.getChildren().clear();

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

        if (autoVisibili.size()%2==0){
            for (int i=0;i<autoVisibili.size();i+=2){
                HBox hBox1 = aggiungiRiga(autoVisibili.get(i),autoVisibili.get(i+1),vBox,autoVisibili);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
        }else{
            for (int i=0;i<autoVisibili.size()-1;i+=2){
                HBox hBox1 = aggiungiRiga(autoVisibili.get(i),autoVisibili.get(i+1),vBox,autoVisibili);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
            HBox hBox2 = aggiungiRigaSola(autoVisibili.getLast(),vBox,autoVisibili);
            vBox.getChildren().add(hBox2);
        }
        Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
        spazio2.setPrefSize(572.0, 50.0);
        vBox.getChildren().add(spazio2);

        scrollPane.setContent(vBox);

        Label labelTitolo = new Label("Ecco la nostra selezione d'auto : ");
        labelTitolo.setLayoutX(22.0);
        labelTitolo.setLayoutY(14.0);
        labelTitolo.setPrefSize(575.0, 31.0);
        labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");
        // Aggiunta degli elementi al pannello
        vistaDinamica.getChildren().addAll(labelTitolo,scrollPane);
    }

    //Metodi x popolare schermata principale
    @FXML
    private HBox aggiungiRiga(Auto auto1, Auto auto2, VBox vbox,ArrayList<Auto> autoVisibili) {
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

        Button selezionaButton = new Button("⭐");
        selezionaButton.setLayoutX(169.0);
        selezionaButton.setLayoutY(122.0);
        selezionaButton.setPrefSize(83.0, 28.0);
        selezionaButton.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        selezionaButton.setOnAction(e->{
            try {
                aggiungiAiPreferiti(auto1);
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
            mostraMeglio(vbox,auto1,autoVisibili);
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

        Button selezionaButton1 = new Button("⭐");
        selezionaButton1.setLayoutX(169.0);
        selezionaButton1.setLayoutY(122.0);
        selezionaButton1.setPrefSize(83.0, 28.0);
        selezionaButton1.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(selezionaButton1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        selezionaButton1.setOnAction(e->{
            try {
                aggiungiAiPreferiti(auto2);
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
            mostraMeglio(vbox,auto2,autoVisibili);
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
    private HBox aggiungiRigaSola(Auto auto1, VBox vbox,ArrayList<Auto> autoVisibili) {
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

        Button selezionaButton = new Button("⭐");
        selezionaButton.setLayoutX(169.0);
        selezionaButton.setLayoutY(122.0);
        selezionaButton.setPrefSize(83.0, 28.0);
        selezionaButton.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(selezionaButton,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        selezionaButton.setOnAction(e->{
            try {
                aggiungiAiPreferiti(auto1);
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
            mostraMeglio(vbox,auto1,autoVisibili);
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
    private void aggiungiAiPreferiti(Auto auto){
        privato.aggiungiAutoPreferite(auto);
        avvisoVisivo("Inserita", "42f58d");
        bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
    }
    @FXML
    private void mostraMeglio(VBox vbox, Auto auto, ArrayList<Auto> autoVisibili){
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
            schermataPrincipale(autoVisibili);
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
        imageView.setImage(new Image(ClienteController.class.getResource("/com/example/pratica724/img/logo.png").toString()));

        hbox2.getChildren().addAll(spacer2, imageView);

        // Labels
        Label label2 = new Label("Specifiche");
        label2.setLayoutX(10.0);
        label2.setLayoutY(10.0);
        label2.setPrefHeight(57.0);
        label2.setPrefWidth(569.0);
        label2.setFont(Font.font("Pivot Classic", 32.0));

        Label label3 = new Label(auto.toString());
        label3.setPrefHeight(121.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }

    //Filtri
    @FXML
    private void filtra(){
        vistaDinamica.getChildren().clear();

        // Create the Label
        Label label = new Label("Seleziona le categorie che vuoi vedere");
        label.setLayoutX(37.0);
        label.setLayoutY(14.0);
        label.setPrefSize(393.0, 18.0);
        label.setFont(Font.font("Pivot Classic", 18.0));

        // Create CheckBoxes
        CheckBox nuove = new CheckBox("Auto nuove");
        nuove.setLayoutX(37.0);
        nuove.setLayoutY(66.0);
        nuove.setMnemonicParsing(false);
        nuove.setSelected(filtriSelezionati[0]);
        nuove.setPrefSize(312.0, 24.0);
        nuove.setFont(Font.font("Goudy Old Style Bold", 18.0));

        CheckBox usate = new CheckBox("Auto usate");
        usate.setLayoutX(37.0);
        usate.setLayoutY(104.0);
        usate.setMnemonicParsing(false);
        usate.setSelected(filtriSelezionati[1]);
        usate.setPrefSize(312.0, 24.0);
        usate.setFont(Font.font("Goudy Old Style Bold", 18.0));

        CheckBox km0 = new CheckBox("Auto Km0");
        km0.setLayoutX(37.0);
        km0.setLayoutY(144.0);
        km0.setMnemonicParsing(false);
        km0.setSelected(filtriSelezionati[2]);
        km0.setPrefSize(312.0, 24.0);
        km0.setFont(Font.font("Goudy Old Style Bold", 18.0));

        CheckBox speciali = new CheckBox("Auto speciali");
        speciali.setLayoutX(37.0);
        speciali.setLayoutY(180.0);
        speciali.setMnemonicParsing(false);
        speciali.setSelected(filtriSelezionati[3]);
        speciali.setPrefSize(312.0, 24.0);
        speciali.setFont(Font.font("Goudy Old Style Bold", 18.0));

        CheckBox disabili = new CheckBox("Auto disabili");
        disabili.setLayoutX(37.0);
        disabili.setLayoutY(218.0);
        disabili.setMnemonicParsing(false);
        disabili.setSelected(filtriSelezionati[4]);
        disabili.setPrefSize(312.0, 24.0);
        disabili.setFont(Font.font("Goudy Old Style Bold", 18.0));

        // Create Buttons
        Button inserisciFiltri = new Button("Inserisci filtri");
        inserisciFiltri.setLayoutX(393.0);
        inserisciFiltri.setLayoutY(271.0);
        inserisciFiltri.setPrefSize(203.0, 28.0);
        inserisciFiltri.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        inserisciFiltri.setTextFill(javafx.scene.paint.Color.web("#30323D"));
        inserisciFiltri.setFont(Font.font("Pivot Classic", 16.0));
        inserisciFiltri.setOnAction(e->{
            ArrayList <Auto> autoFiltrate=new ArrayList<Auto>();
            if (nuove.isSelected()) {
                autoFiltrate.addAll(inventarioAuto.ricercaAutoNuove());
                filtriSelezionati[0]=true;
            }else
                filtriSelezionati[0]=false;
            if (usate.isSelected()) {
                autoFiltrate.addAll(inventarioAuto.ricercaAutoUsate());
                filtriSelezionati[1]=true;
            }else
                filtriSelezionati[1]=false;
            if (km0.isSelected()) {
                autoFiltrate.addAll(inventarioAuto.ricercaAutoKm0());
                filtriSelezionati[2]=true;
            }else
                filtriSelezionati[2]=false;
            if (speciali.isSelected()) {
                autoFiltrate.addAll(inventarioAuto.ricercaAutoSpeciali());
                filtriSelezionati[3]=true;
            }else
                filtriSelezionati[3]=false;
            if (disabili.isSelected()) {
                autoFiltrate.addAll(inventarioAuto.ricercaAutoDisabili());
                filtriSelezionati[4]=true;
            }else
                filtriSelezionati[4]=false;

            schermataPrincipale(autoFiltrate);
        });

        Button cancellaFiltri = new Button("Cancella filtri");
        cancellaFiltri.setLayoutX(173.0);
        cancellaFiltri.setLayoutY(271.0);
        cancellaFiltri.setPrefSize(203.0, 38.0);
        cancellaFiltri.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cancellaFiltri.setTextFill(javafx.scene.paint.Color.web("#30323D"));
        cancellaFiltri.setFont(Font.font("Pivot Classic", 16.0));
        cancellaFiltri.setOnAction(e->{
            Arrays.fill(filtriSelezionati,false);
            schermataPrincipale(inventarioAuto.getInventario());
        });

        // Add all elements to the root
        vistaDinamica.getChildren().addAll(label, nuove, usate, km0, speciali, disabili, inserisciFiltri, cancellaFiltri);
    }

    //Ricerca
    @FXML
    public void ricercaAuto(){
        bFisso.setText("Ricerca auto");
        vistaDinamica.getChildren().clear();
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
        vistaDinamica.getChildren().add(label1);

        // Label 2
        Label label2 = new Label("Inserisci la marca");
        label2.setLayoutX(19);
        label2.setLayoutY(45);
        label2.setPrefSize(260, 43);
        label2.setFont(new Font("Pivot Classic", 14));
        vistaDinamica.getChildren().add(label2);

        // TextField 1
        TextField marca = new TextField();
        marca.setLayoutX(19);
        marca.setLayoutY(92);
        marca.setPrefSize(260, 12);
        marca.setPromptText("Fiat");
        marca.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        marca.setFont(new Font("Goudy Old Style", 12));
        vistaDinamica.getChildren().add(marca);

        // Label 4
        Label label4 = new Label("Inserisci il colore");
        label4.setLayoutX(301);
        label4.setLayoutY(114);
        label4.setPrefSize(260, 43);
        label4.setFont(new Font("Pivot Classic", 14));
        vistaDinamica.getChildren().add(label4);

        // TextField 3
        TextField colore = new TextField();
        colore.setLayoutX(301);
        colore.setLayoutY(161);
        colore.setPrefSize(260, 12);
        colore.setPromptText("Rosso");
        colore.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        colore.setFont(new Font("Goudy Old Style", 12));
        vistaDinamica.getChildren().add(colore);

        // Label 5
        Label label5 = new Label("Inserisci l'alimentazione");
        label5.setLayoutX(19);
        label5.setLayoutY(182);
        label5.setPrefSize(260, 43);
        label5.setFont(new Font("Pivot Classic", 14));
        vistaDinamica.getChildren().add(label5);

        // Label 7
        Label label7 = new Label("Inserisci il modello");
        label7.setLayoutX(19);
        label7.setLayoutY(114);
        label7.setPrefSize(260, 43);
        label7.setFont(new Font("Pivot Classic", 14));
        vistaDinamica.getChildren().add(label7);

        // TextField 5
        TextField modello = new TextField();
        modello.setLayoutX(19);
        modello.setLayoutY(161);
        modello.setPrefSize(260, 12);
        modello.setPromptText("Panda");
        modello.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        modello.setFont(new Font("Goudy Old Style", 12));
        vistaDinamica.getChildren().add(modello);

        // ChoiceBox
        ChoiceBox<String> alimentazione = new ChoiceBox<>();
        alimentazione.setLayoutX(19);
        alimentazione.setLayoutY(229);
        alimentazione.setPrefSize(260, 26);
        alimentazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        alimentazione.getItems().addAll("Benzina", "Diesel", "Elettrico", "Mild-Hybrid",
                "Full-Hybrid", "Plug-in Hybrid", "Idrogeno");

        vistaDinamica.getChildren().add(alimentazione);

        // Label 3
        Label label3 = new Label("Inserisci l'anno d'immatricolazione");
        label3.setLayoutX(301);
        label3.setLayoutY(45);
        label3.setPrefSize(260, 43);
        label3.setFont(new Font("Pivot Classic", 14));
        vistaDinamica.getChildren().add(label3);

        // TextField 2
        TextField annoImmatricolazione = new TextField();
        annoImmatricolazione.setLayoutX(301);
        annoImmatricolazione.setLayoutY(92);
        annoImmatricolazione.setPrefSize(260, 12);
        annoImmatricolazione.setPromptText("2010");
        annoImmatricolazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        annoImmatricolazione.setFont(new Font("Goudy Old Style", 12));
        vistaDinamica.getChildren().add(annoImmatricolazione);

        // Button
        Button button = new Button("Ricerca");
        button.setLayoutX(19);
        button.setLayoutY(351);
        button.setPrefSize(580, 39);
        button.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; " +
                "-fx-border-width: 1.2; -fx-border-radius: 32;");
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
        vistaDinamica.getChildren().add(button);
    }
    @FXML
    public void mostraAutoTrovate( ArrayList<Auto> autoTrovate){
        bFisso.setText("Auto ricercate");
        vistaDinamica.getChildren().clear();

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

        if (autoTrovate.size()%2==0){
            for (int i=0;i<autoTrovate.size();i+=2){
                HBox hBox1 = aggiungiRigaVistaRicerca(inventarioAuto.getInventario().get(i),autoTrovate.get(i+1),vBox,autoTrovate);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
        }else{
            for (int i=0;i<autoTrovate.size()-1;i+=2){
                HBox hBox1 = aggiungiRigaVistaRicerca(autoTrovate.get(i),autoTrovate.get(i+1),vBox,autoTrovate);
                Pane spazio = new Pane();
                spazio.setPrefSize(572.0, 50.0);

                vBox.getChildren().addAll(hBox1, spazio);
            }
            HBox hBox2 = aggiungiRigaSolaVistaRicerca(autoTrovate.getLast(),vBox,autoTrovate);
            vBox.getChildren().add(hBox2);
        }
        Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
        spazio2.setPrefSize(572.0, 50.0);
        vBox.getChildren().add(spazio2);

        scrollPane.setContent(vBox);

        Label labelTitolo = new Label("Ecco le auto trovate: ");
        labelTitolo.setLayoutX(22.0);
        labelTitolo.setLayoutY(14.0);
        labelTitolo.setPrefSize(260.0, 31.0);
        labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");

        Button button = new Button("<----");
        button.setLayoutX(275.0);
        button.setLayoutY(14.0);
        button.setPrefSize(200, 31);
        button.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; " +
                "-fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setFont(new Font("Pivot Classic", 12));
        button.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        cambioColorePassaggioMouse(button,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setOnAction(e->{
            schermataPrincipale(inventarioAuto.getInventario());
        });

        // Aggiunta degli elementi al pannello
        vistaDinamica.getChildren().addAll(labelTitolo,button,scrollPane);
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
            mostraMeglioRicerca(vbox,auto1,autoTrovate);
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
            mostraMeglioRicerca(vbox,auto2,autoTrovate);
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
            mostraMeglioRicerca(vbox,auto1,autoTrovate);
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
            mostraAutoTrovate(autoTrovate);
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
        imageView.setImage(new Image(ClienteController.class.getResource("/com/example/pratica724/img/logo.png").toString()));

        hbox2.getChildren().addAll(spacer2, imageView);

        // Labels
        Label label2 = new Label("Specifiche");
        label2.setLayoutX(10.0);
        label2.setLayoutY(10.0);
        label2.setPrefHeight(57.0);
        label2.setPrefWidth(569.0);
        label2.setFont(Font.font("Pivot Classic", 32.0));

        Label label3 = new Label(auto.toString());
        label3.setPrefHeight(121.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }

    //carosello
    @FXML
    private void vediVistaAcquisti(){
        vistaPrincipale.setVisible(false);
        vistaPrincipale.setDisable(true);

        vistaConfronti.setVisible(true);
        vistaConfronti.setDisable(false);

        entrataAnchor(vistaConfronti,-300,0);
        bAvanti.setDisable(true);
        bIndietro.setDisable(false);
    }
    @FXML
    private void vediVistaArchivio(){
        vistaConfronti.setVisible(false);
        vistaConfronti.setDisable(true);

        vistaPrincipale.setVisible(true);
        vistaPrincipale.setDisable(false);

        entrataAnchor(vistaPrincipale,-300,0);
        bAvanti.setDisable(false);
        bIndietro.setDisable(true);
    }

    //gestione preferiti
    @FXML
    public void inserimentoPreferiti(){
        bFisso.setText("Inserimento Preferiti");
        vistaConfronti.getChildren().clear();

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

        for (int i=0;i<privato.getAutoPreferite().size();i++){
            HBox hBox1 = aggiungiRigaPreferite(privato.getAutoPreferite().get(i),vBox);
            Pane spazio = new Pane();
            spazio.setPrefSize(572.0, 50.0);

            vBox.getChildren().addAll(hBox1, spazio);
        }
        Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
        spazio2.setPrefSize(572.0, 50.0);
        vBox.getChildren().add(spazio2);

        scrollPane.setContent(vBox);

        Label labelTitolo = new Label("Ecco le tue preferite: ");
        labelTitolo.setLayoutX(22.0);
        labelTitolo.setLayoutY(14.0);
        labelTitolo.setPrefSize(575.0, 31.0);
        labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");
        // Aggiunta degli elementi al pannello
        vistaConfronti.getChildren().addAll(labelTitolo,scrollPane);
    }
    @FXML
    private void mostraMeglioPreferite(VBox vbox, Auto auto){
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
            inserimentoPreferiti();
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
        imageView.setImage(new Image(ClienteController.class.getResource("/com/example/pratica724/img/logo.png").toString()));

        hbox2.getChildren().addAll(spacer2, imageView);

        // Labels
        Label label2 = new Label("Specifiche");
        label2.setLayoutX(10.0);
        label2.setLayoutY(10.0);
        label2.setPrefHeight(57.0);
        label2.setPrefWidth(569.0);
        label2.setFont(Font.font("Pivot Classic", 32.0));

        Label label3 = new Label(auto.toString());
        label3.setPrefHeight(121.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }
    @FXML
    private HBox aggiungiRigaPreferite(Auto auto1, VBox vbox) {
        HBox hBox = new HBox();
        hBox.setPrefSize(542.0, 162.0);
        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(542, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        //Auto
        Label modello = new Label(auto1.getModello());
        modello.setLayoutX(14.0);
        modello.setLayoutY(14.0);
        modello.setPrefSize(185, 22);
        modello.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 120.0;");

        Label marca = new Label(auto1.getMarca());
        marca.setLayoutX(14.0);
        marca.setLayoutY(45.0);
        marca.setPrefSize(185, 22);
        marca.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 15.0;");

        Label alimentazioneLabel = new Label(auto1.getAlimentazione());
        alimentazioneLabel.setLayoutX(461.0);
        alimentazioneLabel.setLayoutY(14.0);
        alimentazioneLabel.setRotate(26.1);
        alimentazioneLabel.setPrefSize(86.0, 28.0);
        alimentazioneLabel.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 18.0;");

        Button vediMeglio = new Button("+");
        vediMeglio.setLayoutX(168.0);
        vediMeglio.setLayoutY(126.0);
        vediMeglio.setPrefSize(47.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            mostraMeglioPreferite(vbox,auto1);
        });

        Button rimuoviDaPreferiti = new Button(" - ⭐ ");
        rimuoviDaPreferiti.setLayoutX(269.0);
        rimuoviDaPreferiti.setLayoutY(126);
        rimuoviDaPreferiti.setPrefSize(84, 28.0);
        rimuoviDaPreferiti.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(rimuoviDaPreferiti,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        rimuoviDaPreferiti.setOnAction(e->{
            try {
                privato.rimuoviAutoPreferite(auto1);
                avvisoVisivo("Rimossa con successo", "42f58d");
                bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
                inserimentoPreferiti();
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        Button acquista = new Button("Acquista");
        acquista.setLayoutX(407);
        acquista.setLayoutY(126);
        acquista.setPrefSize(84, 28.0);
        acquista.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(acquista,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        acquista.setOnAction(e->{
            try {
                acquista(auto1);
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(14.0);
        tipoLabel.setLayoutY(126);
        tipoLabel.setPrefSize(100, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modello, marca, alimentazioneLabel, vediMeglio, tipoLabel);

        hBox.getChildren().addAll(pane1);

        return hBox;
    }

    //Acquista
    @FXML
    private void acquista(Auto autoAcquistata){
        vistaConfronti.getChildren().clear();
        // Button b111
        Button b111 = new Button("<---");
        b111.setLayoutX(343.0);
        b111.setLayoutY(370.0);
        b111.setPrefSize(116.0, 28.0);
        b111.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        b111.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        b111.setFont(Font.font("Pivot Classic", 16.0));
        cambioColorePassaggioMouse(b111,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        b111.setOnAction(e -> inserimentoPreferiti() );

        // Label "Riepilogo : Modello - Marca"
        Label label1 = new Label("Riepilogo : "+autoAcquistata.getModello()+" - "+autoAcquistata.getMarca());
        label1.setLayoutX(27.0);
        label1.setLayoutY(30.0);
        label1.setPrefSize(447.0, 43.0);
        label1.setFont(Font.font("Pivot Classic", 26.0));

        // Label "descrizione"
        Label label2 = new Label(autoAcquistata.toString());
        label2.setLayoutX(27.0);
        label2.setLayoutY(86.0);
        label2.setPrefSize(330.0, 184.0);
        label2.setWrapText(true);
        label2.setFont(Font.font("Goudy Old Style", 14.0));

        // ImageView with logo.png
        ImageView imageView = new ImageView();
        imageView.setLayoutX(420.0);
        imageView.setLayoutY(45.0);
        imageView.setFitWidth(254.0);
        imageView.setFitHeight(217.0);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(ClienteController.class.getResource("/com/example/pratica724/img/logo.png").toString()));

        // Label "Vuoi uno sconto di:"
        Label label3 = new Label("Vuoi uno sconto di: "+inventarioAuto.scontoPermuta(autoAcquistata.getPrezzo(), (AutoUsata) privato.getAutoAttuale()));
        label3.setLayoutX(27.0);
        label3.setLayoutY(315.0);
        label3.setPrefSize(393.0, 38.0);
        label3.setFont(Font.font("Goudy Old Style", 14.0));

        // Label "Saldo finale:"
        Label label4 = new Label("Saldo finale: "+autoAcquistata.getPrezzo()+" €");
        label4.setLayoutX(27.0);
        label4.setLayoutY(370.0);
        label4.setPrefSize(314.0, 38.0);
        label4.setFont(Font.font("Pivot Classic", 15.0));

        // Button bAcquista
        Button bAcquista = new Button("Acquista");
        bAcquista.setLayoutX(485.0);
        bAcquista.setLayoutY(370.0);
        bAcquista.setPrefSize(176.0, 38.0);
        bAcquista.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        bAcquista.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        bAcquista.setFont(Font.font("Pivot Classic", 16.0));
        cambioColorePassaggioMouse(bAcquista,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        bAcquista.setOnAction(e ->{
                registroAcquisti.addAcquisto(autoAcquistata,privato);
                inventarioAuto.rimuoviAuto(autoAcquistata);
                vistaConfronti.getChildren().clear();

                // Label 1
                Label l1 = new Label("Grazie per l'acquisto!");
                l1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
                l1.setLayoutX(23.0);
                l1.setLayoutY(25.0);
                l1.setPrefHeight(103.0);
                l1.setPrefWidth(643.0);
                l1.setFont(new Font("Pivot Classic", 58.0));

                // ImageView 1
                ImageView im1 = new ImageView();
                im1.setFitHeight(85.0);
                im1.setFitWidth(260.0);
                im1.setLayoutX(233.0);
                im1.setLayoutY(345.0);
                im1.setPickOnBounds(true);
                im1.setPreserveRatio(true);
                im1.setImage(new Image(ClienteController.class.getResource("/com/example/pratica724/img/scritta.png").toString()));

                // ImageView 2
                ImageView im2 = new ImageView();
                im2.setFitHeight(210.0);
                im2.setFitWidth(339.0);
                im2.setLayoutX(23.0);
                im2.setLayoutY(220.0);
                im2.setPickOnBounds(true);
                im2.setPreserveRatio(true);
                im2.setImage(new Image(ClienteController.class.getResource("/com/example/pratica724/img/logo.png").toString()));

                // Label 2
                Label l2 = new Label("Verrai ricontattato dal concessionario del gruppo per il ritiro e la permuta se inserita.");
                l2.setAlignment(javafx.geometry.Pos.TOP_LEFT);
                l2.setLayoutX(23.0);
                l2.setLayoutY(128.0);
                l2.setPrefHeight(127.0);
                l2.setPrefWidth(399.0);
                l2.setWrapText(true);
                l2.setFont(new Font("Goudy Old Style", 20.0));

                // Add elements to root
                vistaConfronti.getChildren().addAll(l1, im1, im2, l2);
            }
        );

        // CheckBox "Includi permuta della tua auto"
        CheckBox checkBox = new CheckBox("Includi permuta della tua auto");
        checkBox.setLayoutX(437.0);
        checkBox.setLayoutY(325.0);
        checkBox.setFont(Font.font("Goudy Old Style", 14.0));
        checkBox.setOnMouseClicked(e->{
            label4.setText("Saldo finale: "+(autoAcquistata.getPrezzo()-inventarioAuto.scontoPermuta(autoAcquistata.getPrezzo(), (AutoUsata) privato.getAutoAttuale()))+" €");
        });

        // Add all elements to the root
        vistaConfronti.getChildren().addAll(b111, label1, label2, imageView, label3, label4, bAcquista, checkBox, bAvanti, bIndietro);
    }

    //animazione
    @FXML
    private void avvisoVisivo(String string, String colore){
        bFisso.setStyle("-fx-background-color: #"+colore+"; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
        bFisso.setText(string);
        PauseTransition pausa = new PauseTransition(Duration.seconds(3));
        pausa.setOnFinished(e -> {
            bFisso.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");
            bFisso.setText("Inserisci informazioni");
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
    @FXML
    private void cambioColorePassaggioMouse(Button button, String style1, String style2){
        button.setOnMouseMoved(event -> {
            button.setStyle(style1);
        });
        button.setOnMouseExited(event -> {
            button.setStyle(style2);
        });
    }
}
