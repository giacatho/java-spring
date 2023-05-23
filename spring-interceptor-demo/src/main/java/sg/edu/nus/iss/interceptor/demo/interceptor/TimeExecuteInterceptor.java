package sg.edu.nus.iss.interceptor.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeExecuteInterceptor implements HandlerInterceptor {
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
    System.out.println(request.getRequestURL());
    long startTime = (long) request.getAttribute("startTime");
    long endTime = System.currentTimeMillis();
    long executeTime = endTime - startTime;
    
    System.out.println("(Interceptor) Add extra executeTime: " + executeTime);
    modelAndView.addObject("executeTime", executeTime);
  }
}
