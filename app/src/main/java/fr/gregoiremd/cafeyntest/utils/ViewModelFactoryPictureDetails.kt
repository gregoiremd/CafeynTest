package fr.gregoiremd.cafeyntest.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.gregoiremd.cafeyntest.data.PictureRepo
import fr.gregoiremd.cafeyntest.viewmodels.DetailsViewModel

class ViewModelFactoryPictureDetails(private val pictureRepo: PictureRepo, private val pictureId: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailsViewModel(pictureRepo, pictureId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
