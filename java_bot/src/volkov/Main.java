package volkov;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import  java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Main {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {


        // Считываем токен из файла
        BufferedReader reader = null;
        StringBuilder TOKEN = new StringBuilder();

        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("D:\\token.txt"), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                TOKEN.append(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла! (возможно удален или переименован или перенесен)");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Ошибка чтения фала!");
                }
            }
        }

        String token = TOKEN.toString();
        HttpURLConnection connection = null;
        GetUpdates getUpdates = new GetUpdates(connection, token); // Обьект для создания запросов на сервер Telegram

        try {

            String lastMessage = getUpdates.getLastMessage(); //  Получаем последнее смс
            JsonObject jsonMessage = (JsonObject) new JsonParser().parse(lastMessage); // Преобразуем в JSON-объект
            System.out.println(jsonMessage.toString());
            GetDataFrom_JSONMessage.printJSONMessage(jsonMessage);

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}



































