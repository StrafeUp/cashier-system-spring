package com.strafeup.cashiersystemspring.controller;

import com.strafeup.cashiersystemspring.entity.ItemEntity;
import com.strafeup.cashiersystemspring.service.ItemService;
import com.strafeup.cashiersystemspring.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/listAll")
    public ModelAndView getAllItems(
            @RequestParam(defaultValue = "1", name = "page", required = false) String page) {

        Page<ItemEntity> itemsPage = itemService.findAll(PageUtils.parsePageNumber(page, 1));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", itemsPage);

        int totalPages = itemsPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.setViewName("items");

        return modelAndView;
    }
}
