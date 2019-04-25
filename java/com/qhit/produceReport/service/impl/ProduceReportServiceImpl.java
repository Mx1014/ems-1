package com.qhit.produceReport.service.impl;

import com.qhit.baseDevice.pojo.BaseDevice;
import com.qhit.baseDevtype.pojo.BaseDevtype;
import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.produceReport.service.IProduceReportService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qhit.produceReport.dao.IProduceReportDao;
import com.qhit.produceReport.pojo.ProduceReport;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class ProduceReportServiceImpl  implements IProduceReportService {

    @Resource 
    IProduceReportDao dao;

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 

    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 

    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 

    @Override 
    public boolean delete(Object id) { 
        ProduceReport produceReport = findById(id); 
        return dao.delete(produceReport); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public ProduceReport findById(Object id) { 
        List<ProduceReport> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<ProduceReport> search(ProduceReport produceReport) { 
        return dao.search(produceReport); 
    }

    @Override
    public boolean completeTask(ProduceReport produceReport) {
        return dao.completeTask(produceReport);
    }

    @Override
    public List<Map> selectFlowConsume(String year, List<BaseFlow> flows) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("flows",flows);
        return dao.selectFlowConsume(map);
    }

    @Override
    public List<Map> selectDevTypeConsume(String year, List<BaseDevtype> devTypeList) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("devTypeList",devTypeList);
        return dao.selectDevTypeConsume(map);
    }

    @Override
    public List<Map> selectDevConsume(String year, List<BaseDevice> devices) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("devices",devices);
        return dao.selectDevConsume(map);
    }

    @Override
    public List<Map> selectElectricConsume(String year, List<BaseDevice> devices) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("devices",devices);
        return dao.selectElectricConsume(map);
    }

    @Override
    public List<Map> selectWaterConsume(String year, List<BaseDevice> devices) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("devices",devices);
        return dao.selectWaterConsume(map);
    }

    @Override
    public List<Map> selectOilConsume(String year, List<BaseDevice> devices) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("devices",devices);
        return dao.selectOilConsume(map);
    }

    @Override
    public List<Map> selectFlowAmount(String year, List<BaseFlow> flows) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("flows",flows);
        return dao.selectFlowAmount(map);
    }

    @Override
    public List<Map> selectDevTypeAmount(String year, List<BaseDevtype> devTypeList) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("devTypeList",devTypeList);
        return dao.selectDevTypeAmount(map);
    }

    @Override
    public List<Map> selectDevAmount(String year, List<BaseDevice> devices) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("devices",devices);
        return dao.selectDevAmount(map);
    }

    @Override
    public List<Map> selectJobModel(String year, BaseFlow baseFlow) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("baseFlow",baseFlow);
        return dao.selectJobModel(map);
    }

    @Override
    public List<Map> selectConsume(String year, BaseFlow baseFlow) {
        Map map = new HashMap();
        map.put("year",year);
        map.put("baseFlow",baseFlow);
        return dao.selectConsume(map);
    }

    @Override
    public List<ProduceReport> findByCompid(Integer compid) {
        return dao.findByCompid(compid);
    }

    @Override
    public Map<String, Object> usage(String year) {
        String[] columns = {"港口名称","斗轮机","皮带机","装船机"};
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        List<Map> rows = dao.usage(map);
        Map<String,Object> data = new HashMap<>();
        data.put("columns",columns);
        data.put("rows",rows);
        return data;
    }

    @Override
    public Map<String, Object> intactRatio(String year) {
        String[] columns = {"港口名称","斗轮机","皮带机","装船机"};
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        List<Map> rows = dao.intactRatio(map);
        Map<String,Object> data = new HashMap<>();
        data.put("columns",columns);
        data.put("rows",rows);
        return data;
    }

    @Override
    public List<Map> cost(String year, Integer compid) {
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        map.put("compid",compid);
        List<Map> rows = dao.cost(map);
        return rows;
    }

    @Override
    public Map<String, Object> amount(String year) {
        String[] columns = {"港口名称","斗轮机","皮带机","装船机"};
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        List<Map> rows = dao.amount(map);
        Map<String,Object> data = new HashMap<>();
        data.put("columns",columns);
        data.put("rows",rows);
        return data;
    }

    @Override
    public Map<String, Object> consume(String year) {
        String[] columns = {"港口名称","斗轮机","皮带机","装船机"};
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        List<Map> rows = dao.consume(map);
        Map<String,Object> data = new HashMap<>();
        data.put("columns",columns);
        data.put("rows",rows);
        return data;
    }

}