package com.ucsr;

import com.yourapp.dao.StudentDao;
import com.yourapp.model.Student;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView validateLogin(@RequestParam String email,
                                      @RequestParam String password,
                                      HttpSession session) {
        Student student = studentDao.validateLogin(email, password);

        if (student != null) {
            session.setAttribute("student", student);
            return new ModelAndView("redirect:/courses");
        } else {
            ModelAndView mv = new ModelAndView("login");
            mv.addObject("error", "Invalid email or password");
            return mv;
        }
    }
}
