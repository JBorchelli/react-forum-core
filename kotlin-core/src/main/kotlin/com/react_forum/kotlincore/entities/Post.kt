package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.ManyToOne

@Entity
@Table(name="posts")
class Post(

    @Column(name="text")
    var text: String,

    @Column(name="user")
    @ManyToOne
    var user: User,

    @Column(name="discussion")
    @ManyToOne
    var discussion: Discussion,

): AbstractJpaEntity() {
    
}
