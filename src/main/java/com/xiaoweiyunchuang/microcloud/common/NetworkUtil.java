package com.xiaoweiyunchuang.microcloud.common;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/17.
 */
public class NetworkUtil {

    /**
     * 获取访问用户的客户端IP（适用于公网与局域网）.
     */
    public static final String getIpAddr(final HttpServletRequest request) throws Exception {

        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }
        return ipString;
    }
}
