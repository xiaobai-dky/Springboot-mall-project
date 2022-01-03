package com.xiaobai.store.service;

import com.xiaobai.store.entity.District;

import java.util.List;

/**
 * 获取省市区的业务层
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface IDistrictService {
    /**
     * 根据父代号查询区域信息
     * @param parent 父代号
     * @return 区域信息
     */
    List<District> getByParent(String parent);

    /**
     * 根据code查询他的名字
     * @param code 省市区的code
     * @return 省市区的名字
     */
    String getNameByCode(String code);
}
