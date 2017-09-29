package com.example.admin.materialdesigndemo.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.materialdesigndemo.dialog.ETongDaiDialog;
import com.example.admin.materialdesigndemo.dialog.ErrorDialogUtil;
import com.example.admin.materialdesigndemo.retrofit.api.IBaseDialogView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zq on 2017/9/28.
 */

public class BaseActivity extends AppCompatActivity implements IBaseDialogView {

    List<WeakReference<Dialog>> dialogManager = new ArrayList<>();

    private boolean isAlive;//针对Dialog弹窗用于检测当前Activity是否存活

    @Override
    public Dialog createDialog(@StyleRes int themeResId) {
        Dialog dialog = new Dialog(this, themeResId);
        dialogManager.add(new WeakReference<>(dialog));
        return dialog;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isAlive = true;

    }

    @Override
    protected void onStart() {
        super.onStart();
        isAlive = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isAlive = false;
    }

    @Override
    protected void onDestroy() {
        isAlive = false;
        for (WeakReference<Dialog> weakReference : dialogManager) {
            if (weakReference.get() != null) {
                weakReference.get().dismiss();
            }
        }
        dialogManager.clear();
        super.onDestroy();
    }
    protected void showError(int errResource) {
        ErrorDialogUtil.showErrorDialog(this, getString(errResource));
    }
    @Override
    public void showError(String message) {
        showError(message, new ETongDaiDialog.EmptyETongDaiDialogListener());
    }
    public void showError(String errStr, ETongDaiDialog.EtdSingleListener listeners) {
        ErrorDialogUtil.showErrorDialog(this, errStr, listeners);
    }
    @Override
    public BaseActivity getBaseActivity() {
        return this;
    }


    @Override
    public boolean isAlive() {
        return false;
    }
}
