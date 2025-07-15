package br.edu.ifpr.foz.locacao_vhs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpr.foz.locacao_vhs.models.VHS;
import br.edu.ifpr.foz.locacao_vhs.services.VHSService;
import br.edu.ifpr.foz.locacao_vhs.services.CategoryService;

@Controller
@RequestMapping("/vhs")
public class VHSController {

    @Autowired
    private VHSService vhsService;

    @Autowired
    private CategoryService categoryService;

    // Listar todas as fitas
    @GetMapping
    public String listarVHS(Model model) {
        List<VHS> vhsList = vhsService.findAll();
        model.addAttribute("vhsList", vhsList);
        // System.out.println(vhsList.get(0).getTitle());
        return "vhs-list";
    }

    // Formulário para nova fita
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("vhs", new VHS());
        model.addAttribute("categorias", categoryService.findAll());
        return "vhs-form";
    }

    // Salvar nova fita ou editar existente
    @PostMapping("/salvar")
    public String salvarVHS(@ModelAttribute VHS vhs) {
        vhsService.save(vhs);
        return "redirect:/vhs";
    }

    // Editar fita existente
    @GetMapping("/editar/{id}")
    public String editarVHS(@PathVariable Long id, Model model) {
        VHS vhs = vhsService.findById(id);
        model.addAttribute("vhs", vhs);
        model.addAttribute("categorias", categoryService.findAll());
        return "vhs-form";
    }

    // Excluir uma fita
    @GetMapping("/excluir/{id}")
    public String excluirVHS(@PathVariable Long id) {
        vhsService.deleteById(id);
        return "redirect:/vhs";
    }

    // Alterar o status da fita (DISPONIVEL, EMPRESTADA, INDISPONIVEL)
    @GetMapping("/alterar-status/{id}/{novoStatus}")
    public String alterarStatus(@PathVariable Long id, @PathVariable String novoStatus) {
        vhsService.alterarStatus(id, novoStatus);
        return "redirect:/vhs";
    }
}
