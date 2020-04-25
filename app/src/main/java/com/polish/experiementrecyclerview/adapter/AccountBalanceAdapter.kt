package com.polish.experiementrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.experiementrecyclerview.databinding.ListItemBankBalanceBinding
import com.polish.experiementrecyclerview.model.AccountBalance

class AccountBalanceAdapter(val balance:ArrayList<AccountBalance>):ListAdapter<AccountBalance, AccountBalanceAdapter.BalanceViewHolder>(DiffCallback) {

    class BalanceViewHolder(var binding:ListItemBankBalanceBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(accountBalance:AccountBalance){

            binding.accountBalance = accountBalance

            binding.executePendingBindings()

        }


    }

    companion object DiffCallback: DiffUtil.ItemCallback<AccountBalance>(){
        override fun areItemsTheSame(oldItem: AccountBalance, newItem: AccountBalance): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AccountBalance, newItem: AccountBalance): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalanceViewHolder {
        return BalanceViewHolder(ListItemBankBalanceBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BalanceViewHolder, position: Int) {
        val accountBalance = getItem(position)

        holder.bind(accountBalance)
    }


}