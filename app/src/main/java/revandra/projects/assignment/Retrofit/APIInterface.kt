package revandra.projects.assignment.Retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import revandra.projects.assignment.Login
import revandra.projects.assignment.Response

interface APIInterface {
    @POST("api-login/")
    fun login(@Body login: Login):Call<Response>
}