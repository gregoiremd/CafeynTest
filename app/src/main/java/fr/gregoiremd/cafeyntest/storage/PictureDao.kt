package fr.gregoiremd.cafeyntest.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PictureDao {

    @Insert
    fun insert(picture: Picture)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(pictureList: List<Picture>)

    @Query("SELECT * FROM pictures")
    fun getAllPictures(): Flow<List<Picture>>

    @Query("SELECT * FROM pictures WHERE id = :pictureId")
    fun getPictureFromId(pictureId: Int): Picture

    @Update
    fun update(picture: Picture)

    @Delete
    fun delete(picture: Picture)

}