package com.example.demo.service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService() {
        TodoEntity entity = TodoEntity.builder().comment("Cleaning my room").build();
        repository.save(entity);
        TodoEntity savedEntity = repository.findById(entity.getId()).get();
        return savedEntity.getComment();
    }

    @Cacheable(value = "todo")
    public TodoEntity get(final String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("there's no todo item"));
    }
    
    @CachePut(value = "todo", key = "#todo.id") // cache된 데이터를 수정한
    public TodoEntity update(TodoEntity todo) {
        if (repository.existsById(todo.getId()))
            return repository.save(todo);
        throw new IllegalStateException("There's no id in todo");
    }

    @CacheEvict(value = "todo", key = "#id") // Cache된 데이터 삭제
    public void delete(String id) {
        repository.deleteById(id);
    }

}

//======================