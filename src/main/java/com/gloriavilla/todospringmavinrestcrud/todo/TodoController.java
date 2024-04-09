package com.gloriavilla.todospringmavinrestcrud.todo;

import com.gloriavilla.todospringmavinrestcrud.todo.dto.CreateTodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody CreateTodoDto dto) {
        return new ResponseEntity<>(todoService.create(dto), HttpStatus.CREATED);
    }

//    private HttpStatusCode todoService(CreateTodoDto dto) {
//        return null;
//    }
}