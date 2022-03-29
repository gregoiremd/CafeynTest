package fr.gregoiremd.cafeyntest.network

data class PictureResponse(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
