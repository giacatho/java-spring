package sg.edu.nus.iss.interceptor.demo.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticationInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws IOException {
    System.out.println("Intercepting: " + request.getRequestURI());

    HttpSession session = request.getSession();

    // Check if the user already has set attribute userLogin
    if (session.getAttribute("userLogin") != null)
      return true;

    String[] splitURI = request.getRequestURI().split("/");
    if (splitURI[splitURI.length - 1].equals("login"))
      return true;

    // If the user has not logged in, redirect her/him to login
    response.sendRedirect("login");
    return false;
  }
}
