package com.example.a123.myapplication.engine;

import com.alibaba.fastjson.JSON;
import com.example.a123.myapplication.ConstantValue;
import com.example.a123.myapplication.bean.Help;
import com.example.a123.myapplication.bean.HelpDetail;
import com.example.a123.myapplication.net.HttpClientUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2016/11/7.
 */

public class HelpEngineImpl implements HelpEngine {
    @Override
    public List<Help> getServiceHelpList() {
        List<Help> result=null;
        //本地的帮助是否是最新的
        String version="0";
        //发送version到服务器端
        HttpClientUtil util=new HttpClientUtil();
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("version","1");
        String json=util.sendPost(ConstantValue.COMMON+ConstantValue.HELP,params);

        //数据处理，检验数据是否回复正常
        try {
            JSONObject object=new JSONObject(json);
            if(checkError(object)){
               //幫助數據處理
                result=new ArrayList<Help>();
              String helpListstr=  object.getString("helplist");//[{....},{.....}]
                /**
                 * 使用alibaba。jar包控件
                 */
                result= JSON.parseArray(helpListstr,Help.class);

                //持久化到本地
                //如果數據量過大，開啓子綫程完成數據擦歐縂


                return  result;
            }else{

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //帮助列表的数据处理
        //回复json字符串

        return null;
    }

    private boolean checkError(JSONObject object) {
        try {
          String response  =object.getString("response");
            if(ConstantValue.ERROR.equals(response)){
                return  false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
return  true;
    }

    @Override
    public HelpDetail getServiceHelpDetail(int helpid) {
        return null;
    }

    @Override
    public List<Help> getLocalHelpList() {
        return null;
    }

    @Override
    public HelpDetail getLocalHelpDetail(int helpid) {
        return null;
    }
}
