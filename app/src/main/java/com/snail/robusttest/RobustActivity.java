package com.snail.robusttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.meituan.robust.patch.annotaion.Add;
import com.meituan.robust.patch.annotaion.Modify;

/**
 * author：created by Snail.江
 * time: 4/6/2017 15:02
 * email：409962004@qq.com
 * TODO:
 */
public class RobustActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robust);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(getString());
    }

    private String getString() {
        return "hello robust";
    }

    /**
     * @Modify 注解表明该方法会被打补丁
     *
     * @Add 注解表明该方法是新增的
     */
//    @Override
//    @Modify
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_robust);
//        TextView textView = (TextView) findViewById(R.id.textView2);
//        textView.setText(getInfo());
//    }
//
//    @Add
//    public String getInfo() {
//        String msg = "";
//        for (int i = 0; i < 10; i++) {
//            msg += i + "\n";
//        }
//        return msg;
//    }
}
