package com.tops.tutorialapp.Fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.tutorialapp.DashboardDawer
import com.tops.tutorialapp.IS_Login
import com.tops.tutorialapp.R
import com.tops.tutorialapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnsignup.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace<SignupFragment>(R.id.fragmentContainerView)
                addToBackStack(LoginFragment::class.java.name)
            }
        }

        binding.btnlogin.setOnClickListener {

            val username = binding.mtusername.text.toString()
            val password = binding.mtpassword.text.toString()

            if (username== ""){
                binding.mtusername.error = " Enter valid Username!"
                return@setOnClickListener
            }
            if (password == ""){
                binding.mtpassword.error = " Enter valid Password!"
                return@setOnClickListener
            }
            if (username== "" && password == "" ){
                binding.mtusername.error = " Enter valid Username!"
                binding.mtpassword.error = " Enter valid Password!"
                return@setOnClickListener
            }

            val sharedPref = activity?.getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE)?: return@setOnClickListener
            with(sharedPref.edit()){
                putBoolean(IS_Login,true)
                apply()
            }
            val intent = Intent(context, DashboardDawer::class.java)
            startActivity(intent)
        }
    }
}