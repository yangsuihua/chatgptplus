package com.gpt.Frame;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;


import com.gpt.Frame.utils.Request;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Map;


/**\
 *  需要挂全局代理才能访问，或者使用局部代理，指向代理端口
 */

public class mywork {
    static JTextArea textArea1;
    static JTextArea textArea;
    private JFrame jf;
    static public String sendmessage;
    public String returnmessage;
    static JSONObject jsonObjectinit;

    static InputStream inputStream;
    static JSONArray jsonArrayinit;
    static Request request;

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new mywork();
    }

    public mywork() {
        jf = new JFrame("chatgpt");
        jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 14));
        jf.setBounds(550, 250, 500, 467);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);
        jsonObjectinit = new JSONObject();
        jsonObjectinit.put("role", "system");
        jsonObjectinit.put("content", "你是一个乐于助人的助手");
        request = new Request();
        jsonArrayinit = request.getMessagearray();
        jsonArrayinit.add(jsonObjectinit);

        //输出文本
        textArea1 = new JTextArea();
        textArea1.setLineWrap(true);                         // 自动换行
        textArea1.setEditable(false);
//        textArea1.setText( "我们都有一个家，名字叫中国，兄弟姐妹都很多...... ");
        textArea1.setFont(new Font(null, Font.PLAIN, 10));
        JScrollPane jScrollPane1 = new JScrollPane(textArea1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setBounds(10, 20, 430, 270);
        jf.getContentPane().add(jScrollPane1);

        //用户输入文本框
        textArea = new JTextArea();
        textArea.setLineWrap(true);                         // 自动换行
        textArea.setFont(new Font(null, Font.PLAIN, 10));
        JScrollPane jScrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(10, 320, 350, 100);
        jf.getContentPane().add(jScrollPane);


        //按钮发送事件
        JButton button = new JButton("发送");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                sendmessage = textArea.getText().toString();
                textArea.setText("");
                send(e);
            }
        });
        button.setBounds(400, 355, 60, 40);
        jf.getContentPane().add(button);

        jf.setVisible(true);
        jf.setResizable(true);
    }

    public void send(ActionEvent e) {
        chat chat = new chat();
        chat.start();
    }
    }
//        try {
//            URL url = new URL("https://api.openai.com/v1/chat/completions");
//
//            urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("POST");
//
//
//            urlConnection.setConnectTimeout(100000);
//            // 设置读取远程返回的数据时间：60000毫秒
//            urlConnection.setReadTimeout(10000);
//
//            urlConnection.setRequestProperty("Content-Type", "application/json");
//            urlConnection.setRequestProperty("Authorization", "Bearer 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");
//            //传入参数
//            Request request = new Request();
//            JSONObject jsonObject = request.getjsonObject();
//            jsonObject.put("model", "gpt-3.5-turbo");
//            JSONObject jsonObjectmessage;
//            for (int i = 0; i < 1; i++) {
//                jsonObjectmessage = new JSONObject();
//                jsonObjectmessage.put("role", "user");
//                jsonObjectmessage.put("content", sendmessage);
//                jsonArrayinit.add(jsonObjectmessage);
//            }
//            jsonObject.put("messages", jsonArrayinit);
//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//
//            //传入参数
//            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
//            System.out.println("asdjdskajdkjdkaj" + request.toString());
//            writer.write(request.toString());
//            writer.flush();
//
//            InputStream is = urlConnection.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            StringBuffer sbf = new StringBuffer();
//            String strRead = null;
//            while ((strRead = reader.readLine()) != null) {
//                sbf.append(strRead);
//                sbf.append("\r\n");
//            }
//            reader.close();
//
//            // 关闭连接
//            urlConnection.disconnect();
//
//            // 打印读到的响应结果
//            System.out.println("运行结束：" + sbf);
//            String responseData = sbf.toString();
//
//            org.json.JSONObject responseJson = new org.json.JSONObject(responseData);
//            String returnmessage = responseJson.getJSONArray("choices")
//                    .getJSONObject(0)
//                    .getJSONObject("message")
//                    .getString("content");
////            returnmessage=sbf.toString();
//            textArea1.append(returnmessage + "\n");
//            textArea1.append("\n");
//
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }
//}


