package com.example.admin.materialdesigndemo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zq on 2017/9/19.
 */

public class DataUtil {

    public static List<String> listString;

    public static List<String> getListData() {
        if (listString == null) {
            listString = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                listString.add(i + "");
            }
        }
        return listString;
    }


}
