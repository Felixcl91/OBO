package com.obo.opo.bomberos.domain.util

import com.obo.opo.bomberos.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result: Response<T>): Resource<T> {
        return try {
            //val result = authRemoteDataSource.login(email, password)
            //val result = authRemoteDataSource.register(user)
            if (result.isSuccessful) { //201
                Resource.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }
        }
        catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la petición HTTP")
        }
        catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Verifica tu conexión a internet")
        }
        catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }
}