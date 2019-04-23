package com.qhit.produceJob.controller; 

import com.qhit.baseCompany.pojo.BaseCompany;
import com.qhit.baseCompany.service.IBaseCompanyService;
import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceJob.service.IProduceJobService;
import com.qhit.produceReport.service.IProduceReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/10
*/ 

@RestController 
@RequestMapping("/produceJob") 
public class ProduceJobController { 

    @Resource 
    IProduceJobService produceJobService;

    @Resource
    IBaseFlowService baseFlowService;
    @Resource
    IProduceReportService produceReportService;
    @Resource
    IBaseCompanyService baseCompanyService;

    @RequestMapping("/insert") 
    public void insert(ProduceJob produceJob) { 
        produceJobService.insert(produceJob); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer jobid) { 
        produceJobService.delete(jobid); 
    } 

    @RequestMapping("/update") 
    public void update(ProduceJob produceJob) { 
        produceJobService.update(produceJob); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(ProduceJob produceJob) { 
        produceJobService.updateSelective(produceJob); 
    } 

    @RequestMapping("/load") 
    public ProduceJob load(Integer jobid) { 
        ProduceJob produceJob = produceJobService.findById(jobid); 
        return produceJob; 
    } 

    @RequestMapping("/list") 
    public List<ProduceJob> list()  { 
        List<ProduceJob> list = produceJobService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<ProduceJob> search(ProduceJob produceJob) { 
        List<ProduceJob> list = produceJobService.search(produceJob); 
        return list; 
    }

    @RequestMapping("/model")
    public Object model(String year, HttpSession session){
        Map map = new HashMap();
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        Integer compid = baseUser.getCompid();
        BaseCompany baseCompany = baseCompanyService.findById(compid);
        List<BaseFlow> baseFlows = baseFlowService.findByCompid(compid);
        double amounts = 0;
        List<Map> m = new ArrayList<Map>();
        for (int i = 0; i < baseFlows.size(); i++) {
            Map map1 = new HashMap();
            double amount = 0;
            List<Map> list = produceReportService.selectJobModel(year, baseFlows.get(i));
            for (int j = 0; j < list.size(); j++) {
                amount += (double)list.get(j).get("amount");
                list.get(j).put("amount",list.get(j).get("amount")+"吨");
            }
            amounts+=amount;
            map1.put("flow",baseFlows.get(i).getFlowname());
            map1.put("amount",amount+"吨");
            map1.put("children",list);
            m.add(map1);
        }
//        System.out.println(m);

        map.put("comp",baseCompany.getCompname());
        map.put("amount",amounts+"吨");
        map.put("children",m);
        return  map;
    }

} 
