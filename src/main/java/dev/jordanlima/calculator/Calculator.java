package dev.jordanlima.calculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Calculator extends Application {
    @Override
    public void start(Stage main) throws IOException {
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 300,300);
        BorderPane layout = new BorderPane();
        GridPane grid = new GridPane();
        HBox hbox = new HBox();

        Label aviso = new Label("0");

        Button btnAC = new Button("AC");
        Button numUm = new Button("1");
        Button numDois = new Button("2");
        Button numTres = new Button("3");
        Button numQuatro = new Button("4");
        Button numCinco = new Button("5");
        Button numSeis = new Button("6");
        Button numSete = new Button("7");
        Button numOito = new Button("8");
        Button numNove = new Button("9");
        Button numZero = new Button("0");
        Button btnPonto = new Button(".");
        Button btnDividir = new Button("/");
        Button btnVezes = new Button("*");
        Button btnMais = new Button("+");
        Button btnMenos = new Button("-");
        Button btnIgual = new Button("=");
        Button btnPorcentagem = new Button("%");
        Button btnParenteseEsquerdo = new Button("(");
        Button btnParenteseDireito = new Button(")");





        grid.add(numZero, 0, 4);
        grid.add(btnPonto, 1, 4);
        grid.add(btnIgual, 2, 4);
        grid.add(btnMais, 3, 4);

        grid.add(numUm, 0, 3);
        grid.add(numDois, 1, 3);
        grid.add(numTres, 2, 3);
        grid.add(btnMenos, 3, 3);

        grid.add(numQuatro, 0, 2);
        grid.add(numCinco, 1, 2);
        grid.add(numSeis, 2, 2);
        grid.add(btnVezes, 3, 2);

        grid.add(numSete, 0, 1);
        grid.add(numOito, 1, 1);
        grid.add(numNove, 2, 1);
        grid.add(btnDividir, 3, 1);

        grid.add(btnParenteseEsquerdo, 0, 0);
        grid.add(btnParenteseDireito, 1, 0);
        grid.add(btnPorcentagem, 2, 0);
        grid.add(btnAC, 3, 0);


        tecladoNumerico(numUm, aviso);
        tecladoNumerico(numDois, aviso);
        tecladoNumerico(numTres, aviso);
        tecladoNumerico(numQuatro, aviso);
        tecladoNumerico(numCinco, aviso);
        tecladoNumerico(numSeis, aviso);
        tecladoNumerico(numSete, aviso);
        tecladoNumerico(numOito, aviso);
        tecladoNumerico(numNove, aviso);
        tecladoNumerico(numZero, aviso);

        teclaOperador(btnMais, aviso);
        teclaOperador(btnMenos, aviso);
        teclaOperador(btnVezes, aviso);
        teclaOperador(btnDividir, aviso);
        teclaOperador(btnPorcentagem, aviso);

        btnAC.setOnAction(e -> aviso.setText("0"));

        btnPonto.setOnAction(e -> {
            if(!aviso.getText().contains(".")) {
                aviso.setText(aviso.getText() + btnPonto.getText());
            }
        });



        hbox.getChildren().add(aviso);
        hbox.setAlignment(Pos.CENTER);
        HBox.getHgrow(btnAC);


        grid.setAlignment(Pos.CENTER);
        grid.prefWidth(layout.getWidth());

        layout.setMinSize(300, 300);
        layout.setTop(hbox);
        layout.setCenter(grid);
        root.getChildren().add(layout);

        Objects.requireNonNull(scene.getStylesheets().getClass().getResource(
                "/dev/jordanlima/css/main.css")).toExternalForm();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public void tecladoNumerico(Button btn, Label display) {
        btn.setOnAction(e -> {
            if(display.getText().equals("0")) {
                display.setText(btn.getText());
                return;
            }
            display.setText(display.getText() + btn.getText());
        });
    }

    public void teclaOperador(Button btn, Label display){
        btn.setOnAction(e -> {
            if(!display.getText().endsWith("+") || !display.getText().endsWith("-") || !display.getText().endsWith("*") || !display.getText().endsWith("/") || !display.getText().endsWith("%")) {
                display.setText(display.getText().concat(btn.getText()));
            }
        });
    }
}
