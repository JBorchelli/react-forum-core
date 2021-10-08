package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn

@Entity
@Table(name="posts")
class Post(

    @Column(name="content")
    var content: String,

    @JoinColumn(name="user_id")
    @ManyToOne
    var user: User,

    @JoinColumn(name="discussion_id")
    @ManyToOne
    var discussion: Discussion,

): AbstractJpaEntity() {
    
}
