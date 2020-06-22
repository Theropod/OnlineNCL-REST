package com.thudessesil.onlinencl.ModelFileManager.controller;

import com.thudessesil.onlinencl.ModelFileManager.service.ModelFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * FrontEnd Controller
 * </p>
 *
 * @author Theropod
 * @since 2020-06-14
 */
@RestController
@Api(tags = "Model File Manager")
@RequestMapping("/online-ncl/model-file-manager")
public class ModelFileController {

    @Autowired
    private ModelFileService modelFileService;

    @CrossOrigin
    @ApiOperation(value = "find model file information", notes = "find record by model and string and variable name")
    @GetMapping("/findModelFile")
    public Map findModelFile(
            @RequestParam(value = "model", defaultValue = "S2S_T226") String model,
            @RequestParam(value = "startTime", defaultValue = "20200406") String startTime,
            @RequestParam(value = "variableName", defaultValue = "PRECT") String variableName
    ) {
        Map response = new HashMap<>();
        try {
            Collection modelFileList = modelFileService.findByColumnValues(model, startTime, variableName);
            response.put("status", "success");
            response.put("result", modelFileList);
            return response;
        } catch (Exception e) {
            response.put("status", "failed");
            response.put("result", e);
            return response;
        }
    }

    @CrossOrigin
    @ApiOperation(value = "model file filters", notes = "find distinct values of model, startTime and variableName as filters")
    @GetMapping("/findModelFileFilter")
    public Map findModelFileFilter(
            @RequestParam(value = "columnName", defaultValue = "model") String columnName,
            @RequestParam(value = "model", defaultValue = "") String model,
            @RequestParam(value = "startTime", defaultValue = "") String startTime,
            @RequestParam(value = "variableName", defaultValue = "") String variableName
    ) {
        Map response = new HashMap<>();
        try {
            List modelFileFilterList = modelFileService.findDistinctByColumnValues(columnName, model, startTime, variableName);
            response.put("status", "success");
            response.put("result", modelFileFilterList);
            return response;
        } catch (Exception e) {
            response.put("status", "failed");
            response.put("result", e);
            return response;
        }
    }
}

