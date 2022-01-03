package com.xiaobai.store.service.impl;

import com.xiaobai.store.entity.Address;
import com.xiaobai.store.mapper.AddressMapper;
import com.xiaobai.store.service.IAddressService;
import com.xiaobai.store.service.IDistrictService;
import com.xiaobai.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 地址业务实现类
 * @author xiaobaicai
 * data:2021-12-31
 */

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IDistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;
    /**
     * 插入新的address
     * @param uid      用户的uid
     * @param username 用户名
     * @param address  用户的表单提交的address对象
     */
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //调用收货地址统计的数据
        Integer count = addressMapper.countByUid(uid);
        if (count >= maxCount) {
            throw new AddressCountLimitException("收获地址数量超出限制");
        }

        //address的数据进行补全：省市区
        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String areaName = districtService.getNameByCode(address.getAreaCode());

        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        Integer isDefault = count == 0 ? 1 : 0;
        //uid、isDefault
        address.setUid(uid);
        address.setIsDefault(isDefault);
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());

        //插入收货地址
        Integer rows = addressMapper.insert(address);
        if (rows != 1){
            throw new InsertException("插入用户的收获地址产生未知的异常!");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> addressList = addressMapper.findByUid(uid);
        for (Address address : addressList){
            //address.setAid(null);
            //address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return addressList;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        Address address = addressMapper.findByAid(aid);
        if (address == null){
            throw new AddressNotFoundException("用户地址不存在!");
        }
        //检测获取到的收货地址的数据的归属
        if (!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问");
        }

        Integer rows = addressMapper.updateNoDefault(uid);
        if (rows < 1){
            throw new UpdateException("更新数据时产生未知异常!");
        }
        rows = addressMapper.updateDefault(aid,username,new Date());
        if (rows != 1){
            throw new UpdateException("更新数据时产生未知异常!");
        }
    }

    @Override
    public void delete(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result == null){
            throw new AddressNotFoundException("收货地址数据不存在!");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer row =  addressMapper.deleteByAid(aid);
        if (row != 1){
            throw new DeleteException("删除地址时产生未知的异常");
        }
        Integer count = addressMapper.countByUid(uid);
        if (count == 0){
            return;
        }
        if (result.getIsDefault() == 0){
            return;
        }
        Address address = addressMapper.findLastModified(uid);
        Integer rows = addressMapper.updateDefault(address.getAid(),username,new Date());
        if (rows != 1){
            throw new UpdateException("更新数据产生了未知的异常");
        }

    }

    @Override
    public Address getByAid(Integer aid ,Integer uid) {
        Address result = addressMapper.findByAid(aid);
        if (result == null){
            throw new AddressNotFoundException("收货地址数据不存在!");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        result.setProvinceCode(null);
        result.setCityCode(null);
        result.setAreaCode(null);
        result.setModifiedUser(null);
        result.setModifiedTime(null);
        result.setCreatedUser(null);
        result.setCreatedTime(null);
        return result;
    }
}
