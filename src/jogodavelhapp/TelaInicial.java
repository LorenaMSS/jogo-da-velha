package jogodavelhapp;


import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class TelaInicial extends Pane {

    Button novoJogo = new Button("Novo Jogo");
    Button carregarJogo = new Button("Jogos Salvos"+"\r\n"+" CTRL+L");
    Button sair = new Button("Sair");

    public TelaInicial() {

        novoJogo.setPrefSize(240, 40);
        carregarJogo.setPrefSize(240, 40);
        sair.setPrefSize(240, 40);

        novoJogo.setTranslateX(80);
        novoJogo.setTranslateY(110);
        carregarJogo.setTranslateX(80);
        carregarJogo.setTranslateY(170);
        sair.setTranslateX(80);
        sair.setTranslateY(230);

        getChildren().add(novoJogo);
        getChildren().add(carregarJogo);
        getChildren().add(sair);

        novoJogo.setOnAction((Action) -> {
            Gerenciador.exibir(Gerenciador.telaSelecionar);
            
        });
        
         carregarJogo.setOnAction((Action) -> {
             Gerenciador.load();
 
    });
    
        sair.setOnAction((Action) -> {
            System.exit(0);
        });

    }

}
