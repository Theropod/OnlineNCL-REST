package com.thudessesil.onlinencl.ModelFileManager.service;

import com.thudessesil.onlinencl.ModelFileManager.entity.ModelFile;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  Service class
 * </p>
 *
 * @author Theropod
 * @since 2020-06-14
 */
public interface ModelFileService extends IService<ModelFile> {

    Collection findByColumnValues(String model, String startTime, String variableName);

    List findDistinctByColumnValues(String columnName, String model, String startTime, String variableName);

    String scanFiles(String path);
}
