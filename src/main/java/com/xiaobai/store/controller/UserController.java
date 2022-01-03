package com.xiaobai.store.controller;

import com.xiaobai.store.controller.ex.*;
import com.xiaobai.store.entity.User;
import com.xiaobai.store.service.IUserService;
import com.xiaobai.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 用户注册控制层@RestController == @Controller + @ResponseBody
 * @author PC
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

     /**
     * //@ResponseBody 表示此方法响应结果以json格式进行响应
     * 1.接收数据方式：请求处理方法的参数列表设置为pojo类来接收前端的数据
     *  SpringBoot会将前端的url地址中的参数名和pojo类的属性名进行比较，如果这两个名相同会将值注入到pojo类中
     * @param user
     * @return
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    /**
     * 2.接收数据方式：请求处理方法的参数列表设置为非pojo类型
     * SpringBoot会将请求的参数名和方法的参数名直接进行比较，如果名称相同，完成依赖注入
     * 并将数据保存到HttpSession全局作用域中
     * @param username 前端传过来的用户名
     * @param password 前端传过来的密码
     * @return
     */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User user = userService.login(username,password);
        //向session对象中绑定数据
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        //获取session对象中的数据
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));
        return new JsonResult<User>(OK,user);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> change(String oldPassword, String newPassword, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }
    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        User user = userService.getByUid(uid);
        return new JsonResult<>(OK,user);
    }
    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        //user对象有四部分数据：username , phone, email, gender
        userService.changeInfo(uid, username, user);
        return new JsonResult<>(OK);
    }

    /**
     * 设置上传文件的最大字节
     */
    public static final Integer AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    /**
     * 设置上传类型限制
     */
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    /**
     * MultipartFile是springMVC提供的一个接口，这个接口包装了获取文件类型的数据
     * 接收只需要在处理请求的方法参数列表上声明一个MultipartFile参数即可 @RequestParam("file")是
     * 为了解决页面的 请求参数注入到请求处理方法中的某个参数上，用来强行标记和映射 类似Mapper接口中的@Param
     * @param session httpSession
     * @param file 用户上传的文件
     * @return 返回执行这个文件的地址
     */
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session,
                                           @RequestParam("file") MultipartFile file){
        //判断文件是否为空
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        //判断文件是否为我们限制的类型
        if (!AVATAR_TYPE.contains(file.getContentType())){
            throw new FileTypeException("文件只能是jpeg,png,bmp,gif的一种");
        }
        //判断文件大小
        if (file.getSize() > AVATAR_MAX_SIZE){
            throw new FileSizeException("文件大小超出上限");
        }
        //上传的文件目录结构 ../upload/文件.png
        String parent = session.getServletContext().getRealPath("upload");
        //让File对象指向这个路径,File是否存在
        File dir = new File(parent);
        if (!dir.exists()){
            dir.mkdirs();//创建目录
        }
        //获取到这个文件的名称,使用UUID生成一个随机的新字符串作为文件名  UUID.randomUUID()
        String originalFilename = file.getOriginalFilename();
        Integer index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;

        //此时是一个空文件
        File dest = new File(dir, filename);
        //将file中的数据写入到dest中
        try {
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常!");
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常!");
        }
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = "/upload/" + filename;
        userService.changeAvatar(uid, avatar, username);

        //返回头像的相对路径
        return new JsonResult<String>(OK,avatar);
    }
}
