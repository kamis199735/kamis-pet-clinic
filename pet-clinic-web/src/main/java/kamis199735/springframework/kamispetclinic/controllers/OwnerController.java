package kamis199735.springframework.kamispetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"/","", "/index", "/index.html"})
    private String listOwners(){
        return "owners/index";
    }

}
