package com.kprotasov.test.presentation.viewmodel.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kprotasov.test.domain.interactor.RecipeDetailsInteractor
import com.kprotasov.test.presentation.BaseViewModel
import com.kprotasov.test.presentation.navigation.IMAGE_SCREEN
import com.kprotasov.test.presentation.navigation.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class RecipeDetailsViewModel @Inject constructor(
    private val recipeDetailsInteractor: RecipeDetailsInteractor,
    private val router: Router,
    private val recipeUuid: String
) : BaseViewModel() {

    private val _state = MutableLiveData<RecipeState>()
    val state: LiveData<RecipeState> = _state

    fun loadRecipeDetails() {
        if (_state.value != RecipeState.InProgress) {
            _state.value = RecipeState.InProgress

            recipeDetailsInteractor.getRecipeByUuid(recipeUuid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _state.value = RecipeState.RecipeResult(it)
                    },
                    {
                        _state.value = RecipeState.Error(it.localizedMessage)
                    }
                )
                .addToDisposable()
        }
    }

    fun openImage(imageLink: String) {
        router.moveTo(IMAGE_SCREEN, imageLink)
    }

}