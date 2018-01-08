package com.dialog;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import com.lucky.wsy.wzx.R;
import com.utils.DialogUtils;


/**
 * 对话框
 * <p>
 * Created by wsy on 2017/9/27.
 */

public class SweetActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sweetacy);
        findViewById(R.id.basic_test).setOnClickListener(this);
        findViewById(R.id.under_text_test).setOnClickListener(this);
        findViewById(R.id.error_text_test).setOnClickListener(this);
        findViewById(R.id.success_text_test).setOnClickListener(this);
        findViewById(R.id.warning_confirm_test).setOnClickListener(this);
        findViewById(R.id.warning_cancel_test).setOnClickListener(this);
        findViewById(R.id.custom_img_test).setOnClickListener(this);
        findViewById(R.id.progress_dialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basic_test:
                DialogUtils.basicDialog(SweetActivity.this, "da独山大道撒旦撒旦撒大声地实打实大撒大声地撒颠三倒四到死大手大脚soID就爱上单价较低啊搜集2");
                break;
            case R.id.under_text_test:
                DialogUtils.underTextDialog(this, "大祭司奇偶啊", "大家就死哦那就是");
                break;
            case R.id.error_text_test:
                DialogUtils.errorTextDialog(this, "2412421", "jdifjisodjfisjdisodjfi");
                break;
            case R.id.success_text_test:
                DialogUtils.successTextDialog(this, "jiojijvoicjvoc", "fdsdf12123123");
                break;
            case R.id.warning_confirm_test:
                DialogUtils.warningConfirmDialog(this, "sdadads", "dsdasdasd", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                });
                break;
            case R.id.warning_cancel_test:
//                DialogUtils.warningCanceDialog(this, "123123", "fdfsfdsfsdfdf", new SweetAlertDialog.onSweetCCClickListener() {
//                    @Override
//                    public void onConfirmClick(SweetAlertDialog sweetAlertDialog) {
//                        sweetAlertDialog.dismiss();
//                    }
//
//                    @Override
//                    public void onCancleClick(SweetAlertDialog sweetAlertDialog) {
//                        sweetAlertDialog.dismiss();
//                    }
//                });
                break;
            case R.id.custom_img_test:
                DialogUtils.customImgDialog(this, "sdasd", "dasdasdsd", null);
                break;
            case R.id.progress_dialog:
                DialogUtils.progressDialogShow(this, "加载中...");
                CountDownTimer cdt = new CountDownTimer(7000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        DialogUtils.progressDialogHide();
                    }
                };
                cdt.start();
                break;
            default:
        }
    }
}
