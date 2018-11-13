package com.ucbcba.logindemo.repositories;

import com.ucbcba.logindemo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PostRepository extends JpaRepository<Post, Integer>{

}
