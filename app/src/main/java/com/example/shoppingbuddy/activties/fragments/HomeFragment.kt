package com.example.shoppingbuddy.activties.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingbuddy.R
import com.example.shoppingbuddy.activties.adapter.HomeRecyclerAdapter
import com.example.shoppingbuddy.activties.models.Products

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
   lateinit var recyclerHome : RecyclerView
   lateinit var layoutManager : RecyclerView.LayoutManager
   val productList = arrayListOf(
       "Bricks","CementBags","Helmet","Hoe","Glove","Masonry Tool","Mixer","Iron Rods"
   )
    val productInfoList = arrayListOf<Products>(
        Products("Bricks","GoldBricks","$0.3/brick","4.2",R.drawable.brick),
        Products("CementBags","Ultra_tech","$6.5/bag","4.5",R.drawable.cement),
        Products("Helmet","Solidan","$10/piece","4.0",R.drawable.helmet),
        Products("Hoe","ACC","$3/piece","4.1",R.drawable.shovel),
        Products("Glove","Limits","$4/pair","4.6",R.drawable.gloves),
        Products("Masonry Tool","Small_Fitter","$2/piece","4.3",R.drawable.trowel),
        Products("Mixer","Ashok_LeyLand","$200/piece","4.4",R.drawable.concrete_mixer),
        Products("Steel Bars","TATA Tiscon","$10/piece","4.1",R.drawable.iron_bar)

    )
    lateinit var homerecyclerAdapter: HomeRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home,container,false)
        recyclerHome = view.findViewById(R.id.home_recycler_view)
        layoutManager = LinearLayoutManager(activity)
        homerecyclerAdapter = HomeRecyclerAdapter(activity as Context, productInfoList)
        recyclerHome.adapter = homerecyclerAdapter
        recyclerHome.layoutManager = layoutManager
        recyclerHome.addItemDecoration(
            DividerItemDecoration(
                recyclerHome.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}