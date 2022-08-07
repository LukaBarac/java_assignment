package com.assignment.javatask.repositories;

import com.assignment.javatask.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<PostModel, Integer> {
}
