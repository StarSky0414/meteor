package com.starsky.meteor.controller.externalrequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseNetRequest {

    public String postModel(String url,HashMap<String, String> header, HashMap<String, String> parameter) {
        String respondsString="";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        if (parameter != null) {
            for (Map.Entry<String, String> entry : parameter.entrySet()) {
                formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                System.out.println(entry.getKey()+entry.getValue());
            }
        }
        UrlEncodedFormEntity uefEntity;
        CloseableHttpResponse response = null;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(uefEntity);
            response = httpClient.execute(httpPost);
            String string = EntityUtils.toString(response.getEntity());
            System.out.println(string);
            respondsString=string;
        } catch (Exception e) {
            System.out.println("网络请求异常");
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("网络请求，资源关闭异常");
            }
        }
        return respondsString;
    }

}
