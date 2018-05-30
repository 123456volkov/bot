package volkov;

import com.google.gson.JsonObject;

/**
 * Created by Александр on 30.05.2018.
 */
//jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("text").toString();

public abstract class GetDataFrom_JSONMessage {

    public static  String getOK(JsonObject jsonObject){
       return jsonObject.get("ok").toString();
    }

    public static String getResult_update_id(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("update_id").toString();
    }

    public static String getResult_message_message_id(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("message_id").toString();
    }

    public static String getResult_message_from_id(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("from").getAsJsonObject().get("id").toString();
    }

    public static String getResult_message_from_is_bot(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("from").getAsJsonObject().get("is_bot").toString();
    }

    public static String getResult_message_from_first_name(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("from").getAsJsonObject().get("first_name").toString();
    }

    public static String getResult_message_from_username(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("from").getAsJsonObject().get("username").toString();
    }

    public static String getResult_message_from_language_code(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("from").getAsJsonObject().get("language_code").toString();
    }

    public static String getResult_chat_id(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().getAsJsonObject().get("message").getAsJsonObject().get("chat").getAsJsonObject().get("id").toString();
    }

    public static String getResult_chat_first_name(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("chat").getAsJsonObject().get("first_name").toString();
    }

    public static String getResult_chat_username(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("chat").getAsJsonObject().get("username").toString();
    }

    public static String getResult_chat_type(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("chat").getAsJsonObject().get("type").toString();
    }

    public static String getResult_date(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("date").toString();
    }

    public static String getResult_text(JsonObject jsonObject){
        return jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("text").toString();
    }
}
