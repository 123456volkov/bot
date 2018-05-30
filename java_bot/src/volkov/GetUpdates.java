package volkov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Александр on 30.05.2018.
 */
public class GetUpdates { //   Класс, который содержит методы получения последних обновлений бота

    private String token;
    private HttpURLConnection connection;
    private String URL;

    GetUpdates(HttpURLConnection connection, String token){ //  Конструктор, для инициализации стоки запроса на сервер Telegram
        this.connection = connection;
        this.token = token;
        URL = "https://api.telegram.org/bot" + token + "/" + "getupdates?offset=-1";
    }

    public String getLastMessage() throws IOException, InterruptedException { // Получение последнего смс пришедшего боту

        StringBuilder lastMessage = new StringBuilder(); //  Переменная для соеденения строки (последнего сообщенея), получаемого от сервера

        connection = (HttpURLConnection) new URL(this.URL).openConnection(); //  Инициализируем connection
        connection.setRequestMethod("GET");
        connection.setUseCaches(false); //  Кеширование данных

        connection.connect(); // Отправляем запрос

        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) { //  Если есть подключение к серверу Telegram ( == 200)

            //  Считываем последние полученые данные
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "cp1251"));

            String line;
            while ((line = in.readLine()) != null) {
                lastMessage.append(line);
            }

            return lastMessage.toString(); //  Строка содержит кирилические строки в Unicode
        }
        else { //  Нет подключения к серверу Telegram
            System.out.println("Fail (1) нет подключения: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
            return null;
        }
    }
}

