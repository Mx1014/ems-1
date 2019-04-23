package com.qhit.baseDevtype.service;

import java.util.List;
import com.qhit.baseDevtype.pojo.BaseDevtype;
/**
* Created by GeneratorCode on 2019/04/02
*/
public interface IBaseDevtypeService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseDevtype findById(Object id);

    List<BaseDevtype> search(BaseDevtype baseDevtype);

}