package com.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * @author wsy  2018/1/10.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;

    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View mView = bindView();
        if (null == mView) {
            mContextView = LayoutInflater.from(this)
                    .inflate(bindLayout(), null);
        } else {
            mContextView = mView;
        }

        if (isSetStatusBar) {
            steepStatusBar();
        }
        setContentView(mContextView);
        initView(mContextView);
        initData();
        onClickEvent(mContextView);
    }


    public abstract View bindView();

    public abstract int bindLayout();

    public abstract void initView(final View view);

    public abstract void initData();

    public abstract void onClickEvent(View v);

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    @Override
    public void onClick(View v) {
        if (fastClick()) {
            onClickEvent(v);
        }
    }


    /**
     * 沉浸状态栏
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 快速点击
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * 页面跳转
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }
}
