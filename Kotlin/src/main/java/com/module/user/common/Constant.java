package com.module.user.common;

public class Constant {
    public static final String TAOBAO_SERVER_URL = "http://gw.api.taobao.com/router/rest";
    public static final String TAOBAO_APP_KEY = "23374292";
    public static final String TAOBAO_APP_SECRET = "be5e98d53e40e90b2d41d029290816cb";
    public static final String DEFAULT_ICON = "http://osea2fxp7.bkt.clouddn.com/108x108.png";
    public static final Long TOKEN_PERIOD = Long.valueOf(604800000L);
    public static final int DEFAULT_PAGE_SIZE = 6;

    public static abstract interface BC {
        public static final String BC_TYPE = "BC";
    }

    public static abstract interface AES {
        public static final String AES_TYPE = "AES";
        public static final String AES_MODE = "AES/ECB/PKCS5Padding";
    }

    public static abstract interface ErrorMessage {
        public static final String NETWORK_ERROR = "服务器出错";
    }
}