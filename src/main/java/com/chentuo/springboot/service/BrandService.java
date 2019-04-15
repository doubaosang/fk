package com.chentuo.springboot.service;

import com.chentuo.model.BrandInfo;
import com.chentuo.model.OrgInfo;
import com.chentuo.model.SortInfo;
import com.chentuo.springboot.repository.BrandRepo;
import com.chentuo.springboot.repository.SortRepo;
import com.chentuo.superClass.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
@Service
public class BrandService extends SuperService {
    @Autowired
    private BrandRepo brandRepo = null;
    @Autowired
    private SortRepo sortRepo = null;

    public String save (BrandInfo brandInfo) {
        String sortName=sortRepo.getOne(brandInfo.getSortId()).getSortName();
        brandInfo.setDescriptions(sortName);
        brandInfo.setCreateTime(new Date());
        brandInfo.setLastUpTime(new Date());
        brandInfo.setStatus("1");
        brandRepo.save(brandInfo);
        return brandInfo.getPid();
    }

    public String delete(BrandInfo brandInfo) {

        brandInfo.setLastUpTime(new Date());

        brandInfo.setStatus("0");

        brandRepo.save(brandInfo);

        return brandInfo.getPid();

    }
    public String delete(String pid) {

        BrandInfo brandInfo = brandRepo.getOne(pid);

        return delete(brandInfo);

    }
}
