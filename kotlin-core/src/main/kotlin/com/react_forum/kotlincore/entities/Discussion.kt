package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.CascadeType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.JoinColumn

@Entity
@Table(name="discussions")
class Discussion(

    @Column(name="heading")
    var heading: String,

    @Column(name="sub")
    var sub: String?,

    @JoinColumn(name="category_id")
    @ManyToOne
    var category: Category,

    @OneToMany(mappedBy ="discussion", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH])
    var posts: MutableSet<Post> = mutableSetOf(),

    @JoinColumn(name="user_id")
    @ManyToOne
    var user: User,

): AbstractJpaEntity() {
    
}
