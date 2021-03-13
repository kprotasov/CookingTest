package com.kprotasov.test.cooking.view.recipes

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kprotasov.test.cooking.R
import com.kprotasov.test.cooking.ui.extensions.hideKeyboard
import com.kprotasov.test.cooking.ui.mvvm.MvvmFragment
import com.kprotasov.test.cooking.ui.mvvm.delegates.viewModels
import com.kprotasov.test.cooking.ui.mvvm.lifecycle.bind
import com.kprotasov.test.cooking.ui.mvvm.lifecycle.subscribeSafe
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.presentation.viewmodel.recipes.RecipesState
import com.kprotasov.test.presentation.viewmodel.recipes.RecipesViewModel
import kotlinx.android.synthetic.main.recipes_fragment.*
import javax.inject.Inject

class RecipesFragment : MvvmFragment(),
    OnRecipeItemClickListener, TextView.OnEditorActionListener {

    companion object {
        fun newInstance(): Fragment = RecipesFragment()
    }

    override val contentLayout: Int = R.layout.recipes_fragment
    private val viewModel: RecipesViewModel by viewModels()

    @Inject
    lateinit var adapter: RecipesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecipesAdapter()

        recipesList.layoutManager = LinearLayoutManager(context)

        viewModel.state.subscribeSafe(viewLifecycleOwner, ::updateState)
        viewModel.sortingIndex.bind(viewLifecycleOwner, radioGroup)

        viewModel.loadRecipes()

        changeRadioGroupIds()

        searchEditText.setOnEditorActionListener(this)
    }

    private fun changeRadioGroupIds() {
        for (i in 0 until radioGroup.childCount) {
            radioGroup.getChildAt(i).id = i
        }
    }

    private fun initRecipesAdapter() {
        recipesList.adapter = adapter
        adapter.setOnRecipeItemClickListener(this)
    }

    override fun onRecipeItemClicked(recipe: Recipe) {
        viewModel.openDetails(recipe)
    }

    override fun onEditorAction(view: TextView, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            viewModel.filterRecipes(view.text.toString())
            view.hideKeyboard()
            return true
        }
        return false
    }

    private fun updateState(state: RecipesState) {
        when (state) {
            RecipesState.InProgress -> renderInProgressState()
            is RecipesState.Error -> renderErrorState(state)
            is RecipesState.Recipes -> renderRecipesFullListState(state)
        }
    }

    private fun renderInProgressState() {
        // code to show progress
    }

    private fun renderErrorState(state: RecipesState.Error) {
        Log.v("RecipesFragment", "error " + state.message)
    }

    private fun renderRecipesFullListState(state: RecipesState.Recipes) {
        adapter.setRecipesList(state.recipesList)
    }

}