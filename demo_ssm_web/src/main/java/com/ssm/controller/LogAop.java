package com.ssm.controller;

import com.ssm.domain.SysLog;
import com.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 实现aop的日志控制
 */
@Component
@Aspect
public class LogAop {
//    @Autowired
//    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;
    private Date startTime; // 开始时间
    private Class clazz; // 访问的类
    private Method method; // 访问的方法

    // 前置通知
    // 主要是获取开始时间，执行了哪一个类，哪一个方法
    @Before("execution(* com.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        // 获取当前的执行时间
        startTime = new Date();
        // 获取当前执行的类
        clazz = joinPoint.getTarget().getClass();
        // 获取访问方法的名称
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        // 获得执行方法的method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName); // 只能获取不带参数的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classArgs);
        }


    }

    // 后置通知
    @After("execution(* com.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        String url = "";
        // 获取访问时长
        long time = new Date().getTime() - startTime.getTime(); // 开始时间-当前结束时间
        // 获取url
        RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
        if (classAnnotation != null) {
            String[] classValue = classAnnotation.value();
            // 获取执行方法上的@RequestMapping
            RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
            String[] methodValue = methodAnnotation.value();
            // 得到访问者url
            url = classValue[0] + methodValue[0];
            // 获取访问ip
            String ip = "127.0.0.1";
            // 获取当前操作的用户
            SecurityContext context = SecurityContextHolder.getContext(); // 从上下文中获取当前登录的用户
            User user = (User) context.getAuthentication();
            String username = user.getUsername(); // 获取用户名
            // 将信息封装到syslog类中
            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time); // 执行时长
            sysLog.setIp(ip); // 访问ip
            sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
            sysLog.setUrl(url);
            sysLog.setUsername(username);
            sysLog.setVisitTime(startTime);
            // 将数据存入数据库中
            sysLogService.save(sysLog);
        }
    }
}
