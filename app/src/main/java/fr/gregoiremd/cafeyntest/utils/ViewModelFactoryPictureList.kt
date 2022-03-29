package fr.gregoiremd.cafeyntest.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.gregoiremd.cafeyntest.data.PictureRepo
import fr.gregoiremd.cafeyntest.viewmodels.PictureListViewModel

class ViewModelFactoryPictureList(private val pictureRepo: PictureRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PictureListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PictureListViewModel(pictureRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}