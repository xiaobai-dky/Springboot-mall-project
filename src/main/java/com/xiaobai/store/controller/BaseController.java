package com.xiaobai.store.controller;

import com.xiaobai.store.controller.ex.*;
import com.xiaobai.store.service.ex.*;
import com.xiaobai.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制层的基类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class BaseController {
    /** 表示操作成功的状态码 */
    public static final int OK = 200;

    /** 用于统一处理抛出的异常，请求处理的方法，这个返回值就是传给前端的东西
     *  自动将异常对象传给此方法的参数列表上
     *  当项目中产生了异常，被统一拦截到此方法中，这个方法充当请求处理方法，返回值传给前端
     * */
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDepulitedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        } else if (e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMessage("用户数据不存在");
        } else if (e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("用户名的密码错误");
        } else if (e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage("用户的收获地址超出上限");
        } else if (e instanceof AddressNotFoundException){
            result.setState(4004);
            result.setMessage("用户收货地址不存在");
        } else if (e instanceof AccessDeniedException){
            result.setState(4005);
            result.setMessage("数据非法访问异常");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("商品信息不存在");
        } else if (e instanceof CartNotFoundException) {
            result.setState(4007);
            result.setMessage("购物车信息不存在");
        } else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        } else if (e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新信息时产生未知异常");
        } else if (e instanceof DeleteException){
            result.setState(5002);
            result.setMessage("删除信息时产生未知异常");
        } else if (e instanceof FileEmptyException){
            result.setState(6000);
            result.setMessage("文件为空,无法上传异常");
        } else if (e instanceof FileSizeException){
            result.setState(6001);
            result.setMessage("文件大小超出最大上传限制");
        } else if (e instanceof FileStateException){
            result.setState(6002);
            result.setMessage("文件状态异常");
        } else if (e instanceof FileUploadIOException){
            result.setState(6003);
            result.setMessage("文件上传IO异常");
        } else if (e instanceof FileTypeException){
            result.setState(6004);
            result.setMessage("文件类型异常");
        }

        return result;
    }

    /**
     * 获取session对象中uid的值
     * @param session HttpSession对象
     * @return  当前用户登录uid的值
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.parseInt(session.getAttribute("uid").toString());
    }

    /**
     * 获取session对象中username的值
     * @param session HttpSession对象
     * @return 当前用户登录username的值
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
