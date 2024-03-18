@file:Suppress("DEPRECATION")

package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object;

    // Binding for the fragment's layout
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    // View model for the fragment
    private lateinit var viewModel: MainViewModel

    //  create the fragment's view hierarchy
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Called when the fragment's activity has been created
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // Set click listeners for buttons to navigate to the second fragment
        binding.button.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = binding.button.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = binding.button2.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = binding.button3.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

    // Called when the fragment's view is being destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
