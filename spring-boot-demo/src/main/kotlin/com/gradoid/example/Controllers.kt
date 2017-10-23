package com.gradoid.example

import org.springframework.web.bind.annotation.*

@RestController
class HelloController {
    @GetMapping("hello")
    fun hello(): String {
        return "Hello, Kotlin User Group Serbia!"
    }
}

@RestController
@RequestMapping("users")
class UserController(private val service: UserService) {

    @GetMapping("id/{id}")
    fun getById(@PathVariable id: Int) = service.get(id) ?: "User with id: $id not found!"

    @GetMapping("all")
    fun getAll() = service.getAll()

    @GetMapping("get")
    fun get(@RequestParam(required = false) id: Int?) = if (id == null) getAll() else getById(id)

    @GetMapping("add")
    fun add(@RequestParam name: String, @RequestParam age: Int): String {
        val user = User(name = name, age = age)
        service.add(user)

        return "User $name created."
    }
}
