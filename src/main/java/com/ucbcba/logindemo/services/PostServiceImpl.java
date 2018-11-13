package com.ucbcba.logindemo.services;

import com.ucbcba.logindemo.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ucbcba.logindemo.repositories.PostRepository;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;


    @Autowired
    @Qualifier(value = "postRepository")
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    public Post findPost(Integer id){
        Optional<Post> opt;
        opt = postRepository.findById(id);
        return opt.get();
    }

    @Override
    public void savePost(Post post) { postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id){
        postRepository.deleteById(id);
    }
}
