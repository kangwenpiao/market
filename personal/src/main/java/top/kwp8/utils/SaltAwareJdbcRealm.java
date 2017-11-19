package top.kwp8.utils;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import top.kwp8.entity.Admin;
import top.kwp8.service.AdminService;

public class SaltAwareJdbcRealm extends JdbcRealm {

	private static final Logger log = LoggerFactory.getLogger(SaltAwareJdbcRealm.class);
	@Autowired
	private AdminService adminService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();

		// Null username is invalid
		if (StringUtils.isBlank(username)) {
			throw new AccountException("用户名为空");
		}
		AuthenticationInfo info = null;
		try {

			String password = getPasswordForUser(username);

			if (StringUtils.isBlank(password)) {
				throw new UnknownAccountException("用户名不存在");
			}

			SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(username, password, getName());
			/**
			 * This (very bad) example uses the username as the salt in this sample app. DON'T DO THIS IN A REAL APP!
			 * 
			 * Salts should not be based on anything that a user could enter (attackers can exploit this). Instead they should ideally be cryptographically-strong randomly generated numbers.
			 */
			saInfo.setCredentialsSalt(ByteSource.Util.bytes(username));

			info = saInfo;

		} catch (SQLException e) {
			final String message = "There was a SQL error while authenticating user [" + username + "]";
			if (log.isErrorEnabled()) {
				log.error(message, e);
			}
			// Rethrow any SQL errors as an authentication exception
			throw new AuthenticationException(message, e);
		}
		return info;
	}

	/**
	 * 根据用户名判断用户是否存在
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	private String getPasswordForUser(String username) throws SQLException {
		Admin admin = adminService.selectByName(username);
		if (admin != null) {
			return admin.getPassword();
		}
		return null;
	}

}
