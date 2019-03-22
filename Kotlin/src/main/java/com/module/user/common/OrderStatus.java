package com.module.user.common;

public abstract interface OrderStatus
{
  public static final int ORDER_NEW = -1;
  public static final int ORDER_ALL = 0;
  public static final int ORDER_WAIT_PAY = 1;
  public static final int ORDER_WAIT_CONFIRM = 2;
  public static final int ORDER_COMPLETED = 3;
  public static final int ORDER_CANCELED = 4;
}
