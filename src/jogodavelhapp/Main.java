package jogodavelhapp;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        root.getChildren().add(Gerenciador.telaInicial);
        root.getChildren().add(Gerenciador.telaSelecionar);
        root.getChildren().add(Gerenciador.telaJogo);

        Gerenciador.exibir(Gerenciador.telaInicial);
        Scene scene = new Scene(root, 380, 500);
        root.setStyle("-fx-background-color: #CD950C");
        stage.setTitle("Jogo da Velha");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        stage.setOnCloseRequest(e->Gerenciador.fechar());
        stage.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            Gerenciador.acoesT(t);
   
});

    }
     
    
    public static void main(String[] args) {
        launch(args);
    }

}
