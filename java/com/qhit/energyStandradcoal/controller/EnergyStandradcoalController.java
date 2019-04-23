package com.qhit.energyStandradcoal.controller; 

import com.qhit.energyStandradcoal.pojo.EnergyStandradcoal; 
import com.qhit.energyStandradcoal.service.IEnergyStandradcoalService; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/10
*/ 

@RestController 
@RequestMapping("/energyStandradcoal") 
public class EnergyStandradcoalController { 

    @Resource 
    IEnergyStandradcoalService energyStandradcoalService; 

    @RequestMapping("/insert") 
    public void insert(EnergyStandradcoal energyStandradcoal) { 
        energyStandradcoalService.insert(energyStandradcoal); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer sid) { 
        energyStandradcoalService.delete(sid); 
    } 

    @RequestMapping("/update") 
    public void update(EnergyStandradcoal energyStandradcoal) { 
        energyStandradcoalService.update(energyStandradcoal); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(EnergyStandradcoal energyStandradcoal) { 
        energyStandradcoalService.updateSelective(energyStandradcoal); 
    } 

    @RequestMapping("/load") 
    public EnergyStandradcoal load(Integer sid) { 
        EnergyStandradcoal energyStandradcoal = energyStandradcoalService.findById(sid); 
        return energyStandradcoal; 
    } 

    @RequestMapping("/list") 
    public List<EnergyStandradcoal> list()  { 
        List<EnergyStandradcoal> list = energyStandradcoalService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<EnergyStandradcoal> search(EnergyStandradcoal energyStandradcoal) { 
        List<EnergyStandradcoal> list = energyStandradcoalService.search(energyStandradcoal); 
        return list; 
    } 

} 
