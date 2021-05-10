package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    TextArea chatTextArea;
    @FXML
    TextField messageTextField;

    private static StringBuilder sb = new StringBuilder();
    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    public void buttonSendClicked(ActionEvent actionEvent) {

        sendMessage();

    }

    @FXML
    public void messageTextFieldOnAction(ActionEvent actionEvent) {

        sendMessage();

    }

    private void sendMessage(){

        String currentMessageText = messageTextField.getText().trim();
        if(currentMessageText.isEmpty()){
            return;
        }
        Date dateNow = new Date();
        currentMessageText = dateFormat.format(dateNow) + ": " + currentMessageText;
        sb.append(currentMessageText);
        sb.append("\n");
        chatTextArea.setText((chatTextArea.getText().isEmpty() ? "" : chatTextArea.getText() + "\n") + currentMessageText);
        messageTextField.setText("");
        messageTextField.requestFocus();

    }
}