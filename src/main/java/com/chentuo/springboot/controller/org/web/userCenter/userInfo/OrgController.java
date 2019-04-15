package com.chentuo.springboot.controller.org.web.userCenter.userInfo;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.OrgInfo;
import com.chentuo.springboot.service.OrgService;
import com.chentuo.springboot.service.ShiroConfiguration;
import com.chentuo.springboot.service.UserService;
import com.chentuo.util.MapToBean;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@RestController
@RequestMapping("/org/web/userCenter/userInfo/org")
public class OrgController {

    @Autowired
    private OrgService orgService = null;

    /**
     * 分页
     * @param pageNumber:当前页数
     * @param searchValue:查询条件
     * @param pageSize:每页显示
     * @param sortName:排序字段
     * @param sortOrder:排序规则
     * @param startDate:按时间查询
     * @param endDate:按时间查询
     * @return:PageInfo
     */
    @RequestMapping("page.json")
    public PageInfo page(Integer pageNumber, String searchValue, Integer pageSize, String sortName, String sortOrder, String startDate, String endDate) {
        PageInfo pageInfo = orgService.getPage("ORG_INFO", pageNumber, searchValue, pageSize, sortName, sortOrder);
        for (Object o : pageInfo.getRows()) {
            Map<String, Object> map = (Map<String, Object>) o;
            if (map.get("CREATE_USER_ID") != null){
                Object creatUserName = (Object) orgService.getMapOne("ORG_INFO", map.get("CREATE_USER_ID").toString()).get("USERNAME");
                map.put("CREATE_USER_NAME", creatUserName);
            } else {
                Object creatUserName = "系统";
                map.put("CREATE_USER_NAME", creatUserName);
            }
        }
        return pageInfo;
    }

    /**
     * 新增
     * @param orgInfo:
     * @return:新增用户信息
     */
    @RequestMapping("save.json")
    public Map<String, Object> save(OrgInfo orgInfo) {

        orgInfo.setCreateUserId(ShiroConfiguration.getUserId());

        orgInfo.setPassword("202cb962ac59075b964b07152d234b70");

        String pid = orgService.save(orgInfo);

        return orgService.getMapOne("ORG_INFO", pid);

    }

    /**
     * 图片上传
     * @param file:图片
     * @return:图片全路径
     */
    @RequestMapping("uploda.json")
    public void uploadImg(@RequestParam("file") MultipartFile file, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        String name = file.getOriginalFilename();
        String a = name.substring(name.indexOf(".")+1, name.length());
        if ("jpeg".equals(a) || "png".equals(a) || "jpg".equals(a)) {
            String prefix = UUID.randomUUID().toString();
            String dfilename = prefix + name;
            try {
                String path = ResourceUtils.getURL("classpath:").getPath();
                File dfile = new File(path + "/static/upload/" + dfilename);
                file.transferTo(dfile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.put("img", dfilename);
            try {
                writeToJSON(response, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*return "{'img' : '" + dfilename + "'}";*/
        }
        map.put("img", "");
        try {
            writeToJSON(response, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeToJSON(HttpServletResponse response, Object o)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        JSONObject jsonObject= JSONObject.fromObject(o);
        out.println(jsonObject);
        out.flush();
        out.close();
    }

    /**
     * 删除
     * @param pid:删除用户的PID
     * @return:删除用户的PID
     */
    @RequestMapping("delete.json")
    public String delete(String pid) {

        return orgService.delete(pid);

    }

    /**
     * 修改USERNAME,TURENAME
     * @param orgInfo:form表单
     * @return:修改用户信息
     */
    @RequestMapping("update.json")
    public Map<String, Object> update(OrgInfo orgInfo) {

        String pid = orgService.update(orgInfo);

        return orgService.getMapOne("ORG_INFO", pid);

    }

    /**
     * 修改密码
     * @param nPassword:页面输入新密码
     * @return:'success'
     */
    @RequestMapping("upPass.json")
    public String upPassword(String nPassword){
        String password = UserService.passwordDigest(nPassword);
        String pid = ShiroConfiguration.getUserId();
        return orgService.upPassword(pid, password);
    }

    /**
     * 获取修改用户信息
     * @param pid:修改用户的PID
     * @return
     */
    @RequestMapping("detail.json")
    public Map<String, Object> detail(String pid) {

        return orgService.getMapOne("ORG_INFO", pid);

    }

    /**
     *
     * @param pid:
     * @param prevId:
     * @param nextId:
     * @return
     */
    @RequestMapping("sortOrder.json")
    public String sortOrder(String pid, String prevId, String nextId) {

        orgService.sortOrderNew("ORG_INFO", pid, prevId, nextId);

        return " { } ";

    }

    /**
     *
     * @return
     */
    @RequestMapping("list.json")
    public List<Map<String, Object>> list() {

        return orgService.getList("ORG_INFO");

    }

    /**
     * 检查用户名是否重复
     * @param username:页面输入的用户名
     * @return:'no':输入为空,'false':用户名重复,'true':用户名可用
     */
    @RequestMapping("chkusername.json")
    public String chkUsername(String username){
        if ("".equals(username)){
           return "no";
        }else {
            Map<String, Object> user = orgService.getUsernameOne("ORG_INFO", username);
            if (user == null){
                return "true";
            } else {
                return "false";
            }
        }
    }

    /**
     * 验证原密码
     * @param yPassword:页面输入的原密码
     * @return:'no':输入为空,'false':与原密码不符,'true':验证成功
     */
    @RequestMapping("chkpwd.json")
    public String chkPassword(String yPassword){
        if ("".equals(yPassword)){
            return "no";
        }else {
            String password = UserService.passwordDigest(yPassword);
            String pid = ShiroConfiguration.getUserId();
            Map<String, Object> user = orgService.getPasswordOne("ORG_INFO", password, pid);
            if (user != null && user.size() == 14){
                return "true";
            } else {
                return "false";
            }
        }
    }

    /**
     * 查看头像
     * @param pid:查看用户的PID
     * @return:'timg.jpg':无头像显示默认头像,path:头像的文件名
     */
    @RequestMapping("look.json")
    public String lookPic(String pid){
        String path = (String) orgService.getMapOne("ORG_INFO",pid).get("PIC");
        if (path == null){
            return "timg.jpg";
        }
        return path;
    }

}
