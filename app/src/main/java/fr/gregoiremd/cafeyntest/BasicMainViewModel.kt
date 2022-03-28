package fr.gregoiremd.cafeyntest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasicMainViewModel(private val repository: Repository) : ViewModel() {
    val uiModel: MutableLiveData<UiModel> by lazy {
        MutableLiveData< UiModel >()
    }

    fun generateReport (){
        // TODO Add complicated report computation
    }
}
