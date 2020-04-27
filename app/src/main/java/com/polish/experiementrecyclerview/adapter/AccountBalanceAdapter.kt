package com.polish.experiementrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.experiementrecyclerview.databinding.ListItemBankBalanceBinding
import com.polish.experiementrecyclerview.model.AccountBalance
import com.polish.experiementrecyclerview.utils.ItemDeleteListener
import kotlinx.android.synthetic.main.list_item_bank_balance.view.*

class AccountBalanceAdapter(val balance:ArrayList<AccountBalance>, val onClickListener:OnClickListener, val onItemDeleteListener: ItemDeleteListener):ListAdapter<AccountBalance, AccountBalanceAdapter.BalanceViewHolder>(DiffCallback) {

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
        holder.itemView.setOnClickListener {
            onClickListener.onClick(accountBalance)
        }

//        holder.binding.deleteCardInfoId.setOnClickListener {
//            onClickListener.onDelete(accountBalance)
//        }

//        holder.itemView.deleteCardInfoId.setOnClickListener {
//            onClickListener.onDelete(accountBalance)
//        }
        holder.itemView.deleteCardInfoId.setOnClickListener {
            onItemDeleteListener.onItemDelete(accountBalance)
        }

        holder.bind(accountBalance)
    }

    class OnClickListener(val clickListener:(accountBalance:AccountBalance) -> Unit){

        fun onClick(accountBalance:AccountBalance) = clickListener(accountBalance)


    }


}