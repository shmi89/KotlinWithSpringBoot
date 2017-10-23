package com.gradoid.example

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int>
