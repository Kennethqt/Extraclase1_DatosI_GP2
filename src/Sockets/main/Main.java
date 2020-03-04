package Sockets.main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.List;

    public class Main extends Application implements EventHandler<ActionEvent> {

        private Button btnEnviar;
        private Text txtChat;
        private TextField txtMensaje;
        private List<String> listMessages;

        public void start(Stage primaryStage) throws Exception {

            try {
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                hBox.setPadding(new Insets(5));
                HBox.setHgrow(hBox, Priority.ALWAYS);
                listMessages = new LinkedList<String>();
                txtChat = new Text();
                hBox.getChildren().addAll(txtChat);



                HBox ButtonArea = new HBox();
                ButtonArea.setSpacing(10);
                ButtonArea.setPadding(new Insets(5));
                txtMensaje = new TextField();
                btnEnviar = new Button("Enviar");
                btnEnviar.setOnAction(this);
                ButtonArea.setAlignment(Pos.BOTTOM_RIGHT);

                HBox.setHgrow(ButtonArea, Priority.ALWAYS);
                ButtonArea.getChildren().addAll(txtMensaje, btnEnviar);

                BorderPane root = new BorderPane();
                root.setCenter(hBox);
                root.setBottom(ButtonArea);
                Scene scene = new Scene(root, 500, 500);
                primaryStage.setScene(scene);
                primaryStage.setTitle("WhatsUpp");
                primaryStage.show();

            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btnEnviar) {
                listMessages.add(txtMensaje.getText());
                for (int i = 0; i < listMessages.size(); i++) {
                    txtChat.setText(listMessages.get(i));
                    txtMensaje.setText("");

                }
            }
        }
    }
