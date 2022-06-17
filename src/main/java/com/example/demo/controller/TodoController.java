package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/cache")
    public void testCache() {
        log.info("before");
        TodoEntity todo = service.get("ff80808181676a4f0181676b63bc0000");
        System.out.println(todo.getComment());
        System.out.println(todo.getId());
        log.info("get Todo");

        TodoEntity todo2 = service.get("ff80808181676a4f0181676b63bc0000");
        System.out.println(todo.getComment());
        System.out.println(todo.getId());
        log.info("get Todo");

        TodoEntity todo3 = service.get("ff80808181676a4f0181676b63bc0000");
        System.out.println(todo.getComment());
        System.out.println(todo.getId());
        log.info("get Todo");
    }
    @GetMapping
    public String GetTodoAll() {
        // DB에서 todo항목을 모두 가져온다.
        return "[Get]TodoALL";
    }

    @GetMapping("/{id}")
    public String GetTodoWithPath(@PathVariable(required = true) int id) {
        // DB에서 id에 해당하는 todo항목을 가져온다.
        return "[Get]Just read Todo No." + id + " by PathVar";
    }

    @PostMapping
    public String PostTodo() {
        // form에서 입력받은 정보로 todo항목을 생성해 DB에 넣는다.
        return "[Post]Just create new Todo";
    }
    @PutMapping
    public String PutTodo(@RequestParam(required = true) int id) {
        // DB에서 id에 해당하는 todo항목을 수정하여 갱신한다.
        return "[Put]Just Update Todo No." + id;
    }
    @DeleteMapping
    public String DeleteTodo(@RequestParam(required = true) int id) {
        // DB에서 id에 해당하는 todo항목을 삭제한다.
        return "[Delete]Just Delete Todo No." + id;
    }
}
