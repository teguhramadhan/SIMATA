package com.teguhrmdhn.simata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_maincore.*

class AddMaincoreActivity : AppCompatActivity() {

    lateinit var tanggal:String
    lateinit var teknisi:String
    lateinit var sto:String
    lateinit var gpon_slot:String
    lateinit var gpon_ip:String
    lateinit var ea:String
    lateinit var oa:String
    lateinit var keterangan:String

    private lateinit var mDatabaseReference : DatabaseReference
    private lateinit var mFirebaseInstance : FirebaseDatabase
    private lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_maincore)


        mDatabaseReference = FirebaseDatabase.getInstance().getReference("MAINCORE")

        btn_inputdatamaincore.setOnClickListener {
            saveDataMaincore()
        }
    }

    private fun saveDataMaincore() {
        val datamaincore = Maincore(tanggal, teknisi, sto, gpon_slot, gpon_ip, ea, oa,keterangan)
        val userId = mDatabaseReference.push().key.toString()

        mDatabaseReference.child(userId).setValue(datamaincore).addOnCompleteListener {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            et_tanggal.setText("")
            et_teknisi.setText("")
            et_sto.setText("")
            et_gponslot.setText("")
            et_gponip.setText("")
            et_ea.setText("")
            et_oa.setText("")
            et_keterangan.setText("")
        }
    }
}