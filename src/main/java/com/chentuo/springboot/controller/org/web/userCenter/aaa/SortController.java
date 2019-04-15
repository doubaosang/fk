package com.chentuo.springboot.controller.org.web.userCenter.aaa;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.SortInfo;
import com.chentuo.springboot.service.ShiroConfiguration;
import com.chentuo.springboot.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author 孟翔飞
 * @date 2019/3/28
 */
@RestController
@RequestMapping("/org/web/userCenter/aaa")
public class SortController {

    @Autowired
    private SortService sortService = null;

    @RequestMapping("page.json")
    public PageInfo page(Integer pageNumber,
                         String searchValue, Integer pageSize, String sortName,
                         String sortOrder, String startDate, String endDate) {
        if ("".equals(sortName)){
            sortName="TOP_PID";
        }
        PageInfo pageInfo = sortService.getPage("SORT_INFO", pageNumber,
                searchValue, pageSize, sortName,
                sortOrder);
        for (Object o : pageInfo.getRows()) {
            Map<String, Object> map = (Map<String, Object>) o;
            if (map.get("TOP_PID") != null){
                Object topName = (Object) sortService.getMapOne("SORT_INFO", map.get("TOP_PID").toString()).get("SORT_NAME");
                map.put("TOP_NAME", topName);
            } else {
                Object topName = "无";
                map.put("TOP_NAME", topName);
            }
        }
        return pageInfo;

    }

    @RequestMapping("save.json")
    public Map<String, Object> save (SortInfo sortInfo){
        sortInfo.setCreateUserId(ShiroConfiguration.getUserId());
        String pid = sortService.save(sortInfo);
        return sortService.getMapOne("SORT_INFO", pid);
    }

    @RequestMapping("delete.json")
    public String delete(String pid, String top) {

        return sortService.delete(pid, top);

    }

    @RequestMapping("chkistop.json")
    public String chkIsTop(String pid){
        Map<String, Object> sortInfo = sortService.getMapOne("SORT_INFO", pid);
        if ("0".equals(sortInfo.get("IS_TOP"))){
            return "yes";
        } else {
            return "no";
        }
    }

    @RequestMapping("querytopsort.json")
    public List<Map<String, Object>> queryTopSort(){
        return sortService.queryTopSort();
    }

    @RequestMapping("sortOrder.json")
    public String sortOrder(String pid, String prevId, String nextId) {

        sortService.sortOrderNew("SORT_INFO", pid, prevId, nextId);

        return " { } ";

    }
}
