package com.example.kotlin1homework2.ui.fragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin1homework2.databinding.FragmentSecondFragmentsBinding
import com.example.kotlin1homework2.ui.adapters.TaskAdapter
import com.example.kotlin1homework2.ui.fragments.first.SharedViewModel

class SecondFragments : Fragment() {

    private lateinit var binding: FragmentSecondFragmentsBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private val taskAdapter: TaskAdapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondFragmentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupObserves()

    }

    private fun setupRecycler() {
        binding.recView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = taskAdapter
        }
    }

    private fun setupObserves() {
        viewModel.list.observeForever {
            taskAdapter.submitList(it)
        }
    }
}
