package com.kprotasov.test.data.datasource

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kprotasov.test.data.model.NewRecipeModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.requests.VKRequest
import io.reactivex.Observable
import org.json.JSONObject
import javax.inject.Inject


/*
class RecipeDataSource @Inject constructor(
    private val recipesApi: RecipesApi
) {

    fun getRecipeByUuid(uuid: String): Single<RecipeResultModel> =
        recipesApi.getRecipe(uuid).subscribeOn(Schedulers.io())

}
 */
/*
Observable.fromCallable {
    VK.executeSync(VKUsersRequest())
}
    .subscribeOn(Schedulers.single())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({
        // response here
    }, {
        // throwable here
    })
 */
class VkWallDataSource @Inject constructor(){

    companion object {
        const val GROUP_OWNER_ID = "-%s"
    }

    val gson = Gson()

    init {

    }

    fun getWallById(ownerId: String, offset: Int, count: Int): Observable<List<NewRecipeModel>> {
        return Observable.fromCallable {
            val request = VkWallRequest()
            request.addParam("owner_id", String.format(GROUP_OWNER_ID, ownerId))
            request.addParam("count", count)
            request.addParam("offset", offset)
            request.addParam("extended", 1)
            VK.executeSync(request)
        }
    }
}

class VkWallRequest : VKRequest<List<NewRecipeModel>>("wall.get") {

    /*
    override fun parse(r: JSONObject): WallContentModel {
        Log.v("VkWallRequest", "result " + r)
        val response = r.getJSONObject(Fields.RESPONSE)

        val items = response.getJSONArray(Fields.ITEMS)
        val typeWall = object : TypeToken<List<WallModel>>() {}.type
        val wallModelList: List<WallModel> = gson.fromJson(items.toString(), typeWall)

        val profiles =
            try {
                response.getJSONArray(Fields.PROFILES)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        val typeProfile = object : TypeToken<List<ProfileModel>>() {}.type
        val profileModelList: List<ProfileModel> = gson.fromJson(profiles.toString(), typeProfile)

        val groups =
            try {
                response.getJSONArray(Fields.GROUPS)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        val typeGroup = object : TypeToken<List<GroupModel>>() {}.type
        val groupModelList: List<GroupModel> = gson.fromJson(groups.toString(), typeGroup)

        return WallContentModel(wallModelList, profileModelList, groupModelList)
    }
     */
    val gson = Gson()
    override fun parse(r: JSONObject): List<NewRecipeModel> {
        val response = r.getJSONObject(Fields.RESPONSE)
        val items = response.getJSONArray(Fields.ITEMS)
        val typeWall = object : TypeToken<List<NewRecipeModel>>() {}.type

        Log.v("WallDataSourceTest", items.toString())
        return gson.fromJson(items.toString(), typeWall)
    }
}