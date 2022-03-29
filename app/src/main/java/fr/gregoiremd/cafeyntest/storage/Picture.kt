package fr.gregoiremd.cafeyntest.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pictures")
data class Picture(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "album_id") val albumId: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "thumbnail_url") val thumbnailUrl: String?
)
