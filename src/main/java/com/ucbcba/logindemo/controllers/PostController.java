package com.ucbcba.logindemo.controllers;

import com.ucbcba.logindemo.entities.Post;
import com.ucbcba.logindemo.entities.Subcategoria;
import com.ucbcba.logindemo.services.PostService;
import com.ucbcba.logindemo.services.SubcategoriaService;
import com.ucbcba.logindemo.services.UserService;
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
public class PostController {
    PostService postService;
    UserService userService;
    SubcategoriaService subcategoriaService;

    @Autowired
    public void setPostService(PostService postservice) {
        this.postService = postservice;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSubcategoriaService(SubcategoriaService subcategoriaService) {
        this.subcategoriaService = subcategoriaService;
    }


        @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String index(Model model) {
        List<Post> posts = (List) postService.listAllPosts();
        model.addAttribute("posts", posts);
        return "post/posts";
    }

    @RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        Post post = postService.findPost(id);
        model.addAttribute("post", post);
        return "editPost";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model) {
        Post post = postService.findPost(id);
        model.addAttribute("post", post);
        return "showPost";
    }

    @RequestMapping(value = "/post/new", method = RequestMethod.GET)
    public String newPost(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Subcategoria> subcategorias=(List) subcategoriaService.listAllSubcategorias();
        model.addAttribute("post", new Post());
        Object currentUser=userService.findByUsername(user.getUsername());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("subcategorias", subcategorias);
        return "post/newPost";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String create(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors())
        {
            System.out.println(bindingResult.getAllErrors().toString());
            return "post/newpost";
        }
        postService.savePost(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/post/delete/{id}")
    public String delete(@PathVariable Integer id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
