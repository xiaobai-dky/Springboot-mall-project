package com.xiaobai.store.controller;

import com.xiaobai.store.entity.District;
import com.xiaobai.store.service.IDistrictService;
import com.xiaobai.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 省市信息的控制层
 * @author xiaobaicai
 * data:2021-12-31
 */

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK,data);
    }

}
