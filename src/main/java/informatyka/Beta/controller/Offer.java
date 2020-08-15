package informatyka.Beta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Offer {

    @RequestMapping(value =  "/offer", method = RequestMethod.GET)
    public ModelAndView indexPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oferta");
        return modelAndView;
    }
}
