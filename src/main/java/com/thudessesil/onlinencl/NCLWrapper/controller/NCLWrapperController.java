package com.thudessesil.onlinencl.NCLWrapper.controller;

import com.thudessesil.onlinencl.NCLWrapper.entity.RunResult;
import com.thudessesil.onlinencl.NCLWrapper.entity.RunScriptForm;
import com.thudessesil.onlinencl.NCLWrapper.service.NCLWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@Api(tags = "NCL Wrapper")
@RequestMapping("/ncl-wrapper")
public class NCLWrapperController {

    // NCL执行路径
    @Value("${onlinencl.workingDir}")
    private String workingDir;

    @CrossOrigin
    @ApiOperation(value = "run NCL script", notes = "base on submitted script form")
    @PostMapping("/run")
    public RunResult run(@RequestBody RunScriptForm newScriptForm) {
        String filename = newScriptForm.getFilename();
        String scriptpath = newScriptForm.getScriptpath();
        ArrayList parameters = newScriptForm.getParameters();
        String outputfilename = newScriptForm.getOutputfilename();

        try {
            NCLWrapper nclwrapper = new NCLWrapper(filename, scriptpath, parameters, outputfilename, workingDir);
            return new RunResult(nclwrapper.runCommand());
        } catch (
                Exception e) {
            e.printStackTrace();
            return new RunResult();
        }
    }

    @CrossOrigin
    @ApiOperation(value = "get result image", notes = "based on image filename")
    @GetMapping("/getImage")
    public ResponseEntity<byte[]> getImage(
            @RequestParam(value = "filename",defaultValue = "daily_bcccsm_2020040600_T_mean_line_plot_All.png")
                    String filename) throws IOException {
        String filepath= workingDir + filename;
        byte[] image = Files.readAllBytes(Paths.get(filepath));
        System.out.println("get NCL outputfile: "+ filepath);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
    }
}
