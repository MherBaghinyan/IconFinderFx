package sample;

import com.memento.services.MementoHttpServer;
import com.memento.services.MementoHttpServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// https://stackoverflow.com/questions/10143392/javafx-2-and-internationalization
//Client Id y990aNV9JNd1q4XIVJm6jq5sqQHoZDjU7TBmZGzRAnH8RzR7QonqXAcOYjmcB97w
// Client Secret LSXALwY89W1Mqe2CVOfCYKeLthxiePFhuwYsiODq4vLPb291U5jRUhVKWQsxUJWh
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Icon Finder");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        MementoHttpServer server = new MementoHttpServiceImpl();

        try {
            System.out.println(server.run("https://raw.github.com/square/okhttp/master/README.md"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
