package com.react_forum.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.NotNull
import javax.persistence.GenerationType
import javax.persistence.ManyToMany
import javax.persistence.CascadeType


@Entity
@Table(name="categories")
class Category(
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    var id: Int

    @Column(name="title")
    @NotNull
    var title: String

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    var discussions: MutableSet<Discussion> = mutableSetOf()


) {
    
}
