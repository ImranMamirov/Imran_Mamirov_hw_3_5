package com.example.imran_mamirov_hw_3_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import com.example.imran_mamirov_hw_3_5.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCounter.setOnClickListener {
            binding.tvCounter.text = counter.toString()
            if (binding.btnCounter.text == "+1") {
                if (counter < 10) {
                    counter++
                    binding.tvCounter.text = counter.toString()
                } else {
                    binding.btnCounter.text = "-1"
                }
            } else {
                if (counter <= 10 && counter > 0) {
                    counter--
                    binding.tvCounter.text = counter.toString()
                } else {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SecondFragment()).addToBackStack(null)
                        .commit()
                }
            }

        }


    }
}

