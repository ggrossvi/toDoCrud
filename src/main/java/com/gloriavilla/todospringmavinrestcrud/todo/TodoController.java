package com.gloriavilla.todospringmavinrestcrud.todo;

import com.gloriavilla.todospringmavinrestcrud.todo.dto.CreateTodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> index() {
        return ResponseEntity.ok(todoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody CreateTodoDto dto) {
        return new ResponseEntity<>(todoService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> findOne(@PathVariable("id") Integer id) {
        Todo todo = todoService.findOne(id).orElseThrow();
        return ResponseEntity.ok(todo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> update(
            @PathVariable("id") Integer id,
            @RequestBody CreateTodoDto dto
    ) {
        return new ResponseEntity<>(todoService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer todoId){
        todoService.delete(todoId);
        return ResponseEntity.ok(true);
    }

}
