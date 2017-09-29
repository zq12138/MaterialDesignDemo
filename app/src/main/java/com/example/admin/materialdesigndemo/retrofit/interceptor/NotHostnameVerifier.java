package com.example.admin.materialdesigndemo.retrofit.interceptor;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by zq on 2017/8/3.
 */

public class NotHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
