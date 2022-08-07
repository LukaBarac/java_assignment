package com.assignment.javatask.repositories;

import com.assignment.javatask.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<CommentModel, Integer> {
}
