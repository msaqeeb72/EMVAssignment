package com.saqeeb.emvassignment.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.saqeeb.emvassignment.models.UserResponse
import com.saqeeb.emvassignment.network.api.UsersAPI
import com.saqeeb.emvassignment.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class SplashRepo @Inject constructor(private val usersAPI: UsersAPI) {
    private val _userResponseLiveData = MutableLiveData<NetworkResult<UserResponse>>()
    val userResponseLiveData : LiveData<NetworkResult<UserResponse>>
        get() = _userResponseLiveData



    suspend fun getUser(userId: String) {
        val response = usersAPI.getUserById(userId)
        validateResponseAndUpdate(response);
    }

    private fun validateResponseAndUpdate(response: Response<UserResponse>) {
        if(response.isSuccessful && response.body()!=null){
            _userResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
        }else{
            _userResponseLiveData.postValue(NetworkResult.Error("Unable to Load ${response.code()}"))
        }
    }
}