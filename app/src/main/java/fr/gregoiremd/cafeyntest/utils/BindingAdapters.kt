package fr.gregoiremd.cafeyntest.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String) {
    Picasso.get().load(url).into(this)
}

@BindingAdapter("android:text")
fun TextView.text(text: Int) {
    this.text = "$text"
}
