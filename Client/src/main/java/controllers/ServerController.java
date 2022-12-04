package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();
    private List<Id> ids;
    private List<Message> messages;

    ServerController() {}

    public static ServerController shared() {
        return svr;
    }

    public String idGet() throws IOException {
        // url -> /ids/
        // send the server a get with url
        // return json from server

        String jsonString;
        URL url = new URL(rootURL + "/ids");
        ObjectMapper mapper = new ObjectMapper();
        ids = mapper.readValue(url, new TypeReference<>(){});

        jsonString = mapper.writeValueAsString(ids);

        return jsonString;
    }

    public String messagesGet() throws IOException {
        // url -> /ids/
        // send the server a get with url
        // return json from server

        String jsonString;
        URL url = new URL(rootURL + "/messages");
        ObjectMapper mapper = new ObjectMapper();
        messages = mapper.readValue(url, new TypeReference<>(){});

        jsonString = mapper.writeValueAsString(messages);

        return jsonString;
    }

    //Id myId = new Id("Collin", "Collin-Cleveland");
    public String idPost(Id id) throws Exception {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        URL url = new URL(rootURL + "/ids");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = id.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        StringBuilder response;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        return response.toString();
    }
    public String idPut(Id id) {
        // url -> /ids/
        return "";
    }


}

// ServerController.shared.doGet()