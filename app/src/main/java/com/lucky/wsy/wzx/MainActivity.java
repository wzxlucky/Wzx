package com.lucky.wsy.wzx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.lucky.wsy.wzx.adapter.MainAdapter;
import com.lucky.wsy.wzx.bean.MainBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    private MainAdapter mainAdapter;

    private List<MainBean> mList = new ArrayList<>();

    private MainBean mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        mb = new MainBean();
        mb.setId("0");
        mb.setName("对话框flyco");
        mList.add(mb);

        mainAdapter = new MainAdapter(MainActivity.this, mList);
        lv.setAdapter(mainAdapter);
    }
}
