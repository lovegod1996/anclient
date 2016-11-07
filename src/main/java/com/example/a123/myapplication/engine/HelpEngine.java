package com.example.a123.myapplication.engine;
   //检查本地是否有帮助列表
   //如果有，直接展示给用户
    //检查服务器是否有新数据
   //如果没有，到服务器获取

import com.example.a123.myapplication.bean.Help;
import com.example.a123.myapplication.bean.HelpDetail;

import java.util.List;

/**
 * 帮助模块业务操作
 * Created by 123 on 2016/11/7.
 */

public interface HelpEngine {
    /**
     * 获取服务器帮助列表
     */
    public List<Help> getServiceHelpList();

/**
 * 一句帮助id获取详情
 */
   public HelpDetail getServiceHelpDetail(int helpid);
    /**
     * 获取本地的帮助列表
     */
   public List<Help> getLocalHelpList();
    /**
     * 获取本地的帮助详情
     */
    public HelpDetail getLocalHelpDetail(int helpid);

}
