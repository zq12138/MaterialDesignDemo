package com.example.admin.materialdesigndemo.fragment;


import android.app.Dialog;
import android.content.Context;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;

import com.example.admin.materialdesigndemo.activity.BaseActivity;
import com.example.admin.materialdesigndemo.dialog.ETongDaiDialog;
import com.example.admin.materialdesigndemo.retrofit.api.IBaseDialogView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zq on 2017/9/29.
 */

public class BaseFragment extends Fragment implements IBaseDialogView {

    private boolean isAlive = false;
    List<WeakReference<Dialog>> dialogManager = new ArrayList<>();
    @Override
    public void onAttach(Context context) {
        isAlive = true;
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        isAlive = false;
        for (WeakReference<Dialog> weakReference : dialogManager) {
            if (weakReference.get() != null) {
                weakReference.get().dismiss();
            }
        }
        dialogManager.clear();
        super.onDetach();
    }

    @Override
    public Dialog createDialog(@StyleRes int themeResId) {
        Dialog dialog = new Dialog(getBaseActivity(), themeResId);
        dialogManager.add(new WeakReference<>(dialog));
        return dialog;
    }

    @Override
    public void showError(String message) {
        getBaseActivity().showError(message);
    }

    public void showError(String errStr, ETongDaiDialog.EtdSingleListener listeners) {
        getBaseActivity().showError(errStr, listeners);
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) super.getActivity();
    }

    public boolean isAlive() {
        return isAlive;
    }

}
