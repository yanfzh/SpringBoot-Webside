package com.yanfzh.component;

import org.apache.tomcat.jni.Local;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @program: spring-boot-webapp
 * @description:在连接上携带区域信息，语言切换
 * @author: Yanfzh
 * @create: 2020-08-10 14:55
 **/
public class MylocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l=request.getParameter("l");
        Locale locale=Locale.getDefault();
        //Locale locale=null;
        if(!StringUtils.isEmpty(l)){
            String[] split=l.split("_");
            locale =new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
