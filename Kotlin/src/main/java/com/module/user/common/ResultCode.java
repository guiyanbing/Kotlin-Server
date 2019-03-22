package com.module.user.common;

public abstract interface ResultCode
{
  public static final int SUCCESS = 0;
  public static final int ERROR = -1;
  public static final int ERROR_REQ = 100;
  public static final int ERROR_KEY = 101;
  public static final int ERROR_SIGN = 102;
  public static final int ERROR_PARAM = 103;
  public static final int ERROR_SERVER = 200;
  public static final int ERROR_UNUSED = 201;
  public static final int ERROR_REBOOT = 202;
  public static final int BUSINESS_FAILED = 300;
  public static final int REQUET_PARAMS_ERROR = 400;
}