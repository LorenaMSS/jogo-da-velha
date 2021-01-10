package jogodavelhapp;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Gerenciador {

    static TelaInicial telaInicial = new TelaInicial();
    static TelaSelecionar telaSelecionar = new TelaSelecionar();
    static TelaJogo telaJogo = new TelaJogo();

    public static void exibir(Pane pane) {
        telaInicial.setVisible(false);
        telaSelecionar.setVisible(false);
        telaJogo.setVisible(false);

        pane.setVisible(true);
    }

    public static void fechar() {
        if (telaJogo.isVisible()) {
            boolean result = Confirmar.display("Fechar Jogo", "Deseja salvar seu jogo?");
            if (result == true) {
                salvar();
            } else {

            }
        } else {

        }
    }

    public static void acoesT(KeyEvent t) {
        if (t.getCode() == KeyCode.CONTROL.S) {
            if (telaJogo.isVisible()) {
                salvar();
            }

        }
        if (t.getCode() == KeyCode.CONTROL.L) {
                load();
            }
        }

    

    public static void salvar() {
        SaveData data = new SaveData();

        data.b0 = telaJogo.t00;
        data.b1 = telaJogo.t01;
        data.b2 = telaJogo.t02;
        data.b3 = telaJogo.t10;
        data.b4 = telaJogo.t11;
        data.b5 = telaJogo.t12;
        data.b6 = telaJogo.t20;
        data.b7 = telaJogo.t21;
        data.b8 = telaJogo.t22;

        data.nomeJ1 = telaJogo.nomeJogador1.getText();
        data.nomeJ2 = telaJogo.nomeJogador2.getText();
        data.pontuacaoJ1 = telaJogo.pontuacaoJogador1.getText();
        data.pontuacaoJ2 = telaJogo.pontuacaoJogador2.getText();
        data.simbolo = telaJogo.simboloJogadorAtual.getText();
        data.vez = telaJogo.vezPrimeiroJogador;
        String fileName = null;

        TextInputDialog dialog = new TextInputDialog(fileName);
        dialog.setTitle("Salvar arquivo");
        dialog.setHeaderText("Nomei o seu jogo");
        dialog.setContentText("Por favor coloque o nome do seu jogo: ");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            fileName = result.get();
        }
        try {
            ResourceManager.save(data, fileName + ".save");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Salvo!");
            alert.setHeaderText("Salvo!");
            alert.setContentText("O jogo foi salvo!");
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText("Erro!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }
    }

    public static void load() {
        String fileName = null;
        TextInputDialog dialog = new TextInputDialog(fileName);
        dialog.setTitle("Carregar arquivo");
        dialog.setHeaderText("Carrege o seu jogo");
        dialog.setContentText("Por favor coloque o nome do jogo salvo: ");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            fileName = result.get();
        }
        try {
            SaveData data = (SaveData) ResourceManager.load(fileName + ".save");
            telaJogo.t00 = data.b0;
            telaJogo.t01 = data.b1;
            telaJogo.t02 = data.b2;
            telaJogo.t10 = data.b3;
            telaJogo.t11 = data.b4;
            telaJogo.t12 = data.b5;
            telaJogo.t20 = data.b6;
            telaJogo.t21 = data.b7;
            telaJogo.t22 = data.b8;
            telaJogo.nomeJogador1.setText(data.nomeJ1);
            telaJogo.nomeJogador2.setText(data.nomeJ2);
            telaJogo.pontuacaoJogador1.setText(data.pontuacaoJ1);
            telaJogo.pontuacaoJogador2.setText(data.pontuacaoJ2);
            telaJogo.simboloJogadorAtual.setText(data.simbolo);
            telaJogo.randomNumber = data.random;
            telaJogo.vezPrimeiroJogador = data.vez;
            telaJogo.preencher();

            System.out.println(data.b1 + data.b2 + data.b3 + data.b4 + data.b5 + data.b6 + data.b7 + data.b8);

            Gerenciador.exibir(telaJogo);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText("Save não existe");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }
    }

}
