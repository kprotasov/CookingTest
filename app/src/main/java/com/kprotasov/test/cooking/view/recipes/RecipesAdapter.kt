package com.kprotasov.test.cooking.view.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kprotasov.test.cooking.R
import com.kprotasov.test.domain.entity.Recipe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recipe_item.view.*
import javax.inject.Inject

class RecipesAdapter @Inject constructor() : RecyclerView.Adapter<RecipesViewHolder>() {

    private var onRecipeItemClickListener: OnRecipeItemClickListener? = null

    private var recipesList = mutableListOf<Recipe>()

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

    fun setRecipesList(recipesList: List<Recipe>) {
        this.recipesList.clear()
        this.recipesList.addAll(recipesList)
        notifyDataSetChanged()
    }

}

class RecipesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(recipe: Recipe, onRecipeItemClickListener: OnRecipeItemClickListener?) {
        view.recipeTitle.text = recipe.name
        Picasso.get()
            .load(recipe.images.first())
            .placeholder(R.drawable.image_placeholder)
            .into(view.recipeImage)

        val difficultyNames = view.context.resources.getStringArray(R.array.difficulty_names)
        val difficultyText: String = if (recipe.difficulty <= difficultyNames.size) {
            difficultyNames[recipe.difficulty - 1]
        } else {
            difficultyNames[difficultyNames.size - 1]
        }
        view.difficulty.text = view.context.resources.getString(R.string.difficulty_placeholder, difficultyText)

        view.description.text = recipe.description

        view.setOnClickListener {
            onRecipeItemClickListener?.onRecipeItemClicked(recipe)
        }
    }

}