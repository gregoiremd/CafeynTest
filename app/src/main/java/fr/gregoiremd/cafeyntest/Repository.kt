package fr.gregoiremd.cafeyntest

import androidx.lifecycle.LiveData

interface Repository {

    fun insert(album: Album)

    fun getAll(): LiveData<List<Album>>

    fun update(album: Album)
}
