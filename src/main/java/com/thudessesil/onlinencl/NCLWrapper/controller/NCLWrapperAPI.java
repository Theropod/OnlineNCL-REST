package com.thudessesil.onlinencl.NCLWrapper.controller;

import com.thudessesil.onlinencl.NCLWrapper.model.RunResult;
import com.thudessesil.onlinencl.NCLWrapper.model.RunScriptForm;
import com.thudessesil.onlinencl.NCLWrapper.service.NCLWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
public class NCLWrapperAPI {

    @Value("${onlinencl.workingDir}")
    private String workingDir;

    @CrossOrigin
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
