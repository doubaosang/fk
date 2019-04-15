/**
 *
 */
package com.chentuo.springboot.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@Component
public class AuthenticationRealm extends AuthorizingRealm {

    @Autowired
    private OrgService orgService = null;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String userId = null;

        String host = usernamePasswordToken.getHost();

        if (StringUtils.equals(host, "org")) {

            userId = orgService.login(username, password);

        }

        if (StringUtils.isBlank(userId)) {

            throw new IncorrectCredentialsException();

        }

        return new SimpleAuthenticationInfo(userId, password, getName());

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String userId = (String) principals.getPrimaryPrincipal();

        return null;

    }

    @Override
    public String getName() {
        return "realmService";
    }

    @Override
    public boolean supports(AuthenticationToken token) {

        return token instanceof UsernamePasswordToken;
    }

}
