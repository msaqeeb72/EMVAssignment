package com.saqeeb.emvassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saqeeb.emvassignment.models.UserResponse
import com.saqeeb.emvassignment.repos.SplashRepo
import com.saqeeb.emvassignment.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val splashRepo:SplashRepo) : ViewModel(){
    val userResponseLiveData : LiveData<NetworkResult<UserResponse>>
        get() = splashRepo.userResponseLiveData
    fun getUser(userId:String){
        viewModelScope.launch{
            splashRepo.getUser(userId)
        }

    }

    suspend fun saveTagInfoToRoom(tagInfoData: Map<String, String>?):Boolean {

        return viewModelScope.async {
            splashRepo.saveDataTagInfoToDb(tagInfoData)
        }.await()

    }
}