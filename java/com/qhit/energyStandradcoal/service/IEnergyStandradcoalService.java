package com.qhit.energyStandradcoal.service;

import java.util.List;
import com.qhit.energyStandradcoal.pojo.EnergyStandradcoal;
/**
* Created by GeneratorCode on 2019/04/10
*/
public interface IEnergyStandradcoalService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    EnergyStandradcoal findById(Object id);

    List<EnergyStandradcoal> search(EnergyStandradcoal energyStandradcoal);

}