package com.example.practiceproject.view.recipe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.Item
import com.example.practiceproject.R
import org.w3c.dom.Text
import javax.inject.Inject

class RecipeAdapter(list: MutableList<RecipeModel>) :
    BaseAdapter<RecipeModel>(list) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<RecipeModel> {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false), this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<RecipeModel>, position: Int) {
        holder.bindData(baseList[position])
    }
}

class RecipeViewHolder(view: View, adapter: RecipeAdapter) :
    BaseViewHolder<RecipeModel>(view, adapter) {

    private var title = view.findViewById(R.id.tvTitle) as TextView
    private var thumnail = view.findViewById(R.id.ivImage) as ImageView

    override fun bindData(item: RecipeModel) {
        title.text = item.title
        Glide.with(view)
            .load(item.url)
            .placeholder(R.drawable.place_holder)
            .error(R.drawable.place_holder)
            .fallback(R.drawable.place_holder)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .transform(CircleCrop())
            .into(thumnail)
    }

}

data class RecipeModel(
    var title: String?,
    var imageType: String?,
    var url: String?
) : Item()