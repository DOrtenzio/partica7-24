package com.example.pratica724;

import com.example.pratica724.auto.InventarioAuto;
import com.example.pratica724.auto.RegistroAcquisti;
import com.example.pratica724.utenti.Concessionario;
import com.example.pratica724.utenti.Privato;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Configurazione della finestra principale
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("concessionario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.getIcons().add(new Image(HelloApplication.class.getResource("/com/example/pratica724/img/logo.png").toString()));
        stage.setTitle("AutoPixel - Gruppo Martini");
        stage.setScene(scene);
        stage.setResizable(false);

        ConcessionarioController concessionarioController = fxmlLoader.getController();
        InventarioAuto inventarioAuto = new InventarioAuto();
        RegistroAcquisti registroAcquisti = new RegistroAcquisti();
        Concessionario concessionario = new Concessionario(null, null, "template", "template", null, null, "template", "template", inventarioAuto, registroAcquisti);

        concessionarioController.setConcessionario(concessionario);
        concessionarioController.setFirstView(true);
        concessionarioController.initializeAComando();

        stage.show();

        // Configurazione della seconda finestra indipendente
        FXMLLoader clienteLoader = new FXMLLoader(HelloApplication.class.getResource("cliente-view.fxml"));
        Scene clienteScene = new Scene(clienteLoader.load(), 900, 600);
        Stage clienteStage = new Stage();
        clienteStage.getIcons().add(new Image(HelloApplication.class.getResource("/com/example/pratica724/img/logo.png").toString()));
        clienteStage.setTitle("Cliente - AutoPixel");
        clienteStage.setScene(clienteScene);
        clienteStage.setResizable(false);

        ClienteController clienteController = clienteLoader.getController();
        Privato privato=new Privato(null,null,"Template","template", "template","template", null,"template");
        clienteController.setFirstView(true);
        clienteController.setConcessionario(concessionario);
        clienteController.setPrivato(privato);

        clienteStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}