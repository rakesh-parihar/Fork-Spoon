package com.fns.recipe.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.fns.recipe.R
import com.fns.recipe.api.model.RecipeModel
import com.fns.recipe.base.BaseActivity
import com.fns.recipe.util.BUNDLE_TAG
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_details
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
    }


    private fun initView() {
        val bundle = intent.extras
        if (bundle != null) {
            updateUI(Gson().fromJson<RecipeModel>(bundle.getString(BUNDLE_TAG), RecipeModel::class.java))
        }
    }

    private fun updateUI(model: RecipeModel) {
        tv_title.text = model.title
        if (!model.img.isBlank())
            Picasso.get().load(model.img).placeholder(R.drawable.ic_placeholder).into(iv_thumb)
        if (model.chef.isBlank())
            tv_chef.visibility = View.GONE
        else
            tv_chef.text = model.chef
        tv_desc.text = model.desc
        tv_tags.text = model.tags

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)

    }
}