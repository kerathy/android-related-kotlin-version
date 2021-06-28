package com.example.cardswipeviewkotlinversion

class PetsModel {

    var image: Int
    var title: String? = null
    var desc: String? = null

    constructor(image: Int, title: String?, desc: String?) {
        this.image = image
        this.title = title
        this.desc = desc
    }
}