package sg.nus.iss.session.workshop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  static final String TODOS = "TODO_ATTRIBUTE_NAME";
  @PostMapping("/add")
  public String add(@RequestParam("todo") String todo, HttpSession sessionObj) {
    List<String> todoList = (List<String>) sessionObj.getAttribute(TODOS);
    if (todoList == null) {
      todoList = new ArrayList<>();
    }
    
    todoList.add(todo);
    sessionObj.setAttribute(TODOS, todoList);
    
    return "redirect:/list";
  }

  @GetMapping("/list")
  public String list(Model model, HttpSession sessionObj) {
    List<String> todoList = (List<String>) sessionObj.getAttribute(TODOS);
    model.addAttribute("todoList", todoList != null ? todoList : new ArrayList<>());
     
    return "todos";
  }

  @PostMapping("/clear-session")
  public String destroySession(HttpSession sessionObj) {
    sessionObj.invalidate();
    
    return "redirect:/list";
  }
}