package com.chentuo.springboot.service;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.OrgInfo;
import com.chentuo.model.SortInfo;
import com.chentuo.springboot.repository.SortRepo;
import com.chentuo.superClass.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 孟翔飞
 * @date 2019/3/28
 */
@Service
public class SortService extends SuperService {
    @Autowired
    private SortRepo sortRepo = null;

    public List<Map<String, Object>> queryTopSort(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<SortInfo> all = sortRepo.findAll();
        for (SortInfo sortInfo : all){
            if ("0".equals(sortInfo.getIsTop())&&"1".equals(sortInfo.getStatus())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("PID", sortInfo.getPid());
                map.put("SORT_NAME", sortInfo.getSortName());
                list.add(map);
            }
        }
        return list;
    }

    public List<Map<String, Object>> querySort(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<SortInfo> all = sortRepo.findAll();
        for (SortInfo sortInfo : all){
            if ("1".equals(sortInfo.getIsTop())&&"1".equals(sortInfo.getStatus())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("SORT_PID", sortInfo.getPid());
                map.put("SORT_NAME", sortInfo.getSortName());
                list.add(map);
            }
        }
        return list;
    }

    public String save (SortInfo sortInfo) {
        sortInfo.setCreateTime(new Date());
        sortInfo.setLastUpTime(new Date());
        sortInfo.setStatus("1");
        sortRepo.save(sortInfo);
        return sortInfo.getPid();
    }

    public String delete(SortInfo sortInfo) {

        sortInfo.setLastUpTime(new Date());

        sortInfo.setStatus("0");

        sortRepo.save(sortInfo);

        return sortInfo.getPid();

    }

    public String delete (String pid, String top) {
        SortInfo sortInfo = sortRepo.getOne(pid);
        if ("yes".equals(top)){
            List<SortInfo> list = sortRepo.findAll();
            for (SortInfo info: list) {
                if (pid.equals(info.getTopPid())){
                    info.setStatus("0");
                    sortRepo.save(info);
                }
            }
            return delete(sortInfo);
        } else {
            return delete(sortInfo);
        }
    }
}
