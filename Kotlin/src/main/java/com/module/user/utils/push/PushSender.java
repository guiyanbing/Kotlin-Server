package com.module.user.utils.push;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushSender {
    private static final String MASTER_SECRET = "a2c145c82f74c72534d205a4";
    private static final String APP_KEY = "7f3d74ec9161e033d723f585";
    private static JPushClient jpushClient = new JPushClient("a2c145c82f74c72534d205a4", "7f3d74ec9161e033d723f585", null, ClientConfig.getInstance());

    public static void sendLoginEvent(String pushId) {
        try {
            PushResult localPushResult = jpushClient.sendPush(buildLoginObject(pushId));
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static PushPayload buildLoginObject(String pushId) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.registrationId(new String[]{pushId}))
                .setMessage(Message.newBuilder()
                        .setMsgContent("登录")
                        .addExtra("code",
                                Integer.valueOf(1))
                        .build())
                .build();
    }

    public static void sendOrderEvent(String pushId, String orderId) {
        try {
            PushResult localPushResult = jpushClient.sendPush(buildOrderObject(pushId, orderId));
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static PushPayload buildOrderObject(String pushId, String orderId) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.registrationId(new String[]{pushId}))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(
                                ((AndroidNotification.Builder) AndroidNotification.newBuilder()
                                        .setAlert("订单")
                                        .addExtra("orderId", orderId))
                                        .build())
                        .build())
                .build();
    }
}
