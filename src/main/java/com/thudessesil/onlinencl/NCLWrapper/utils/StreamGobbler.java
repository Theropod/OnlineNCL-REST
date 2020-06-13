package com.thudessesil.onlinencl.NCLWrapper.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// using nio is a little bit overkill
// use this stream gobbler to deal with output in a new thread
// or, when ncl encounters error and never quits, readline in main tread will be waiting forever
// only killing ncl process will continue the program
public class StreamGobbler extends Thread {
    InputStream is;
    String nclOutputFile = "";

    public StreamGobbler(InputStream is) {
        this.is = is;
    }

    public String getNclOutputFile() {
        return nclOutputFile;
    }

    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (line.contains("Plot Done")) {
                    nclOutputFile = line;
                    nclOutputFile = nclOutputFile.split("./")[1];
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
