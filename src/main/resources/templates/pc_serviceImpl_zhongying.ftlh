package com.penglai.project.order.service.impl;

import com.penglai.project.order.service.I${module_name}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ${module_name}ServiceImpl implements I${module_name}Service{

    @Autowired
    ${module_name}Mapper ${module_name?uncap_first}Mapper;

    @Override
    public int insert(${module_name_entity} record) {
        return ${module_name?uncap_first}Mapper.insert(record);
    }

    @Override
    public int delete(${module_name_entity} record) {
    	return ${module_name?uncap_first}Mapper.delete(record);
    }

    @Override
    public int update(${module_name_entity} record) {
        return ${module_name?uncap_first}Mapper.updateByPrimaryKeySelective(record);
    }

/**    @Override
    public List<${module_name}> selectByCondition(${module_name} record) {
        return ${module_name?uncap_first}Mapper.selectAll();
    }*/
}
