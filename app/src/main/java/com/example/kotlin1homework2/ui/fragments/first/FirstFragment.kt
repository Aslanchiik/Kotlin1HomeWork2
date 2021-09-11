package com.example.kotlin1homework2.ui.fragments.first

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.kotlin1homework2.databinding.FragmentFirstBinding
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class FirstFragment : Fragment() {

    private var url: ArrayList<String> = ArrayList()
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

        url = arrayListOf(
            "https://i.pinimg.com/564x/9f/c3/c2/9fc3c2d2989592e70c9464b23195a11c.jpg",
            "https://i.pinimg.com/236x/94/82/66/948266a93475b224e486167e4dcd6740.jpg",
            "https://i.pinimg.com/236x/11/88/17/1188171ba61d2b6d2e940826826ca203.jpg",
            "https://i.pinimg.com/564x/98/13/33/981333a599250e2fa60e6e073eb304be.jpg",
            "https://i.pinimg.com/236x/c7/83/ac/c783ac40e146ee618a3090f87af57c47.jpg"
        )
    }

    private fun clickListener() {
        binding.addButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.editText.text.toString())) {
                binding.editText.error = "Добавьте ссылку"
            } else {
                val image = binding.editText.text.toString()
                url.add(
                    image
                )
            }

        }
    }

    private fun setupClickRandom() {

        binding.randomButton.setOnClickListener {
            val random = Random().nextInt(url.size)
            Picasso.get()
                .load(url[random])
                .into(binding.imageView)
        }
    }

    private fun initialize() {
        initView()
        viewModel.data.value = url
    }


}