package com.example.mvvmcompose.domain

data class RandomMessageModel(val authorSlug: String?, val content: String?) {
    companion object {
        fun empty() = RandomMessageModel(null, null)
    }
}
