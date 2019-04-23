package com.qhit.baseDevtype.service.impl;

import com.qhit.baseDevtype.service.IBaseDevtypeService;
import java.util.List;
import com.qhit.baseDevtype.dao.IBaseDevtypeDao;
import com.qhit.baseDevtype.pojo.BaseDevtype;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/04/02
*/

@Service 
public class BaseDevtypeServiceImpl  implements IBaseDevtypeService {

    @Resource 
    IBaseDevtypeDao dao;

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
        BaseDevtype baseDevtype = findById(id); 
        return dao.delete(baseDevtype); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public BaseDevtype findById(Object id) { 
        List<BaseDevtype> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<BaseDevtype> search(BaseDevtype baseDevtype) { 
        return dao.search(baseDevtype); 
    } 

}