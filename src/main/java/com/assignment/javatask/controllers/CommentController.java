package com.assignment.javatask.controllers;

import com.assignment.javatask.dto.CommentDto;
import com.assignment.javatask.models.CommentModel;
import com.assignment.javatask.models.PostModel;
import com.assignment.javatask.repositories.ICommentRepository;
import com.assignment.javatask.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private ICommentRepository commentRepo;

    @Autowired
    private IPostRepository postRepo;


    @GetMapping(value = "")    // ne mora da stoji value =
    public List<CommentModel> getComments(){
        return commentRepo.findAll();

    }

    @PostMapping("")
        public String createComment(@RequestBody CommentDto comment){
        PostModel p1 = postRepo.findById(comment.getPost_id()).get();
        CommentModel c1 = new CommentModel();
        c1.setName(comment.getName());
        c1.setText(comment.getText());
        Set<CommentModel> comments = p1.getComments();
        comments.add(c1);
        p1.setComments(comments);
        postRepo.save(p1);
        return "saved!";

    }

    @PutMapping("/{id}")
    public String updateComment(@PathVariable int id, @RequestBody CommentDto comment){
        CommentModel c1 = commentRepo.findById(id).get();
        c1.setName(comment.getName());
        c1.setText(comment.getText());
        commentRepo.save(c1);
        return "Saved comment!";

    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable int id){
        commentRepo.deleteById(id);
        return "Comment " + id + " has been deleted";
    }
}
