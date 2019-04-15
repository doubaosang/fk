package com.chentuo.springboot.controller.org.web.frontPage;

import com.chentuo.springboot.service.OrgService;
import com.chentuo.springboot.service.ShiroConfiguration;
import com.chentuo.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@RestController
@RequestMapping("/org/web/frontPage/passport")
public class PassportController {
    @Autowired
    private OrgService orgService;

    @RequestMapping("login.json")
    public String login(String username, String password) {
        password = UserService.passwordDigest(password);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, "org");
        try {
            subject.login(token);
        } catch (AuthenticationException e){
            return "1";
        }
        return "3";
    }

}
