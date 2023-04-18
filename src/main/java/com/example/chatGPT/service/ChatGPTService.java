package com.example.chatGPT.service;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

import java.util.Collections;

public class ChatGPTService {
    private static final String API_KEY = "xxxxxxx";
    private static final String API_ENDPOINT = "https://api.openai.com/v1/completions";
    public String getAnswer(String question) {
        String prompt = "Answer the following question: " + question;

        JSONObject requestBody = new JSONObject()
                .put("prompt", prompt)
                .put("max_tokens", 1000)
                .put("model", "text-davinci-003");
        System.out.println(prompt);
        HttpResponse<JsonNode> response = Unirest.post(API_ENDPOINT)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .asJson();
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            return response.getBody().getObject().getJSONArray("choices").getJSONObject(0).getString("text").trim();
        } else {
            throw new RuntimeException("Failed to call ChatGPT API: " + response.getStatusText());
        }
    }

}

