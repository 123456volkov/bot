package volkov;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import  java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;

import static java.lang.Thread.sleep;

public class Main {

    private static  final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

        String token = "619767740:AAFb1IfAsmRQJ_WKO0CbbhQJyvXHdtH36LM";

	    HttpURLConnection connection = null;
        getUpdates getUpdates = new getUpdates(connection, token); // Обьект для создания запросов на сервер Telegram

	    try{

           String lastMessage = getUpdates.getLastMessage(); //  Получаем последнее смс
           System.out.println(lastMessage);
           JsonObject jsonObject = (JsonObject)new JsonParser().parse(lastMessage); // Преобразуем в JSON-объект
           System.out.println(jsonObject.get("result"));

           JsonArray result = (JsonArray) jsonObject.get("result") ;
           Iterator<JsonElement> iterator = result.iterator();

           while(iterator.hasNext()){
               System.out.println(iterator.next());
           }

        } catch (Throwable cause){
	        cause.printStackTrace();
        }
        finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }

    public static class getUpdates { //   Класс, который содержит методы получения последних обновлений бота

        private String token;
        private HttpURLConnection connection;
        private String URL;

        getUpdates(HttpURLConnection connection, String token){ //  Конструктор, для инициализации стоки запроса на сервер Telegram
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
}

































