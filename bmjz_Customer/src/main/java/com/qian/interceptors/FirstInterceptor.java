package com.qian.interceptors;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.qian.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.List;

// springmvc 普通组件
@Component
public class FirstInterceptor implements HandlerInterceptor {
    /**
     * 注意： 如果拦截器中出现异常，而又未处理，则这个系统都会无法正常显示，页面错乱，所有请求都 错误2022.02.13
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         // 在调用springmvc管控下的Controller之前调用此方法，根据返回bool值，来决定是否让其访问controller
//        Cookie[] cookie = request.getCookies();
//        String userDataString = null;
//        for(Cookie c : cookie){
//            // 之前用的是utf-8编码，解码也使用utf-8编码
//            String tempName = URLDecoder.decode(c.getName(),"utf-8");
//            String tempValue= URLDecoder.decode(c.getValue(),"utf-8");
//            System.out.println(tempName);
//            System.out.println(tempValue);
//            if(tempName.equals("userDataJson")){ // 注意==和equals的使用区别
//                System.out.println("equals successful");
//                userDataString=tempValue;
//            }
//        }
//        Gson gson = new Gson();
//        System.out.println(userDataString);
//        User user = gson.fromJson(userDataString, User.class);// transform successful
//        System.out.println("user:"+user);

        System.out.println("\n\n\nFirst拦截器拦截了");
        /**
         * 通过cookie中的用户名和密码比对，来决定是否返回true，拦截器的作用。后期实现，02.11
         */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
