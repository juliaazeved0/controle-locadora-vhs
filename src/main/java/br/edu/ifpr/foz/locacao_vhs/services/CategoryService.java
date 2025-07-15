package br.edu.ifpr.foz.locacao_vhs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpr.foz.locacao_vhs.models.Category;
import br.edu.ifpr.foz.locacao_vhs.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void save(Category categoria) {
        categoryRepository.save(categoria);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
