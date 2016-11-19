package DreamDiary.config;

import org.springframework.security.web.context.*;

//Initializes security configurations.
public class SecurityWebApplicationInitializer
      extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}