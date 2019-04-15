package com.chentuo.springboot.controller.org.web.userCenter.bbb;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.BrandInfo;
import com.chentuo.springboot.service.BrandService;
import com.chentuo.springboot.service.ShiroConfiguration;
import com.chentuo.springboot.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
@RestController
@RequestMapping("/org/web/userCenter/bbb")
public class BrandController {
    @Autowired
    private BrandService brandService = null;
    @Autowired
    private SortService sortService = null;

    @RequestMapping("page.json")
    public PageInfo page(Integer pageNumber,
                         String searchValue, Integer pageSize, String sortName,
                         String sortOrder, String startDate, String endDate, HttpSession httpSession) {

        return brandService.getPage("BRAND_INFO", pageNumber,
                searchValue, pageSize, sortName,
                sortOrder);

    }

    @RequestMapping("save.json")
    public Map<String, Object> save (BrandInfo brandInfo){
        brandInfo.setCreateUserId(ShiroConfiguration.getUserId());
        String pid = brandService.save(brandInfo);
        return brandService.getMapOne("BRAND_INFO", pid);
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

    @RequestMapping("delete.json")
    public String delete(String pid) {
        return brandService.delete(pid);
    }

    @RequestMapping("look.json")
    public String lookPic(String pid){
        String path = (String) brandService.getMapOne("BRAND_INFO",pid).get("PIC");
        if (path == null){
            return "timg.jpg";
        }
        return path;
    }

    @RequestMapping("querysort.json")
    public List<Map<String, Object>> querySort(){
        return sortService.querySort();
    }


}
