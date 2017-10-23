package com.zy.creditindex.service.IndexService;

import com.zy.creditindex.entity.idri.idri;
import com.zy.creditindex.repostory.indexJpa.IdriRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${ZhaoYing}on 2017/10/23 0023
 */
@Service
public class IdriService {
    @Autowired
    private IdriRepostory idriRepostory;

    /**
     *id查询
     */
    public idri findIdriId(String id){
        return idriRepostory.findOne(id);
    }

    /**
     * 查询所有的数据
     * @return
     */
    public List<idri> findIdriAll(){
        return idriRepostory.findAll();
    }

}
