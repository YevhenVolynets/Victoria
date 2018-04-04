package ua.victoria.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.entity.UserRole;
import ua.victoria.app.repository.UserRepository;

@SpringBootApplication
public class VictoriaProjectApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(VictoriaProjectApplication.class, args);
		addAdmin(context);
	} 

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(VictoriaProjectApplication.class);
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {
		String adminEmail = "volynetstest@gmail.com";
		String adminPassword = "qwerty";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByEmail(adminEmail);
		
		if(entity == null) {
			
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setEmail(adminEmail);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setUserRole(UserRole.ROLE_ADMIN);
			entity.setActivated(true);
			
			userRepository.save(entity);
		}
	}
	
}
