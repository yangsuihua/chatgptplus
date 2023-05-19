package com.gpt.Frame.utils;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class Respond {
    JSONObject respondmap= new JSONObject();
    JSONArray choicesarray=new JSONArray();

    public JSONObject getRespondmap() {
        return respondmap;
    }

    public void setRespondmap(JSONObject respondmap) {
        this.respondmap = respondmap;
    }

    public JSONArray getChoicesarray() {
        return choicesarray;
    }

    public void setChoicesarray(JSONArray choicesarray) {
        this.choicesarray = choicesarray;
    }
}
