package com.xiaoweiyunchuang.microcloud.config;

import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Maps;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * @author zhongyibiao
 * 
 */
@Configuration
public class ShiroConfiguration {

	private static Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

	@Bean(name = "userRealm")
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		userRealm.setCachingEnabled(true);
		userRealm.setAuthenticationCachingEnabled(true);
		userRealm.setAuthorizationCachingEnabled(true);
		return userRealm;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	/**
	 * 安全管理器
	 * 
	 * @return
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(userRealm);
		return manager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager);
		return aasa;
	}

	/**
	 * Shiro 的 Web 过滤器
	 * 
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setLoginUrl("/login");
		bean.setUnauthorizedUrl("/unauthor");
		bean.setSuccessUrl("/index");

		Map<String, Filter> filters = Maps.newHashMap();
		filters.put("perms", new URLPermissionsFilter());
		// filters.put("authc", rememberAuthenticationFilter());
		filters.put("anon", new AnonymousFilter());
		bean.setFilters(filters);

		Map<String, String> chains = Maps.newHashMap();
		chains.put("/login", "anon");
		chains.put("/index", "anon");
		chains.put("/", "anon");
		chains.put("/footer", "anon");
		chains.put("/header", "anon");
		chains.put("/goods", "anon");
		
		chains.put("/unauthor", "anon");
		chains.put("/logout", "logout");
		chains.put("/base/**", "anon");
		chains.put("/css/**", "anon");
		chains.put("/layer/**", "anon");
		chains.put("/validatecodeServlet", "anon");
		chains.put("/mgmt/**", "perms");
		

		// chains.put("/index", "user");
		// chains.put("/", "user");
		// chains.put("/**", "authc,perms");
		
		//chains.put("/**", "authc");

		bean.setFilterChainDefinitionMap(chains);
		return bean;
	}

	@Bean(name = "shiroDialect")
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
}
