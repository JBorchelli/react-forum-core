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
import javax.persistence.ManyToOne

@Entity
@Table(name="discussions")
class Discussion(
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    var id: Int

    @Column(name="main")
    @NotNull
    var main: String

    @Column(name="sub")
    var sub: String

    @ManyToOne
    var category: Category

    @OneToMany(mappedBy ="discussion", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    var posts: MutableSet<Post> = mutableSetOf()

) {
    
}
