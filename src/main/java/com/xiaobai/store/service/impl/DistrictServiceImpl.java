package com.xiaobai.store.service.impl;

import com.xiaobai.store.entity.District;
import com.xiaobai.store.mapper.DistrictMapper;
import com.xiaobai.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 省市区的业务层实现类
 * @author xiaobaicai
 * data:2021-12-31
 */

@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> districtList = districtMapper.findByParent(parent);
        return districtList;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
