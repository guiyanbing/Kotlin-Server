package com.module.user.utils.pay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class OrderInfoUtil2_0 {
    public static Map<String, String> buildAuthInfoMap(String pid, String app_id, String target_id, boolean rsa2) {
        Map keyValues = new HashMap();

        keyValues.put("app_id", app_id);

        keyValues.put("pid", pid);

        keyValues.put("apiname", "com.alipay.account.auth");

        keyValues.put("app_name", "mc");

        keyValues.put("biz_type", "openservice");
 
        keyValues.put("product_id", "APP_FAST_LOGIN");
 
        keyValues.put("scope", "kuaijie");
 
        keyValues.put("target_id", target_id);
 
        keyValues.put("auth_type", "AUTHACCOUNT");
 
        keyValues.put("sign_type", rsa2 ? "RSA2" : "RSA");
 
        return keyValues;
    }

    public static Map<String, String> buildOrderParamMap(String app_id, boolean rsa2, String totalPrice, String orderId) {
        Map keyValues = new HashMap();
 
        keyValues.put("app_id", app_id);
 
        keyValues.put("biz_content", "{\"timeout_express\":\"30m\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"total_amount\":\"" + totalPrice + "\",\"subject\":\"1\",\"body\":\"我是测试数据\",\"out_trade_no\":\"" + orderId + "\"}");
 
        keyValues.put("charset", "utf-8");
 
        keyValues.put("method", "alipay.trade.app.pay");
 
        keyValues.put("sign_type", rsa2 ? "RSA2" : "RSA");
 
        keyValues.put("timestamp", "2016-07-29 16:55:53");
 
        keyValues.put("version", "1.0");
 
        return keyValues;
    }

    public static String buildOrderParam(Map<String, String> map) {
        List keys = new ArrayList(map.keySet());
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = (String) keys.get(i);
            String value = (String) map.get(key);
            sb.append(buildKeyValue(key, value, true));
            sb.append("&");
        }
 
        String tailKey = (String) keys.get(keys.size() - 1);
        String tailValue = (String) map.get(tailKey);
        sb.append(buildKeyValue(tailKey, tailValue, true));
 
        return sb.toString();
    }

    private static String buildKeyValue(String key, String value, boolean isEncode) {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("=");
        if (isEncode)
            try {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                sb.append(value);
            }
        else {
            sb.append(value);
        }
        return sb.toString();
    }

    public static String getSign(Map<String, String> map, String rsaKey, boolean rsa2) {
        List keys = new ArrayList(map.keySet());
 
        Collections.sort(keys);
 
        StringBuilder authInfo = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = (String) keys.get(i);
            String value = (String) map.get(key);
            authInfo.append(buildKeyValue(key, value, false));
            authInfo.append("&");
        }
 
        String tailKey = (String) keys.get(keys.size() - 1);
        String tailValue = (String) map.get(tailKey);
        authInfo.append(buildKeyValue(tailKey, tailValue, false));
 
        String oriSign = SignUtils.sign(authInfo.toString(), rsaKey, rsa2);
        String encodedSign = "";
        try {
            encodedSign = URLEncoder.encode(oriSign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "sign=" + encodedSign;
    }

    private static String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);
 
        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }
}
