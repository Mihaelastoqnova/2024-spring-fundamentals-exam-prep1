package com.dictionaryapp.controller;


import com.dictionaryapp.model.dto.UserRegisterDTO;
import com.dictionaryapp.service.UserSrvice;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private UserSrvice userSrvice;

    public UserController(UserSrvice userSrvice) {
        this.userSrvice = userSrvice;
    }

    @ModelAttribute("registerData")
    public UserRegisterDTO createEmptyDTO() {

        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String viewRegister() {


        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDTO data,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            //Return errors
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);

            return "redirect:/register";

        }
        //Validate Data
        //Register user

        return "redirect:/login";
    }
}
