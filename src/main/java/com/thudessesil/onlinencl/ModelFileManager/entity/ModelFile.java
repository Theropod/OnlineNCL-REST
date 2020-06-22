package com.thudessesil.onlinencl.ModelFileManager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * entity of modelfile
 * </p>
 *
 * @author Theropod
 * @since 2020-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("MODEL_FILE")
public class ModelFile implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * primary key id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * entity output filename
     */
    @TableField("FILENAME")
    private String filename;

    /**
     * entity name
     */
    @TableField("MODEL")
    private String model;

    /**
     * entity predict start time
     */
    @TableField("START_TIME")
    private String startTime;

    /**
     * entity variable_name
     */
    @TableField("VARIABLE_NAME")
    private String variableName;

    /**
     * entity file path
     */
    @TableField("PATH")
    private String path;

    /**
     * entity file info
     */
    @TableField("FILE_INFO")
    private String fileInfo;


}
