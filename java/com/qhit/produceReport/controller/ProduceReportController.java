package com.qhit.produceReport.controller; 

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.energyConsume.service.IEnergyConsumeService;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceJob.service.IProduceJobService;
import com.qhit.produceReport.pojo.ProduceReport;
import com.qhit.produceReport.service.IProduceReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RestController;

/** 
* Created by GeneratorCode on 2019/04/10
*/ 

@RestController 
@RequestMapping("/produceReport") 
public class ProduceReportController {

    @Resource
    IProduceJobService produceJobService;

    @Resource 
    IProduceReportService produceReportService;

    @Resource
    IBaseFlowService baseFlowService;

    @Resource
    IEnergyConsumeService energyConsumeService;

    @RequestMapping("/insert") 
    public void insert(ProduceReport produceReport) { 
        produceReportService.insert(produceReport); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer reportid) { 
        produceReportService.delete(reportid); 
    } 

    @RequestMapping("/update") 
    public void update(ProduceReport produceReport) {
        produceReportService.update(produceReport);
    } 

    @RequestMapping("/updateSelective") 
    public List<ProduceReport> updateSelective(ProduceReport produceReport) {
        produceReportService.updateSelective(produceReport);
        List<ProduceReport> list = produceReportService.findAll();
        return list;
    } 

    @RequestMapping("/load") 
    public ProduceReport load(Integer reportid) { 
        ProduceReport produceReport = produceReportService.findById(reportid); 
        return produceReport; 
    } 

    @RequestMapping("/list") 
    public List<ProduceReport> list()  {
        List<ProduceReport> list = produceReportService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<ProduceReport> search(ProduceReport produceReport) { 
        List<ProduceReport> list = produceReportService.search(produceReport); 
        return list; 
    }

    @RequestMapping("/completeTask")
//    @Transactional  事务注释
    public List<ProduceReport> completeTask(ProduceReport produceReport) {
//        1 记录实际到港时间，完成时间 流程 更新报岗表
//        (1)更新报岗表  更新flowid,startjobtime,completetime
        boolean b = produceReportService.completeTask(produceReport);
//        (2)插入作业信息表
//        2 记录作业信息，每个设备作业时间，完成了多少作业量  作业量比例 斗:装:皮带 = 4:4:2
        BaseFlow byId = baseFlowService.findById(produceReport.getFlowid());  //设备对象
        ProduceJob p=new ProduceJob();
        p.setStarttime(produceReport.getStartjobtime());
        p.setCompletetime(produceReport.getCompletetime());
        p.setReportid(produceReport.getReportid());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long data=(format.parse(produceReport.getCompletetime()).getTime()-
                        format.parse(produceReport.getStartjobtime()).getTime())/(1000*60);
            p.setDuration(new BigDecimal(Math.floor(data / 60)+(double) (data % 60)/60).
                            setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int s=byId.getDljid();
        p.setDevid(byId.getDljid());
        float v = (produceReport.getCapacity() / 10) * 4;
        p.setAmount(new BigDecimal(String.valueOf(v)).doubleValue());
        produceJobService.insert(p);
        p.setDevid(byId.getZcjid());
        v = (produceReport.getCapacity() / 10) * 4;
        p.setAmount(new BigDecimal(String.valueOf(v)).doubleValue());
        produceJobService.insert(p);
        p.setDevid(byId.getPdjid());
        v = (produceReport.getCapacity() / 10) * 2;
        p.setAmount(new BigDecimal(String.valueOf(v)).doubleValue());
        produceJobService.insert(p);
//        (3)插入能耗信息表
//        3 记录每个设备用电情况  一吨作业量对应100~300度电 随机数100~300
//
//        4 记录每个设备用水情况  一吨作业量对应1~10吨电 随机数1~10
//
//        5 记录每个设备用油情况  一吨作业量对应10~40L油 随机数10~40   随机数：均保留两位小数
        EnergyConsume e=new EnergyConsume();
        double electric = new BigDecimal(Math.random() * 201 + 100).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setElectric(produceReport.getCapacity()*electric);
        double water = new BigDecimal(Math.random() * 10 + 1).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setWater(produceReport.getCapacity()*water);
        double oil = new BigDecimal(Math.random() * 31 + 10).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setOil(produceReport.getCapacity()*oil);
        e.setReportid(produceReport.getReportid());
        e.setDevid(byId.getDljid());
        energyConsumeService.insert(e);
        electric = new BigDecimal(Math.random() * 201 + 100).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setElectric(produceReport.getCapacity()*electric);
        water = new BigDecimal(Math.random() * 10 + 1).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setWater(produceReport.getCapacity()*water);
        oil = new BigDecimal(Math.random() * 31 + 10).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setOil(produceReport.getCapacity()*oil);
        e.setDevid(byId.getZcjid());
        energyConsumeService.insert(e);
        electric = new BigDecimal(Math.random() * 201 + 100).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setElectric(produceReport.getCapacity()*electric);
        water = new BigDecimal(Math.random() * 10 + 1).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setWater(produceReport.getCapacity()*water);
        oil = new BigDecimal(Math.random() * 31 + 10).setScale(2,BigDecimal.ROUND_CEILING).doubleValue();
        e.setOil(produceReport.getCapacity()*oil);
        e.setDevid(byId.getPdjid());
        energyConsumeService.insert(e);
        List<ProduceReport> list = produceReportService.findAll();
        return list;
    }
    @RequestMapping(value = "/init")
    public void init(HttpSession session){
//      初始化报岗表
        ProduceReport produceReport = new ProduceReport();
        Random random = new Random();
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        List<BaseFlow> flows = baseFlowService.findByCompid(baseUser.getCompid());
//        船队名称
        String shipname = "sh-船A";
        int flowIndex = 0;
        int count=0;
        String[] year = {"2018","2019"};
        String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        int yearIndex=0;
        int monthIndex=0;
        for (int i = 101; i <=148 ; i++) {
            produceReport.setShipname(shipname+i);  //船队名称
            produceReport.setCapacity(0f+random.nextInt(100)+200);  //装载量
            count++;
            if(count%17==0) flowIndex++;
            produceReport.setFlowid(flows.get(flowIndex).getFlowid());  //流程id
            produceReport.setReportuser("廖伟良");
            produceReport.setCompid(10);

            if((i-100)%17<=12){
                yearIndex=0;
            }else{
                yearIndex=1;
            }
            if((i-100)%16==1 || (i-100)%16==13){
                monthIndex=0;
            }else{
                monthIndex++;
            }
            String startjobtime = year[yearIndex]+"-"+month[monthIndex]+"-02"+" "+random.nextInt(5)+":00:00";
            String completetime = year[yearIndex]+"-"+month[monthIndex]+"-02"+" "+(random.nextInt(5)+8)+":"+random.nextInt(60)+":00";
            produceReport.setPlanjobtime(startjobtime);
            produceReport.setStartjobtime(startjobtime);
            produceReport.setCompletetime(completetime);
            produceReportService.insert(produceReport);
        }
        List<ProduceReport> list = produceReportService.findByCompid(baseUser.getCompid());
        for(ProduceReport pr:list){
            completeTask(pr);
        }
    }

} 
