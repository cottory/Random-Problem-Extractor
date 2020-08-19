package com.baylab.project.domain.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Component
public class KakaoApiService {

    private static final String accessTokenRequestURL = "https://kauth.kakao.com/oauth/token";
    private static final String userInfoRequestURL = "https://kapi.kakao.com/v1/user/access_token_info";

    @Value("${custom.oauth2.kakao.client-id}")
    private String client_id;

    @Value("${custom.oauth2.kakao.client-secret}")
    private String client_secret;

    @Value("${custom.oauth2.kakao.redirect-uri}")
    private String redirect_uri;

    public String getAccessToken(final String authorize_code) throws IOException {

        URL url = new URL(accessTokenRequestURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("grant_type=authorization_code");
        stringBuffer.append("&client_id=" + client_id);
        stringBuffer.append("&redirect_uri=" + redirect_uri);
        stringBuffer.append("&code=" + authorize_code);
        stringBuffer.append("&client_secret=" + client_secret);
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.flush();

        //결과 코드가 200이라면 성공
        int responseCode = connection.getResponseCode();
        System.out.println("responseCode : " + responseCode);

        //요청을 통해 얻은 JSON 타입의 Response 메시지 읽어오기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        StringBuffer result = new StringBuffer();

        while ((line = bufferedReader.readLine()) != null)
        {
            result.append(line);
        }

        System.out.println("response body : " + result);

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(result.toString());

        final String access_Token = element.getAsJsonObject().get("access_token").getAsString();
        final String refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

        System.out.println("access_token : " + access_Token);
        System.out.println("refresh_token : " + refresh_Token);

        bufferedReader.close();
        bufferedWriter.close();

        return access_Token;
    }

    public HashMap<String,Object> getUserInfo(final String access_Token) throws IOException{

        HashMap<String, Object> userInfo = new HashMap<>();

        URL url = new URL(userInfoRequestURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + access_Token);

        int responseCode = connection.getResponseCode();
        System.out.println("responseCode : " + responseCode);

        //요청을 통해 얻은 JSON 타입의 Response 메시지 읽어오기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        StringBuffer result = new StringBuffer();

        while ((line = bufferedReader.readLine()) != null)
        {
            result.append(line);
        }

        System.out.println("response body : " + result);

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(result.toString());

        final String id = element.getAsJsonObject().get("id").getAsString();
        final String expires_in = element.getAsJsonObject().get("expires_in").getAsString();
        final String app_id = element.getAsJsonObject().get("app_id").getAsString();

        userInfo.put("id", id);
        userInfo.put("expires_in", expires_in);
        userInfo.put("app_id", app_id);

        return userInfo;
    }
}
