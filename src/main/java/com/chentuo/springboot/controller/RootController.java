package com.chentuo.springboot.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UrlPathHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@Controller
@EnableAutoConfiguration
@ComponentScan
public class RootController {

    @RequestMapping("**/*.htm")
    public String dynamic(HttpServletRequest request,
                          HttpServletResponse response) {

        String uri = getURI(request);

        if (StringUtils.isBlank(uri)) {

            return "index";

        }

        uri = StringUtils.substring(uri, 1, uri.length());

        uri = StringUtils.replace(uri, ".htm", "");

        return uri;

    }

    public static String getURI(HttpServletRequest request) {
        UrlPathHelper helper = new UrlPathHelper();
        String uri = helper.getOriginatingRequestUri(request);
        String ctx = helper.getOriginatingContextPath(request);
        if (!StringUtils.isBlank(ctx)) {
            uri= uri.substring(ctx.length());
        }
        //跨路径伪请求
        if(uri.contains("../")||uri.contains("..\\")){
            return "";
        }
        return uri;
    }

}
