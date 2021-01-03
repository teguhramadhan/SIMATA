package com.teguhrmdhn.simata.maincore

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.teguhrmdhn.simata.R
import kotlinx.android.synthetic.main.activity_add_maincore.*

class Adapter(val mCtx: Context, val layoutResId: Int, val list: List<Maincore> )
    : ArrayAdapter<Maincore>(mCtx,layoutResId,list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId,null)

        //deklarasi for update
        val btnUpdate = view.findViewById<TextView>(R.id.btn_update)
//        val btnDelete = view.findViewById<TextView>(R.id.btn_delete)

        //deklarasi for input
        val textJudul = view.findViewById<TextView>(R.id.textJudul)
        val textKeterangan = view.findViewById<TextView>(R.id.textKeterangan)
        val textTanggal = view.findViewById<TextView>(R.id.textTanggal)

        val maincore = list[position]

        textJudul.text = maincore.judul
        textKeterangan.text = maincore.keterangan
        textTanggal.text = maincore.tanggal


        btnUpdate.setOnClickListener {
            showUpdateDialog(maincore)
        }

//        btnDelete.setOnClickListener {
//            Deleteinfo(maincore)
//        }

        return view
    }

    private fun Deleteinfo(maincore: Maincore) {
        val progressDialog = ProgressDialog(context, R.style.Theme_MaterialComponents_Light_Dialog)

        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Deleting...")
        progressDialog.show()

        val mydatabase = FirebaseDatabase.getInstance().getReference("MAINCORE")

        mydatabase.child(maincore.id).removeValue()
        Toast.makeText(mCtx,"Deleted!!",Toast.LENGTH_SHORT).show()

        val intent = Intent(context, ShowMaincoreActivity::class.java)
        context.startActivity(intent)
    }

    private fun showUpdateDialog(maincore: Maincore) {
        val builder = AlertDialog.Builder(mCtx)

        builder.setTitle("Update")

        val inflater = LayoutInflater.from(mCtx)

        val view = inflater.inflate(R.layout.update_maincore, null)

        val textTanggal = view.findViewById<EditText>(R.id.et_tanggal)
        val textJudul = view.findViewById<EditText>(R.id.et_judul)
        val textTeknisi = view.findViewById<EditText>(R.id.et_teknisi)
        val textSto = view.findViewById<EditText>(R.id.et_sto)
        val textGponSlot = view.findViewById<EditText>(R.id.et_gponslot)
        val textGponIp = view.findViewById<EditText>(R.id.et_gponip)
        val textEa = view.findViewById<EditText>(R.id.et_ea)
        val textOa = view.findViewById<EditText>(R.id.et_oa)
        val textOdc = view.findViewById<EditText>(R.id.et_odc)
        val textKeterangan = view.findViewById<EditText>(R.id.et_keterangan)

        textTanggal.setText(maincore.tanggal)
        textJudul.setText(maincore.judul)
        textTeknisi.setText(maincore.teknisi)
        textSto.setText(maincore.sto)
        textGponSlot.setText(maincore.gpon_slot)
        textGponIp.setText(maincore.gpon_ip)
        textEa.setText(maincore.ea)
        textOa.setText(maincore.oa)
        textOdc.setText(maincore.odc)
        textKeterangan.setText(maincore.keterangan)

        builder.setView(view)

        builder.setPositiveButton("Update Data Maincore") { dialog, which ->

            val dbMaincore = FirebaseDatabase.getInstance().getReference("MAINCORE")

            val tanggal = textTanggal.text.toString().trim()
            val judul = textJudul.text.toString().trim()
            val teknisi = textTeknisi.text.toString().trim()
            val sto = textSto.text.toString().trim()
            val gpon_slot = textGponSlot.text.toString().trim()
            val gpon_ip = textGponIp.text.toString().trim()
            val ea = textEa.text.toString().trim()
            val oa = textOa.text.toString().trim()
            val odc = textOdc.text.toString().trim()
            val keterangan = textKeterangan.text.toString().trim()

            if (sto.isEmpty()){
                textSto.error = "please enter name"
                textSto.requestFocus()
                return@setPositiveButton
            }

            if (ea.isEmpty()){
                textEa.error = "please enter status"
                textEa.requestFocus()
                return@setPositiveButton
            }

            if (oa.isEmpty()){
                textEa.error = "please enter status"
                textEa.requestFocus()
                return@setPositiveButton
            }


            val maincore = Maincore(maincore. id, tanggal, judul, teknisi, sto, gpon_slot, gpon_ip, ea, oa, odc, keterangan)

            dbMaincore.child(maincore.id).setValue(maincore).addOnCompleteListener {
                Toast.makeText(mCtx,"Updated", Toast.LENGTH_SHORT).show()
            }

        }

        builder.setNegativeButton("No") { dialog, which ->

        }

        val alert = builder.create()
        alert.show()

    }
}