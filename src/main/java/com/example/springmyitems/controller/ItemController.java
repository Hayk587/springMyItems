package com.example.springmyitems.controller;


import com.example.springmyitems.dto.CreateItemRequest;
import com.example.springmyitems.entity.Item;
import com.example.springmyitems.entity.User;
import com.example.springmyitems.service.CategoryService;
import com.example.springmyitems.service.ItemService;
import com.example.springmyitems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;

    private CategoryService categoryService;


    @Value("${myitems.upload.path}")
    private String imagaPath;

    @GetMapping("/items")
    public String itemsPage(ModelMap map) {
        List<Item> items = itemService.findAll();
        map.addAttribute("items", items);
        return "items";
    }


    //sig en logikane or bacenq tesninq te item nkar kam urish incor ban uni ira mej
    @GetMapping("/items/byUser/{id}")
    public String itemsByUserPage(ModelMap map, @PathVariable("id") int id) {
        User user = userService.findById(id);
        List<Item> items = itemService.findAllByUser(user);
        map.addAttribute("items", items);
        return "items";
    }


    @GetMapping("/items/add")
    public String addItemPage(ModelMap map) {
        map.addAttribute("categories",categoryService.findAll());
        map.addAttribute("users", userService.findAll());
        return "saveItem";
    }


    @PostMapping("/items/add")
    public String addItem(CreateItemRequest createItemRequest, @RequestParam("pictures") MultipartFile[] uploadedFiles) throws IOException {
        itemService.addItemFromItemReuest(createItemRequest,uploadedFiles);
        return "redirect:/items";
    }


    @GetMapping("/items/{id}")
    public String singleItem(@PathVariable("id") int id, ModelMap map) {
        map.addAttribute("categories", categoryService.findAll());
        map.addAttribute("item", itemService.findById(id));
        return "singleItem";
    }
}
