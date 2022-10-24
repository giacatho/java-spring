package sg.edu.nus.iss.interceptor.demo.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticationInterceptor implements HandlerInterceptor {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(AuthenticationInterceptor.class);

  //intercept request before it reaches the controller
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    LOGGER.info("Intercepting: " + request.getRequestURI());

      //get session from request
      HttpSession session = request.getSession();
      LOGGER.info(session.getAttribute("loginUser").toString());

      //check if user already have set attribute userLogin
      if (session.getAttribute("userLogin") != null)
          return true;

      String[] splitURI = request.getRequestURI().split("/");
      if (splitURI[splitURI.length - 1].equals("login"))
          return true;

      //if user is not logged in we redirect him to login
      LOGGER.info("redirect to secure/login");
      response.sendRedirect("login");
      return false;
  }
}
