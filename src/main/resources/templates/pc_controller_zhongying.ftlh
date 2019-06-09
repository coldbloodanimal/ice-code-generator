package org.tycloud.api.weimall.controller.base;

import com.penglai.project.auth.annotations.ResourceAuthorization;
import com.penglai.project.order.entity.${module_name_entity};
import com.penglai.project.order.model.${module_name_model};
import com.penglai.project.order.service.I${module_name}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.e.pernsion.erp.annotation.LogKind;
import com.e.pernsion.erp.dao.model.${module_name};
import com.e.pernsion.erp.service.${module_name}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/refund/refund")
@Api(description = ${module_description})
public class ${module_name}Resource{

    @Autowired
    I${module_name}Service ${module_name?uncap_first}Service;

    @ApiOperation(value = "添加${module_shortcut}")
	@RequestMapping(value ="add", method = RequestMethod.POST)
    public int insert(@RequestBody ${module_name_model} model) {
        ${module_name_entity} record=new ${module_name_entity}();
        BeanUtils.copyProperties(model,record);
        return ${module_name?uncap_first}Service.insert(record);
    }

    @ApiOperation(value = "删除${module_shortcut}")
    @ResourceAuthorization(needLogin = true)
	@RequestMapping(value ="delete", method = RequestMethod.POST)
    public int delete(@RequestBody ${module_name_model} model) {
        ${module_name_entity} record=new ${module_name_entity}();
        BeanUtils.copyProperties(model,record);
        return ${module_name?uncap_first}Service.delete(record);
    }

    @ApiOperation(value = "修改${module_shortcut}")
    @ResourceAuthorization(needLogin = true)
    @RequestMapping(value ="update", method = RequestMethod.POST)
    public int update(@RequestBody ${module_name_model} model) {
        ${module_name_entity} record=new ${module_name_entity}();
        BeanUtils.copyProperties(model,record);
        return ${module_name?uncap_first}Service.update(record);
    }

    @ApiOperation(value = "根据条件查询${module_shortcut}")
    @ResourceAuthorization(needLogin = true)
    @RequestMapping(value ="update", method = RequestMethod.POST)
    public List<${module_name}> listByCondition(@RequestBody ${module_name_model} model) {
       // return ${module_name?uncap_first}Service.selectByCondition(record);
    }
}
