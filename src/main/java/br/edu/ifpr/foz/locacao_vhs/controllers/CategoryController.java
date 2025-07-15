package br.edu.ifpr.foz.locacao_vhs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpr.foz.locacao_vhs.models.Category;
import br.edu.ifpr.foz.locacao_vhs.services.CategoryService;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoryService.findAll());
        return "category-list";
    }

    @GetMapping("/nova")
    public String exibirFormulario(Model model) {
        model.addAttribute("categoria", new Category());
        return "category-form";
    }

    @PostMapping("/salvar")
    public String salvarCategoria(@ModelAttribute Category categoria) {
        categoryService.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Category categoria = categoryService.findById(id);
        model.addAttribute("categoria", categoria);
        return "category-form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCategoria(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/categorias";
    }
}
