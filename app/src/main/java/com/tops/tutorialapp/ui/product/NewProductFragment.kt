package com.tops.tutorialapp.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tops.tutorialapp.R
import com.tops.tutorialapp.databinding.FragmentNewProductBinding

class NewProductFragment : Fragment() {

    private lateinit var binding: FragmentNewProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewProductBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


}