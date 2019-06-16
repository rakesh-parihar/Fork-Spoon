package com.fns.recipe.ui.activity

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fns.recipe.R
import com.fns.recipe.api.model.RecipeModel
import com.fns.recipe.base.BaseActivity
import com.fns.recipe.ui.adapter.RecipeAdapter
import com.fns.recipe.ui.presenter.RecipePresenter
import com.fns.recipe.util.BUNDLE_TAG
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity(), RecipeAdapter.Listener, RecipePresenter.IRecipeView {


    private lateinit var mAdapter: RecipeAdapter
    private lateinit var mPresenter: RecipePresenter

    override fun getContentView(): Int {
        return R.layout.activity_list
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {

        mPresenter = RecipePresenter(this)

        vw_refresh.setColorSchemeColors(
            ResourcesCompat.getColor(resources, R.color.colorPrimaryDark, null),
            ResourcesCompat.getColor(resources, R.color.colorPink, null)
        )

        vw_refresh.setOnRefreshListener {
            loadData()
        }

        mAdapter = RecipeAdapter(this)
        rv_recipes.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this)
        rv_recipes.layoutManager = layoutManager
        rv_recipes.adapter = mAdapter

        loadData()
    }

    private fun loadData() {
        if (!isConnected()) {
            showToast(getString(R.string.msg_no_internet))
            return
        }
        mPresenter.getData()
    }

    override fun onItemClick(recipeModel: RecipeModel) {
        val bundle = Bundle()
        bundle.putString(BUNDLE_TAG, Gson().toJson(recipeModel))
        launchActivity(DetailsActivity(), bundle = bundle)
    }

    override fun updateRecipes(data: List<RecipeModel>) {

        mAdapter.setData(data)
        tv_empty.visibility = if (data.isNullOrEmpty()) View.VISIBLE else View.GONE
    }

    override fun showProgress() {
        vw_refresh.isRefreshing = true
    }

    override fun hideProgress() {
        vw_refresh.isRefreshing = false
    }

    override fun showError() {
        showToast(getString(R.string.msg_error))
    }
}