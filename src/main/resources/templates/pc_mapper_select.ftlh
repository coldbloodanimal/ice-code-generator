package com.penglai.project.order.service.impl;

import com.penglai.project.order.service.I${module_name}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ${module_name}ServiceImpl implements I${module_name}Service{

    @Autowired(required = false)
    ${module_name}Mapper ${module_name?uncap_first}Mapper;

    @Override
    public ${module_name_entity} insert(${module_name_entity} record) {
        ${module_name?uncap_first}Mapper.insert(record);
        return record;
    }

    @Override
    public int delete(Long id) {
    	return ${module_name?uncap_first}Mapper.deleteByPrimaryKey(record);
    }

    @Override
    public ${module_name_entity} update(${module_name_entity} record) {
        ${module_name?uncap_first}Mapper.updateByPrimaryKeySelective(record);
        return record;
    }

/**    @Override
    public List<${module_name}> selectByCondition(${module_name} record) {
        return ${module_name?uncap_first}Mapper.selectAll();
    }*/
}
