package com.e.pernsion.erp.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e.pernsion.erp.dao.model.${module_name};
import com.e.pernsion.erp.noscan.BaseMapper;

import io.swagger.annotations.Api;

@Repository
@Api(value = "[${module_description}]-${module_name}Mapper-${module_description}数据访问层")
public interface ${module_name}Mapper extends BaseMapper<${module_name}> {

	List<${module_name}> selectByCondition(${module_name} record);

}