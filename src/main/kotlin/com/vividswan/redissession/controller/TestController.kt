package com.vividswan.redissession.controller

import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    val key: String = "word"

    @PostMapping("/word")
    fun updateWord(httpSession: HttpSession, @RequestParam(required = true) word: String): String {
        httpSession.setAttribute(key, word)
        return "update ok"
    }

    @GetMapping("/word")
    fun getWord(httpSession: HttpSession): String? {
        return httpSession.getAttribute(key) as? String
    }
}
