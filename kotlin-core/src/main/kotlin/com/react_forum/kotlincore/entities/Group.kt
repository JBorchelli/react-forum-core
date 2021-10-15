package com.react_forum.kotlincore.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.ManyToMany
import javax.persistence.CascadeType
import javax.persistence.OneToMany


@Entity
@Table(name="groups")
class Group(

    @Column(name="name")
    val name: String,

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    val users: MutableSet<User> = mutableSetOf(),

    @OneToMany(mappedBy = "group", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH], orphanRemoval = true)
    val categories: MutableSet<Category> = mutableSetOf(),

): AbstractJpaEntity()

//############### Extensions ##################

fun Group.addUser(user: User): Boolean {
   return this.users.add(user)
}

fun Group.removeUser(userId: Long): Boolean {
    val checkLength = this.users.size
    this.users = this.users.filterNot { user -> user.id == userId }
    return this.users.size = checkLength - 1
}

fun Group.removeUser(user: User): Boolean {
    return this.users.remove(user)
}

fun Group.addCategory(category: Category): Boolean {
    return this.categories.add(category)
}

fun Group.removeCategory(categoryId: Long): Boolean {
    val checkLength = this.categories.size
    this.categories = this.categories.filterNot { category -> category.id == categoryId }
    return this.categories.size = checkLength - 1
}

fun Group.removeCategory(category: Category): Boolean {
    return this.categories.remove(category)
}
