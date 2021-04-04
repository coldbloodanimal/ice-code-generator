package com.penglai.project.order.service;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface I${module_name}Service{

    ${module_name} insert(${module_name} record);

    int delete(Long id);

    ${module_name} update(${module_name} record);
    
/*    @ApiOperation(value = "根据条件查询${module_shortcut}")
    public List<${module_name}> selectByCondition(${module_name} record);*/
}