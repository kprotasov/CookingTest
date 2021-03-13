package com.kprotasov.test.cooking.view.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kprotasov.test.cooking.R
import com.kprotasov.test.cooking.ui.extensions.args
import com.kprotasov.test.cooking.ui.mvvm.MvvmFragment
import com.kprotasov.test.cooking.ui.mvvm.delegates.viewModels
import com.kprotasov.test.cooking.ui.mvvm.lifecycle.subscribeSafe
import com.kprotasov.test.cooking.view.image.OnImageClickListener
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.presentation.viewmodel.details.RecipeDetailsViewModel
import kotlinx.android.synthetic.main.recipe_details_fragment.*

private const val RECIPE = "RECIPE"
var Bundle.recipe : Recipe
    get() = getSerializable(RECIPE) as Recipe
    set(value) = putSerializable(RECIPE, value)

class RecipeDetailsFragment : MvvmFragment(),
    OnImageClickListener {

    companion object {
        fun newInstance(recipe: Recipe): Fragment = RecipeDetailsFragment().args {
            this.recipe = recipe
        }
    }

    override val contentLayout: Int = R.layout.recipe_details_fragment
    private val viewModel: RecipeDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.images.subscribeSafe(viewLifecycleOwner, ::fillImages)

        fillRecipeInfo()
    }

    private fun fillImages(images: List<String>) {
        recipeImage.setImages(images, this)
    }

    override fun onImageClicked(imageLink: String) {
        viewModel.openImage(imageLink)
    }

    private fun fillRecipeInfo() {
        recipeTitle.text = args.recipe.name
        val difficultyNames = resources.getStringArray(R.array.difficulty_names)
        val difficultyText: String = if (args.recipe.difficulty <= difficultyNames.size) {
            difficultyNames[args.recipe.difficulty - 1]
        } else {
            difficultyNames[difficultyNames.size - 1]
        }
        difficulty.text = resources.getString(R.string.difficulty_placeholder, difficultyText)
        description.text = args.recipe.description
        instruction.text = args.recipe.instructions
    }

}