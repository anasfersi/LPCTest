package com.lakooz.lpctest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakooz.lpctest.databinding.PotItemBinding
import com.lakooz.lpctest.model.Pot

class PotAdapter(private val context: Context, private var emptyView: View? = null) :
    RecyclerView.Adapter<PotAdapter.ViewHolder>() {


    private var pots: List<Pot>? = null
    private var recyclerView: RecyclerView? = null


    fun setPots(pots: List<Pot>?) {
        this.pots = pots
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PotItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = if (pots != null) pots!!.size else 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textAmountPot.text = pots?.get(position)?.amount.toString()
        holder.binding.textTitlePot.text = pots?.get(position)?.name
        holder.binding.textContributorsPot.text = pots?.get(position)?.contributorsCount.toString()
       // holder.binding.imagePot.u = pots?.get(position)?.contributorsCount.toString()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView

    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = null

        super.onDetachedFromRecyclerView(recyclerView)
    }

    inner class ViewHolder(val binding: PotItemBinding) : RecyclerView.ViewHolder(binding.root)
}