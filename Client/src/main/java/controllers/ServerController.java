package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";
    private String idsURL = "http://zipcode.rocks:8085/ids";

    private ServerController svr = new ServerController();
    private List<Id> ids;

    private ServerController() {}

//    public static shared() {
//        return svr;
//    }

    public String idGet() throws IOException {
        // url -> /ids/
        // send the server a get with url
        // return json from server

        String jsonString;
        URL url = new URL(idsURL);
        ObjectMapper mapper = new ObjectMapper();
        ids = mapper.readValue(url, new TypeReference<>(){});

        jsonString = mapper.writeValueAsString(ids);

        return jsonString;
    }
    public String idPost(Id id) {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        return "";
    }
    public String idPut(Id id) {
        // url -> /ids/
        return "";
    }


}

// ServerController.shared.doGet()