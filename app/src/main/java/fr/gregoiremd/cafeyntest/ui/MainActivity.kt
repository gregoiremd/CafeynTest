package fr.gregoiremd.cafeyntest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import fr.gregoiremd.cafeyntest.data.Injection.provideViewModelFactoryPicturesList
import fr.gregoiremd.cafeyntest.databinding.ActivityMainBinding
import fr.gregoiremd.cafeyntest.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, provideViewModelFactoryPicturesList(this))[MainViewModel::class.java]

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
