package fr.gregoiremd.cafeyntest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import fr.gregoiremd.cafeyntest.CafeynTestApplication
import fr.gregoiremd.cafeyntest.databinding.ActivityDetailsBinding
import fr.gregoiremd.cafeyntest.storage.Picture
import fr.gregoiremd.cafeyntest.viewmodels.DetailsViewModel
import fr.gregoiremd.cafeyntest.viewmodels.DetailsViewModelFactory
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val picture: Picture = intent.getParcelableExtra("picture")!!
        val viewModel: DetailsViewModel by viewModels {
            DetailsViewModelFactory((application as CafeynTestApplication).repository, picture)
        }
        //val pictureId: Int = intent.getIntExtra("pictureId", 0)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        binding.picture = picture

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
