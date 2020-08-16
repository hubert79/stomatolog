package informatyka.Beta.controller;

import informatyka.Beta.model.User;
import informatyka.Beta.repository.UserRepository;
import informatyka.Beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Transfer {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/transfer.html", method = RequestMethod.GET)
    public ModelAndView wireTransfer(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("userName", "Witaj " + user.getName() + " " + user.getPersonId() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Twoje dane dostępne są tylko po zalogowaniu na Twoje konto :)");
        modelAndView.setViewName("user/transfer");
        return modelAndView;
    }

    /*
    @PostMapping("transferdo")
    public void doTransfer(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        user.setSaldo(user.getSaldo() - 444);

    }*/
}
