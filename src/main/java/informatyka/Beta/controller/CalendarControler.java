package informatyka.Beta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarControler {

    @RequestMapping(value =  "/user/calendar", method = RequestMethod.GET)
    public ModelAndView calendarPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/calendar");
        return modelAndView;
    }
}
