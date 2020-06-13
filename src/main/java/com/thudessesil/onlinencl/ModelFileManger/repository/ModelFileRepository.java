package com.thudessesil.onlinencl.ModelFileManger.repository;

import java.util.List;
import com.thudessesil.onlinencl.ModelFileManger.model.ModelFile;

import org.springframework.data.repository.CrudRepository;

public interface ModelFileRepository extends CrudRepository<ModelFile, Long>, ModelFileFilter {
    List<ModelFile> findByModelAndStartTimeAndVariableName(String model, String startTime, String variableName);
}