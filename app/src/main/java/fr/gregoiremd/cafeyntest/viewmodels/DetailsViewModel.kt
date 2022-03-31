package fr.gregoiremd.cafeyntest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.gregoiremd.cafeyntest.data.PictureRepository
import fr.gregoiremd.cafeyntest.storage.Picture
import kotlin.coroutines.suspendCoroutine

class DetailsViewModel(private val repository: PictureRepository, private val picture: Picture) : ViewModel() {

    suspend fun getPicture(pictureId: Int): Picture {
        return suspendCoroutine {
            repository.getPictureFromId(pictureId)
        }
    }
}

class DetailsViewModelFactory(private val repository: PictureRepository, private val picture: Picture) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailsViewModel(repository, picture) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
