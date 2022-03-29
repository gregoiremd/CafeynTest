package fr.gregoiremd.cafeyntest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import fr.gregoiremd.cafeyntest.data.PictureRepo
import fr.gregoiremd.cafeyntest.storage.Picture

class PictureListViewModel(pictureRepo: PictureRepo) : ViewModel() {

    val picturesList: LiveData<List<Picture>> =
        pictureRepo.getAllPictures().asLiveData(viewModelScope.coroutineContext)
}
