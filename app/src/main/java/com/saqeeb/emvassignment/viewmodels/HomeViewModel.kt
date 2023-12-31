package com.saqeeb.emvassignment.viewmodels

import androidx.lifecycle.ViewModel
import com.saqeeb.emvassignment.repos.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepo: HomeRepo):ViewModel() {

}