package fr.gregoiremd.cafeyntest.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.gregoiremd.cafeyntest.data.PictureRepo
import fr.gregoiremd.cafeyntest.viewmodels.MainViewModel

class ViewModelFactoryPictureList(private val pictureRepo: PictureRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(pictureRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
