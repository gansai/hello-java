package com.javaexamples.web;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class SendHTTPRequestExample {


    private static String GET_MESSAGE_URL = "https://www.google.com/search";
    private static String GET_MESSAGE_PARAM = "?q=hello";
    private static String USER_AGENT_STRING = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";

    public static void main(String[] args) {
        try {
            sendGetRequest( GET_MESSAGE_URL, Arrays.asList(GET_MESSAGE_PARAM));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // HTTP GET request
    private static void sendGetRequest(String getURL, List<String> parameters) throws Exception {

        String url = getURL;
        String firstParam = parameters.get(0);
        url += firstParam;
        for(int index=0; index < parameters.size();index++){
            if(index == 0){
                continue;
            }
            else{
                url += "&" + parameters.get(index);
            }
        }


        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT_STRING);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
