package controllers;

import models.Id;

import java.io.IOException;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        this.idCtrl = j;
    }

    //    public List<Id> getIds() {
//
//    }
    public String postId(String idtoRegister, String githubName) throws Exception {
        Id tid = new Id(idtoRegister, githubName);
        return ServerController.shared().idPost(tid);
//        Id tid = new Id(idtoRegister, githubName);
//        idCtrl.postId(tid);
//        return ("Id registered.");
    }

    public String makecall(String s, String get, String s1) throws IOException {
        return ServerController.shared().idGet();
    }
}
