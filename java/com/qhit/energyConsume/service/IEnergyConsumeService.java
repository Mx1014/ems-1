package com.qhit.energyConsume.service;

import java.util.List;
import com.qhit.energyConsume.pojo.EnergyConsume;
/**
* Created by GeneratorCode on 2019/04/10
*/
public interface IEnergyConsumeService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    EnergyConsume findById(Object id);

    List<EnergyConsume> search(EnergyConsume energyConsume);

}