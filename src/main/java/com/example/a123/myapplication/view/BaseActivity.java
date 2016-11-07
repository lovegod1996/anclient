package com.example.a123.myapplication.view;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/11/7.
 */

public class BaseActivity extends Activity {
    //底部导航处理
    //标题处理


    //多个Activity应用的退出
    //方案两种
    private List<Activity> activities=new ArrayList<Activity>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
    }
    private void exitSYtem(){
        for (Activity item: activities){
            item.finish();
        }
        //杀进程

    }
    //如果某个Activity显示的调用finish（），activities集合中还存在应用
    //finish(),做清理的操作

    //重写destory

    @Override
    protected void onDestroy() {
        activities.remove(this);
        super.onDestroy();
    }
}
