package com.qhit.utils;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * Created by Administrator on 2019/4/13 0013.
 */
@RestController
@RequestMapping("/kettleSynchro")
public class KettleSynchro {


    @RequestMapping("/synchro")
    public void synchro(HttpServletRequest request){
        String filename = "c:/kettleJob/produceReport.ktr";
        String filename2 = "c:/kettleJob/produceJob.ktr";
        String filename3 = "c:/kettleJob/EnergyConsume.ktr";
        // 调用转换
        try {
            transfer(filename);
            transfer(filename2);
            transfer(filename3);
        } catch (KettleException e) {
            e.printStackTrace();
        }
    }
    public void transfer(String filename) throws KettleException {
        KettleEnvironment.init();
        TransMeta tm = new TransMeta(filename);
        Trans trans = new Trans(tm);
        // 空参调用
        trans.execute(null);
        trans.waitUntilFinished();
    }

}
