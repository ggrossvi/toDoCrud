package com.gloriavilla.todospringmavinrestcrud.todo;

import com.gloriavilla.todospringmavinrestcrud.todo.dto.CreateTodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo create(CreateTodoDto dto) {
        Todo todo = new Todo();
        todo.setTitle(dto.getTitle());
        todo.setStatus(dto.getStatus());
        return todoRepository.save(todo);
    }

    public Todo update(Integer id, CreateTodoDto dto) {
        Todo todo = findOne(id).orElseThrow();
        todo.setId(id);
        todo.setTitle(dto.getTitle());
        todo.setStatus(dto.getStatus());
        return todoRepository.save(todo);
    }

    public Optional<Todo> findOne(Integer id) {
        return todoRepository.findById(id);
    }

    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }

}
