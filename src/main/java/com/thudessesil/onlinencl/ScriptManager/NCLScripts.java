package com.thudessesil.onlinencl.ScriptManager;

import java.util.ArrayList;
import java.util.HashMap;

public class NCLScripts {
    // list of all scripts, each script is a hashmap storing name and ncl filename
    private ArrayList Scripts;

    public NCLScripts() {
        this.Scripts = new ArrayList();

        HashMap<String, String> HashMap1 = new HashMap<>();
        HashMap1.put("name", "latlon plot");
        HashMap1.put("script", "/work2/theropod/BCC/Operational_Prediction/latlonplot.ncl");

        HashMap<String, String> HashMap2 = new HashMap<>();
        HashMap2.put("name", "average plot");
        HashMap2.put("script", "/work2/theropod/BCC/Operational_Prediction/averageplot.ncl");

        this.Scripts.add(HashMap1);
        this.Scripts.add(HashMap2);
    }

    public ArrayList getNCLScripts() {
        return this.Scripts;
    }
}
