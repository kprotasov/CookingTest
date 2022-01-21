package com.kprotasov.test.cooking.view.recipes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kprotasov.test.cooking.R
import com.kprotasov.test.domain.entity.MediaTypes
import com.kprotasov.test.domain.entity.NewRecipe
import com.kprotasov.test.domain.entity.PhotoMedia
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recipe_item.view.*
import javax.inject.Inject

class RecipesAdapter @Inject constructor() : RecyclerView.Adapter<RecipesViewHolder>() {

    private var onRecipeItemClickListener: OnRecipeItemClickListener? = null

    private var recipesList = mutableListOf<NewRecipe>()

    fun setOnRecipeItemClickListener(listener: OnRecipeItemClickListener) {
        onRecipeItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder =
        RecipesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        )

    override fun getItemCount(): Int = recipesList.size

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bind(recipesList[position], onRecipeItemClickListener)
    }

    fun setRecipesList(recipesList: List<NewRecipe>) {
        this.recipesList.clear()
        this.recipesList.addAll(recipesList)
        notifyDataSetChanged()
    }

}

class RecipesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(recipe: NewRecipe, onRecipeItemClickListener: OnRecipeItemClickListener?) {
        view.recipeTitle.text = recipe.text
        Log.v("RecipesAdapterTest", "attachment ${recipe.attachments?.map { it.type }}")
        val photoAttachmentList = recipe.attachments?.filter { it.type == MediaTypes.TYPE_PHOTO }
        if (photoAttachmentList?.isNotEmpty() == true) {
            photoAttachmentList.let {
                if (photoAttachmentList.size == 1) {
                    val photoAttachment = it[0] as PhotoMedia
                    photoAttachment.sizes?.get(0)?.let { photoSize ->
                        view.recipeMediaContainer.setImages(listOf(photoSize.url))
                    }
                } else {
                    val urls = mutableListOf<String>()
                    val photoAttachment = it[0] as PhotoMedia
                    photoAttachment.sizes?.get(0)?.let { photoSize ->
                        urls.add(photoSize.url)
                    }
                    val photoAttachment2 = it[1] as PhotoMedia
                    photoAttachment2.sizes?.get(1)?.let { photoSize ->
                        urls.add(photoSize.url)
                    }

                    view.recipeMediaContainer.setImages(urls)
                }
            }
        }


        /*val difficultyNames = view.context.resources.getStringArray(R.array.difficulty_names)
        val difficultyText: String = if (recipe.difficulty <= difficultyNames.size) {
            difficultyNames[recipe.difficulty - 1]
        } else {
            difficultyNames[difficultyNames.size - 1]
        }
        view.difficulty.text = view.context.resources.getString(R.string.difficulty_placeholder, difficultyText)

        view.description.text = recipe.description

        view.setOnClickListener {
            onRecipeItemClickListener?.onRecipeItemClicked(recipe)
        }*/
    }

}