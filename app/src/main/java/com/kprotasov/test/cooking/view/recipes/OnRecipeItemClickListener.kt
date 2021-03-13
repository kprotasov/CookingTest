package com.kprotasov.test.cooking.view.recipes

import com.kprotasov.test.domain.entity.Recipe

interface OnRecipeItemClickListener {

    fun onRecipeItemClicked(recipe: Recipe)

}