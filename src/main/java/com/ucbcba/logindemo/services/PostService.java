package com.ucbcba.logindemo.services;

import com.ucbcba.logindemo.entities.Post;

public interface PostService {
    Iterable<Post> listAllPosts();
    Post findPost(Integer id);
    void savePost(Post post);
    void deletePost(Integer id);
}
