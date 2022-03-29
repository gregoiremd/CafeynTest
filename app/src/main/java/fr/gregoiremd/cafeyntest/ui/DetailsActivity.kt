package fr.gregoiremd.cafeyntest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.gregoiremd.cafeyntest.BR
import fr.gregoiremd.cafeyntest.databinding.ActivityDetailsBinding
import fr.gregoiremd.cafeyntest.storage.Picture

class DetailsActivity : AppCompatActivity() {

    //private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val picture: Picture = intent.getParcelableExtra("picture")!!
        //viewModel = ViewModelProvider(this, Injection.provideViewModelFactoryPictureDetails(this, picture.id))[DetailsViewModel::class.java]

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.setVariable(BR.picture, picture)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
