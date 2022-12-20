package sg.edu.nus.iss.interceptor.demo.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(LoggingInterceptor.class);
  
  @Override
  public boolean preHandle(HttpServletRequest request, 
        HttpServletResponse response, Object handler) {
    LOGGER.info("LoggingInterceptor preHandle");
    LOGGER.info("[request.url] {}", request.getRequestURL());
    Enumeration<String> paramNames = request.getParameterNames();
    
    while (paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      LOGGER.info("[request.param] {} = {}", paramName, request.getParameter(paramName));
    }
    return true;
  }
  
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse 
    response, Object handler, ModelAndView modelAndView) {
    LOGGER.info("LoggingInterceptor postHandle");
  }
  
  @Override
  public void afterCompletion(HttpServletRequest request, 
    HttpServletResponse response, Object handler, Exception ex) {
    LOGGER.info("LoggingInterceptor afterCompletion");
  }
}
