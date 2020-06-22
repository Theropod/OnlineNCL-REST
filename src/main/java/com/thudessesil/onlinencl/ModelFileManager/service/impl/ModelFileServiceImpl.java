package com.thudessesil.onlinencl.ModelFileManager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.thudessesil.onlinencl.ModelFileManager.entity.ModelFile;
import com.thudessesil.onlinencl.ModelFileManager.mapper.ModelFileMapper;
import com.thudessesil.onlinencl.ModelFileManager.service.ModelFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  Realization class of service
 * </p>
 *
 * @author Theropod
 * @since 2020-06-14
 */
@Service
public class ModelFileServiceImpl extends ServiceImpl<ModelFileMapper, ModelFile> implements ModelFileService {
    @Autowired
    private ModelFileService modelFileService;

    // find record by model and string and variable name
    public Collection findByColumnValues(String model, String startTime, String variableName){
        Map<String, Object> columnMap = new HashMap<>();
        // use column name in DB！
        columnMap.put("model", model);
        columnMap.put("start_time", startTime);
        columnMap.put("variable_name", variableName);
        // select * from model_file where entity= and start_time= and variable_name =
        return modelFileService.listByMap(columnMap);
    }

    // find distinct values of model, startTime and variableName as filters
    public List findDistinctByColumnValues(String columnName, String model, String startTime, String variableName){
        QueryWrapper<ModelFile> queryWrapper = new QueryWrapper<>();
        // distinct values of selected column:
        queryWrapper
                .select("distinct " + columnName)
                .like(StringUtils.isNotBlank(model),"model", model)
                .like(StringUtils.isNotBlank(startTime),"start_time", startTime)
                .like(StringUtils.isNotBlank(variableName),"variable_name", variableName);

        return modelFileService.listObjs(queryWrapper);
    }

}
