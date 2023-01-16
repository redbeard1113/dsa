package com.example.loginscreen1.viewmodel

data class ItemsViewModel(val image: Int, val text: String) {
    constructor(image: Int) : this(image,"")
}
