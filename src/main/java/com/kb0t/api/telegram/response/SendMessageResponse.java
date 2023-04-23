package com.kb0t.api.telegram.response;

import com.kb0t.api.telegram.TelegramConnectionService;


public class SendMessageResponse extends TelegramConnectionService {
  public void sendMessage(String token, String id, String msg) throws Exception {

    try{
      String params = String.format("/sendMessage?chat_id=%s&text=%s", id, msg);
      this.connectToAPI(token, params);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }

  }
}
