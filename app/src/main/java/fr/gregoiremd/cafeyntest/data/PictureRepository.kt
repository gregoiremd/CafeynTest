package fr.gregoiremd.cafeyntest.data

import fr.gregoiremd.cafeyntest.network.PictureListService
import fr.gregoiremd.cafeyntest.network.PictureResponse
import fr.gregoiremd.cafeyntest.storage.Picture
import fr.gregoiremd.cafeyntest.storage.PictureDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow

class PictureRepository(private val pictureListService: PictureListService, private val pictureDao: PictureDao) {

    private fun getAllRemotePictures(): Flow<List<PictureResponse>> = flow {
        emit(emptyList())
        try {
            val networkResult = pictureListService.getPictures()
            emit(networkResult)
            pictureDao.insertAll(toDbModel(networkResult))
        } catch (throwable: Throwable) {}
    }

    fun getAllPictures(): Flow<List<Picture>> =
        pictureDao.getAllPictures().combine(getAllRemotePictures()) { local, remote ->
            toUiModel(remote, local)
        }

    fun getPictureFromId(pictureId: Int): Picture = pictureDao.getPictureFromId(pictureId)

    private fun toDbModel(pictureResponseList: List<PictureResponse>): List<Picture> {
        return pictureResponseList.map {
            Picture(
                it.id,
                it.albumId,
                it.title,
                it.url,
                it.thumbnailUrl
            )
        }
    }

    private fun toUiModel(pictureResponseList: List<PictureResponse>, pictureList: List<Picture>): List<Picture> {
        return if (pictureResponseList.isEmpty()) {
            pictureList
        } else return pictureResponseList.map {
            Picture(
                it.id,
                it.albumId,
                it.title,
                it.url,
                it.thumbnailUrl
            )
        }
    }
}
