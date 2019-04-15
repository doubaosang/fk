package com.chentuo.springboot.controller.org.web.userCenter.ccc;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.ComInfo;
import com.chentuo.model.SortInfo;
import com.chentuo.springboot.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
@RestController
@RequestMapping("/org/web/userCenter/ccc")
public class ComController {
    @Autowired
    private CodeService codeService = null;
    @Autowired
    private ComService comService = null;
    @Autowired
    private SortService sortService = null;
    @Autowired
    private BrandService brandService = null;
    @Autowired
    private SkuService skuService = null;

    @RequestMapping("page.json")
    public PageInfo page(Integer pageNumber,
                         String searchValue, Integer pageSize, String sortName,
                         String sortOrder, String startDate, String endDate, HttpSession httpSession) {

        return comService.getPage("COM_INFO", pageNumber,
                searchValue, pageSize, sortName,
                sortOrder);

    }
    @RequestMapping("readSkuPage.json")
    public PageInfo readLogPage(String pid, Integer pageNumber, String searchValue, Integer pageSize, String sortName, String sortOrder, String startDate, String endDate) {
        PageInfo pageInfo = skuService.getPage(pid, pageNumber, searchValue, pageSize, sortName, sortOrder, startDate, endDate);
        PageInfo pageInfo1 = null;
        for (Object o : pageInfo.getRows()) {
            Map<String, Object> map = (Map<String, Object>) o;
            map.put("COM_NAME", comService.getMapOne("COM_INFO",(String) map.get("COM_PID")).get("COM_NAME"));
        }
        return pageInfo;
    }

    @RequestMapping("save.json")
    public Map<String, Object> save (ComInfo comInfo){
        Map<String, Object> map = new HashMap<String, Object>();
        if (comInfo.getBrandPid().equals("--请选择--")){
            map.put("errCode", 1000);
            map.put("errMsg", "请选择商品品牌");
            return map;
        }
        comInfo.setCreateUserId(ShiroConfiguration.getUserId());
        String pid = comService.save(comInfo);
        return comService.getMapOne("COM_INFO", pid);
    }

    @RequestMapping("querybrand.json")
    public List<Map<String, Object>> queryBrand(){

        return brandService.getList("BRAND_INFO");
    }


    @RequestMapping("querysort.json")
    public Map<String, Object> querySort(String pid){
        if ("--请选择--".equals(pid)){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("PID", "");
            map.put("SORT_NAME", "--请选择--");
            return map;
        }
        return sortService.getMapOne("SORT_INFO", (String) brandService.getMapOne("BRAND_INFO", pid).get("SORT_PID"));
    }

    @RequestMapping("querycode.json")
    public List<Map<String, Object>> queryCode(){
        return codeService.getList("CODE_INFO");
    }

    @RequestMapping("uploda.json")
    public String uploadImg(@RequestParam("file") MultipartFile file){
        String prefix = UUID.randomUUID().toString();
        String dfilename = prefix + file.getOriginalFilename();
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            File dfile = new File(path + "/static/upload/" + dfilename);
            file.transferTo(dfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dfilename ;
    }

    @RequestMapping("looksku.json")
    public String lookSkuPic(String pid){
        String comPid = (String) skuService.getMapOne("SKU_INFO", pid).get("COM_PID");
        String path = (String) comService.getMapOne("COM_INFO", comPid).get("PIC");
        if (path == null){
            return "timg.jpg";
        }
        return path;
    }

    @RequestMapping("look.json")
    public String lookPic(String pid){
        String path = (String) comService.getMapOne("COM_INFO",pid).get("PIC");
        if (path == null){
            return "timg.jpg";
        }
        return path;
    }
    @RequestMapping("chkPrime.json")
    public String chkPrime(String pid, String sellprime){
        BigDecimal prime = (BigDecimal)skuService.getMapOne("SKU_INFO", pid).get("PRIME");
        BigDecimal sell = new BigDecimal(sellprime);
        sell.setScale(2, BigDecimal.ROUND_HALF_UP);
        int r = prime.compareTo(sell);
        if (r > 0){
            return "no";
        }
        comService.update(pid, sell);
        return "yes";
    }

    @RequestMapping("chklogin.json")
    public String login(String username, String password, String sellprime, String pid) {
        password = UserService.passwordDigest(password);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, "org");
        try {
            subject.login(token);
        } catch (AuthenticationException e){
            return "no";
        }
        BigDecimal sell = new BigDecimal(sellprime);
        sell.setScale(2, BigDecimal.ROUND_HALF_UP);
        comService.update(pid, sell);
        return "yes";
    }

    @RequestMapping("chkstock.json")
    public String chkstock(String pid, String stock){
        return comService.chkstock(pid, stock);
    }
}
