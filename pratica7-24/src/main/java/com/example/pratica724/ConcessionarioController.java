package com.example.pratica724;

import com.example.pratica724.utenti.Concessionario;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ConcessionarioController {
    @FXML
    private AnchorPane vistaArchivio,vistaAcquisti,vistaInfo;
    @FXML
    private Button bIndietro,bAvanti,bInserisci,bFisso;
    @FXML
    private TextField t1,t2,t3,t4,t5,t6,t7,t8;

    private Concessionario concessionario;
    private boolean isFirstView=true;

    //set informazioni
    public void setConcessionario(Concessionario concessionario){ this.concessionario=concessionario; }

    @FXML
    private void initialize(){
        if (isFirstView) {
            entrataAnchor(vistaInfo, -300, 0);
            isFirstView=false;
        }else{
            vistaInfo.setDisable(true);
            vistaInfo.setVisible(false);

            bIndietro.setVisible(true);
            bAvanti.setVisible(true);
            vistaArchivio.setDisable(false);
            vistaArchivio.setVisible(true);
            entrataAnchor(vistaArchivio,-300,0);
        }
        cambioColorePassaggioMouse(bIndietro,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(bAvanti,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F4FAFF; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
        cambioColorePassaggioMouse(bInserisci,"-fx-background-color: #F2ED6F; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;","-fx-background-color: #F1E4F3; -fx-border-color: #30323D; -fx-background-radius: 32; -fx-border-width: 1.2; -fx-border-radius: 32;");
    }

    @FXML
    private void setInfoConcessionario(){
        boolean validitaInfo=true;
        concessionario.setNomeUtente(t1.getText());
        concessionario.setLocazione(t2.getText());
        concessionario.setNomeAzienda(t5.getText());
        concessionario.setSedeLegale(t6.getText());
        if (concessionario.isEmailValida(t3.getText()))
            concessionario.setEmail(t3.getText());
        else
            validitaInfo=false;
        if (concessionario.isNumeroValido(t4.getText()))
            concessionario.setTelefono(t4.getText());
        else
            validitaInfo=false;
        if (concessionario.isValidPartitaIVA(t7.getText()))
            concessionario.setpIva(t7.getText());
        else
            validitaInfo=false;
        if (concessionario.isValidRagioneSociale(t8.getText()))
            concessionario.setRagioneSociale(t8.getText());
        else
            validitaInfo=false;
        if (!validitaInfo)
            avvisoVisivo("Errore","bc0000");
        else {
            avvisoVisivo("Ottimo", "42f58d");
            bFisso.setText("Benvenuto/a "+concessionario.getNomeUtente());

            vistaInfo.setDisable(true);
            vistaInfo.setVisible(false);

            bIndietro.setVisible(true);
            bAvanti.setVisible(true);
            vistaArchivio.setDisable(false);
            vistaArchivio.setVisible(true);
            entrataAnchor(vistaArchivio,-300,0);
        }
    }

    //carosello
    @FXML
    private void vediVistaAcquisti(){
        vistaArchivio.setVisible(false);
        vistaArchivio.setDisable(true);

        vistaAcquisti.setVisible(true);
        vistaAcquisti.setDisable(false);

        entrataAnchor(vistaAcquisti,-300,0);
        bAvanti.setDisable(true);
        bIndietro.setDisable(false);
    }

    @FXML
    private void vediVistaArchivio(){
        vistaAcquisti.setVisible(false);
        vistaAcquisti.setDisable(true);

        vistaArchivio.setVisible(true);
        vistaArchivio.setDisable(false);

        entrataAnchor(vistaArchivio,-300,0);
        bAvanti.setDisable(false);
        bIndietro.setDisable(true);
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

    //Cambio schermata

    @FXML
    private void cambiaInventarioView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("concessionarioInventario-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.getIcons().add(new Image(HelloApplication.class.getResource("/com/example/pratica724/img/logo.png").toString()));
        stage.setScene(scene);

        ConcessionarioInventarioView concessionarioInventarioView=fxmlLoader.getController();
        System.out.println(concessionarioInventarioView);
        concessionarioInventarioView.setConcessionario(this.concessionario);
    }

    @FXML
    private void cambiaArchivioView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("concessionarioArchivio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.getIcons().add(new Image(HelloApplication.class.getResource("/com/example/pratica724/img/logo.png").toString()));
        stage.setScene(scene);
    }
}