package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @GetMapping
    public String GetTodoAll() {
        // DB에서 todo항목을 모두 가져온다.
        return "[Get]TodoALL";
    }
//    @GetMapping
//    public String GetTodo(@RequestParam(required = true) int id) {
//        // DB에서 todo항목을 하나 가져온다.
//        return "[Get]Just read Todo No." + id + " by Param";
//    }

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
    @PatchMapping
    public String PatchTodo(@RequestParam(required = true) int id) {
        // DB에서 id에 해당하는 todo항목을 수정하여 갱신한다.
        return "[Patch]Just Update Todo No." + id;
    }
    @DeleteMapping
    public String DeleteTodo(@RequestParam(required = true) int id) {
        // DB에서 id에 해당하는 todo항목을 삭제한다.
        return "[Delete]Just Delete Todo No." + id;
    }
}
