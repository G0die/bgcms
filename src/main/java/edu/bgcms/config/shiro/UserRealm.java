package edu.bgcms.config.shiro;

import edu.bgcms.dao.PermissionMapper;
import edu.bgcms.dao.RoleMapper;
import edu.bgcms.dao.UserMapper;
import edu.bgcms.model.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 自定义Realm
 * @author lenovo
 *
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermissionMapper permissionMapper;
	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("执行授权逻辑");
		
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//添加资源的授权字符串
		//info.addStringPermission("user:add");
		//到数据库查询当前登录用户的授权字符串
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		User dbUser = userMapper.selectByPrimaryKey(user.getUuid());
		List<String> roles = roleMapper.selectByUser(user.getUuid());
		List<String> permissions = new ArrayList<>();
		if(roles != null&& roles.size()>0) {
			permissions = permissionMapper.selectByUser(roles);
//			LinkedHashMap
			info.setStringPermissions(new HashSet<>(permissions));
			info.setRoles(new HashSet<>(roles));
		}
		return info;
	}
	


	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
		//编写shiro判断逻辑，判断用户名和密码
		//1.判断用户名
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
		User user = userMapper.checkLogin(token.getUsername());
		if(user==null){
			//用户名不存在
			return null;//shiro底层会抛出UnKnowAccountException
		}
		/**
		 * user.getPwd()是从数据库查出的密码
		 * 会与subject.login(token);token中的密码进行校验
		 * SimpleAuthenticationInfo()中第一和第三参数不重要 作用目前不明确
		 */
		//2.判断密码
		return new SimpleAuthenticationInfo(user,user.getPwd(),"");
	}

}
