package sg.nus.iss.interceptor.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sg.nus.iss.interceptor.workshop.interceptor.SecurityInterceptor;

@Component
public class WebAppConfig implements WebMvcConfigurer {
  @Autowired
  SecurityInterceptor securityInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // This interceptor only takes care of the URL paths stated below
    registry.addInterceptor(securityInterceptor)
            .addPathPatterns("/product/*", 
                              "/account/*");

  }
}
