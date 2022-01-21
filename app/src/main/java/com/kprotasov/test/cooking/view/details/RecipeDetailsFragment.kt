package com.kprotasov.test.cooking.view.details

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.*
import androidx.fragment.app.Fragment
import com.kprotasov.test.cooking.R
import com.kprotasov.test.cooking.ui.extensions.args
import com.kprotasov.test.cooking.ui.mvvm.MvvmFragment
import com.kprotasov.test.cooking.ui.mvvm.delegates.viewModels
import com.kprotasov.test.cooking.ui.mvvm.lifecycle.subscribeSafe
import com.kprotasov.test.cooking.view.image.OnImageClickListener
import com.kprotasov.test.presentation.viewmodel.details.RecipeDetailsViewModel
import com.kprotasov.test.presentation.viewmodel.details.RecipeState
import kotlinx.android.synthetic.main.recipe_details_fragment.*

private const val RECIPE_UUID = "RECIPE_UUID"
var Bundle.recipeUuid : String
    get() = getString(RECIPE_UUID) ?: ""
    set(value) = putString(RECIPE_UUID, value)

class RecipeDetailsFragment : MvvmFragment(),
    OnImageClickListener {

    companion object {
        fun newInstance(recipeUuid: String): Fragment = RecipeDetailsFragment().args {
            this.recipeUuid = recipeUuid
        }
    }

    override val contentLayout: Int = R.layout.recipe_details_fragment
    private val viewModel: RecipeDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.subscribeSafe(viewLifecycleOwner, ::updateState)

        viewModel.loadRecipeDetails()
    }

    private fun updateState(state: RecipeState) {
        when (state) {
            RecipeState.InProgress -> renderInProgressState()
            is RecipeState.Error ->renderErrorState(state)
            is RecipeState.RecipeResult -> renderRecipeState(state)
        }
    }

    private fun renderInProgressState() {
        containerLayout.visibility = GONE
        progressBar.visibility = VISIBLE
    }

    private fun renderErrorState(state: RecipeState.Error) {
        Log.v("RecipeDetailsFragment", "error " + state.message)
    }

    private fun renderRecipeState(state: RecipeState.RecipeResult) {
        containerLayout.visibility = VISIBLE
        progressBar.visibility = GONE
        val recipe = state.recipe

        recipeTitle.text = recipe.name
        val difficultyNames = resources.getStringArray(R.array.difficulty_names)
        val difficultyText: String = if (recipe.difficulty <= difficultyNames.size) {
            difficultyNames[recipe.difficulty - 1]
        } else {
            difficultyNames[difficultyNames.size - 1]
        }
        difficulty.text = resources.getString(R.string.difficulty_placeholder, difficultyText)
        description.text = recipe.description
        instruction.text = recipe.instructions

        recipeMediaContainer.setImages(recipe.images, this)
    }

    override fun onImageClicked(imageLink: String) {
        viewModel.openImage(imageLink)
    }

}