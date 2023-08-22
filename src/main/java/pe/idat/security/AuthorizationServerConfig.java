package pe.idat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import pe.idat.service.UserService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public AuthorizationServerConfig() {		
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception 
	{
		clients.inMemory()
		       .withClient("idatApp")
		       .secret(bCryptPasswordEncoder.encode("i123"))
		       .authorizedGrantTypes("password","refresh_token")
		       .scopes("read","write")
		       .accessTokenValiditySeconds(60) //token de acceso
		       .refreshTokenValiditySeconds(4*60); //token de refresco
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception 
	{
		endpoints.authenticationManager(authenticationManager)
		         .userDetailsService((UserDetailsService)userService);
	}
}
