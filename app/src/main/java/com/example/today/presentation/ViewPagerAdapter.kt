package com.example.today.presentation

import java.util.*

/**
 * Created by Depression on 10-08-2018.
 */
class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {

    private val mFragmentList = ArrayList<androidx.fragment.app.Fragment>()

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        if(position == 1){

        }
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: androidx.fragment.app.Fragment) {
        mFragmentList.add(fragment)
        notifyDataSetChanged()
    }

    fun addFragmentAt(fragment: androidx.fragment.app.Fragment, position: Int) {
        mFragmentList.add(position, fragment)
        notifyDataSetChanged()
    }

    companion object {
        private val TAG = "ViewPagerAdapter"
    }
}
