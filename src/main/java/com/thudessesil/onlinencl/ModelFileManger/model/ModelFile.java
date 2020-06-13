package com.thudessesil.onlinencl.ModelFileManger.model;

import javax.persistence.*;

@Entity
public class ModelFile{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String startTime;
    @Column(nullable = false)
    private String variableName;
    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String path;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String fileInfo;

    public ModelFile() {}

    public ModelFile(String fileName, String model, String startTime, String variableName, String path, String fileInfo) {
        this.fileName=fileName;
        this.model = model;
        this.startTime = startTime;
        this.variableName=variableName;
        this.path=path;
        this.fileInfo=fileInfo;
    }

    @Override
    public String toString() {
        return String.format(
                "ModelFile[id=%d, filename='%s' model='%s', startTime='%s', variableName='%s', path='%s', fileInfo='%s']",
                id, fileName,  model, startTime, variableName, path, fileInfo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(String fileInfo) {
        this.fileInfo = fileInfo;
    }
}
