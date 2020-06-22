package com.thudessesil.onlinencl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.thudessesil.onlinencl.ModelFileManager.entity.ModelFile;
import com.thudessesil.onlinencl.ModelFileManager.mapper.ModelFileMapper;
import com.thudessesil.onlinencl.ModelFileManager.service.ModelFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelFileManagerTest {

    @Autowired
    private ModelFileMapper modelFileMapper;
    @Autowired
    private ModelFileService modelFileService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<ModelFile> modelList = modelFileMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        modelList.forEach(System.out::println);
    }

    @Test
    public void InitSpringDBTest() {
        System.out.println(("----- Run Spring App and build embedded db ------"));
    }

    @Test
    public void findByColumnValues(){
        // MyBatis Plus provides two ways for CRUD: Service CRUD Interface(Extends IService) and Mapper CRUD interface(Extends BaseMapper)
        // Service CRUD is on service level(provides batch and Encapsulated methods)
        // Mapper CRUD is on dao level which is more basic
        // see https://blog.csdn.net/weixin_30387799/article/details/101855435
        // https://blog.csdn.net/pingfandehaozai/article/details/103537250

        // Service CRUD Flavor:
        Map<String, Object> columnMap = new HashMap<>();
        // use column name in DB！
        columnMap.put("model", "S2S_T226");
        columnMap.put("start_time", "20200406");
        columnMap.put("variable_name", "PRECT");
        // select * from model_file where entity= and start_time= and variable_name =
        Collection<ModelFile> modelFileList = modelFileService.listByMap(columnMap);

        System.out.println(modelFileList.toString());
    }

    // helper function of findDistinctByColumnValues
    public void findAllColumnDistinctByColumnValues(String model, String startTime, String variableName){
        QueryWrapper<ModelFile> queryWrapper = new QueryWrapper<>();
        // distinct values of these columns:
        for(String columnName : new ArrayList<>( Arrays.asList("model", "start_time", "variable_name"))){
            queryWrapper
                    .select("distinct " + columnName)
                    .like(StringUtils.isNotBlank(model),"model", model)
                    .like(StringUtils.isNotBlank(startTime),"start_time", startTime)
                    .like(StringUtils.isNotBlank(variableName),"variable_name", variableName);

            System.out.println(columnName + ":" + modelFileService.listObjs(queryWrapper));
        }
    }
    @Test
    public void findDistinctByDifferentFilter(){
        // select distinct entity/start_time/variable_name from model_file where entity= and start_time= and variable_name =
        // criteria overlooked if parameter is null
        // use return value as filters to find modelfiles

        // no filter selected
        System.out.println("========================");
        System.out.println("no filter.");
        findAllColumnDistinctByColumnValues("","","");
        // 1 filter selected
        System.out.println("========================");
        System.out.println("1 filter. model = S2S_T226");
        findAllColumnDistinctByColumnValues("S2S_T226","","");
        // 2 filters selected
        System.out.println("========================");
        System.out.println("2 filters. model = S2S_T226, start_time = 20200406");
        findAllColumnDistinctByColumnValues("S2S_T226","20200406","");
        // 3 filters selected
        System.out.println("========================");
        System.out.println("3 filters. model = S2S_T226, start_time = 20200406, variableName = PRECT ");
        findAllColumnDistinctByColumnValues("S2S_T226","20200406","PRECT");
    }

}
