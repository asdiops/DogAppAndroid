package com.example.randomimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.replace
import androidx.fragment.app.commit
import com.example.randomimage.databinding.ActivityMainBinding
import com.example.randomimage.network.NetworkClient
import com.example.randomimage.fragmtns.FragmentToAdd
import com.example.randomimage.fragmtns.FragmentToReplace

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var data: List<String> = listOf(
            "String1", "New String", "another string", "cat", "dog", "asdasd"
        )
//
//        binding.myList.layoutManager = LinearLayoutManager(this@MainActivity)
//        val myAdapter = ListAdapter()
//        binding.myList.adapter = myAdapter
//
//        myAdapter.setList(data)

        val networkClient = NetworkClient()
        networkClient.initClient()
//
//        networkClient.getDogImage() { imageAdress ->
//            Picasso.get().load(imageAdress).into(binding.myDogImage)
//        }
//
//        networkClient.getDogImage() { imageAdress ->
//            Picasso.get().load(imageAdress).into(binding.myDogImage2)
//        }


//        if (savedInstanceState == null) {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<MyNewFragment>(R.id.fragment_container_view)
//            }
//        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, MyNewFragment(this@MainActivity), "")
            }
        }
    }

    fun addFragment() {
        supportFragmentManager.commit {
            add<FragmentToAdd>(R.id.fragment_container_view)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }

    fun replaceFragment() {
        supportFragmentManager.commit {
            replace<FragmentToReplace>(R.id.fragment_container_view)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }

}