package fr.gregoiremd.cafeyntest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import fr.gregoiremd.cafeyntest.CafeynTestApplication
import fr.gregoiremd.cafeyntest.databinding.ActivityMainBinding
import fr.gregoiremd.cafeyntest.viewmodels.MainViewModel
import fr.gregoiremd.cafeyntest.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as CafeynTestApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.picturesRecyclerView.run {
            layoutManager = GridLayoutManager(context, 5)
            adapter = PicturesAdapter(this@MainActivity).apply {
                viewModel.picturesList.observe(this@MainActivity) { list ->
                    addItems(list)
                }
            }
        }
    }
}
