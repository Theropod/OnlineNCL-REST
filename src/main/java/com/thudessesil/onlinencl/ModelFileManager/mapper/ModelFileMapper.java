package com.thudessesil.onlinencl.ModelFileManager.mapper;

import com.thudessesil.onlinencl.ModelFileManager.entity.ModelFile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper Interface
 * </p>
 *
 * @author Theropod
 * @since 2020-06-14
 */
// use @Repository to supress IDEA warning: no beans of ModelFileMapper found
@Repository
public interface ModelFileMapper extends BaseMapper<ModelFile> {

}
