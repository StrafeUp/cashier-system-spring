package com.strafeup.cashiersystemspring.controller;

import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.entity.Role;
import com.strafeup.cashiersystemspring.entity.UserEntity;
import com.strafeup.cashiersystemspring.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

@Log4j2
@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final AuthService authService;
    private final Map<Role, String> roleToPath = new EnumMap<>(Role.class);

    {
        roleToPath.put(Role.ADMIN, "redirect:/admin/home");
        roleToPath.put(Role.MERCHANDISER, "redirect:/merchandiser/home");
        roleToPath.put(Role.MANAGER, "redirect:/manager/home");
        roleToPath.put(Role.CASHIER, "redirect:/cashier/home");
        roleToPath.put(Role.DEFAULT, "redirect:/default/home");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity loggedUser = authService.login(user.getEmail(), user.getPassword1());
        modelAndView.addObject("user", loggedUser);
        log.info("User logged in");
        modelAndView.setViewName(roleToPath.get(loggedUser.getRole()));
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();

        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user);
        Optional<UserEntity> userExists = authService.findByEmail(user.getEmail());
        System.out.println("test1");
        if (userExists.isPresent()) {
            bindingResult.rejectValue("email", "error.user",
                    "There is already a user registered with the email provided");
            System.out.println("test2");

        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            System.out.println(bindingResult.getAllErrors());
            System.out.println("test3");

        } else {
            authService.register(user);

            modelAndView.addObject("successMessage", "User has been registered successfully");

            modelAndView.addObject("user", new User());
            log.info("User registered");
            System.out.println("test4");

            modelAndView.setViewName("redirect:login");

        }
        return modelAndView;
    }
}
