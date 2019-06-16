package com.fns.recipe.ui.presenter

import com.fns.recipe.api.APIService
import com.fns.recipe.api.ServiceFactory
import com.fns.recipe.api.model.RecipeModel
import com.fns.recipe.api.model.ResponseModel
import com.fns.recipe.util.ACCESS_TOKEN
import com.fns.recipe.util.CONTENT_TYPE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecipePresenter(private val view: IRecipeView) {

    private val apiService: APIService = ServiceFactory.getInstance()

    fun getData() {

        view.showProgress()
        val call = apiService.getRecipes(ACCESS_TOKEN, CONTENT_TYPE)
        call.enqueue(object : Callback<ResponseModel> {
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                view.hideProgress()
                view.showError()
                view.updateRecipes(listOf())
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                view.hideProgress()
                val resp: ResponseModel = response.body()!!
                view.updateRecipes(mapResponse(resp))
            }

        })

    }

    interface IRecipeView {

        fun updateRecipes(data: List<RecipeModel>)
        fun showProgress()
        fun hideProgress()
        fun showError()
    }

    private fun mapResponse(respModel: ResponseModel): List<RecipeModel> {

        val list: MutableList<RecipeModel> = arrayListOf()
        for (item in respModel.items) {
            val model = RecipeModel()
            model.id = item.sys.id
            model.title = item.fields.title
            model.desc = item.fields.description

            //Filtering Image from Assets
            var index = respModel.includes.asset.indexOfFirst {
                it.sys.id == item.fields.photo.sys.id
            }
            if (index >= 0)
                model.img = "http:${respModel.includes.asset[index].fields.file.url}"

            //Filtering Chef value
            index = respModel.includes.entry.indexOfFirst {
                it.sys.id == item.fields.chef.sys.id
            }
            if (index >= 0)
                model.chef = respModel.includes.entry[index].fields.name


            //Filtering tag values
            val sb = StringBuilder()
            for (temp in item.fields.tags) {
                index = respModel.includes.entry.indexOfFirst {
                    it.sys.id == temp.sys.id
                }
                if (index >= 0) {
                    sb.append("#")
                    sb.append(respModel.includes.entry[index].fields.name)
                    sb.append(" ")
                }
            }
            model.tags = sb.toString()

            list.add(model)
        }
        return list
    }
}