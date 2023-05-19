package com.gpt.Frame;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.gpt.Frame.utils.Request;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.gpt.Frame.mywork.jsonArrayinit;
import static com.gpt.Frame.mywork.sendmessage;


public class chat extends Thread {
    JTextArea textArea=mywork.textArea;
    JTextArea textArea1=mywork.textArea1;
    static HttpURLConnection urlConnection;
    @Override
    public void run() {

        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");


            urlConnection.setConnectTimeout(100000);
            // 设置读取远程返回的数据时间：60000毫秒
            urlConnection.setReadTimeout(600000);
//
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer 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");
            //传入参数
            Request request = new Request();
            JSONObject jsonObject = request.getjsonObject();
            jsonObject.put("model","gpt-3.5-turbo");
            JSONObject jsonObjectmessage;
            for(int i=0;i<1;i++){
                jsonObjectmessage=new JSONObject();
                jsonObjectmessage.put("role","user");
                jsonObjectmessage.put("content",sendmessage);
                jsonArrayinit.add(jsonObjectmessage);
            }

                    jsonObject.put("max_tokens",2000);
                    jsonObject.put("temperature",0.5);
            jsonObject.put("messages",jsonArrayinit);
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            //传入参数
            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
            System.out.println("asdjdskajdkjdkaj"+request.toString());
            writer.write(request.toString());
            writer.flush();

            InputStream is = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuffer sbf = new StringBuffer();
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();

            // 关闭连接
            urlConnection.disconnect();

            // 打印读到的响应结果
            System.out.println("运行结束：" + sbf);
            String responseData = sbf.toString();

            org.json.JSONObject responseJson = new org.json.JSONObject(responseData);
            String returnmessage = responseJson.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
//            returnmessage=sbf.toString();
            textArea1.append(returnmessage+"\n");
            textArea1.append("\n");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    }

