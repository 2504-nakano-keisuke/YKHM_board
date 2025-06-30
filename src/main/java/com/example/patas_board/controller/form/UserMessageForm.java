package com.example.patas_board.controller.form;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class UserMessageForm {
    @Id
    private int id;

    private String text;

    private String title;

    private int userId;

    private  String name;

    private  String account;

    private String category;

    private int branchId;

    private int departmentId;

    private long diffDate;

    private String diffDateUnit;

    private Date createdDate;

    private Date updatedDate;
}
