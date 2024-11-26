package com.example.hellospring.controller;

import org.springframework.web.bind.annotation.*; //패키지 내의 여러 어노테이션을 한 번에 가져오겠다

@RestController // @RestController를 사용하면 문자열이 그대로 클라이언트에 반환됩니다.
@RequestMapping("/api") // 기본경로
public class Controller {

    @GetMapping("/index")  // GET 요청을 처리
    public String index() {
        return "This is a GET request - index"; // "This is a DELETE request - index"라는 문자열이 응답으로 전송
    }

    @PostMapping("/post")  // POST 요청을 처리
    public String post() {
        return "This is a POST request - post "; // "This is a DELETE request - post"라는 문자열이 응답으로 전송
    }

    @PatchMapping("/patch")  // PATCH 요청을 처리
    public String patch() {
        return "This is a PATCH request - patch";   // "This is a DELETE request - patch"라는 문자열이 응답으로 전송
    }

    @DeleteMapping("/delete")  // DELETE 요청을 처리
    public String delete() {
        return "This is a DELETE request - delete"; // "This is a DELETE request - delete"라는 문자열이 응답으로 전송
    }
}