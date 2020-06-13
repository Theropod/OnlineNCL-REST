package com.thudessesil.onlinencl.NCLWrapper.model;

public class RunScriptParameter {
    private String name;
    private String description;
    private String type;
    private String hint;
    private String value;
    private boolean readonly;

    public RunScriptParameter () {}

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDescription(String Description){
        this.description = Description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setHint(String hint){
        this.hint = hint;
    }
    public String getHint(){
        return this.hint;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    public void setReadonly(boolean readonly){
        this.readonly = readonly;
    }
    public boolean getReadonly(){
        return this.readonly;
    }
}
