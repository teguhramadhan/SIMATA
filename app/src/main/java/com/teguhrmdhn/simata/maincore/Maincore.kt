package com.teguhrmdhn.simata.maincore

class Maincore (var id:String,
                var tanggal:String,
                var teknisi:String,
                var sto:String,
                var gpon_slot:String,
                var gpon_ip:String,
                var ea:String,
                var oa:String,
                var keterangan:String) {

    constructor() : this("", "", "", "", "", "", "", "", "") {

    }
}