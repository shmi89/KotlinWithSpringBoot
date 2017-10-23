package com.gradoid.example

import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun get(id: Int): User? = repository.findOne(id)

    fun getAll() = repository.findAll().map { "${it.name}_${it.age}" }

    fun add(user: User): User = repository.save(user)
}