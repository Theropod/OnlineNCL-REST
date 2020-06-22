package com.thudessesil.onlinencl.NCLWrapper.service;

import com.thudessesil.onlinencl.NCLWrapper.entity.RunScriptParameter;
import com.thudessesil.onlinencl.NCLWrapper.utils.StreamGobbler;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NCLWrapper {
    // parts of a ncl command: filename, nclscriptname, parameters, outputFile
    private String filename;
    private String scriptFunction;
    private String outputFilename;
    private String workingDir;

    private ArrayList<RunScriptParameter> parameters;

    public NCLWrapper() {
    }

    // receiving ncl command parts from outside
    public NCLWrapper(String filename, String scriptFunction, ArrayList parameters, String outputFilename, String workingDir) {
        this.filename = filename;
        this.scriptFunction = scriptFunction;
        this.parameters = parameters;
        this.workingDir = workingDir;
        this.outputFilename = outputFilename;
    }

    private String buildCommand() {
        String command = "";
        // stringify all parameters
        for (RunScriptParameter parameter : this.parameters
        ) {
            // structure of parameters: [{"name":"name1","value":"value1","type":"number/text"},{...}]
            String type = parameter.getType();
            StringBuilder sb = new StringBuilder();
            if (type.equals("number")) {
                command = sb.append(command).append(parameter.getName()).append("=").append(parameter.getValue()).append(" ").toString();
            } else if (type.equals("text")) {
                command = sb.append(command).append(parameter.getName()).append("=").append("\"").append(parameter.getValue()).append("\" ").toString();
            }
        }
        command = "ncl " + command + "filename=\"" + this.filename + "\" " + "outputFile=\"" + this.outputFilename + "\" " + this.scriptFunction;
        return command;
    }

    public String runCommand() {
        String nclOutputFile = "";
        boolean exitVal = false;
        File outputFile = new File(workingDir + this.outputFilename + ".png");
        if (outputFile.exists()) {
            System.out.println("========== OUTPUT FILE EXISTS ==========");
            System.out.println(java.time.LocalDate.now());
            System.out.println(java.time.LocalTime.now());
            System.out.println(this.outputFilename + ".png");
            return this.outputFilename + ".png";
        } else {
            try {
                String cmd = buildCommand();
                System.out.println("=============== NCL CALL ===============");
                System.out.println(java.time.LocalDate.now());
                System.out.println(java.time.LocalTime.now());
                System.out.println(cmd);
                // process builder is expecting string[] and automatically add spaces
                ProcessBuilder builder = new ProcessBuilder(cmd.split(" "));
                builder.directory(new File(this.workingDir));
                builder.redirectErrorStream(true);

                Process process = builder.start();

                StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream());
                outputGobbler.start();

                exitVal = process.waitFor(1, TimeUnit.MINUTES);

                nclOutputFile = outputGobbler.getNclOutputFile();
                System.out.println(exitVal ? "NCL Success" : "NCL Failed");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ((exitVal) && (nclOutputFile.equals(this.outputFilename + ".png"))) {
                return this.outputFilename + ".png";
            } else return "Failed";
        }
    }
}
