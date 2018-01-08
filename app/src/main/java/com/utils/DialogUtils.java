package com.utils;

import android.content.Context;
import android.util.Log;

import com.dialog.SweetAlertDialog;
import com.lucky.wsy.wzx.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by wsy on 2017/9/27.
 */

public class DialogUtils {

    static TimerTask task;
    static SweetAlertDialog pDialog;
    static int colorNum = -1;

    public DialogUtils(Context context, String title, String text) {
        underTextDialog(context, title, text);
    }

    public static void basicDialog(Context context, String title) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setCancelable(true);
        sweetAlertDialog.setCanceledOnTouchOutside(true);
        sweetAlertDialog.setTitleText(title);
        sweetAlertDialog.setConfirmText("确定");
        sweetAlertDialog.show();
    }

    public static void underTextDialog(Context context, String title, String text) {
        new SweetAlertDialog(context).setTitleText(title).setContentText(text).setConfirmText("确定").show();
    }

    public static void errorTextDialog(Context context, String title, String content) {
        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(content)
                .setConfirmText("确定")
                .show();
    }

    public static void successTextDialog(Context context, String title, String content) {
        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(title)
                .setContentText(content)
                .setConfirmText("确定")
                .show();
    }

    public static void warningConfirmDialog(Context context, String title, String content, SweetAlertDialog.OnSweetClickListener confirmClick) {
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(content)
                .setConfirmText("确定")
                .setConfirmClickListener(confirmClick)
                .show();
    }

//    public static void warningCanceDialog(Context context, String title, String content, com.lucky.wzx.dialog.SweetAlertDialog.onSweetCCClickListener onSweetCCClickListener) {
//        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
//                .setTitleText(title)
//                .setContentText(content)
//                .setCancelText("取消")
//                .setConfirmText("确定")
//                .showCancelButton(true)
//                .setCCClickListener(onSweetCCClickListener)
//                .show();
//    }

    public static void customImgDialog(Context context, String title, String text, int resId) {
        new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(title)
                .setContentText(text)
                .setConfirmText("确定")
                .setCustomImage(resId)
                .show();
    }

    public static void customImgDialog(Context context, String title, String text, Object o) {
        if (!StringUtils.isNotBlank(String.valueOf(o))) {
            customImgDialog(context, title, text, Integer.valueOf(String.valueOf(o)));
        } else {
            new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText(title)
                    .setContentText(text)
                    .setConfirmText("确定")
                    .show();
        }
    }

    public static void progressDialogShow(final Context context, String title) {
        pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(title);
        pDialog.show();
        pDialog.setCancelable(false);
        timeStart(context);
    }

    private static void timeStart(final Context context) {
        Timer timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                colorNum++;
                switch (colorNum) {
                    case 0:
                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.blue_btn_bg_color));
                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
                        break;
                    case 1:
                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.material_deep_teal_50));
                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
                        break;
                    case 2:
                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.success_stroke_color));
                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
                        break;
                    case 3:
                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.material_deep_teal_20));
                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
                        break;
                    case 4:
                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.material_blue_grey_80));
                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
                        break;
                    case 5:
                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.warning_stroke_color));
                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
                        break;
                    case 6:
                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.success_stroke_color));
                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
                        colorNum = -1;
                        break;
                    default:
                }
            }
        };
        timer.schedule(task, 1000,1000);
    }
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                colorNum++;
//                switch (colorNum) {
//                    case 0:
//                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.blue_btn_bg_color));
//                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
//                        break;
//                    case 1:
//                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.material_deep_teal_50));
//                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
//                        break;
//                    case 2:
//                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.success_stroke_color));
//                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
//                        break;
//                    case 3:
//                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.material_deep_teal_20));
//                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
//                        break;
//                    case 4:
//                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.material_blue_grey_80));
//                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
//                        break;
//                    case 5:
//                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.warning_stroke_color));
//                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
//                        break;
//                    case 6:
//                        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.success_stroke_color));
//                        Log.i("ProgressDialogShow", "ProgressDialogShow: " + colorNum);
//                        colorNum = -1;
//                        break;
//                    default:
//                }
//            }
//        }, 1000, 1000);
//}

    public static void progressDialogHide() {
        if (pDialog != null) {
            task.cancel();
            task = null;
            pDialog.dismiss();
        }
    }
}
