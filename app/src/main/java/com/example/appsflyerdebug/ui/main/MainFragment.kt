package com.example.appsflyerdebug.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.appsflyerdebug.MainApplication
import com.example.appsflyerdebug.R
import kotlinx.android.synthetic.main.main_fragment.view.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.action.text = viewModel.actionText
        view.scheme.text = viewModel.schemeText
        view.host.text = viewModel.hostText
        view.path.text = viewModel.pathText
        view.opt_in_button.setOnClickListener {
            viewModel.optInClicked()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity?.application as? MainApplication)?.viewModelFactory?.also { viewModelFactory ->
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        }
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
}
