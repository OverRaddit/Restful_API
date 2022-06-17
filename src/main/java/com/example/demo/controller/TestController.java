package com.example.demo.controller;

import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController // 리턴된 오브젝트를 JSON으로 바꾸고 HttpResponse에 담아 반환한다
@Controller
@RequestMapping("test")
public class TestController {
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody(required = true) TestRequestBodyDTO testRequestBodyDTO) {
//        System.out.println(testRequestBodyDTO.getId());
//        System.out.println(testRequestBodyDTO.getMessage());
        return "Hello World! ID " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/template")
    public String TemplateTestController() {
        return "/example";
    }

//    @GetMapping
//    public String testController() {
//        return "Hello World!";
//    }
}
