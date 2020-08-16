package informatyka.Beta.controller;

import informatyka.Beta.model.User;
import informatyka.Beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/home", method = RequestMethod.GET)
    public ModelAndView home(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Witaj " + user.getName() + " " + user.getPersonId() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Twoje dane dostępne są tylko po zalogowaniu na Twoje konto :)");
        modelAndView.setViewName("user/home");
        return modelAndView;
    }
}
