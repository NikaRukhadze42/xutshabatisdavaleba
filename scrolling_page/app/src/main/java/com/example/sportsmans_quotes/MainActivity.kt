package com.example.sportsmans_quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RemoveItem{

    private val items = mutableListOf<Item>()
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var cases: Array<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        cases = arrayOf(
            Item(R.mipmap.ic_brady, "T. Brady", "'I'm a pretty good winner. I'm a terrible loser. And I rub it in pretty good when I win'"),
            Item(R.mipmap.ic_kobe, "K. Bryant", "'Winning takes precedence over all. There's no gray area. No almosts'"),
            Item(R.mipmap.ic_lebron, "LeBron", "'You have to be able to accept failure to get better'"),
            Item(R.mipmap.ic_lewis, "L. Hamilton", "'I don't aspire to be like other drivers - I aspire to be unique in my own way'"),
            Item(R.mipmap.ic_marquez, "M. Marquez", "'There is no reward without work'"),
            Item(R.mipmap.ic_messi, "L. Messi", "'You have to fight to reach your dream. You have to sacrifice and work hard for it'"),
            Item(R.mipmap.ic_ronaldo, "C. Ronaldo", "'Your love makes me strong. Your hate makes me unstoppable'"),
            Item(R.mipmap.ic_rossi, "V. Rossi", "'I'm Valentino Rossi. And I want to be a person, not an icon'"),
            Item(R.mipmap.ic_tiger, "T. Woods", "'No matter how good you get you can always get better and that’s the exciting part'"),
            Item(R.mipmap.ic_usain, "U. Bolt", "'Kill them with success and bury them with a smile'"))
        adapter = RecyclerViewAdapter(items , itemClick)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private val itemClick = object : RemoveItem{
        override fun onClick(position: Int) {
            items.removeAt(position)
            adapter.notifyItemRemoved(position)
        }

    }

    fun addItemOnClick(view:View)
    {
        val randomCase = cases.indices.random()
        items.add(0, cases[randomCase])
        adapter.notifyItemInserted(0)
        recyclerView.scrollToPosition(0)
    }

    override fun onClick(position: Int) {

    }


}

