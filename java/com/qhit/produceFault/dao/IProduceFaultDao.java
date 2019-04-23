package com.qhit.produceFault.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.produceFault.pojo.ProduceFault;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/04/09
*/

@Mapper  
public interface IProduceFaultDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<ProduceFault> search(ProduceFault produceFault);

    List findByDevid(Object devid);

    List findByCause(Object cause);

    List findByFaultuser(Object faultuser);

    List findByFaulttime(Object faulttime);

}