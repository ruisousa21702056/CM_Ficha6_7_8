package com.example.acalculator.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import com.example.acalculator.ui.viewmodels.HistoryViewModel
import com.example.acalculator.R
import com.example.acalculator.ui.adapters.HistoryAdapter
import com.example.acalculator.ui.listeners.OnLongClick
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment(), OnLongClick {

    private val TAG = HistoryFragment::class.java.simpleName
    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.list_historic?.layoutManager = LinearLayoutManager(activity as Context)
        this.list_historic?.adapter =
            HistoryAdapter(
                activity as Context,
                R.layout.item_expression,
                viewModel.getHistory(),
                this
            )
    }

    override fun onLongClick(position: Int,view: View): Boolean {
        Log.e(TAG, "CLICK LONG $position")
        //lista.remove(po)
        return true
    }


}
