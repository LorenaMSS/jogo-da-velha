
package jogodavelhapp;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class TelaSelecionar extends Pane {
    

    Label jogadorXLabel = new Label("Jogador X: ");
    Label jogadorOLabel = new Label("Jogador O: ");
    TextField nomeJogador1 = new TextField("Primeiro Jogador");
    TextField nomeJogador2 = new TextField("Segundo Jogador");
    Button jogar = new Button("Jogar");
    Button voltar = new Button("Voltar");

    public TelaSelecionar() {

        jogadorXLabel.setPrefSize(70, 30);
        nomeJogador1.setPrefSize(160, 30);
        jogadorOLabel.setPrefSize(70, 30);
        nomeJogador2.setPrefSize(160, 30);
        jogar.setPrefSize(240, 40);
        voltar.setPrefSize(240, 40);

        jogadorXLabel.setTranslateX(80);
        jogadorXLabel.setTranslateY(130);
        nomeJogador1.setTranslateX(160);
        nomeJogador1.setTranslateY(130);
        jogadorOLabel.setTranslateX(80);
        jogadorOLabel.setTranslateY(190);
        nomeJogador2.setTranslateX(160);
        nomeJogador2.setTranslateY(190);
        jogar.setTranslateX(80);
        jogar.setTranslateY(250);
        voltar.setTranslateX(80);
        voltar.setTranslateY(310);

        getChildren().add(jogadorXLabel);
        getChildren().add(jogadorOLabel);
        getChildren().add(nomeJogador1);
        getChildren().add(nomeJogador2);
        getChildren().add(jogar);
        getChildren().add(voltar);

        jogar.setOnAction((Action) -> {

            Gerenciador.telaJogo.nomeJogador1.setText(nomeJogador1.getText());
            Gerenciador.telaJogo.nomeJogador2.setText(nomeJogador2.getText());
            Gerenciador.telaJogo.pontuacaoJogador1.setText("0");
            Gerenciador.telaJogo.pontuacaoJogador2.setText("0");

            Gerenciador.exibir(Gerenciador.telaJogo);

        });

        voltar.setOnAction((Action) -> {
            Gerenciador.exibir(Gerenciador.telaInicial);
        });
    }

   
}
