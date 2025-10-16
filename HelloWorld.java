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

        try {
            // Create JSch instance
            JSch jsch = new JSch();
            
            // Optional: Add identity (private key) for key-based auth
            // jsch.addIdentity("/path/to/private/key");
            
            // Get session
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            
            // Configure session properties
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            
            // Force only aes192-ctr cipher for both directions
            config.put("cipher.s2c", "aes192-ctr");  // Server to client
            config.put("cipher.c2s", "aes192-ctr");  // Client to server
            config.put("CheckCiphers", "aes192-ctr");
            
            session.setConfig(config);
            
            // Set timeout (optional)
            session.setTimeout(30000);
            
            // Connect session
            System.out.println("Connecting to " + host + "...");
            session.connect();
            System.out.println("Connected successfully!");
            System.out.println("Using cipher: aes192-ctr");
            
            // Open exec channel for command execution
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            
            // Configure channel streams
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            
            InputStream in = channel.getInputStream();
            
            // Connect channel
            channel.connect();
            
            // Read command output
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("\nExit status: " + channel.getExitStatus());
                    break;
                }
                
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    // Handle interruption
                }
            }
            
        } catch (JSchException e) {
            System.err.println("JSch error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up resources
            if (channel != null && channel.isConnected()) {
                channel.disconnect();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
                System.out.println("Disconnected.");
            }
        }        

    }
}
