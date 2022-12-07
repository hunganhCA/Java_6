package j6.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
// 6.6 sử dụng phân quyền bằng anotation
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	Cơ chế mã hoá mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	Nguồn dữ liệu người dùng
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser("user1").password(pe.encode("123")).roles("GUEST")
			.and()
			.withUser("user2").password(pe.encode("123")).roles("GUEST", "USER")
			.and()
			.withUser("user3").password(pe.encode("123")).roles("GUEST", "USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		Tắt csrf và cros 6.2
		http.csrf().disable().cors().disable();
	
		
//		Phân quyền 6.6
		http.authorizeRequests()
			.anyRequest().permitAll();
		
//		Kiểm tra lỗi truy cập 6.5
		http.exceptionHandling()
			.accessDeniedPage("/auth/access/denied");
		
//		Hộp thoại đăng nhập 6.2
//		http.httpBasic();
		
//		Thay đổi trang đăng nhập 6.4
		http.formLogin()
			.loginPage("/auth/login/form")
			.loginProcessingUrl("/auth/login")
			.defaultSuccessUrl("/auth/login/success", false)
			.failureUrl("/auth/login/error")
			.usernameParameter("username")
			.passwordParameter("password");
		http.rememberMe()
			.rememberMeParameter("remember");
		http.logout()
			.logoutUrl("/auth/logout")
			.logoutSuccessUrl("/auth/logout/success")
			.addLogoutHandler(new SecurityContextLogoutHandler());
	}
}
