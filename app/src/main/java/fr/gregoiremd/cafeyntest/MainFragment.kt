package fr.gregoiremd.cafeyntest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var selectedAlbum: Album? = null
    private lateinit var viewModelBasic: BasicMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelBasic = BasicMainViewModel()
        viewModelBasic.uiModel.observe(this, Observer<UiModel>{ uiModel ->
            // update UI
        })
    }
}