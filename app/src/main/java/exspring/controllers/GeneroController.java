package exspring.controllers;

import org.springframework.beans.factory.annotation,Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping;

import exspring.repositories.GeneroRepository;

@Controller
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepository generosRepo;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute(attributeName: "generos", this.generosRepo.findAll());
        return "list";
    }
}
