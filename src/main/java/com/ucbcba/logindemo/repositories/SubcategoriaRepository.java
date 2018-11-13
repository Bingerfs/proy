package com.ucbcba.logindemo.repositories;

import com.ucbcba.logindemo.entities.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer>{
}
