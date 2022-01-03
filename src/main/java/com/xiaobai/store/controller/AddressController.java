package com.xiaobai.store.controller;

import com.xiaobai.store.entity.Address;
import com.xiaobai.store.service.IAddressService;
import com.xiaobai.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户注册控制层@RestController == @Controller + @ResponseBody
 * @author xiaobaicai
 * data:2021-12-31
 */

@RestController
@RequestMapping("address")
public class AddressController extends BaseController{
    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping({"/",""})
    public JsonResult<List<Address>> getAddressByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> addressList = addressService.getByUid(uid);
        return new JsonResult<>(OK,addressList);
    }
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(aid, uid, username);
        return new JsonResult<>(OK);
    }

    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session){
        addressService.delete(aid,getUidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
