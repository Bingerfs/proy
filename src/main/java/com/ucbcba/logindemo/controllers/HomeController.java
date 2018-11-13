package com.ucbcba.logindemo.controllers;


import com.ucbcba.logindemo.entities.Subcategoria;
import com.ucbcba.logindemo.services.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    SubcategoriaService subcategoriaService;

    @Autowired
    public void setSubcategoriaService(SubcategoriaService subcategoriaservice) {
        this.subcategoriaService = subcategoriaservice;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String registrationInit() {
        return "home";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Subcategoria> subcategorias = (List) subcategoriaService.listAllSubcategorias();
        String username=user.getUsername();
        String rol=user.getAuthorities().toString();
        model.addAttribute("username", username);
        model.addAttribute("rol", rol);
        model.addAttribute("subcategorias", subcategorias);
        return "welcome";
    }
}
