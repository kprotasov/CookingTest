package com.kprotasov.test.presentation.viewmodel.recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.domain.interactor.RecipesInteractor
import com.kprotasov.test.presentation.BaseViewModel
import com.kprotasov.test.presentation.navigation.RECIPE_DETAILS_SCREEN
import com.kprotasov.test.presentation.navigation.Router
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class RecipesViewModel @Inject constructor(
    private val recipeInteractor: RecipesInteractor,
    private val router: Router
) : BaseViewModel() {

    private val _state = MutableLiveData<RecipesState>()
    val state: LiveData<RecipesState> = _state

    private var defaultRecipesList = emptyList<Recipe>()
    private var filterPhrase: String? = null
    private var currentSorting: RecipesSortingType? = null

    fun loadRecipes() {
        if (_state.value != RecipesState.InProgress) {
            _state.value = RecipesState.InProgress

            recipeInteractor.getRecipes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        defaultRecipesList = it

                        if (!filterPhrase.isNullOrEmpty()) {
                            filter(filterPhrase)
                        } else {
                            _state.value =
                                RecipesState.Recipes(
                                    sorting(currentSorting, defaultRecipesList)
                                )
                        }
                    },
                    {
                        _state.value =
                            RecipesState.Error(it.localizedMessage)
                    }
                )
                .addToDisposable()
        }
    }

    fun changeSorting(checkedIndex: Int) {
        val sortingTypes = RecipesSortingType.values()
        val sortingType = sortingTypes[checkedIndex]

        if (_state.value !is RecipesState.Recipes) {
            return
        }
        currentSorting = sortingType
        val recipes = _state.value as RecipesState.Recipes
        _state.value = RecipesState.Recipes(sorting(sortingType, recipes.recipesList))
    }

    private fun sorting(sortingType: RecipesSortingType?, recipesList: List<Recipe>): List<Recipe> {
        if (sortingType == null) {
            return recipesList
        }
        return when (sortingType) {
            RecipesSortingType.SORTING_BY_NAME -> sortByName(recipesList)
            RecipesSortingType.SORTING_BY_DATE -> sortByDate(recipesList)
        }
    }

    private fun sortByName(recipesList: List<Recipe>): List<Recipe> =
        recipesList.sortedBy { it.name }

    private fun sortByDate(recipesList: List<Recipe>): List<Recipe> =
        recipesList.sortedBy { it.lastUpdated.time }

    fun filterRecipes(filterPhrase: String) {
        if (_state.value !is RecipesState.Recipes) {
            return
        }

        if (filterPhrase.isEmpty()) {
            this.filterPhrase = null
            _state.value = RecipesState.Recipes(defaultRecipesList)
        }

        this.filterPhrase = filterPhrase

        filter(filterPhrase)
    }

    private fun filter(filterPhrase: String?) {
        if (filterPhrase.isNullOrEmpty()) return
        Single.fromCallable {
            defaultRecipesList.filter {
                it.name.contains(filterPhrase, true) ||
                        it.description.contains(filterPhrase, true) ||
                        it.instructions.contains(filterPhrase, true)
            }
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _state.value =
                        RecipesState.Recipes(sorting(currentSorting, it))
                },
                {
                    _state.value =
                        RecipesState.Error(it.localizedMessage)
                }
            )
            .addToDisposable()
    }

    fun openDetails(recipe: Recipe) {
        router.moveTo(RECIPE_DETAILS_SCREEN, recipe.uuid)
    }

}