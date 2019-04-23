package com.qhit.produceJob.service.impl;

import com.qhit.produceJob.service.IProduceJobService;
import java.util.List;
import com.qhit.produceJob.dao.IProduceJobDao;
import com.qhit.produceJob.pojo.ProduceJob;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class ProduceJobServiceImpl  implements IProduceJobService {

    @Resource 
    IProduceJobDao dao;

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
        ProduceJob produceJob = findById(id); 
        return dao.delete(produceJob); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public ProduceJob findById(Object id) { 
        List<ProduceJob> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<ProduceJob> search(ProduceJob produceJob) { 
        return dao.search(produceJob); 
    } 

}