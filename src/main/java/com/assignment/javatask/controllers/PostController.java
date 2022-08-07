package com.assignment.javatask.controllers;

import com.assignment.javatask.dto.PostDto;
import com.assignment.javatask.models.PostModel;
import com.assignment.javatask.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostRepository postRepo;

    @GetMapping("")
    public List<PostModel> getPosts(){
        return postRepo.findAll();
    }

    @PostMapping("")
    public String createPost(@RequestBody PostDto post){
        PostModel p1 = new PostModel();
        p1.setName(post.getName());
        p1.setHeader(post.getHeader());
        p1.setTag(post.getTag());
        p1.setText(post.getText());
        postRepo.save(p1);
        return "Saved...";
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable int id, @RequestBody PostDto post){
        PostModel p1 = postRepo.findById(id).get();
        p1.setName(post.getName());
        p1.setHeader(post.getHeader());
        p1.setTag(post.getTag());
        p1.setText(post.getText());
        postRepo.save(p1);
        return "Post updated!";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id){
        postRepo.deleteById(id);
        return "Deleted post with id: " + id;
    }

    @PatchMapping("/{id}/like")
    public String changeLike(@PathVariable int id){
        PostModel post = postRepo.findById(id).get();
        post.setLiked(!post.isLiked());
        postRepo.save(post);
        return "Post is successfully liked/disliked";
    }
}
