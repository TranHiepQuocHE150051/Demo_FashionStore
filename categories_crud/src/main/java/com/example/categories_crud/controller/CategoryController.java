package com.example.categories_crud.controller;

import com.example.categories_crud.model.categories;
import com.example.categories_crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
@Autowired
private CategoryService service ;

    @RequestMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("cateList", service.getAllCategory());
        return "index";
    }

    @GetMapping("/add_cate")
    public String add(Model model){
        categories cate = new categories();
        model.addAttribute("cate",cate);
        return "add_cate";
    }

    @PostMapping("/add_cate")
    public String save_add(@ModelAttribute("cate") categories cate, Model model){
            cate.setName(cate.getName());
            service.saveCate(cate);
        return "redirect:/";
    }
    @GetMapping("/update_cate/{id}")
    public String update(Model model,@PathVariable(name = "id") int id){
        categories cate = service.getCatebyId(id);
        model.addAttribute("cate",cate);
        return "update_cate";
    }

    @PostMapping("/update_cate")
    public String save_update(@ModelAttribute("cate") categories cate){
        service.saveCate(cate);
        return "redirect:/";
    }
    @RequestMapping("/delete_cate/{id}")
    public String deleteCate(@PathVariable(name = "id") int id){
        service.deleteCate(id);
        return "redirect:/";
    }
}
