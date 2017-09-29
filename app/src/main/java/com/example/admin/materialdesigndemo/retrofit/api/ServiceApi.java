package com.example.admin.materialdesigndemo.retrofit.api;

import com.example.admin.materialdesigndemo.retrofit.bean.ImageCodeBean;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by zq on 2017/9/28.
 */

public interface ServiceApi {

    @POST("service/system/identify")
    Call<ImageCodeBean> login();

}
