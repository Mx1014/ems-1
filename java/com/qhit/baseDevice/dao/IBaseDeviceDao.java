package com.qhit.baseDevice.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.baseDevice.pojo.BaseDevice;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/04/08
*/

@Mapper  
public interface IBaseDeviceDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<BaseDevice> search(BaseDevice baseDevice);

    List findByDevname(Object devname);

    List findByTypeid(Object typeid);

    List findByDevdate(Object devdate);

    List findByDevuser(Object devuser);

    List findByCompid(Object compid);

    List<BaseDevice> findDljByCompid(Integer compid);

    List<BaseDevice> findCzjByCompid(Integer compid);

    List<BaseDevice> findPdjByCompid(Integer compid);
}