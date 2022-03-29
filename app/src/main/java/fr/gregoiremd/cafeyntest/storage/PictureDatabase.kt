package fr.gregoiremd.cafeyntest.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database to store all pictures
 */
@Database(
    entities = [Picture::class],
    version = 2,
    exportSchema = false
)
abstract class PictureDatabase : RoomDatabase() {

    abstract fun pictureDao(): PictureDao

    companion object {

        @Volatile
        private var INSTANCE: PictureDatabase? = null

        fun getInstance(context: Context): PictureDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PictureDatabase::class.java,
                "pictures.db"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}
