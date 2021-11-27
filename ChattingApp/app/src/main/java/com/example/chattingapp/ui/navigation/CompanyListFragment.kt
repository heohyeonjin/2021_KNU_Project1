package com.example.chattingapp.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chattingapp.ProfileActivity
import com.example.chattingapp.R
import com.example.chattingapp.adapter.CompanyAdapter
import com.example.chattingapp.data.model.Corporation

class CompanyListFragment : Fragment() {
    companion object {
        fun newInstance() : CompanyListFragment {
            return CompanyListFragment()
        }
    }

    var companyList = arrayListOf<Corporation>()
    private lateinit var listAdapter : CompanyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_company_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list: ArrayList<Corporation> = requireActivity().intent!!.extras!!.get("companyList") as ArrayList<Corporation>
        val companyView: RecyclerView = view.findViewById(R.id.fragment_company_list_recyclerview)
        listAdapter = CompanyAdapter(list)
        companyView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        companyView.adapter = listAdapter
        listAdapter.itemClick = object: CompanyAdapter.ItemClick{
            override fun OnClick(view: View, position: Int) {
                var intent = Intent(activity,ProfileActivity::class.java)
                intent.putExtra("corporation",list[position])
                startActivity(intent)

            }
        }


    }






}