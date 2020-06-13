package com.thudessesil.onlinencl.NCLWrapper.model;

public class RunResult {
    private String outputFilename = "";
    private String status = "Failed";

    public RunResult(){}

    public RunResult(String NCLWrapperOutput){
        if(NCLWrapperOutput.equals("Failed")){
        }
        else {
            this.outputFilename=NCLWrapperOutput;
            this.status="Success";
        }
    }

    public String getOutputFilename() {
        return outputFilename;
    }

    public void setOutputFilename(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
