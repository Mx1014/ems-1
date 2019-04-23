package com.qhit.baseFlow.service;

import java.util.List;
import com.qhit.baseFlow.pojo.BaseFlow;
/**
* Created by GeneratorCode on 2019/04/09
*/
public interface IBaseFlowService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseFlow findById(Object id);

    List<BaseFlow> search(BaseFlow baseFlow);

    List<BaseFlow> findByCompid(Integer compid);
}