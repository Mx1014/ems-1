package com.qhit.baseFlow.service.impl;

import com.qhit.baseFlow.service.IBaseFlowService;
import java.util.List;
import com.qhit.baseFlow.dao.IBaseFlowDao;
import com.qhit.baseFlow.pojo.BaseFlow;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/04/09
*/

@Service 
public class BaseFlowServiceImpl  implements IBaseFlowService {

    @Resource 
    IBaseFlowDao dao;

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
        BaseFlow baseFlow = findById(id); 
        return dao.delete(baseFlow); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public BaseFlow findById(Object id) { 
        List<BaseFlow> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<BaseFlow> search(BaseFlow baseFlow) { 
        return dao.search(baseFlow); 
    }

    @Override
    public List<BaseFlow> findByCompid(Integer compid) {
        return dao.findByCompid(compid);
    }

}