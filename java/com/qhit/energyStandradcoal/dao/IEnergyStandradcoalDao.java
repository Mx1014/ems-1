package com.qhit.energyStandradcoal.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.energyStandradcoal.pojo.EnergyStandradcoal;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/04/10
*/

@Mapper  
public interface IEnergyStandradcoalDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<EnergyStandradcoal> search(EnergyStandradcoal energyStandradcoal);

    List findByEnergetype(Object energetype);

    List findByRatio(Object ratio);

}