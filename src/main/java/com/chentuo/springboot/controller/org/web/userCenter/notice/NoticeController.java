package com.chentuo.springboot.controller.org.web.userCenter.notice;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.NoticeInfo;
import com.chentuo.springboot.service.NoticeLogService;
import com.chentuo.springboot.service.NoticeService;
import com.chentuo.springboot.service.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@RestController
@RequestMapping("/org/web/userCenter/notice/noticePage")
public class NoticeController {
    @Autowired
    private NoticeService noticeService = null;

    @Autowired
    private NoticeLogService noticeLogService = null;

    @RequestMapping("page.json")
    public PageInfo page(Integer pageNumber,
                         String searchValue, Integer pageSize, String sortName,
                         String sortOrder, String startDate, String endDate, HttpSession httpSession) {

        return noticeService.getPage(ShiroConfiguration.getUserId(), pageNumber,
                searchValue, pageSize, sortName,
                sortOrder,startDate, endDate);

    }

    @RequestMapping("detail.json")
    public Map<String, Object> detail(String pid) {

        return noticeService.getMapOne(pid, ShiroConfiguration.getUserId());

    }

    @RequestMapping("delete.json")
    public String delete(String pid) {

        return noticeService.delete(pid);

    }

    @RequestMapping("sortOrder.json")
    public String sortOrder(String pid, String prevId, String nextId) {

        noticeService.sortOrderNew("NOTICE_INFO", pid, prevId, nextId);

        return " { } ";

    }

    @RequestMapping("list.json")
    public List<Map<String, Object>> list() {

        return noticeService.getList("NOTICE_INFO");

    }

    @RequestMapping("save.json")
    public Map<String, Object> save(NoticeInfo noticeInfo) {

        noticeInfo.setCreateUserId(ShiroConfiguration.getUserId());

        String pid = noticeService.save(noticeInfo);

        return noticeService.getMapOne(pid, ShiroConfiguration.getUserId());

    }

    @RequestMapping("update.json")
    public Map<String, Object> update(NoticeInfo noticeInfo) {

        String pid = noticeService.update(noticeInfo);

        return noticeService.getMapOne(pid, ShiroConfiguration.getUserId());

    }

    @RequestMapping("readLogPage.json")
    public PageInfo readLogPage(String pid, Integer pageNumber, String searchValue, Integer pageSize, String sortName, String sortOrder, String startDate, String endDate) {

        return noticeLogService.getPage(pid, pageNumber, searchValue, pageSize, sortName, sortOrder,startDate, endDate);
    }

}
