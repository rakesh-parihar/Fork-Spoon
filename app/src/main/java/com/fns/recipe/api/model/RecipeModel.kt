package com.fns.recipe.api.model

data class RecipeModel(
    var id: String = String(),
    var title: String = String(),
    var desc: String = String(),
    var chef: String = String(),
    var tags: String = String(),
    var img: String = String()
)