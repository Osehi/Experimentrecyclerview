package com.polish.experiementrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polish.experiementrecyclerview.adapter.AccountBalanceAdapter
import com.polish.experiementrecyclerview.model.AccountBalance
import com.polish.experiementrecyclerview.utils.ItemDeleteListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // list of bank account details
        var accountList = arrayListOf<AccountBalance>()

        val strength = AccountBalance(1,"234XXXX786", "GTBANK", "Checked 30th March, 2020", "$300", "$300")
        val peace = AccountBalance(2,"980XXXX345", "GTBANK", "Checked 23rd Apr., 2020", "$150", "$150")
        val power = AccountBalance(3,"345XXXX096", "GTBANK", "Checked 5th June, 2020", "$900", "$900")

        // populate the list
        accountList.add(strength)
        accountList.add(peace)
        accountList.add(power)


        val recyclerView:RecyclerView = findViewById(R.id.myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var adapter = AccountBalanceAdapter(accountList, AccountBalanceAdapter.OnClickListener{}, object :ItemDeleteListener{
            override fun onItemDelete(position:Int) {
                accountList.removeAt(position)
            }
        })
        recyclerView.adapter = adapter
        adapter.submitList(accountList)


    }








}
