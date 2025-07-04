package com.example.patas_board.repository;

import com.example.patas_board.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByUserId(int id);
}
