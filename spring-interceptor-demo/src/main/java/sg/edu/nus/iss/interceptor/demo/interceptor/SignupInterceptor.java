package sg.edu.nus.iss.interceptor.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class SignupInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, 
         HttpServletResponse response, Object handler) throws Exception {

    String emailAddress = request.getParameter("emailaddress");
    String password = request.getParameter("password");

    if(!StringUtils.hasLength(emailAddress) ||             
        StringUtils.containsWhitespace(emailAddress) ||
        !StringUtils.hasLength(password) || 
        StringUtils.containsWhitespace(password)) {
      throw new Exception("Invalid Email Address or Password. " +
                           "Please try again.");
    }

    return true;
  }
}
