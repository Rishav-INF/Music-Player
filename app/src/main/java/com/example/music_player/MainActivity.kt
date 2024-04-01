package com.example.music_player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_player.databinding.ActivityMainBinding
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  searchView: SearchView
    private lateinit var searchList: ArrayList<song_class>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create a list of songs
        val songList = mutableListOf<song_class>()
        songList.add(song_class("Bohemian Rhapsody", "Queen"))
        songList.add(song_class("Hotel California", "Eagles"))
        songList.add(song_class("Stairway to Heaven", "Led Zeppelin"))
        songList.add(song_class("Smells Like Teen Spirit", "Nirvana"))
        songList.add(song_class("Imagine", "John Lennon"))
        songList.add(song_class("Like a Rolling Stone", "Bob Dylan"))
        songList.add(song_class("Hey Jude", "The Beatles"))
        songList.add(song_class("Purple Haze", "Jimi Hendrix"))
        songList.add(song_class("Sweet Child o' Mine", "Guns N' Roses"))
        songList.add(song_class("Another Brick in the Wall", "Pink Floyd"))
        songList.add(song_class("Yesterday", "The Beatles"))
        songList.add(song_class("Comfortably Numb", "Pink Floyd"))
        songList.add(song_class("Wonderwall", "Oasis"))
        songList.add(song_class("Under the Bridge", "Red Hot Chili Peppers"))
        // Add more songs as needed...


        // Set up RecyclerView
        binding.RecyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        // Create and set up your songAdapter
        binding.RecyclerView.adapter=songAdapter(songList)

        searchList= arrayListOf<song_class>()
        binding.search.clearFocus()
        searchView=findViewById(R.id.search)
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
              searchView.clearFocus()
              return true
            }


override fun onQueryTextChange(newText: String?): Boolean {
    searchList.clear()
    val searchText = newText!!.toLowerCase(Locale.getDefault())
    if (searchText.isNotEmpty()) {
        songList.forEach {
            if (it.Song.toLowerCase(Locale.getDefault()).contains(searchText)) {
                searchList.add(it)
            }
        }
        // Update RecyclerView adapter with filtered list
        (binding.RecyclerView.adapter as songAdapter).updateList(searchList)
    } else {
        // If search text is empty, show original list
        (binding.RecyclerView.adapter as songAdapter).updateList(songList)
    }
    return false
}


        })

        binding.gotoo.setOnClickListener(){
           val intent= Intent(this,musix::class.java)
            startActivity(intent)
        }

    }

}

