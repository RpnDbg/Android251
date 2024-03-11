package com.example.lifecycleawarev2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycleawarev2.DemoObserver
import com.example.lifecycleawarev2.R
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import com.example.lifecycleawarev2.databinding.ActivityMainBinding
import com.example.lifecycleawarev2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize ViewModel using ViewModelProvider
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    // Inflate the layout and return the root view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(DemoObserver())
        // Initialize ViewModel again to ensure consistency
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // update/observe viewModel ui
        val resultObserver = Observer<String> { result ->
            binding.eventText.text = result.toString()
        }
        viewModel.getStatus().observe(viewLifecycleOwner, resultObserver)
    }

}
