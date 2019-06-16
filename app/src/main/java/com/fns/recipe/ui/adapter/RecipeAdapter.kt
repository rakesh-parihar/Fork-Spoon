package com.fns.recipe.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fns.recipe.R
import com.fns.recipe.api.model.RecipeModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recipe_list.view.*
import java.util.*

class RecipeAdapter(private val listener: Listener) :
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    private var dataList: ArrayList<RecipeModel> = arrayListOf()

    interface Listener {
        fun onItemClick(recipeModel: RecipeModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], listener, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_list, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(recipeModel: RecipeModel, listener: Listener, position: Int) {

            itemView.tv_title.text = recipeModel.title
            if (!recipeModel.img.isBlank())
                Picasso.get().load(recipeModel.img).into(itemView.iv_thumb)

            itemView.setOnClickListener { listener.onItemClick(recipeModel) }
        }
    }

    fun setData(dataList: List<RecipeModel>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

}