package com.thudessesil.onlinencl.NCLWrapper.model;


import java.util.ArrayList;


public class RunScriptForm {
    private String filename;
    private String scriptname;
    private String scriptpath;
    private ArrayList<RunScriptParameter> parameters;
    private String outputfilename;

    RunScriptForm() {}

    public void setFilename(String filename){
        this.filename = filename;
    }
    public String getFilename(){
        return this.filename;
    }
    public void setScriptname(String scriptname){
        this.scriptname = scriptname;
    }
    public String getScriptname(){
        return this.scriptname;
    }
    public void setScriptpath(String scriptpath){
        this.scriptpath = scriptpath;
    }
    public String getScriptpath(){
        return this.scriptpath;
    }
    public void setOutputfilename(String outputfilename){
        this.outputfilename = outputfilename;
    }
    public String getOutputfilename(){
        return this.outputfilename;
    }
    public void setParameters(ArrayList<RunScriptParameter> parameters){
        this.parameters = parameters;
    }
    public ArrayList<RunScriptParameter> getParameters(){
        return this.parameters;
    }
}
