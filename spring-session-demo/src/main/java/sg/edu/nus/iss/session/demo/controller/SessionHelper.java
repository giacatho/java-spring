package sg.edu.nus.iss.session.demo.controller;

import jakarta.servlet.http.HttpSession;

public class SessionHelper {
  public static boolean isLoggedIn(HttpSession sessionObj) {
    String username = (String) sessionObj.getAttribute("username");
    return username != null;
  }
}
