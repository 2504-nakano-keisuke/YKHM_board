package com.example.patas_board.controller.form;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class UserCommentForm {

    @Id
    private int id;

    private String text;

    private int userId;

    private int messageId;

    private  String name;

    private  String account;

    private  int branchId;

    private Date createdDate;

    private Date updatedDate;
}
