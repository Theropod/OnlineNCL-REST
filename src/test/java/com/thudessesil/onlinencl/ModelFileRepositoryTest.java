package com.thudessesil.onlinencl;

import com.thudessesil.onlinencl.ModelFileManger.model.ModelFile;
import com.thudessesil.onlinencl.ModelFileManger.repository.ModelFileRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ModelFileRepositoryTest {

    // new an instance of  modelfilerepository and modelFileFilter to perform crud test
    @Autowired
    private ModelFileRepository modelFileRepository;

    @BeforeEach
    public void testAdd() {

        // save new defined rows in db
        modelFileRepository.save(new ModelFile("daily_bcccsm_2020040600_PRECT.nc", "S2S_T226",
                "20200406", "PRECT", "D:\\WorkSpace\\NetCDF_Test_Data\\BCC\\Operational_Prediction\\S2S_T226\\PRECT",
                "fileinfo1"));
        modelFileRepository.save(new ModelFile("daily_bcccsm_2020040600p01_PRECT.nc", "S2S_T226",
                "20200406", "PRECT", "D:\\WorkSpace\\NetCDF_Test_Data\\BCC\\Operational_Prediction\\S2S_T226\\PRECT",
                "fileinfo2"));
        modelFileRepository.save(new ModelFile("daily_bcccsm_2020040600_T.nc", "S2S_T226",
                "20200406", "T", "D:\\WorkSpace\\NetCDF_Test_Data\\BCC\\Operational_Prediction\\S2S_T226\\T",
                "fileinfo3"));
        modelFileRepository.save(new ModelFile("daily_bcccsm_2020040700_T.nc", "S2S_T226",
                "20200407", "T", "D:\\WorkSpace\\NetCDF_Test_Data\\BCC\\Operational_Prediction\\S2S_T226\\T",
                "fileinfo4"));
        modelFileRepository.save(new ModelFile("20200101.atm.T.202001-202101_prs0010_member.nc", "Seasonal_T106",
                "20200101", "T", "D:\\WorkSpace\\NetCDF_Test_Data\\BCC\\Operational_Prediction\\Seasonal_T106\\20200101\\T",
                "fileinfo5"));
    }

    // helper function in testAll
    public void testFilters(String model, String startTime, String variableName){
        // print 3 filter column distinct values, when arbitraty filter(s) are provided
        List<String> models = modelFileRepository.findOneColumnByModelFileFilter("model", model, startTime, variableName);
        List<String> startTimes = modelFileRepository.findOneColumnByModelFileFilter("startTime",model, startTime, variableName);
        List<String> variableNames = modelFileRepository.findOneColumnByModelFileFilter("variableName",model, startTime, variableName);
        System.out.println("size: " + models.size());
        System.out.println(models.toString());
        System.out.println("size: " + startTimes.size());
        System.out.println(startTimes.toString());
        System.out.println("size: " + variableNames.size());
        System.out.println(variableNames.toString());
    }

    @Test
    public void testAll() {
        // get all possible filters
        System.out.println("get all possible filters");
        testFilters("","","");
        // select one filter
        System.out.println("select one filter");
        testFilters("S2S_T226","","");
        // select two filter
        System.out.println("select two filters");
        testFilters("S2S_T226","20200406","");
        // select three filter
        System.out.println("select three filters");
        testFilters("S2S_T226","20200406","PRECT");

        // get file if all 3 filters are determined
        System.out.println("get file if all 3 filters are determined");
        List<ModelFile> modelfiles = modelFileRepository.findByModelAndStartTimeAndVariableName("S2S_T226", "20200406", "PRECT");
        System.out.println("size: " + modelfiles.size());
        System.out.println(modelfiles.toString());
    }

    @AfterEach
    public void after() {
//         remove records
        modelFileRepository.deleteAll();
    }

}
