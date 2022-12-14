package sg.nus.iss.i18n.demo.switchlanguage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Component
public class WebMvcContextConfiguration implements WebMvcConfigurer{
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    var localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang");
    
    registry.addInterceptor(localeChangeInterceptor);
  }

  @Bean
  LocaleResolver localeResolver() {
      return new CookieLocaleResolver();
  }
  
  
}
