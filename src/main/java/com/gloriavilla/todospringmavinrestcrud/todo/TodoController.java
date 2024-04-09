package com.gloriavilla.todospringmavinrestcrud.todo;

import com.gloriavilla.todospringmavinrestcrud.todo.dto.CreateTodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;



@Controller
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody CreateTodoDto dto) {
        return new ResponseEntity<>(todoService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> findOne(@PathVariable("id") Integer id) {
        Todo todo = todoService.findOne(id).orElseThrow();
        return ResponseEntity.ok(todo);
    }

}
