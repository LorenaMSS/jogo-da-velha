/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Confirmar {
    
    static boolean resposta;
    
    public static boolean display(String title, String message){
        Stage window= new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label= new Label(message);
        
        Button sim= new Button("sim");
        Button não= new Button("não");
        
        sim.setOnAction((Action)->{
            resposta=true;
            window.close();
        });
        não.setOnAction((Action)->{
            resposta=false;
            window.close();
        });
        
        VBox layout= new VBox();
        layout.getChildren().add(label);
        layout.getChildren().add(sim);
        layout.getChildren().add(não);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #FF7256");
        Scene scene= new Scene(layout);
        window.setScene (scene);
        window.showAndWait();
        
        return resposta;
      
        
    }

    
}
