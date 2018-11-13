package com.ucbcba.logindemo.services;

import com.ucbcba.logindemo.entities.Subcategoria;
import com.ucbcba.logindemo.repositories.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService{
    SubcategoriaRepository subcategoriaRepository;


    @Autowired
    @Qualifier(value = "subcategoriaRepository")
    public void setSubcategoriaRepository(SubcategoriaRepository subcategoriaRepository) {
        this.subcategoriaRepository = subcategoriaRepository;
    }

    @Override
    public Iterable<Subcategoria> listAllSubcategorias() {
        return subcategoriaRepository.findAll();
    }

    public Subcategoria findSubcategoria(Integer id){
        Optional<Subcategoria> opt;
        opt = subcategoriaRepository.findById(id);
        return opt.get();
    }

    @Override
    public void saveSubcategoria(Subcategoria subcategoria) { subcategoriaRepository.save(subcategoria);
    }

    @Override
    public void deleteSubcategoria(Integer id){
        subcategoriaRepository.deleteById(id);
    }
}
