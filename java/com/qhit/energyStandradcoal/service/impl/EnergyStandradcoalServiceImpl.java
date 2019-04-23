package com.qhit.energyStandradcoal.service.impl;

import com.qhit.energyStandradcoal.service.IEnergyStandradcoalService;
import java.util.List;
import com.qhit.energyStandradcoal.dao.IEnergyStandradcoalDao;
import com.qhit.energyStandradcoal.pojo.EnergyStandradcoal;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class EnergyStandradcoalServiceImpl  implements IEnergyStandradcoalService {

    @Resource 
    IEnergyStandradcoalDao dao;

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
        EnergyStandradcoal energyStandradcoal = findById(id); 
        return dao.delete(energyStandradcoal); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public EnergyStandradcoal findById(Object id) { 
        List<EnergyStandradcoal> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<EnergyStandradcoal> search(EnergyStandradcoal energyStandradcoal) { 
        return dao.search(energyStandradcoal); 
    } 

}