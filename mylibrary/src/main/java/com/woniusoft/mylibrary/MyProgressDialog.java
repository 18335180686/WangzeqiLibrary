package com.woniusoft.mylibrary;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

/**
 * 作者： WZQ
 * 功能： 自定义等待弹窗
 * 日期：2017/7/11 0004
 */

public class MyProgressDialog {

    private Context context;
    private ProgressDialog progressDialog;

    /**
     * 初始化
     *
     * @param context this
     */
    public MyProgressDialog(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);

    }

    /**
     * 显示等待条
     *
     * @param msg 要显示的内容
     */
    public void showPDialog(String msg) {
        progressDialog.setMessage(msg);
        progressDialog.show();

    }

    /**
     * 消失等待条
     */
    public void disPDialog() {
        progressDialog.dismiss();
    }

    public void cancelListener(final Thread thread) {
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (thread!= null&& thread.isAlive()){
                    thread.interrupt();
                    Log.e("------线程----", "线程死了");
                }
                Log.e("------弹窗消失了----", "取消了");
            }
        });
    }
}
