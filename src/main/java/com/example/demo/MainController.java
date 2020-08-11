package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MainController {
    private TodoRepository repository;

    public MainController(TodoRepository repository){
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/all")
    List<Todo> all() {
        return (List<Todo>) repository.findAll();
    }

    @PostMapping("/add")
        Todo addTodo(@RequestBody Todo  newTodo){
        return  repository.save(newTodo);
    }

    // Sing item

    @GetMapping("/{id}")
    Todo one(@PathVariable Long id){

        return repository.findById(id)
                .orElseThrow(() ->  new TodoNotFoundException(id));
    }

    @PutMapping("/{id}")
    Todo replaceTodo(@RequestBody Todo newTodo, @PathVariable Long id){

        return repository.findById(id)
        .map(todo ->{
            todo.setTitle(newTodo.getTitle());
            todo.setCompleted(newTodo.isCompleted());
            return repository.save(todo);
        })
        .orElseGet(() -> {
            newTodo.setId(id);
            return repository.save(newTodo);
        });
    }


    @DeleteMapping("/{id}")
    void deleteTodo(@PathVariable Long id){
        repository.deleteById(id);
    }

}
