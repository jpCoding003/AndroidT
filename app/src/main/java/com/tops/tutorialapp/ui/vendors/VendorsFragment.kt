package com.tops.tutorialapp.ui.vendors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tops.tutorialapp.R
import com.tops.tutorialapp.R.layout
import com.tops.tutorialapp.R.layout.fragment_vendors
import com.tops.tutorialapp.databinding.FragmentVendorsBinding

class VendorsFragment : Fragment() {

    private lateinit var binding: FragmentVendorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding=FragmentVendorsBinding.inflate(layoutInflater)
//        return binding.root
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vendors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}