package revandra.projects.assignment

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("message")
    val message:String?,
    @SerializedName("success")
    val success:Boolean?,
    @SerializedName("token")
    val token:String?,
    @SerializedName("error")
    val error:List<String>?,
    @SerializedName("status")
    val status:String?,
)
