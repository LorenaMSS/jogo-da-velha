/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhapp;

import java.util.Optional;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;

public class TelaJogo extends Pane {

    Alert alert = new Alert(AlertType.INFORMATION);

    Label nomeJogador1 = new Label();
    Label nomeJogador2 = new Label();
    Label pontuacaoJogador1 = new Label("0");
    Label pontuacaoJogador2 = new Label("0");
    Label simboloJogadorAtual = new Label();
    GridPane boardPane = new GridPane();
    Button[] boardButtons = new Button[3 * 3];
    Button voltar = new Button("Voltar");
    Button reset = new Button("Reset");
    Button salvar = new Button("Salvar"+"\r\n"+"CTRL+S");
    ImageView boardBackground = new ImageView();
    String t00;
    String t01;
    String t02;
    String t10;
    String t11;
    String t12;
    String t20;
    String t21;
    String t22;

    boolean fimDeJogo;
    boolean vezPrimeiroJogador = true;

    int contXO = 0;

    Random random = new Random();
    int randomNumber;

    Color jogadaX = Color.RED;
    Color jogadaO = Color.BLUE;

    EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
        actionPerformed(e);

    };

    private void corGanhador(Button b1, Button b2, Button b3) {

        b1.setStyle("-fx-background-color: #FFC125");
        b2.setStyle("-fx-background-color: #FFC125");
        b3.setStyle("-fx-background-color: #FFC125");

    }

    private void criarGameBoard() {

        int linha = 0;
        int coluna = 0;

        for (int i = 0; i < boardButtons.length; i++) {

            boardButtons[i] = new Button();
            boardButtons[i].setPrefSize(90, 90);
            boardButtons[i].setFocusTraversable(false);
            GridPane.setMargin(boardButtons[i], new Insets(5));
            boardButtons[i].setFont(Font.font("Arial", FontWeight.BOLD, 40));
            boardPane.add(boardButtons[i], coluna, linha);
            boardButtons[i].addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });

            coluna++;
            if (coluna == 3) {
                linha++;
                coluna = 0;
            }
        }
    }

    public void preencher() {
        //X
        if (t00.equals("X")) {
            boardButtons[0].setTextFill(jogadaX);
            boardButtons[0].setText("X");
        }
        if (t01.equals("X")) {
            boardButtons[1].setTextFill(jogadaX);
            boardButtons[1].setText("X");
        }if (t02.equals("X")) {
            boardButtons[2].setTextFill(jogadaX);
            boardButtons[2].setText("X");
        }if (t10.equals("X")) {
            boardButtons[3].setTextFill(jogadaX);
            boardButtons[3].setText("X");
        }if (t11.equals("X")) {
            boardButtons[4].setTextFill(jogadaX);
            boardButtons[4].setText("X");
        }if (t12.equals("X")) {
            boardButtons[5].setTextFill(jogadaX);
            boardButtons[5].setText("X");
        }if (t20.equals("X")) {
            boardButtons[6].setTextFill(jogadaX);
            boardButtons[6].setText("X");
        }if (t21.equals("X")) {
            boardButtons[7].setTextFill(jogadaX);
            boardButtons[7].setText("X");
        }if (t22.equals("X")) {
            boardButtons[8].setTextFill(jogadaX);
            boardButtons[8].setText("X");
        }
        //O
         if (t00.equals("O")) {
            boardButtons[0].setTextFill(jogadaO);
            boardButtons[0].setText("O");
        }
        if (t01.equals("O")) {
            boardButtons[1].setTextFill(jogadaO);
            boardButtons[1].setText("O");
        }if (t02.equals("O")) {
            boardButtons[2].setTextFill(jogadaO);
            boardButtons[2].setText("O");
        }if (t10.equals("O")) {
            boardButtons[3].setTextFill(jogadaO);
            boardButtons[3].setText("O");
        }if (t11.equals("O")) {
            boardButtons[4].setTextFill(jogadaO);
            boardButtons[4].setText("O");
        }if (t12.equals("O")) {
            boardButtons[5].setTextFill(jogadaO);
            boardButtons[5].setText("O");
        }if (t20.equals("O")) {
            boardButtons[6].setTextFill(jogadaO);
            boardButtons[6].setText("O");
        }if (t21.equals("O")) {
            boardButtons[7].setTextFill(jogadaO);
            boardButtons[7].setText("O");
        }if (t22.equals("O")) {
            boardButtons[8].setTextFill(jogadaO);
            boardButtons[8].setText("O");
        }

    }

    private void checarAcabou() {

        t00 = boardButtons[0].getText();
        t01 = boardButtons[1].getText();
        t02 = boardButtons[2].getText();
        t10 = boardButtons[3].getText();
        t11 = boardButtons[4].getText();
        t12 = boardButtons[5].getText();
        t20 = boardButtons[6].getText();
        t21 = boardButtons[7].getText();
        t22 = boardButtons[8].getText();

        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[0], boardButtons[1], boardButtons[2]);
        }
        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[3], boardButtons[4], boardButtons[5]);
        }
        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[6], boardButtons[7], boardButtons[8]);
        }
        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[0], boardButtons[3], boardButtons[6]);
        }
        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[1], boardButtons[4], boardButtons[7]);
        }
        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[2], boardButtons[5], boardButtons[8]);
        }
        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[0], boardButtons[4], boardButtons[8]);
        }
        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            fimDeJogo = true;
            corGanhador(boardButtons[2], boardButtons[4], boardButtons[6]);
        }

        if (contXO >= 9 && fimDeJogo == false) {
            String str
                    = "EMPATE";
            alert.setContentText(str);
            alert.setTitle("");
            alert.setHeaderText("Ganhador");
            alert.setX(50);
            alert.setY(50);
            alert.showAndWait();

            fimDeJogo = true;

            vezPrimeiroJogador = true;
            contXO = 0;
            comecaJogoNovo();

        }

        if (fimDeJogo == true) {
            if (vezPrimeiroJogador) {
                String str
                        = nomeJogador1.getText() + " Venceu";
                alert.setContentText(str);
                alert.setTitle("");
                alert.setHeaderText("Ganhador");
                alert.showAndWait();

                pontuacaoJogador1.setText(Integer.valueOf(pontuacaoJogador1.getText()) + 1 + "");
                comecaJogoNovo();
                contXO = 0;

            } else {
                String str
                        = nomeJogador2.getText() + " Venceu";
                alert.setContentText(str);
                alert.setTitle("");
                alert.setHeaderText("Ganhador");
                alert.showAndWait();

                pontuacaoJogador2.setText(Integer.valueOf(pontuacaoJogador2.getText()) + 1 + "");
                contXO = 0;
                comecaJogoNovo();

            }

        }
    }

    void comecaJogoNovo() {
        fimDeJogo = false;
        randomNumber = random.nextInt(2);

        if (randomNumber == 0) {
            vezPrimeiroJogador = true;
        } else {
            vezPrimeiroJogador = false;
        }
        simboloAtual();
        for (Button boardButton : boardButtons) {
            boardButton.setText("");
            boardButton.setStyle("-fx-background-color: none; -fx-cursor: hand;");
        }
        t00="";t01="";t02="";t10="";t11="";t12="";t20="";t21="";t22="";
        
    }

    private void simboloAtual() {

        if (vezPrimeiroJogador == true) {
            simboloJogadorAtual.setText("X");
            simboloJogadorAtual.setTextFill(jogadaX);

        } else {
            simboloJogadorAtual.setText("O");
            simboloJogadorAtual.setTextFill(jogadaO);
        }
    }

    private void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();

        if (fimDeJogo == false && clickedButton.getText().equals("")) {
            if (vezPrimeiroJogador) {
                clickedButton.setTextFill(jogadaX);
                clickedButton.setText("X");
                if (e.getSource() == boardButtons[0]) {
                    t00 = "X";
                }
                if (e.getSource() == boardButtons[1]) {
                    t01 = "X";
                }
                if (e.getSource() == boardButtons[2]) {
                    t02 = "X";
                }
                if (e.getSource() == boardButtons[3]) {
                    t10 = "X";
                }
                if (e.getSource() == boardButtons[4]) {
                    t11 = "X";
                }
                if (e.getSource() == boardButtons[5]) {
                    t12 = "X";
                }
                if (e.getSource() == boardButtons[6]) {
                    t20 = "X";
                }
                if (e.getSource() == boardButtons[7]) {
                    t21 = "X";
                }
                if (e.getSource() == boardButtons[8]) {
                    t22 = "X";
                }
            } else {
                clickedButton.setTextFill(jogadaO);
                clickedButton.setText("O");
                if (e.getSource() == boardButtons[0]) {
                    t00 = "O";
                }
                if (e.getSource() == boardButtons[1]) {
                    t01 = "O";
                }
                if (e.getSource() == boardButtons[2]) {
                    t02 = "O";
                }
                if (e.getSource() == boardButtons[3]) {
                    t10 = "O";
                }
                if (e.getSource() == boardButtons[4]) {
                    t11 = "O";
                }
                if (e.getSource() == boardButtons[5]) {
                    t12 = "O";
                }
                if (e.getSource() == boardButtons[6]) {
                    t20 = "O";
                }
                if (e.getSource() == boardButtons[7]) {
                    t21 = "O";
                }
                if (e.getSource() == boardButtons[8]) {
                    t22 = "O";
                }
            }

            contXO++;

            checarAcabou();
            simboloAtual();
            vezPrimeiroJogador = !vezPrimeiroJogador;
            simboloAtual();
        }

    }

    public void reset() {
        fimDeJogo = false;
        randomNumber = random.nextInt(2);
        pontuacaoJogador1.setText("0");
        pontuacaoJogador2.setText("0");

        if (randomNumber == 0) {
            vezPrimeiroJogador = true;
        } else {
            vezPrimeiroJogador = false;
        }
        simboloAtual();
        for (Button boardButton : boardButtons) {
            boardButton.setText("");
            boardButton.setStyle("-fx-background-color: none; -fx-cursor: hand;");

        }

    }

    public TelaJogo() {

        boardBackground.setImage(new Image(getClass().getResourceAsStream("/imagens/grade.png")));
        boardPane.setStyle("-fx-background-color: #CD950C");
        nomeJogador1.setPrefSize(150, 30);
        nomeJogador2.setPrefSize(150, 30);
        pontuacaoJogador1.setPrefSize(150, 30);
        pontuacaoJogador2.setPrefSize(150, 30);
        simboloJogadorAtual.setPrefSize(150, 30);
        boardPane.setPrefSize(300, 300);
        reset.setPrefSize(100, 30);
        voltar.setPrefSize(100, 30);
        salvar.setPrefSize(100, 30);
       
        simboloJogadorAtual.setFont(Font.font(30));
        pontuacaoJogador1.setFont(Font.font(15));
        pontuacaoJogador2.setFont(Font.font(15));
        nomeJogador1.setFont(Font.font(16));
        nomeJogador2.setFont(Font.font(16));

        
        
        
        
        
        nomeJogador1.setTranslateY(10);
        nomeJogador2.setTranslateX(250);
        nomeJogador2.setTranslateY(10);
        pontuacaoJogador1.setTranslateY(40);
        pontuacaoJogador2.setTranslateX(250);
        pontuacaoJogador2.setTranslateY(40);
        simboloJogadorAtual.setTranslateX(120);
        simboloJogadorAtual.setTranslateY(25);
        boardBackground.setFitWidth(300);
        boardBackground.setFitHeight(300);
        boardBackground.setTranslateX(45);
        boardBackground.setTranslateY(105);
        boardPane.setTranslateX(45);
        boardPane.setTranslateY(105);
        voltar.setTranslateX(20);
        voltar.setTranslateY(455);
        reset.setTranslateX(150);
        reset.setTranslateY(455);
        salvar.setTranslateX(280);
        salvar.setTranslateY(455);

        nomeJogador1.setAlignment(Pos.CENTER);
        nomeJogador2.setAlignment(Pos.CENTER);
        pontuacaoJogador1.setAlignment(Pos.CENTER);
        pontuacaoJogador2.setAlignment(Pos.CENTER);
        simboloJogadorAtual.setAlignment(Pos.CENTER);
        criarGameBoard();

        getChildren().add(nomeJogador1);
        getChildren().add(nomeJogador2);
        getChildren().add(pontuacaoJogador1);
        getChildren().add(pontuacaoJogador2);
        getChildren().add(simboloJogadorAtual);
        getChildren().add(boardPane);
        getChildren().add(boardBackground);
        getChildren().add(voltar);
        getChildren().add(reset);
        getChildren().add(salvar);

        comecaJogoNovo();

        voltar.setOnAction((Action) -> {
            comecaJogoNovo();
            Gerenciador.exibir(Gerenciador.telaSelecionar);
        });

        reset.setOnAction((Action) -> {
            reset();

        });

        salvar.setOnAction((Action) -> {
            Gerenciador.salvar();

        });

    }
}
