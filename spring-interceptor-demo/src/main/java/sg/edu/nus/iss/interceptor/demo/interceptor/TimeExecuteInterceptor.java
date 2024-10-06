package sg.edu.nus.iss.interceptor.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeExecuteInterceptor implements HandlerInterceptor {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(TimeExecuteInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response, Object handler) {
    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);
    
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, 
         HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    //System.out.println(request.getRequestURL());
    long startTime = (long) request.getAttribute("startTime");
    long completeTime = System.currentTimeMillis();
    long executeTime = completeTime - startTime;
    
    LOGGER.info("TimeExcecuteInterceptor Execution time: " + executeTime + "ms");
    
    modelAndView.addObject("completeTime", completeTime);
    modelAndView.addObject("executeTime", executeTime);
  }
}
