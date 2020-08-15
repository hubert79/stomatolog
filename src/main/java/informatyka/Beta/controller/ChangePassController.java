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
public class ChangePassController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/changePassForm.html", method = RequestMethod.GET)
    public ModelAndView wireTransfer(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("userName", "Witaj " + user.getName() + " " + user.getPersonId() + " (" + user.getEmail() + ")");
        modelAndView.setViewName("user/changePassForm");
        return modelAndView;
    }
}
