package com.lihao.aop;

import com.lihao.entity.SysUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lihao on 2017/3/22.
 */
@Aspect
@Component
public class LoginCut {

    @Pointcut("execution(* com.lihao.service.*.*(..))")
    void anyMethod() {
    }

    @Before("anyMethod()")//声明前置通知
    public void doBefore() {
        System.out.println("前置通知");
    }

    @AfterReturning(pointcut = "anyMethod()", returning = "userList")//声明后置通知
    public void doAfterReturning(List<SysUser> userList) {
        System.out.println("后置通知");
        for (SysUser user : userList) {
            System.out.println(user.toString());
        }

    }

    @AfterThrowing(pointcut = "anyMethod()", throwing = "e")//声明例外通知
    public void doAfterThrowing(Exception e) {
        System.out.println("例外通知");
        System.out.println(e.getMessage());
    }

    @After("anyMethod()")//声明最终通知
    public void doAfter() {
        System.out.println("最终通知");
    }

    @Around("anyMethod()")//声明环绕通知
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知");
        //显示调用，确保被代理的方法被调用
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知");
        return o;
    }
}
