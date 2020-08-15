package informatyka.Beta.controller;

import informatyka.Beta.model.User;
import informatyka.Beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(){

        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");

        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult){

        ModelAndView modelAndView = new ModelAndView();
        User userExist = userService.findUserByEmail(user.getEmail());

        if (userExist != null){

            bindingResult
                    .rejectValue("email", "error.user",
                           "Istnieje użytkownik o podanym adresie email" );
        }

        if (bindingResult.hasErrors()){

            modelAndView.setViewName("registration");
        }
        else {

            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Użytkownik pomyślnie został zarejestrowany :)");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}
