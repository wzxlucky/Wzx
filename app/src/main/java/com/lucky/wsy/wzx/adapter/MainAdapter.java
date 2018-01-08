package com.lucky.wsy.wzx.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dialog.SweetActivity;
import com.flyco.dialogsamples.ui.DialogHomeActivity;
import com.lucky.wsy.wzx.R;
import com.lucky.wsy.wzx.bean.MainBean;
import com.timeline.TimeLineActivity;

import java.util.List;

/**
 * Created by wsy on 2017/11/23.
 */

public class MainAdapter extends BaseAdapter {

    private Context context;
    private List<MainBean> mList;

    public MainAdapter(Context context, List<MainBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.adp_main, null);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(mList.get(position).getName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context, DialogHomeActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, TimeLineActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, SweetActivity.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
    }
}
