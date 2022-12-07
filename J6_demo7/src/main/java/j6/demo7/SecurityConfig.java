package j6.demo7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import j6.demo7.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		Tắt csrf và cros
		http.csrf().disable().cors().disable();

//		Phân quyền
		http.authorizeRequests()
			.antMatchers("/home/admins").hasRole("ADMIN")
			.antMatchers("/home/users").hasAnyRole("ADMIN", "USER")
			.antMatchers("/home/authenticated").authenticated()
			.anyRequest().permitAll();
		
//		Kiểm tra lỗi truy cập
		http.exceptionHandling()
			.accessDeniedPage("/auth/access/denied");

//		Thay đổi trang đăng nhập
		http.formLogin()
			.loginPage("/auth/login/form")
			.loginProcessingUrl("/auth/login")
			.defaultSuccessUrl("/auth/login/success", false)
			.failureUrl("/auth/login/error")
			.usernameParameter("username")
			.passwordParameter("password");
		
		http.rememberMe()
			.rememberMeParameter("remember");
		
//		Đăng xuất
		http.logout()
			.logoutUrl("/auth/logout")
			.logoutSuccessUrl("/auth/logout/success")
			.addLogoutHandler(new SecurityContextLogoutHandler());
		
//		Đăng nhập bằng MXH
		http.oauth2Login()
			.loginPage("/auth/login/form")
			.defaultSuccessUrl("/oauth2/login/success")
			.failureUrl("/auth/login/error")
			.authorizationEndpoint()
			.baseUri("/oauth2/authorization");
	}
}
