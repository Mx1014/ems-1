package com.qhit.produceFault.controller; 

import com.qhit.produceFault.pojo.ProduceFault; 
import com.qhit.produceFault.service.IProduceFaultService; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/09
*/ 

@RestController 
@RequestMapping("/produceFault") 
public class ProduceFaultController { 

    @Resource 
    IProduceFaultService produceFaultService; 

    @RequestMapping("/insert") 
    public void insert(ProduceFault produceFault) { 
        produceFaultService.insert(produceFault); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer faultId) { 
        produceFaultService.delete(faultId); 
    } 

    @RequestMapping("/update") 
    public void update(ProduceFault produceFault) { 
        produceFaultService.update(produceFault); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(ProduceFault produceFault) { 
        produceFaultService.updateSelective(produceFault); 
    } 

    @RequestMapping("/load") 
    public ProduceFault load(Integer faultId) { 
        ProduceFault produceFault = produceFaultService.findById(faultId); 
        return produceFault; 
    } 

    @RequestMapping("/list") 
    public List<ProduceFault> list()  { 
        List<ProduceFault> list = produceFaultService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<ProduceFault> search(ProduceFault produceFault) { 
        List<ProduceFault> list = produceFaultService.search(produceFault); 
        return list; 
    } 

} 
