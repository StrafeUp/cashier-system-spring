package com.strafeup.cashiersystemspring.controller;

import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.service.UserService;
import com.strafeup.cashiersystemspring.util.PageUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {

    private final UserService userService;

    @GetMapping("/home")
    public String adminpage(){
        return "redirect:/items/listAll";
    }

    @GetMapping("/users")
    public ModelAndView getUsers(@RequestParam(defaultValue = "1", name = "page", required = false) String page) {

        Page<User> usersPage = userService.findAll(PageUtils.parsePageNumber(page, 1));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", usersPage);

        int totalPages = usersPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.setViewName("users");

        return modelAndView;
    }
}
