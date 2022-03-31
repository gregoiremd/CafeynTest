package fr.gregoiremd.cafeyntest

import android.app.Application
import fr.gregoiremd.cafeyntest.data.PictureRepository
import fr.gregoiremd.cafeyntest.network.PictureListService
import fr.gregoiremd.cafeyntest.storage.PictureDatabase

class CafeynTestApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { PictureDatabase.getDatabase(this) }
    val repository by lazy { PictureRepository(PictureListService.create(), database.pictureDao()) }
}
