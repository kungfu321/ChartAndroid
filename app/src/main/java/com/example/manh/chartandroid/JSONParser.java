package com.example.manh.chartandroid;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by manh on 23/04/2015.
 */
public class JSONParser {
    HttpGet httpGet;

    public JSONObject httpGETJSONArray(String url, List<NameValuePair> params) {
        try {

            HttpParams httpParameters = new BasicHttpParams();

            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);

            url = url + "?" + URLEncodedUtils.format(params, "UTF-8");
            httpGet = new HttpGet(url);
//            if(token != null) httpGet.setHeader(token, token_value);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            InputStream inputStream = httpEntity.getContent();
            if(inputStream != null){
                String result = convertInputStream(inputStream);
                JSONObject resultJSON = new JSONObject(result);
                return resultJSON;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String convertInputStream(InputStream inputStream) {
        String json = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            inputStream.close();
            json = stringBuilder.toString();
        } catch (Exception e) {
        }
        return json;
    }
}
