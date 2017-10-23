package com.gradoid.example

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(@Id val id: Int = 0, val name: String = "", val age: Int = 0)
