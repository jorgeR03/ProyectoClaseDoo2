package co.edu.uco.tiendaonline.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServerletInitializer extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application) {
		return application.sources(TiendaOnlineApplication.class);
	}

}
