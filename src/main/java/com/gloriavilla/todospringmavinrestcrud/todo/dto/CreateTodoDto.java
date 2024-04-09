package com.gloriavilla.todospringmavinrestcrud.todo.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateTodoDto {
    private String title;
    private String status;
}
