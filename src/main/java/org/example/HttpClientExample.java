package org.example;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class HttpClientExample {
    public static void main(String[] args) {
        String url = "https://randomuser.me/api";
        //String url = "https://api.example.com/data";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;

        try {
            httpResponse =  httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String responseContent = EntityUtils.toString(httpEntity);
            JSONObject jsonObject = new JSONObject(responseContent);
            JSONObject results = jsonObject.getJSONArray("results").getJSONObject(0);
            String gender = results.getString("gender");

            System.out.println(gender);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
