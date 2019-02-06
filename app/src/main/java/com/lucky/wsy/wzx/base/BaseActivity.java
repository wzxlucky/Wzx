package com.one.wsy.wzxlib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.cazaea.sweetalert.SweetAlertDialog;
import com.noober.background.BackgroundLibrary;

/**
 * 描述：Activity基类
 * 名称: BaseActivity
 * 版本: 1.0
 * 日期: 2018/4/17 9:19
 *
 * @author wsy
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected final String SUCCESS_GET_CODE = "200";

    protected final String SUCCESS_POST_CODE = "201";

    protected final String TAG = this.getClass().getSimpleName();

    protected InputMethodManager inputMethodManager;

    private boolean isDoubleClick = true;

    protected SweetAlertDialog sweetAlertDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        setContentView();
        initView();
        initData();
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    /**
     * 初始化布局
     */
    public abstract void setContentView();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 业务操作
     */
    public abstract void initData();

    /**
     * 点击事件
     *
     * @param v 控件视图
     */
    public abstract void onClickEvent(View v);


    @Override
    public void onClick(View v) {
        if (isDoubleClick) {
            if (fastClick()) {
                onClickEvent(v);
            }
        } else {
            onClickEvent(v);
        }
    }

    public <T extends View> T findView(int resId) {
        return (T) super.findViewById(resId);
    }


    /**
     * 防止快速点击
     * 两次点击间隔不能少于1500ms
     *
     * @return
     */

    private static final int MIN_DELAY_TIME = 1500;

    private static long lastClickTime;

    public void setDoubleClick(boolean isDoubleClick) {
        this.isDoubleClick = isDoubleClick;
    }

    private boolean fastClick() {
        boolean flag = false;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = currentClickTime;
        return flag;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sweetAlertDialog != null) {
            if (sweetAlertDialog.isShowing()) {
                sweetAlertDialog.dismiss();
            }
            sweetAlertDialog = null;
        }
    }


    /**
     * 单个按钮警告对话框
     *
     * @param msg                  提示信息
     * @param onSweetClickListener 接口回调
     */
    protected void getWarmDialog(String msg, SweetAlertDialog.OnSweetClickListener onSweetClickListener) {
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText(msg);
        sweetAlertDialog.setConfirmText("确定");
        sweetAlertDialog.setConfirmClickListener(onSweetClickListener);
        sweetAlertDialog.show();
    }

    /**
     * 两个按钮警告对话框
     *
     * @param msg                  提示信息
     * @param onSweetClickListener 接口回调
     * @param onCancelListener     接口回调
     */
    protected void getWarmDialogTwoBtn(String msg, SweetAlertDialog.OnSweetClickListener onSweetClickListener, SweetAlertDialog.OnSweetClickListener onCancelListener) {
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText(msg);
        sweetAlertDialog.setConfirmText("确定");
        sweetAlertDialog.setCancelText("取消");
        sweetAlertDialog.setConfirmClickListener(onSweetClickListener);
        sweetAlertDialog.setCancelClickListener(onCancelListener);
        sweetAlertDialog.show();
    }

    /**
     * 成功对话框
     *
     * @param msg                  提示信息
     * @param onSweetClickListener 接口回调
     */
    protected void getSuccessDialog(String msg, SweetAlertDialog.OnSweetClickListener onSweetClickListener) {
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setTitleText(msg);
        sweetAlertDialog.setConfirmText("确定");
        sweetAlertDialog.setConfirmClickListener(onSweetClickListener);
        sweetAlertDialog.show();
    }


    /**
     * 失败对话框
     *
     * @param msg                  提示信息
     * @param onSweetClickListener 接口回调
     */
    protected void getErrorDialog(String msg, SweetAlertDialog.OnSweetClickListener onSweetClickListener) {
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setTitleText(msg);
        sweetAlertDialog.setConfirmText("确定");
        sweetAlertDialog.setConfirmClickListener(onSweetClickListener);
        sweetAlertDialog.show();
    }

    /**
     * 加载对话框
     *
     * @param msg 提示信息
     */
    protected void getProgressDialog(String msg) {
        sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        sweetAlertDialog.setTitleText(msg);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }

    /**
     * 关闭加载对话框
     */
    protected void dismissProgressDialog() {
        if (sweetAlertDialog != null) {
            sweetAlertDialog.dismiss();
        }
    }

    /**
     * 隐藏软键盘
     */
    protected void hideSoftKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null) {

                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

}
