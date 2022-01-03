package com.xiaobai.store.mapper;

import com.xiaobai.store.entity.District;
import java.util.List;

/**
 * 省市信息的接口
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface DistrictMapper {

    /**
     * 根据省代号查市区域分布
     * @param parent 父代号
     * @return 某个父区域下的所有市区
     */
    List<District> findByParent(String parent);

    /**
     * 根据code查出所对应的name
     * @param code 省市区的code
     * @return 省市区名
     */
    String findNameByCode(String code);
}
