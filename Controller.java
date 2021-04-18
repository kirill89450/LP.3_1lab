package sample;



import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class Controller {



    @FXML
    private Button StartButton;

    @FXML
    private ProgressBar Progress;

    @FXML
    private TextField message;

    @FXML
    void process(ActionEvent event) {
        new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                try {
                    Thread.sleep(20);
                    }
                catch (Exception e) {}
                float counter = i;
                Platform.runLater(() -> {
                    try {
                        wait();
                    }
                    catch (Exception e) {}
                    StartButton.setText("Подождите...");
                    Progress.setProgress(counter/1000);
                    message.setText("Идёт процесс  - " + counter/10 + "% ");
                    if (counter == 1000) {
                        message.setText("Завершено!");
                        StartButton.setText("Start");
                    }
                });
            }
        }).start();

    }


}
