package com.lakooz.lpctest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakooz.lpctest.databinding.PotsFragmentBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pots_fragment.*

class PotsFragment : Fragment() {

    lateinit var viewModel: PotsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = PotsFragmentBinding.inflate(inflater, container, false)

        this.viewModel.pots.observe(this, Observer {
            (recycler_view.adapter as PotAdapter).setPots(it)
            Log.e("OBSERVER : ",it.toString())
        })
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = PotAdapter(context!!, layout_no_item)
        recycler_view.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.viewModel = ViewModelProviders.of(this).get(PotsViewModel::class.java)
        this.viewModel.category = (activity as MainActivity).viewPager2.currentItem
    }
}