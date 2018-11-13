package com.ucbcba.logindemo.controllers;

import com.ucbcba.logindemo.entities.Subcategoria;
import com.ucbcba.logindemo.services.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SubcategoriaController {
    SubcategoriaService subcategoriaService;

    @Autowired
    public void setSubcategoriaService(SubcategoriaService subcategoriaservice) {
        this.subcategoriaService = subcategoriaservice;
    }

    @RequestMapping(value = "/subcategorias", method = RequestMethod.GET)
    public String index(Model model) {
        List<Subcategoria> subcategorias = (List) subcategoriaService.listAllSubcategorias();
        model.addAttribute("subcategorias", subcategorias);
        return "subcategoria/subcategorias";
    }

    @RequestMapping(value = "/subcategoria/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        Subcategoria subcategoria = subcategoriaService.findSubcategoria(id);
        model.addAttribute("subcategoria", subcategoria);
        return "editSubcategoria";
    }

    @RequestMapping(value = "/subcategoria/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model) {
        Subcategoria subcategoria = subcategoriaService.findSubcategoria(id);
        model.addAttribute("subcategoria", subcategoria);
        return "showSubcategoria";
    }

    @RequestMapping(value = "/subcategoria/new", method = RequestMethod.GET)
    public String newSubcategoria(Model model) {
        model.addAttribute("subcategoria", new Subcategoria());
        return "subcategoria/newSubcategoria";
    }

    @RequestMapping(value = "/subcategoria", method = RequestMethod.POST)
    public String create(@ModelAttribute("subcategoria") @Valid Subcategoria subcategoria, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors())
            return "subcategoria/newSubcategoria";
        subcategoriaService.saveSubcategoria(subcategoria);
        return "redirect:/subcategorias";
    }

    @RequestMapping(value = "/subcategoria/delete/{id}")
    public String delete(@PathVariable Integer id) {
        subcategoriaService.deleteSubcategoria(id);
        return "redirect:/subcategorias";
    }
}
