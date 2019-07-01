package com.penglai.project.order.service;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface I${module_name}Service{

    ${module_name_entity} insert(${module_name_entity} record);

    int delete(Long id);

    ${module_name_entity} update(${module_name_entity} record);
    
/*    @ApiOperation(value = "根据条件查询${module_shortcut}")
    public List<${module_name}> selectByCondition(${module_name} record);*/
}