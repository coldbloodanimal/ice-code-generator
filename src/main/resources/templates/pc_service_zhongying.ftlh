package com.penglai.project.order.service;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface I${module_name}Service{

    int insert(${module_name_entity} record);

    int delete(${module_name_entity} record);

    int update(${module_name_entity} record);
    
/*    @ApiOperation(value = "根据条件查询${module_shortcut}")
    public List<${module_name}> selectByCondition(${module_name} record);*/
}
