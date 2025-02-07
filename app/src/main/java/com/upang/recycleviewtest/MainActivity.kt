package com.upang.recycleviewtest

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList: ArrayList<Songs>
    lateinit var title: Array<String>
    lateinit var artist: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        title = arrayOf(
            "711","ERE", "Miss Miss", "Saan?", "Mahika"
        )
        artist = arrayOf("TONEEJAY", "Juan Karlos", "Rob Deniel", "Maki", "Adie & Janine Berdin")

        newRecyclerview = findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<Songs>()
        getUserData()

    }

    private fun getUserData() {

        for ( i in title.indices) {
            val songs = Songs(title[i],artist[i])
            newArrayList.add(songs)
        }

        newRecyclerview.adapter = SongsAdapter(newArrayList)
    }
}