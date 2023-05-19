package com.gpt.Frame.utils;




import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
public class Request {
   @Override
   public String toString() {
      return  jsonObject.toString() ;
   }

   JSONObject jsonObject=new JSONObject();

   public JSONObject getjsonObject() {
      return jsonObject;
   }

   public void setjsonObject(Map requestmap) {
      this.jsonObject = jsonObject;
   }

   public JSONArray getMessagearray() {
      return messagearray;
   }

   public void setMessagearray(JSONArray messagearray) {
      this.messagearray = messagearray;
   }

   JSONArray messagearray=new JSONArray();
}
