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
    var name: String? = null,

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH])
    var users: MutableSet<User> = mutableSetOf(),

    @OneToMany(mappedBy = "group", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH])
    var categories: MutableSet<Category> = mutableSetOf(),

): AbstractJpaEntity() {

    fun addUser(user: User): Boolean {
       return users.add(user)
    }

    fun removeUser(userId: Long): Boolean {
        val userToRemove: User = users.find{user -> user.getId() == userId} ?: return false
        return users.remove(userToRemove)
    }

    fun removeUser(user: User): Boolean {
        return users.remove(user)
    }

    fun addCategory(category: Category): Boolean {
        return categories.add(category)
    }

    fun removeCategory(categoryId: Long): Boolean {
        val categoryToRemove: Category = categories.find{category -> category.getId() == categoryId} ?: return false
        return categories.remove(categoryToRemove)
    }

    fun removeCategory(category: Category): Boolean {
        return categories.remove(category)
    }

}

