package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class Controller {

    private long time;
    private boolean red = false;

    @FXML
    Button btn;

    @FXML
    Label label;

    @FXML
    private void initialize(){
        changeColor();
    }

    @FXML
    void onBtnClicked(){
        if (red){
        long result=System.currentTimeMillis()-time;
        label.setText("Czas reakcji: " + result + " ms");
        btn.setStyle("-fx-background-color:#1de44f; -fx-pref-height:200px; -fx-pref-width:200px ");
        red = false;
        changeColor();
        }else{label.setText("Za wcześnie");}
    }

    private void changeColor(){
        int interval;
        Random random = new Random();
        interval = random.nextInt(9000)+1001;
        Runnable r = () -> {
            try{
                Thread.sleep(interval);
                btn.setStyle("-fx-background-color:#e21d1d; -fx-pref-height:200px; -fx-pref-width:200px ");
                red = true;
                time = System.currentTimeMillis();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(r);
        thread.start();
    }


}
