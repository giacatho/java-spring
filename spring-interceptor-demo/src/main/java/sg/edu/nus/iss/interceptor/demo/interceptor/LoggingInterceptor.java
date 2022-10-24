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
  public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler) {
    LOGGER.info("LoggingInterceptor preHandle");
    LOGGER.debug("[request.url] {}", request.getRequestURL());
    Enumeration enu = request.getParameterNames();
    String strName;

    while (enu.hasMoreElements()) {
      strName= (String) enu.nextElement();
      LOGGER.debug("[request.param] {} = {}",strName, request.getParameter(strName));
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
