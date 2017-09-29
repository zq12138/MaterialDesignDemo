package com.example.admin.materialdesigndemo.retrofit.callback;

import android.app.Dialog;
import android.widget.Toast;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.dialog.ETongDaiDialog;
import com.example.admin.materialdesigndemo.retrofit.RequestCommand;
import com.example.admin.materialdesigndemo.retrofit.api.IBaseBean;
import com.example.admin.materialdesigndemo.retrofit.api.IBaseDialogView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by zq on 2017/9/28.
 */

public abstract class DialogCallback<E extends IBaseBean, T extends IBaseDialogView> extends RequestCallBack<E> {

    WeakReference<T> attachTargetWeakReference;
    Dialog dialog;

    public DialogCallback(T requestView) {
        attachTargetWeakReference = new WeakReference<>(requestView);
    }

    protected T getAttachTarget() {
        return attachTargetWeakReference.get();
    }

    public boolean isAttached() {
        return getAttachTarget() != null && getAttachTarget().isAlive();
    }

    @Override
    public void onResponse(Call<E> call, Response<E> response) {
        if (!isAttached()) return;
        dismissDialog();
        super.onResponse(call, response);
    }

    @Override
    public void onFailure(Call<E> call, Throwable t) {
        if (!isAttached()) return;
        dismissDialog();
        super.onFailure(call, t);
    }

    @Override
    public void onResponse(E e, Call<E> call) {
        super.onResponse(e, call);
    }

    @Override
    protected void onResponseFailureMessage(E e, Call<E> call) {
        getAttachTarget().showError(e.getInfo());
    }

    @Override
    protected void onResponseFailureForceSignOut(E e, Call<E> call) {
        if (getSessionDialogs().size() != 0) return;
        sessionInvalid(e.getInfo());
    }

    protected void sessionInvalid(String message) {
//        YiTongDaiApplication application = YiTongDaiApplication.sApplication;
//        AppSessionEngine.logout();
//        GesturePasswordUtils.clear(application);
//        ETongDaiDialog dialog = new ETongDaiDialog(getAttachTarget().getBaseActivity());
//        dialog.buildSingle(message, "提示", "返回首页", new ETongDaiDialog.EtdSingleListener() {
//            @Override
//            public void OnLeftButtonClicked(ETongDaiDialog dialog) {
//                HomeActivity.startActivity(getAttachTarget().getBaseActivity(), R.id.tab_home, null);
//                dialog.dismiss();
//                getSessionDialogs().remove(dialog);
//            }
//        });
//        dialog.show();
//        getSessionDialogs().add(dialog);
    }

    @Override
    public void onFailure(final Call<E> call) {

        ETongDaiDialog dialog = new ETongDaiDialog(getAttachTarget().getBaseActivity())
                .buildDouble(getAttachTarget().getBaseActivity().getString(R.string.the_network_is_dead), "稍后再试", "重新加载", new ETongDaiDialog.EtdDoubleListener() {
                    @Override
                    public void OnLeftButtonClicked(ETongDaiDialog dialog) {
                        dialog.dismiss();
                    }

                    @Override
                    public void OnRightButtonClicked(ETongDaiDialog dialog) {
                        dialog.dismiss();
                        onReCall(call);
                    }
                });
        dialog.setCancelable(true);
        dialog.show();
    }

    @Override
    protected void onResponseFailureFrozen(E e, Call<E> call) {
        if (getSessionDialogs().size() != 0) return;
        Toast.makeText(getAttachTarget().getBaseActivity(), "重新登录", Toast.LENGTH_LONG).show();
//        YiTongDaiApplication application = YiTongDaiApplication.sApplication;
//        AppSessionEngine.logout();
//        GesturePasswordUtils.clear(application);
//        Dialog dialog = new ETongDaiDialog(getAttachTarget().getBaseActivity())
//                .buildSingle(e.getInfo(), "提示", "重新登录", new ETongDaiDialog.EtdSingleListener() {
//                    @Override
//                    public void OnLeftButtonClicked(ETongDaiDialog dialog) {
//                        HomeActivity.startActivity(getAttachTarget().getBaseActivity(), R.id.tab_home, LoginActivity.class);
//                        dialog.dismiss();
//                        getSessionDialogs().remove(dialog);
//                    }
//                })
//                .setCancelableChain(false)
//                .showChain();
//        getSessionDialogs().add(dialog);
    }

    public void onReCall(Call<E> call) {
        if (call != null) {
            RequestCommand.onCall(DialogCallback.this, call.clone());
        }
    }

    public void onPreRequest(Call call) {
        if (!isAttached()) return;
        if (isShowDialog()) {
            dialog = getAttachTarget().createDialog(R.style.customDialogTheme);
            dialog.setContentView(R.layout.wait_progress_dialog);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }
    }
    protected boolean isShowDialog() {
        return true;
    }

    public static List<Dialog> dialogs;//用来记录  异地登录，session失效，账户冻结等dialog，防止多次弹出此dialog，因为如果同时发出两个请求就有可能弹出两个这种dialog

    public static List<Dialog> getSessionDialogs() {
        if (dialogs == null) {
            dialogs = new ArrayList<>();
        }
        return dialogs;
    }

    private void dismissDialog() {
        if (dialog == null) return;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
