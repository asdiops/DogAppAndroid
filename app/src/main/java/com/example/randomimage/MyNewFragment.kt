package com.example.randomimage

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*
import com.example.randomimage.FragmentClickListener

class MyNewFragment(
    private val listener: FragmentClickListener
): Fragment(R.layout.fragment_my_new)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonAdd: Button = view.findViewById<Button>(R.id.add_fragment)
        buttonAdd.setOnClickListener {
            listener.addFragment()
        }

        val buttonReplace: Button = view.findViewById<Button>(R.id.replace_fragment)
        buttonReplace.setOnClickListener {
            listener.replaceFragment()
        }
    }
}

//class MyNewFragment : Fragment(R.layout.fragment_my_new) {
//    private lateinit var binding: FragmentMyNewBinding
//}

//class MyNewFragment : Fragment(R.layout.fragment_my_new)


//class MyNewFragment : Fragment(R.layout.fragment_my_new)

//class MyNewFragment : Fragment() {
//    private lateinit var binding: FragmentMyNewBinding
//
//    val fragmentManager
//
//    fun onCreate() {
//        fragmentManager.commit {
//            setReorderingAllowed(true)
//            // Replace whatever is in the fragment_container view with this fragment
//            replace<MyNewFragment>(binding.root)
//        }
//
//    }
//}