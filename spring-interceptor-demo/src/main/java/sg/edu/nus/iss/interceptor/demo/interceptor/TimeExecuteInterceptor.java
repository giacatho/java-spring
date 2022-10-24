package sg.edu.nus.iss.interceptor.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeExecuteInterceptor implements HandlerInterceptor {
  private static final Logger logger = 
      LoggerFactory.getLogger(TimeExecuteInterceptor.class);

  //before the actual handler will be executed
  public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response, Object handler) {
    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);
    
    return true;
  }

  //after the handler is executed
  public void postHandle(HttpServletRequest request, 
         HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    long startTime = (long)request.getAttribute("startTime");
    long endTime = System.currentTimeMillis();
    long executeTime = endTime - startTime;
    
    //modified the existing modelAndView
    modelAndView.addObject("executeTime",executeTime);
    
    // log it
    logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
  }
}
