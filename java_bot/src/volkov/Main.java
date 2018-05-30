package volkov;

import com.google.gson.*;

import  java.net.HttpURLConnection;

import static java.lang.Thread.sleep;

public class Main {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

        String token = "619767740:AAFb1IfAsmRQJ_WKO0CbbhQJyvXHdtH36LM";

        HttpURLConnection connection = null;
        GetUpdates getUpdates = new GetUpdates(connection, token); // Обьект для создания запросов на сервер Telegram

        try {

            String lastMessage = getUpdates.getLastMessage(); //  Получаем последнее смс
            //System.out.println(lastMessage);
            JsonObject jsonObject = (JsonObject) new JsonParser().parse(lastMessage); // Преобразуем в JSON-объект
            System.out.println(jsonObject.toString());

            System.out.println(GetDataFrom_JSONMessage.getOK(jsonObject)+ " " +
                    GetDataFrom_JSONMessage.getResult_update_id(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_message_message_id(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_message_from_id(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_message_from_is_bot(jsonObject)+ " " +
                    GetDataFrom_JSONMessage.getResult_message_from_first_name(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_message_from_username(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_message_from_language_code(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_chat_id(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_chat_id(jsonObject)  + " " +
                    GetDataFrom_JSONMessage.getResult_chat_first_name(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_chat_username(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_chat_type(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_date(jsonObject) + " " +
                    GetDataFrom_JSONMessage.getResult_text(jsonObject));

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}



































