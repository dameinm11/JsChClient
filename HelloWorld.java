import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jcraft.jsch.*;
import java.io.InputStream;
import java.util.Properties;

public class HelloWorld {
    public static class Resp {
      String name;
      Double capD;
      double d;
    }
    public static void main(String[] args) {

        String jsonString = "{ \"name\": \"claro\", \"msisdn\": 234234234234 }";
    
        // Resp json = new Gson().fromJson(jsonString, Resp.class);
        // System.out.println(json);
        // System.out.println(json.toString().length());
        
        System.out.println("-------------------- "+jsonString);
        
        // Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        // String json2 = gson2.toJson(json);
        // System.out.println(json2);
        // System.out.println(json2.toString().length());
        
        // JsonObject convertedObject2 = gson.fromJson(json.toString(), JsonObject.class);
        
        // System.out.println(convertedObject2);


    }
}
