package com.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucky.wsy.wzx.R;
import com.utils.StringUtils;

import static com.lucky.wsy.wzx.R.id.btn_neg;
import static com.lucky.wsy.wzx.R.id.btn_pos;
import static com.lucky.wsy.wzx.R.id.img_line;
import static com.lucky.wsy.wzx.R.id.ll_loading;
import static com.lucky.wsy.wzx.R.id.tv_loading_text;
import static com.lucky.wsy.wzx.R.id.txt_msg;
import static com.lucky.wsy.wzx.R.id.txt_title;


/**
 * Created by wsy on 2017/9/29.
 */

public class IosAlertDialog {

    private Context context;
    private Dialog dialog;
    private LinearLayout lLayoutBg;
    private TextView txtTitle;
    private TextView txtMsg;
    private Button btnNeg;
    private Button btnPos;
    private ImageView imgLine;
    private Display display;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;

    private TextView tvLoadingText;

    private LinearLayout llAlert, llLoading;
    public static final String ALERT_DIALOG = "alertDialog";
    public static final String LOADING_DIALOG = "loadingDialog";

    private String dialogType;

    public IosAlertDialog(Context context, String mDialogType) {
        this.context = context;
        this.dialogType = mDialogType;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public IosAlertDialog builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.view_alertdialog, null);

        // 获取自定义Dialog布局中的控件
        lLayoutBg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
        llAlert = (LinearLayout) view.findViewById(R.id.ll_alert);
        llLoading = (LinearLayout) view.findViewById(R.id.ll_loading);
        tvLoadingText = (TextView) view.findViewById(R.id.tv_loading_text);
        txtTitle = (TextView) view.findViewById(R.id.txt_title);
        txtTitle.setVisibility(View.GONE);
        txtMsg = (TextView) view.findViewById(R.id.txt_msg);
        txtMsg.setVisibility(View.GONE);
        btnNeg = (Button) view.findViewById(R.id.btn_neg);
        btnNeg.setVisibility(View.GONE);
        btnPos = (Button) view.findViewById(R.id.btn_pos);
        btnPos.setVisibility(View.GONE);
        imgLine = (ImageView) view.findViewById(R.id.img_line);
        imgLine.setVisibility(View.GONE);

        if (!StringUtils.isNotBlank(dialogType) || dialogType.equals(ALERT_DIALOG)) {
            llAlert.setVisibility(View.VISIBLE);
            llLoading.setVisibility(View.GONE);
        } else {
            llAlert.setVisibility(View.GONE);
            llLoading.setVisibility(View.VISIBLE);
        }

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        // 调整dialog背景大小
        lLayoutBg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));

        return this;
    }

    public IosAlertDialog setLoadingTitle(String title) {
        if (!StringUtils.isNotBlank(title)) {
            tvLoadingText.setText("加载中...");
        } else {
            tvLoadingText.setText(title);
        }
        return this;
    }

    public IosAlertDialog setTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            txtTitle.setText("标题");
        } else {
            txtTitle.setText(title);
        }
        return this;
    }

    public IosAlertDialog setMsg(String msg) {
        showMsg = true;
        if ("".equals(msg)) {
            txtMsg.setText("内容");
        } else {
            txtMsg.setText(msg);
        }
        return this;
    }

    public IosAlertDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public IosAlertDialog setPositiveButton(String text,
                                            final View.OnClickListener listener) {
        showPosBtn = true;
        if ("".equals(text)) {
            btnPos.setText("确定");
        } else {
            btnPos.setText(text);
        }
        btnPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public IosAlertDialog setNegativeButton(String text,
                                            final View.OnClickListener listener) {
        showNegBtn = true;
        if ("".equals(text)) {
            btnNeg.setText("取消");
        } else {
            btnNeg.setText(text);
        }
        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    private void setLayout() {
        if (!showTitle && !showMsg) {
            txtTitle.setText("提示");
            txtTitle.setVisibility(View.VISIBLE);
        }

        if (showTitle) {
            txtTitle.setVisibility(View.VISIBLE);
        }

        if (showMsg) {
            txtMsg.setVisibility(View.VISIBLE);
        }

        if (!showPosBtn && !showNegBtn) {
            btnPos.setText("确定");
            btnPos.setVisibility(View.VISIBLE);
            btnPos.setBackgroundResource(R.drawable.sel_alert_dialog_one);
            btnPos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        if (showPosBtn && showNegBtn) {
            btnPos.setVisibility(View.VISIBLE);
            btnPos.setBackgroundResource(R.drawable.sel_alert_dialog_two_left);
            btnNeg.setVisibility(View.VISIBLE);
            btnNeg.setBackgroundResource(R.drawable.sel_alert_dialog_two_right);
            imgLine.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn) {
            btnPos.setVisibility(View.VISIBLE);
            btnPos.setBackgroundResource(R.drawable.sel_alert_dialog_one);
        }

        if (!showPosBtn && showNegBtn) {
            btnNeg.setVisibility(View.VISIBLE);
            btnNeg.setBackgroundResource(R.drawable.sel_alert_dialog_one);
        }
    }

    public void show() {
        setLayout();
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }
}
