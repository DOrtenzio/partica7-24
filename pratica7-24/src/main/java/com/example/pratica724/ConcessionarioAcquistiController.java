package com.example.pratica724;

import com.example.pratica724.auto.*;
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

public class ConcessionarioAcquistiController {
    @FXML
    private Button b1,b2,b3,b4,b5,b6,bFisso;
    @FXML
    private AnchorPane boxDinamica,boxPulsanti,root;

    private Concessionario concessionario;
    private RegistroAcquisti registroAcquisti;
    private InventarioAuto inventarioAuto;

    public void setConcessionario(Concessionario concessionario){
        this.concessionario=concessionario;
        bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
        this.inventarioAuto=concessionario.getInventario();
        this.registroAcquisti=concessionario.getRegistroAcquisti();
    }

    //fase iniziale
    @FXML
    private void initialize(){
        cambioColorePassaggioMouse(b1,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b2,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b3,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b4,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b5,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(b6,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");


        entrataAnchor(boxPulsanti,-300,0);
    }

    //metodi

    //REGISTRAZIONE NUOVA VENDITA
    @FXML
    public void nuovaVendita(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Aggiungi vendita");
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

        Label labelTitolo = new Label("Seleziona l'auto venduta : ");
        labelTitolo.setLayoutX(22.0);
        labelTitolo.setLayoutY(14.0);
        labelTitolo.setPrefSize(575.0, 31.0);
        labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");
        // Aggiunta degli elementi al pannello
        boxDinamica.getChildren().addAll(labelTitolo,scrollPane);
    }

    //Metodi x popolamento auto
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
                aggiungiAutoVenduta(auto1);
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
            mostraMeglioAcquistoNuovo(vbox,auto1);
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
                aggiungiAutoVenduta(auto2);
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
            mostraMeglioAcquistoNuovo(vbox,auto2);
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
                aggiungiAutoVenduta(auto1);
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
            mostraMeglioAcquistoNuovo(vbox,auto1);
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
    //Metodi aggiunta auto
    @FXML
    private void aggiungiAutoVenduta(Auto autoVenduta){
        registraVendita(autoVenduta);
        avvisoVisivo("Selezionata", "42f58d");
        boxDinamica.getChildren().clear();
        bFisso.setText("Inserisci acquirente");
        entrataAnchor(boxDinamica,0,1200);
    }
    @FXML
    private void mostraMeglioAcquistoNuovo(VBox vbox, Auto auto){
        System.out.println("Mostra meglio");
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
            nuovaVendita();
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
        label3.setPrefHeight(121.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }
    @FXML
    private void registraVendita(Auto autoVenduta){
        AnchorPane vistaInfo = new AnchorPane();
        vistaInfo.setLayoutX(107.0);
        vistaInfo.setLayoutY(115.0);
        vistaInfo.setPrefSize(686.0, 467.0);
        vistaInfo.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; " +
                "-fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 1.5;");

        Button bInserisci = new Button("Registra");
        bInserisci.setLayoutX(488.0);
        bInserisci.setLayoutY(402.0);
        bInserisci.setPrefSize(171.0, 14.0);
        bInserisci.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; " +
                "-fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        bInserisci.setTextFill(javafx.scene.paint.Color.web("#30323D"));
        bInserisci.setFont(new Font("Pivot Classic", 24));

        vistaInfo.getChildren().add(bInserisci);

        boxPulsanti.setDisable(true);
        root.getChildren().add(vistaInfo);
        entrataAnchor(vistaInfo,1200,0);

        // Label e TextField diretti
        Label label1 = new Label("Inserisci il tuo nome utente");
        label1.setLayoutX(25.0);
        label1.setLayoutY(14.0);
        label1.setPrefSize(260.0, 43.0);
        label1.setFont(new Font("Pivot Classic", 14.0));
        vistaInfo.getChildren().add(label1);

        TextField nomeUtente = new TextField();
        nomeUtente.setPromptText("AutoPixel");
        nomeUtente.setLayoutX(25.0);
        nomeUtente.setLayoutY(68.0);
        nomeUtente.setPrefSize(260.0, 12.0);
        nomeUtente.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; " +
                "-fx-border-image-width: 1.4; -fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        nomeUtente.setFont(new Font("Goudy Old Style", 12.0));
        vistaInfo.getChildren().add(nomeUtente);

        Label label2 = new Label("Inserisci la tua locazione");
        label2.setLayoutX(25.0);
        label2.setLayoutY(105.0);
        label2.setPrefSize(260.0, 43.0);
        label2.setFont(new Font("Pivot Classic", 14.0));
        vistaInfo.getChildren().add(label2);

        TextField locazione = new TextField();
        locazione.setPromptText("Bergamo, It");
        locazione.setLayoutX(25.0);
        locazione.setLayoutY(159.0);
        locazione.setPrefSize(260.0, 12.0);
        locazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; " +
                "-fx-border-image-width: 1.4; -fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        locazione.setFont(new Font("Goudy Old Style", 12.0));
        vistaInfo.getChildren().add(locazione);

        Label label3 = new Label("Inserisci la tua e-mail");
        label3.setLayoutX(25.0);
        label3.setLayoutY(206.0);
        label3.setPrefSize(260.0, 43.0);
        label3.setFont(new Font("Pivot Classic", 14.0));
        vistaInfo.getChildren().add(label3);

        TextField email = new TextField();
        email.setPromptText("giorgione@gmail.com");
        email.setLayoutX(25.0);
        email.setLayoutY(260.0);
        email.setPrefSize(260.0, 12.0);
        email.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; " +
                "-fx-border-image-width: 1.4; -fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        email.setFont(new Font("Goudy Old Style", 12.0));
        vistaInfo.getChildren().add(email);

        Label label4 = new Label("Inserisci il tuo numero di telefono");
        label4.setLayoutX(25.0);
        label4.setLayoutY(309.0);
        label4.setPrefSize(260.0, 43.0);
        label4.setFont(new Font("Pivot Classic", 14.0));
        vistaInfo.getChildren().add(label4);

        TextField numeroTelefono = new TextField();
        numeroTelefono.setPromptText("+39 333 666 0000");
        numeroTelefono.setLayoutX(25.0);
        numeroTelefono.setLayoutY(363.0);
        numeroTelefono.setPrefSize(260.0, 12.0);
        numeroTelefono.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; " +
                "-fx-border-image-width: 1.4; -fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        numeroTelefono.setFont(new Font("Goudy Old Style", 12.0));
        vistaInfo.getChildren().add(numeroTelefono);

        Label label5 = new Label("Inserisci il tuo nome e cognome");
        label5.setLayoutX(358.0);
        label5.setLayoutY(16.0);
        label5.setPrefSize(260.0, 43.0);
        label5.setFont(new Font("Pivot Classic", 14.0));
        vistaInfo.getChildren().add(label5);

        TextField nomeCognome = new TextField();
        nomeCognome.setPromptText("Mario rossi");
        nomeCognome.setLayoutX(358.0);
        nomeCognome.setLayoutY(70.0);
        nomeCognome.setPrefSize(260.0, 12.0);
        nomeCognome.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; " +
                "-fx-border-image-width: 1.4; -fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        nomeCognome.setFont(new Font("Goudy Old Style", 12.0));
        vistaInfo.getChildren().add(nomeCognome);

        Label label6 = new Label("Inserisci il tuo numero CIE");
        label6.setLayoutX(358.0);
        label6.setLayoutY(107.0);
        label6.setPrefSize(260.0, 43.0);
        label6.setFont(new Font("Pivot Classic", 14.0));
        vistaInfo.getChildren().add(label6);

        TextField cie = new TextField();
        cie.setPromptText("CA 374764");
        cie.setLayoutX(358.0);
        cie.setLayoutY(161.0);
        cie.setPrefSize(260.0, 12.0);
        cie.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; " +
                "-fx-border-image-width: 1.4; -fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        cie.setFont(new Font("Goudy Old Style", 12.0));
        vistaInfo.getChildren().add(cie);

        Label label7 = new Label("Inserisci il codice fiscale");
        label7.setLayoutX(358.0);
        label7.setLayoutY(208.0);
        label7.setPrefSize(260.0, 43.0);
        label7.setFont(new Font("Pivot Classic", 14.0));
        vistaInfo.getChildren().add(label7);

        TextField codiceFiscale = new TextField();
        codiceFiscale.setPromptText("RSSMRA85C15H501Z");
        codiceFiscale.setLayoutX(358.0);
        codiceFiscale.setLayoutY(262.0);
        codiceFiscale.setPrefSize(260.0, 12.0);
        codiceFiscale.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; " +
                "-fx-border-image-width: 1.4; -fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        codiceFiscale.setFont(new Font("Goudy Old Style", 12.0));
        vistaInfo.getChildren().add(codiceFiscale);

        bInserisci.setOnAction(e->{
            try {
                Privato privato=setInfoAcquirente(nomeUtente.getText(),locazione.getText(),email.getText(),numeroTelefono.getText(),nomeCognome.getText(), cie.getText(),autoVenduta,codiceFiscale.getText());
                registroAcquisti.addAcquisto(autoVenduta,privato);
                inventarioAuto.rimuoviAuto(autoVenduta); //Auto inserita e rimossa da quelle disponibili
                entrataAnchor(vistaInfo,0,-300);
                boxDinamica.getChildren().remove(vistaInfo);
                boxDinamica.setDisable(false);
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });
    }
    @FXML
    private Privato setInfoAcquirente(String nomeUtente, String locazione, String email, String telefono, String nomeCognome, String numeroCie, Auto autoAttuale,String codiceFiscale){
        boolean validitaInfo=true;
        Privato privato=new Privato(null,null,"template","template",null,"template",autoAttuale,"template");

        privato.setNomeUtente(nomeUtente);
        privato.setLocazione(locazione);

        if (privato.isEmailValida(email))
            privato.setEmail(email);
        else
            validitaInfo=false;
        if (privato.isNumeroValido(telefono))
            privato.setTelefono(telefono);
        else
            validitaInfo=false;
        if (privato.isValidCIE(numeroCie))
            privato.setNumeroCie(numeroCie);
        else
            validitaInfo=false;
        if (privato.isValidNomeCognome(nomeCognome))
            privato.setNomeCognome(nomeCognome);
        else
            validitaInfo=false;
        if (privato.isValidCodiceFiscale(codiceFiscale))
            privato.setCodiceFiscale(codiceFiscale);
        else
            validitaInfo=false;
        if (!validitaInfo)
            avvisoVisivo("Errore","bc0000");
        else {
            avvisoVisivo("Ottimo", "42f58d");
            bFisso.setText("Vendita registrata");
            return privato;
        }
        return privato;
    }


    //Cancellazione
    @FXML
    public void cancellaVendita(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Cancella vendita");
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

        for (int i=0;i<inventarioAuto.getInventario().size();i++){
            HBox hBox1 = aggiungiRigaCancellazione(registroAcquisti.getRegistroAcquistate().get(i),registroAcquisti.getRegistroAcquirenti().get(i),vBox);
            Pane spazio = new Pane();
            spazio.setPrefSize(572.0, 50.0);

            vBox.getChildren().addAll(hBox1, spazio);
        }
        Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
        spazio2.setPrefSize(572.0, 50.0);
        vBox.getChildren().add(spazio2);

        scrollPane.setContent(vBox);

        Label labelTitolo = new Label("Seleziona l'acquisto da cancellare: ");
        labelTitolo.setLayoutX(22.0);
        labelTitolo.setLayoutY(14.0);
        labelTitolo.setPrefSize(575.0, 31.0);
        labelTitolo.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 24.0;");
        // Aggiunta degli elementi al pannello
        boxDinamica.getChildren().addAll(labelTitolo,scrollPane);
    }
    @FXML
    private void mostraMeglioCancellato(VBox vbox,Auto auto){
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
            cancellaVendita();
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
        label3.setPrefHeight(121.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }
    @FXML
    private HBox aggiungiRigaCancellazione(Auto auto1,Privato privato, VBox vbox) {
        HBox hBox = new HBox();
        hBox.setPrefSize(542.0, 162.0);
        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(542, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        //Acquirente
        Label acquirente = new Label(privato.getNomeCognome());
        acquirente.setLayoutX(14.0);
        acquirente.setLayoutY(14.0);
        acquirente.setPrefSize(235, 29.0);
        acquirente.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 18.0;");

        Label infoAcquirente = new Label(privato.getLocazione()+"\n"+privato.getEmail()+"\n"+privato.getTelefono()+"\n"+privato.getCodiceFiscale()+"\n"+privato.getNumeroCie());
        infoAcquirente.setLayoutX(14.0);
        infoAcquirente.setLayoutY(45.0);
        infoAcquirente.setPrefSize(235.0, 103.0);
        infoAcquirente.setWrapText(true);
        infoAcquirente.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 15.0;");

        //Auto
        Label modello = new Label(auto1.getModello());
        modello.setLayoutX(261.0);
        modello.setLayoutY(14.0);
        modello.setPrefSize(185, 22);
        modello.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 18.0;");

        Label marca = new Label(auto1.getMarca());
        marca.setLayoutX(261.0);
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
        vediMeglio.setLayoutX(391.0);
        vediMeglio.setLayoutY(126.0);
        vediMeglio.setPrefSize(47.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioCancellato(vbox,auto1);
            entrataAnchor(boxDinamica,1200,0);
        });

        Button selezionaButton = new Button("Seleziona");
        selezionaButton.setLayoutX(445);
        selezionaButton.setLayoutY(126);
        selezionaButton.setPrefSize(84, 28.0);
        selezionaButton.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(selezionaButton,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        selezionaButton.setOnAction(e->{
            try {
                registroAcquisti.cancellaAcquisto(auto1,privato);
                avvisoVisivo("Cancellata con successo", "42f58d");
                boxDinamica.getChildren().clear();
                bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());
                entrataAnchor(boxDinamica,0,1200);
                boxDinamica.setVisible(false);
                boxDinamica.setDisable(true);
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(261);
        tipoLabel.setLayoutY(126);
        tipoLabel.setPrefSize(100, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modello, marca, alimentazioneLabel, vediMeglio, tipoLabel);

        hBox.getChildren().addAll(pane1);

        return hBox;
    }

    //RICERCA
    //tramite auto
    @FXML
    public void ricercaAuto(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Ricerca Vendite");
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
        button.setStyle("-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; " +
                "-fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setFont(new Font("Pivot Classic", 12));
        button.setTextFill(javafx.scene.paint.Color.web("#30323d"));
        cambioColorePassaggioMouse(button,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        button.setOnAction(e->{
            try {
                mostraVenditeTramiteAuto(registroAcquisti.ricercaAutoAcquistata(marca.getText(),modello.getText(),Integer.parseInt(annoImmatricolazione.getText()),alimentazione.getValue(),colore.getText()));
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }

        });
        boxDinamica.getChildren().add(button);
    }
    @FXML
    public void mostraVenditeTramiteAuto(ArrayList<Integer> posizioniTrovate){
        entrataAnchor(boxDinamica,0,1200);
        bFisso.setText("Vendite trovate");
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

        for (int i=0;i<posizioniTrovate.size();i++){
            HBox hBox1 = aggiungiRigaRicerca(registroAcquisti.getRegistroAcquistate().get(posizioniTrovate.get(i)),registroAcquisti.getRegistroAcquirenti().get(posizioniTrovate.get(i)), vBox ,posizioniTrovate);
            Pane spazio = new Pane();
            spazio.setPrefSize(572.0, 50.0);

            vBox.getChildren().addAll(hBox1, spazio);
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
        boxDinamica.getChildren().addAll(labelTitolo,scrollPane);
    }
    @FXML
    private void mostraMeglioRicerca(VBox vbox,Auto auto, ArrayList<Integer> posizioniTrovate){
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
            mostraVenditeTramiteAuto(posizioniTrovate);
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
        label3.setPrefHeight(121.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }
    @FXML
    private HBox aggiungiRigaRicerca(Auto auto1,Privato privato, VBox vbox, ArrayList<Integer> posizioniTrovate) {
        HBox hBox = new HBox();
        hBox.setPrefSize(542.0, 162.0);
        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(542, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        //Acquirente
        Label acquirente = new Label(privato.getNomeCognome());
        acquirente.setLayoutX(14.0);
        acquirente.setLayoutY(14.0);
        acquirente.setPrefSize(235, 29.0);
        acquirente.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 18.0;");

        Label infoAcquirente = new Label(privato.getLocazione()+"\n"+privato.getEmail()+"\n"+privato.getTelefono()+"\n"+privato.getCodiceFiscale()+"\n"+privato.getNumeroCie());
        infoAcquirente.setLayoutX(14.0);
        infoAcquirente.setLayoutY(45.0);
        infoAcquirente.setPrefSize(235.0, 103.0);
        infoAcquirente.setWrapText(true);
        infoAcquirente.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 15.0;");

        //Auto
        Label modello = new Label(auto1.getModello());
        modello.setLayoutX(261.0);
        modello.setLayoutY(14.0);
        modello.setPrefSize(185, 22);
        modello.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 18.0;");

        Label marca = new Label(auto1.getMarca());
        marca.setLayoutX(261.0);
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
        vediMeglio.setLayoutX(391.0);
        vediMeglio.setLayoutY(126.0);
        vediMeglio.setPrefSize(55.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglioRicerca(vbox,auto1,posizioniTrovate);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(261);
        tipoLabel.setLayoutY(126);
        tipoLabel.setPrefSize(100, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modello, marca, alimentazioneLabel, vediMeglio, tipoLabel);

        hBox.getChildren().addAll(pane1);

        return hBox;
    }

    //tramite acquirente
    @FXML
    public void ricercaPrivato(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Ricerca Vendite");
        boxDinamica.getChildren().clear();
        entrataAnchor(boxDinamica,1200,0);
        try {
            ricercaInserimentoPrivato();
        } catch (Exception e) {
            avvisoVisivo("Errore","bc0000");
        }
    }
    @FXML
    private void ricercaInserimentoPrivato(){
        // Label 1
        Label label1 = new Label("Inserisci le informazioni richieste:");
        label1.setLayoutX(18);
        label1.setLayoutY(21);
        label1.setPrefSize(579, 39);
        label1.setFont(new Font("Pivot Classic", 18));
        boxDinamica.getChildren().add(label1);

        // Label 2
        Label label2 = new Label("Inserisci il nome utente");
        label2.setLayoutX(19);
        label2.setLayoutY(45);
        label2.setPrefSize(260, 43);
        label2.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label2);

        // TextField 1
        TextField nomeUtente = new TextField();
        nomeUtente.setLayoutX(19);
        nomeUtente.setLayoutY(92);
        nomeUtente.setPrefSize(260, 12);
        nomeUtente.setPromptText("Mario89");
        nomeUtente.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        nomeUtente.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(nomeUtente);

        // Label 4
        Label label4 = new Label("Inserisci la locazione");
        label4.setLayoutX(301);
        label4.setLayoutY(114);
        label4.setPrefSize(260, 43);
        label4.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label4);

        // TextField 3
        TextField locazione = new TextField();
        locazione.setLayoutX(301);
        locazione.setLayoutY(161);
        locazione.setPrefSize(260, 12);
        locazione.setPromptText("Rosso");
        locazione.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        locazione.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(locazione);

        // Label 5
        Label label5 = new Label("Inserisci l'email");
        label5.setLayoutX(19);
        label5.setLayoutY(182);
        label5.setPrefSize(260, 43);
        label5.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label5);

        // Label 7
        Label label7 = new Label("Inserisci il numero di telefono");
        label7.setLayoutX(19);
        label7.setLayoutY(114);
        label7.setPrefSize(260, 43);
        label7.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label7);

        // TextField 5
        TextField numTelefono = new TextField();
        numTelefono.setLayoutX(19);
        numTelefono.setLayoutY(161);
        numTelefono.setPrefSize(260, 12);
        numTelefono.setPromptText("+39 333 666 0000");
        numTelefono.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        numTelefono.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(numTelefono);

        // textfield
        TextField email = new TextField();
        email.setLayoutX(19);
        email.setLayoutY(229);
        email.setPrefSize(260, 12);
        email.setPromptText("mario@gmail.com");
        email.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        email.setFont(new Font("Goudy Old Style", 12));

        // Label 3
        Label label3 = new Label("Inserisci nome e cognome");
        label3.setLayoutX(301);
        label3.setLayoutY(45);
        label3.setPrefSize(260, 43);
        label3.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label3);

        // TextField 2
        TextField nomeCognome = new TextField();
        nomeCognome.setLayoutX(301);
        nomeCognome.setLayoutY(92);
        nomeCognome.setPrefSize(260, 12);
        nomeCognome.setPromptText("Mario Rossi");
        nomeCognome.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        nomeCognome.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(nomeCognome);

        // Label 3
        Label label12 = new Label("Inserisci numero CIE");
        label12.setLayoutX(301);
        label12.setLayoutY(113);
        label12.setPrefSize(260, 43);
        label12.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label12);

        // TextField 2
        TextField numeroCIE = new TextField();
        numeroCIE.setLayoutX(301);
        numeroCIE.setLayoutY(160);
        numeroCIE.setPrefSize(260, 12);
        numeroCIE.setPromptText("CA 988789");
        numeroCIE.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        numeroCIE.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(numeroCIE);

        // Label 3
        Label label13 = new Label("Inserisci codice fiscale");
        label13.setLayoutX(301);
        label13.setLayoutY(228);
        label13.setPrefSize(260, 43);
        label13.setFont(new Font("Pivot Classic", 14));
        boxDinamica.getChildren().add(label13);

        // TextField 2
        TextField codiceFiscale = new TextField();
        codiceFiscale.setLayoutX(301);
        codiceFiscale.setLayoutY(275);
        codiceFiscale.setPrefSize(260, 12);
        codiceFiscale.setPromptText("RSSMRA85M01H501Z");
        codiceFiscale.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-border-image-width: 1.4; " +
                "-fx-border-radius: 12 0 12 0; -fx-background-radius: 12 0 12 0;");
        codiceFiscale.setFont(new Font("Goudy Old Style", 12));
        boxDinamica.getChildren().add(codiceFiscale);

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
                mostraVenditeTramiteAuto(registroAcquisti.ricercaAcquirenti(nomeUtente.getText(), locazione.getText(), email.getText(), numTelefono.getText(), nomeCognome.getText(), numeroCIE.getText(), codiceFiscale.getText()));
            } catch (Exception ex) {
                avvisoVisivo("Errore","bc0000");
            }

        });
        boxDinamica.getChildren().add(button);
    }

    //Mostra
    @FXML
    public void mostraTutto(){
        boxDinamica.setVisible(true);
        boxDinamica.setDisable(false);
        bFisso.setText("Vendite effettuate");
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

        for (int i=0;i<inventarioAuto.getInventario().size();i++){
            HBox hBox1 = aggiungiRigaSolaVista(registroAcquisti.getRegistroAcquistate().get(i),registroAcquisti.getRegistroAcquirenti().get(i),vBox);
            Pane spazio = new Pane();
            spazio.setPrefSize(572.0, 50.0);

            vBox.getChildren().addAll(hBox1, spazio);
        }
        Pane spazio2 = new Pane(); //Spaziatura aggiuntiva
        spazio2.setPrefSize(572.0, 50.0);
        vBox.getChildren().add(spazio2);

        scrollPane.setContent(vBox);

        Label labelTitolo = new Label("Tutti gli acquisti effettuati: ");
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
        label3.setPrefHeight(121.0);
        label3.setPrefWidth(572.0);
        label3.setWrapText(true);
        label3.setFont(Font.font("Goudy Old Style", 12.0));

        vbox.getChildren().addAll(hbox1,hbox2,label2,label3);
    }
    @FXML
    private HBox aggiungiRigaSolaVista(Auto auto1,Privato privato, VBox vbox) {
        HBox hBox = new HBox();
        hBox.setPrefSize(542.0, 162.0);
        // Auto 1 riquadro
        Pane pane1 = new Pane();
        pane1.setPrefSize(542, 162.0);
        pane1.setStyle("-fx-background-color: #F4FAFF; -fx-background-radius: 16; -fx-border-color: #30323D; -fx-border-radius: 16; -fx-border-width: 2;");

        //Acquirente
        Label acquirente = new Label(privato.getNomeCognome());
        acquirente.setLayoutX(14.0);
        acquirente.setLayoutY(14.0);
        acquirente.setPrefSize(235, 29.0);
        acquirente.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 18.0;");

        Label infoAcquirente = new Label(privato.getLocazione()+"\n"+privato.getEmail()+"\n"+privato.getTelefono()+"\n"+privato.getCodiceFiscale()+"\n"+privato.getNumeroCie());
        infoAcquirente.setLayoutX(14.0);
        infoAcquirente.setLayoutY(45.0);
        infoAcquirente.setPrefSize(235.0, 103.0);
        infoAcquirente.setWrapText(true);
        infoAcquirente.setStyle("-fx-font-family: 'Goudy Old Style'; -fx-font-size: 15.0;");

        //Auto
        Label modello = new Label(auto1.getModello());
        modello.setLayoutX(261.0);
        modello.setLayoutY(14.0);
        modello.setPrefSize(185, 22);
        modello.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 18.0;");

        Label marca = new Label(auto1.getMarca());
        marca.setLayoutX(261.0);
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
        vediMeglio.setLayoutX(391.0);
        vediMeglio.setLayoutY(126.0);
        vediMeglio.setPrefSize(55.0, 28.0);
        vediMeglio.setStyle("-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(vediMeglio,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        vediMeglio.setOnAction(e->{
            entrataAnchor(boxDinamica,0,1200);
            mostraMeglio(vbox,auto1);
            entrataAnchor(boxDinamica,1200,0);
        });

        Label tipoLabel = new Label(auto1.getClass().getSimpleName());
        tipoLabel.setLayoutX(261);
        tipoLabel.setLayoutY(126);
        tipoLabel.setPrefSize(100, 28.0);
        tipoLabel.setStyle("-fx-font-family: 'Pivot Classic'; -fx-font-size: 14.0;");

        pane1.getChildren().addAll(modello, marca, alimentazioneLabel, vediMeglio, tipoLabel);

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
