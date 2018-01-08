package com.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lucky.wsy.wzx.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间轴
 * <p>
 * Created by wsy on 2017/9/27.
 */

public class TimeLineActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineBean> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_line);

        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(getLinearLayoutManager());
        mRecyclerView.setHasFixedSize(true);
        setDataListItems();
        mTimeLineAdapter = new TimeLineAdapter(mDataList);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    private LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    private void setDataListItems() {
        mDataList.add(new TimeLineBean("Item successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully deliveredItem successfully delivered", "Item successfully delivered"));
        mDataList.add(new TimeLineBean("Courier is out to delivery your order", "2017-02-12 08:00"));
        mDataList.add(new TimeLineBean("Item has reached courier facility at New Delhi", "2017-02-11 21:00"));
        mDataList.add(new TimeLineBean("Item has been given to the courier", "2017-02-11 18:00"));
        mDataList.add(new TimeLineBean("Item is packed and will dispatch soon", "2017-02-11 09:30"));
        mDataList.add(new TimeLineBean("Order is being readied for dispatch", "2017-02-11 08:00"));
        mDataList.add(new TimeLineBean("Order processing initiated", "2017-02-10 15:00"));
        mDataList.add(new TimeLineBean("Order confirmed by seller", "2017-02-10 14:30"));
        mDataList.add(new TimeLineBean("Order placed successfully", "2017-02-10 14:00"));
    }
}
