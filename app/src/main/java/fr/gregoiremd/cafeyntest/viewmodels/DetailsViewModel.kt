package fr.gregoiremd.cafeyntest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import fr.gregoiremd.cafeyntest.data.PictureRepo
import fr.gregoiremd.cafeyntest.storage.Picture

class DetailsViewModel(pictureRepo: PictureRepo, pictureId: Int) : ViewModel() {

    val picture: LiveData<Picture> = pictureRepo.getPictureFromId(pictureId)
        .asLiveData(viewModelScope.coroutineContext)
}