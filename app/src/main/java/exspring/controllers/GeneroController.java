package exspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exspring.models.Genero;
import exspring.repositories.GeneroRepository;

@Controller
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepository generosRepo;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("generos", this.generosRepo.findAll());
        return "list";
    }

    @RequestMapping("insert")
    public String insert(){
        return "insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);
        this.generosRepo.save(genero);
        return "redirect:/generos/list";
    }
}   
