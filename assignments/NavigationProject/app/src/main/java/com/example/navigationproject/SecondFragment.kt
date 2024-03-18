package com.example.navigationproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import androidx.core.view.isVisible
import com.example.navigationproject.databinding.FragmentSecondBinding

// Define constant keys for fragment arguments
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    // Interface for communication with the hosting activity
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    // Parameters for the fragment
    private var param1: String? = null
    private var param2: String? = null

    // Called when the fragment is being created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    // Called when the fragment's UI is being created
    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        arguments?.let {
            val args = SecondFragmentArgs.fromBundle(it)
            // Update UI based on arguments
            when (args.message) {
                "Button 1" -> {
                    binding.frag2TextView.text = "Image 1"
                    binding.frag2ImageView1.isVisible = true
                    binding.frag2ImageView2.isVisible = false
                    binding.frag2ImageView3.isVisible = false
                }
                "Button 2" -> {
                    binding.frag2TextView.text = "Image 2"
                    binding.frag2ImageView1.isVisible = false
                    binding.frag2ImageView2.isVisible = true
                    binding.frag2ImageView3.isVisible = false
                }
                "Button 3" -> {
                    binding.frag2TextView.text = "Image 3"
                    binding.frag2ImageView1.isVisible = false
                    binding.frag2ImageView2.isVisible = false
                    binding.frag2ImageView3.isVisible = true
                }
            }
        }
    }

    // Called to create the fragment's view hierarchy
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using view binding
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Called when the fragment's view is being destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        // Factory method to create a new instance of SecondFragment with provided parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
