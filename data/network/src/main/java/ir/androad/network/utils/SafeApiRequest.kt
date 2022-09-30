package ir.androad.network.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import timber.log.Timber
import java.lang.StringBuilder

abstract class SafeApiRequest {
    suspend fun <T: Any> safeApiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful){
            return response.body()!!
        } else {
            val responseErrorBody = response.errorBody()?.string()

            val message = StringBuilder()
            responseErrorBody.let {
                try {
                    message.append(JSONObject(it!!).getString("status_message"))
                }catch (e: JSONException){
                    Timber.e("Error: ${e.message}, ${e.cause}")
                }
                throw Exception(message.toString())
            }
        }
    }
}