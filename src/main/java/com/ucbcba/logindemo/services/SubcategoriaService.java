package com.ucbcba.logindemo.services;

import com.ucbcba.logindemo.entities.Subcategoria;

public interface SubcategoriaService {
    Iterable<Subcategoria> listAllSubcategorias();
    Subcategoria findSubcategoria(Integer id);
    void saveSubcategoria(Subcategoria subcategoria);
    void deleteSubcategoria(Integer id);
}
