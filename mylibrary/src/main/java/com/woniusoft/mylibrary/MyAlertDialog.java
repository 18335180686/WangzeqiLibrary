package com.woniusoft.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * 作者： WZQ
 * 功能： 自定义弹窗提示
 * 日期：2017/7/11 0004
 */

public class MyAlertDialog {
    private Context context;
    private AlertDialog.Builder builder;

    /**
     * 初始化
     * @param context this
     */
    public MyAlertDialog(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);
    }

    /**
     * 显示提示框
     * @param title     标题
     * @param text      内容
     * @param dialogBtn 点击接口的回掉
     */
    public void showADialog(String title, String text, final MyAlertDialogBtn dialogBtn) {
        builder.setTitle(title);  //设置标题
        builder.setMessage(text);  //设置内容
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogBtn.myPNBtn(true);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogBtn.myPNBtn(false);
            }
        });
        builder.show();
    }

}
