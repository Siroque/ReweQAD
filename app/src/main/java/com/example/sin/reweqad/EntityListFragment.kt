package com.example.sin.reweqad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import com.example.sin.reweqad.adapters.EntityListAdapter
import com.example.sin.reweqad.databinding.FragmentEntityListBinding
import com.example.sin.reweqad.utilities.InjectorUtils
import com.example.sin.reweqad.viewmodels.EntityListViewModel

class EntityListFragment : Fragment() {
    private lateinit var viewModel: EntityListViewModel
    var criterion:Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val binding = FragmentEntityListBinding.inflate(inflater, container, false)
        val binding = FragmentEntityListBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = InjectorUtils.provideEntityListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(EntityListViewModel::class.java)
        viewModel.setCriterion(criterion);
        viewModel.getEntities().observe(this, Observer {
            val adapter = EntityListAdapter(it)
            binding.entityList.adapter = adapter
        })
        return binding.root
    }
}