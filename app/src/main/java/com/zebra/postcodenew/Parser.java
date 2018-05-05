package com.zebra.postcodenew;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zebra.postcodenew.model.PostcodeResponse;

public class Parser {

    private final Gson gson;

    public Parser() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    public PostcodeResponse getParsedResponse(String html) {
        return gson.fromJson(html, PostcodeResponse.class);
    }

}
