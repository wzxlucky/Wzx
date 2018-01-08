package com.timeline;

/**
 * 时间轴
 * <p>
 * Created by wsy on 2017/9/27.
 */

public class TimeLineBean {

    private String mTitle;
    private String mMessage;


    public TimeLineBean(String mMessage, String mTitle) {
        this.mMessage = mMessage;
        this.mTitle = mTitle;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
