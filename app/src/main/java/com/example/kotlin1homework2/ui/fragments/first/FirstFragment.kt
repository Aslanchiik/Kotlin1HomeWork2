package com.example.kotlin1homework2.ui.fragments.first

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.kotlin1homework2.databinding.FragmentFirstBinding
import com.example.kotlin1homework2.utils.getTextE
import com.example.kotlin1homework2.utils.setErrorE
import com.example.kotlin1homework2.utils.setImagePic
import java.util.*

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        clickListener()
        setupClickRandom()
        initialize()
    }


    private fun initView() {
        viewModel.listImage()
    }

    private fun clickListener() {

        binding.addButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.editText.getTextE())) {
                binding.editText.setErrorE()
            } else {
                val image = binding.editText.getTextE()
                viewModel.addImage(image)
                viewModel.url.add(image)

            }

        }
    }

    private fun setupClickRandom() {
        binding.randomButton.setOnClickListener {
            binding.imageView.setImagePic(viewModel.random())

        }
    }

    private fun initialize() {
        initView()
        viewModel.data.observeForever {
            viewModel.updateImage(viewModel.url.toString())

        }
    }
}
