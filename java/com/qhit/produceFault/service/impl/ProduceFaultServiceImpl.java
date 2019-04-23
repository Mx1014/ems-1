package com.qhit.produceFault.service.impl;

import com.qhit.produceFault.service.IProduceFaultService;
import java.util.List;
import com.qhit.produceFault.dao.IProduceFaultDao;
import com.qhit.produceFault.pojo.ProduceFault;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/04/09
*/

@Service 
public class ProduceFaultServiceImpl  implements IProduceFaultService {

    @Resource 
    IProduceFaultDao dao;

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
        ProduceFault produceFault = findById(id); 
        return dao.delete(produceFault); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public ProduceFault findById(Object id) { 
        List<ProduceFault> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<ProduceFault> search(ProduceFault produceFault) { 
        return dao.search(produceFault); 
    } 

}