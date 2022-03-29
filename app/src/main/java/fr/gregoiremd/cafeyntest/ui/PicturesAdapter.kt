package fr.gregoiremd.cafeyntest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.gregoiremd.cafeyntest.BR
import fr.gregoiremd.cafeyntest.databinding.PictureItemBinding
import fr.gregoiremd.cafeyntest.storage.Picture


class PicturesAdapter(private val pictures: MutableList<Picture> = mutableListOf()) :
    RecyclerView.Adapter<PicturesAdapter.PicturesViewHolder>() {

    inner class PicturesViewHolder(private val binding: PictureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: Picture) {
            binding.setVariable(BR.picture, picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        val binding = PictureItemBinding.inflate(LayoutInflater.from(parent.context))
        return PicturesViewHolder(binding)
    }

    override fun getItemCount(): Int = pictures.size

    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        holder.bind(pictures[position])
    }

    fun addItems(pictures: List<Picture>) {
        this.pictures.clear()
        this.pictures.addAll(pictures)
        notifyDataSetChanged()
    }
}
