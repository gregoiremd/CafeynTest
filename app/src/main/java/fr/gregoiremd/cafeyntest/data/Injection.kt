package fr.gregoiremd.cafeyntest.data

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import fr.gregoiremd.cafeyntest.utils.ViewModelFactoryPictureList
import fr.gregoiremd.cafeyntest.network.PictureListService
import fr.gregoiremd.cafeyntest.storage.PictureDatabase
import fr.gregoiremd.cafeyntest.utils.ViewModelFactoryPictureDetails

object Injection{

    private fun providePictureRepo(context: Context): PictureRepo {
        val database = PictureDatabase.getInstance(context)
        return PictureRepo(PictureListService.create(), database.pictureDao())
    }

    fun provideViewModelFactoryPicturesList(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryPictureList(providePictureRepo(context))
    }

    fun provideViewModelFactoryPictureDetails(context: Context, pictureId: Int): ViewModelProvider.Factory {
        return ViewModelFactoryPictureDetails(providePictureRepo(context), pictureId)
    }
}
