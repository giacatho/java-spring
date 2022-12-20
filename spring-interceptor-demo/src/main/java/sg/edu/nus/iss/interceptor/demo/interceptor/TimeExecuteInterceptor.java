package sg.edu.nus.iss.interceptor.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeExecuteInterceptor implements HandlerInterceptor {
  public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response, Object handler) {
    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);
    
    return true;
  }

  public void postHandle(HttpServletRequest request, 
         HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    long startTime = (long) request.getAttribute("startTime");
    long endTime = System.currentTimeMillis();
    long executeTime = endTime - startTime;
    
    System.out.println("Add extra executeTime: " + executeTime);
    modelAndView.addObject("executeTime", executeTime);
  }
}
