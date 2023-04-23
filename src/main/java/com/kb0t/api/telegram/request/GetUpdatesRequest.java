package com.kb0t.api.telegram.request;

import com.kb0t.api.telegram.TelegramConnectionService;

public class GetUpdatesRequest extends TelegramConnectionService {
  public String getUpdates(String token) throws Exception{

    try {
      return this.connectToAPI(token, "/getUpdates");
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
