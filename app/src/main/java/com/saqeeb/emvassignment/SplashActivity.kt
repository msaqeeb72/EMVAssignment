package com.saqeeb.emvassignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.saqeeb.emvassignment.models.UserResponse
import com.saqeeb.emvassignment.utils.NetworkResult
import com.saqeeb.emvassignment.utils.SharedPref
import com.saqeeb.emvassignment.utils.Utils
import com.saqeeb.emvassignment.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val splashViewModel:SplashViewModel by viewModels()
    @Inject
    lateinit var pref:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setUpObservers()
        val randomNumber = Random.nextInt(1..12)
        splashViewModel.getUser("$randomNumber")

    }

    private fun setUpObservers() {
        splashViewModel.userResponseLiveData.observe(this){
            when(it){
                is NetworkResult.Error -> {
                    Utils.showToast(this@SplashActivity,it.message!!)
                }
                is NetworkResult.Loading -> {
                    Utils.showToast(this@SplashActivity,"Loading")
                }
                is NetworkResult.Success -> {
                    saveDataToPref(it.data)
                    goForNextScreen()
                }
            }
        }
    }

    private fun saveDataToPref(data: UserResponse?) {
        pref.putString("name","${data?.data?.first_name} ${data?.data?.last_name}" )
        pref.putString("email","${data?.data?.email}")
        pref.putString("image","${data?.data?.avatar}")
    }

    private fun goForNextScreen() {
        CoroutineScope(Dispatchers.Main).launch{
            delay(3000)
            startActivity(Intent(this@SplashActivity,HomeActivity::class.java))
            finish()
        }
    }
}