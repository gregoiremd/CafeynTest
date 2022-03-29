package fr.gregoiremd.cafeyntest.storage

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PictureDao {

    @Insert
    fun insert(picture: Picture)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(pictureList: List<Picture>)

    @Query("SELECT * FROM pictures")
    fun getAllPictures(): Flow<List<Picture>>

    @Update
    fun update(picture: Picture)

    @Delete
    fun delete(picture: Picture)

}