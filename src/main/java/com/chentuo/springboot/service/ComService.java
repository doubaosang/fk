package com.chentuo.springboot.service;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.ComInfo;
import com.chentuo.model.SkuInfo;
import com.chentuo.model.SortInfo;
import com.chentuo.springboot.repository.BrandRepo;
import com.chentuo.springboot.repository.ComRepo;
import com.chentuo.springboot.repository.SkuRepo;
import com.chentuo.springboot.repository.SortRepo;
import com.chentuo.superClass.SuperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
@Service
public class ComService extends SuperService {
    @Autowired
    private BrandRepo brandRepo = null;
    @Autowired
    private ComRepo comRepo = null;
    @Autowired
    private SkuRepo skuRepo = null;

    public String save (ComInfo comInfo) {
        comInfo.setBrandName(brandRepo.getOne(comInfo.getBrandPid()).getBrandName());
        comInfo.setCreateTime(new Date());
        comInfo.setLastUpTime(new Date());
        comInfo.setStatus("1");
        comRepo.save(comInfo);

        if(comInfo.getColor() != null && comInfo.getScreen() != null && comInfo.getCpu() != null){
            String[] color = comInfo.getColor().split(",");
            String[] screen = comInfo.getScreen().split(",");
            String[] cpu = comInfo.getCpu().split(",");
            for(String c : color) {
                for(String s : screen) {
                    for(String u : cpu) {
                        SkuInfo skuInfo = new SkuInfo();
                        skuInfo.setComPid(comInfo.getPid());
                        skuInfo.setColor(c);
                        skuInfo.setSecreen(s);
                        skuInfo.setCpu(u);
                        skuInfo.setStatus("1");
                        skuInfo.setStock(0);
                        skuInfo.setPrime(comInfo.getPrime());
                        skuInfo.setSncode("请输入");
                        skuInfo.setCreateUserId(comInfo.getCreateUserId());
                        skuInfo.setCreateTime(new Date());
                        String skuname = comInfo.getComName()+" "+c+" "+s+" "+u;
                        skuInfo.setSkuName(skuname);
                        skuRepo.save(skuInfo);
                    }
                }
            }
        } else {
            SkuInfo skuInfo = new SkuInfo();
            skuInfo.setComPid(comInfo.getPid());
            skuInfo.setStatus("1");
            skuInfo.setStock(0);
            skuInfo.setPrime(comInfo.getPrime());
            skuInfo.setSncode("请输入");
            skuInfo.setCreateUserId(comInfo.getCreateUserId());
            skuInfo.setCreateTime(new Date());
            String skuname = comInfo.getComName();
            skuInfo.setSkuName(skuname);
            skuRepo.save(skuInfo);
        }
        return comInfo.getPid();
    }

    public String update (String pid, BigDecimal sellprime){
        SkuInfo skuInfo = skuRepo.getOne(pid);
        skuInfo.setSellprime(sellprime);
        skuRepo.save(skuInfo);
        return skuInfo.getPid();
    }

    public String chkstock(String pid, String stock) {
        Integer count = comRepo.getOne(skuRepo.getOne(pid).getComPid()).getCount();
        Integer oldStock = skuRepo.getOne(pid).getStock();

        List<SkuInfo> list = skuRepo.findAll();
        Integer allStock = 0;
        for (SkuInfo s: list) {
            if (s.getComPid().equals(skuRepo.getOne(pid).getComPid())){
                if (!s.getPid().equals(pid)) {
                    allStock += s.getStock();
                }
            }
        }
        /*allStock = allStock - Integer.parseInt(stock);*/
        /*oldStock > Integer.parseInt(stock)*/

        if (Integer.parseInt(stock)+allStock <= count){
            SkuInfo skuInfo = skuRepo.getOne(pid);
            skuInfo.setStock(Integer.parseInt(stock));
            skuRepo.save(skuInfo);
            return "yes";
        } else {

            return "no";
        }



    }

}
