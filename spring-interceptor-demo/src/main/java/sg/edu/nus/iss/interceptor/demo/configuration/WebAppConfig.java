package sg.edu.nus.iss.interceptor.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sg.edu.nus.iss.interceptor.demo.interceptor.LoggingInterceptor;
import sg.edu.nus.iss.interceptor.demo.interceptor.SecurityInterceptor;
import sg.edu.nus.iss.interceptor.demo.interceptor.TimeExecuteInterceptor;

@Component
public class WebAppConfig implements WebMvcConfigurer {
  @Autowired
  LoggingInterceptor loggingInterceptor;
  @Autowired
  SecurityInterceptor securityInterceptor;
  @Autowired
  TimeExecuteInterceptor timeExecuteInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loggingInterceptor);
//    registry.addInterceptor(securityInterceptor).
//      addPathPatterns("/customer/account/*", "/cart/checkout");
    registry.addInterceptor(timeExecuteInterceptor)
      .addPathPatterns("/time/*");
  }
}
