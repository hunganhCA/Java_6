package j6.demo7.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import j6.demo7.entities.Account;
import j6.demo7.repositories.AccountRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepo;
	private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println(username);
		try {
			Account account = accountRepo.findById(username).get();
			String password = account.getPassword();
			String[] roles = account.getAuthorities().stream().map(au -> au.getRole().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username).password(pe.encode(password)).roles(roles).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username + "không tồn tại");
		}
	}

	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
		String email = oauth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());

		UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("GUEST").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
