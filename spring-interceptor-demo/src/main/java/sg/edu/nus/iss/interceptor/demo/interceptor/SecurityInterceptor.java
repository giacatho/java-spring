package sg.edu.nus.iss.interceptor.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(SecurityInterceptor.class);
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler) {
    LOGGER.info("SecurityInterceptor preHandle");
    return true;
  }
  
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse 
    response, Object handler, ModelAndView modelAndView) {
    LOGGER.info("SecurityInterceptor postHandle");
  }
  
  @Override
  public void afterCompletion(HttpServletRequest request, 
    HttpServletResponse response, Object handler, Exception ex) {
    LOGGER.info("SecurityInterceptor afterCompletion");
  }
}
