package com.example.demo1210.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: sunping
 * @description: 获取ip信息
 * @date: 2020/5/20
 */
@Slf4j
public class IpUtil {
    protected static final String UNKNOWN = "unknown";
    protected static final String LOCAHOST_127 = "127.0.0.1";
    protected static final String LOCAHOST_0 = "0:0:0:0:0:0:0:1";

    private IpUtil() {

    }

    /**
     * 获取客户端ip
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) throws UnknownHostException {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = getInetAddress(request);
        }
        if (!StringUtils.isBlank(ip)) {
            return ip.split(",")[0];
        }
        return ip;
    }

    private static String getInetAddress(HttpServletRequest request) throws UnknownHostException {
        String ip = request.getRemoteAddr();
        if (LOCAHOST_127.equals(ip) || LOCAHOST_0.equals(ip)) {
            //根据网卡取本机配置的IP
            InetAddress inet = InetAddress.getLocalHost();
            if (inet != null) {
                return inet.getHostAddress();
            }
        }
        return ip;
    }
}
