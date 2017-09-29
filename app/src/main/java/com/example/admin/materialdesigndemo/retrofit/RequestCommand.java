package com.example.admin.materialdesigndemo.retrofit;

import com.example.admin.materialdesigndemo.retrofit.api.ServiceApi;
import com.example.admin.materialdesigndemo.retrofit.callback.RequestCallBack;

import retrofit2.Call;

/**
 * Created by zq on 2017/9/28.
 */

public class RequestCommand {

    public static ServiceApi getApi() {
        return ServiceCreate.getServiceApi();
    }

    public static void login(RequestCallBack callBack) {
        Call call = getApi().login();
        send(callBack, call);
    }

    private static void send(RequestCallBack callBack, Call call) {
        callBack.onPreRequest(call);
        call.enqueue(callBack);
    }


    public static void onCall(RequestCallBack callBack, Call call) {
        send(callBack, call);
    }


}
