package com.teguhrmdhn.simata.maincore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.teguhrmdhn.simata.R

class Adapter(val mCtx: Context, val layoutResId: Int, val list: List<Maincore> )
    : ArrayAdapter<Maincore>(mCtx,layoutResId,list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId,null)

        val textSto = view.findViewById<TextView>(R.id.textSto)
        val textEa = view.findViewById<TextView>(R.id.textEa)
        val textOa = view.findViewById<TextView>(R.id.textOa)

        val maincore = list[position]

        textSto.text = maincore.sto
        textEa.text = maincore.ea
        textOa.text = maincore.oa

        return view
    }
}