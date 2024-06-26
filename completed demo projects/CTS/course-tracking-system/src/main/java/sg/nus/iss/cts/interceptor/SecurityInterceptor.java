package sg.nus.iss.cts.interceptor;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sg.nus.iss.cts.exception.UnauthorizedException;
import sg.nus.iss.cts.model.UserSession;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, 
                           HttpServletResponse response, Object handler) 
                               throws IOException, UnauthorizedException {
    System.out.println("Intercepting " + request.getRequestURI());
    
    String uri = request.getRequestURI();
    if (uri.startsWith("/css/") || uri.startsWith("/image/")) {
      return true;
    }
    
    if (uri.equalsIgnoreCase("/") || uri.equalsIgnoreCase("/home") 
              || uri.equalsIgnoreCase("/login")
              || uri.equalsIgnoreCase("/about")) {
      return true;
    }
    
    if (uri.startsWith("/home/")) {
      return true;
    }
    
    HttpSession session = request.getSession();
    UserSession userSession = (UserSession) session.getAttribute("usession");
    if (userSession == null) {
      // No username, meaning not logged in yet
      // Redirect to login page
      response.sendRedirect("/login");
      return false;
    }
    
    List<String> userRoles = userSession.getUser().getRoleIds();
    
    if (uri.startsWith("/admin") && !userRoles.contains("admin")) {
      throw new UnauthorizedException();
    }
    
    if (uri.startsWith("/staff") && !userRoles.contains("staff")) {
      throw new UnauthorizedException();
    }
    
    
    // OK, forward to Controller
    return true;
  }
}
