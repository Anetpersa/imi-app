package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping({"home", "/"})
    public String home() {
        return "index";
    }
    
    @RequestMapping("/403")
    public String odbijenPristup() {
        return "/403";
    }
}
