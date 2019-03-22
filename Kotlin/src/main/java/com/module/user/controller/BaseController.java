package com.module.user.controller;

import com.alibaba.fastjson.JSON;
import com.module.user.domain.BaseResp;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
    protected static final String DEFAULT_CHARTSET = "UTF-8";
    protected static final String DEFAULT_JSON_CONTENT_TYPE = "application/json;charset=UTF-8";
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    protected void sendError(int code, String message) {
        try {
            BaseResp resp = new BaseResp();
            resp.setStatus(code);
            resp.setMessage(message);
            sendJSON(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendSuccess(BaseResp resp) {
        try {
            resp.setStatus(0);
            resp.setMessage("");
            sendJSON(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendSuccess(BaseResp resp, String message) {
        try {
            resp.setStatus(0);
            resp.setMessage(message);
            sendJSON(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendJSON(Object obj) {
        this.response.setContentType("application/json;charset=UTF-8");
        try {
            this.response.getOutputStream().write(JSON.toJSONString(obj).getBytes("UTF-8"));
            this.response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}