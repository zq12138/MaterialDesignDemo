package com.example.admin.materialdesigndemo.retrofit.api;

import android.app.Dialog;
import android.support.annotation.StyleRes;

import com.example.admin.materialdesigndemo.activity.BaseActivity;


/**
 * Created by zq on 2017/9/28.
 */

public interface IBaseDialogView {

    Dialog createDialog(@StyleRes int themeResId);

    void showError(String message);

    BaseActivity getBaseActivity();

    boolean isAlive();

}
