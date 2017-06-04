package com.xiaoweiyunchuang.microcloud.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiaoweiyunchuang.microcloud.domain.Permission;
import com.xiaoweiyunchuang.microcloud.domain.Role;
import com.xiaoweiyunchuang.microcloud.domain.User;
import com.xiaoweiyunchuang.microcloud.service.UserService;

/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	public UserRealm() {
		setName("UserRealm");
		// 采用MD5加密
		//setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
	}

	// 权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		String username = (String) principals.getPrimaryPrincipal();
		User user = new User();
		user.setAccount(username);
		user = userService.findUserRolesAndPermissions(user);

		Set<String> roles = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();

		List<Role> rs = user.getRoles();
		for(Role r : rs){
			roles.add(r.getRole());
			for(Permission p : r.getPermissions()){
				if (StringUtils.isNotEmpty(p.getPermission())) {
					permissions.add(p.getPermission());
				}
			}
		}

		// add Roles String[Set<String> roles]
		info.setRoles(roles);
		// add Permission Resources
		info.setStringPermissions(permissions);
		return info;
	}

	// 登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userName = upt.getUsername();
		User user = userService.findUserByAccount(userName);
		if (user == null) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
		return info;

	}
}