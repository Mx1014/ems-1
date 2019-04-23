package com.qhit.reports;

import com.qhit.produceReport.service.IProduceReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/13 0013.
 */
@RestController
@RequestMapping("/devInfo")
public class devInfo {

    @Resource
    IProduceReportService produceReportService;

    @RequestMapping("/usage")
    public Object usage(String year, HttpSession session){
        Map map = new HashMap();
        String[] columns = {"compname","devType","ratio"};
        List<Map> rows = produceReportService.usage(year);
        map.put("columns",columns);
        map.put("rows",rows);
        return  map;
    }
}
