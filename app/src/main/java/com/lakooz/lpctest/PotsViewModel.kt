package com.lakooz.lpctest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.repositories.PotRepository
import kotlin.concurrent.thread

class PotsViewModel : ViewModel() {

    var category = 0
    private val repository = PotRepository.instance

    val pots: LiveData<List<Pot>> = MutableLiveData<List<Pot>>().apply {
        var tmp: List<Pot> = listOf()
        thread {
            tmp = repository.getPots(category)
        }
        value = tmp
        Log.e("List value",value.toString())
    }

}