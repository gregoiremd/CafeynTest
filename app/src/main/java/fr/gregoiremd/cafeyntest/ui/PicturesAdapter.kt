package fr.gregoiremd.cafeyntest.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import fr.gregoiremd.cafeyntest.BR
import fr.gregoiremd.cafeyntest.databinding.PictureItemBinding
import fr.gregoiremd.cafeyntest.storage.Picture


class PicturesAdapter(private val context: Context, private val pictures: MutableList<Picture> = mutableListOf()) :
    RecyclerView.Adapter<PicturesAdapter.PicturesViewHolder>() {

    inner class PicturesViewHolder(private val binding: PictureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: Picture) {
            binding.setVariable(BR.picture, picture)
            binding.root.setOnClickListener {
                onSelect(picture)
            }
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

    fun onSelect(picture: Picture) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("picture", picture)
        startActivity(context, intent, null)
    }
}
