package fr.gregoiremd.cafeyntest.viewmodels

import androidx.lifecycle.*
import fr.gregoiremd.cafeyntest.data.PictureRepository
import fr.gregoiremd.cafeyntest.storage.Picture

class MainViewModel(pictureRepository: PictureRepository) : ViewModel() {

    val picturesList: LiveData<List<Picture>> =
        pictureRepository.getAllPictures().asLiveData(viewModelScope.coroutineContext)

}

class MainViewModelFactory(private val pictureRepository: PictureRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(pictureRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}