package com.example.burclarrehberi

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*


class BurclarBaseAdapter(context: Context) : BaseAdapter() {
    var tumBurclar: ArrayList<Burclar>
    var context: Context

    init {
        tumBurclar = ArrayList(12)
        this.context = context

        var b_adi = context.resources.getStringArray(R.array.burclar)
        var b_tarih = context.resources.getStringArray(R.array.burcTarih)
        var b_sembol = arrayOf(
            R.drawable.koc1,
            R.drawable.boga2,
            R.drawable.ikizler3,
            R.drawable.yengec4,
            R.drawable.aslan5,
            R.drawable.basak6,
            R.drawable.terazi7,
            R.drawable.akrep8,
            R.drawable.yay9,
            R.drawable.oglak10,
            R.drawable.kova11,
            R.drawable.balik12
        )
        for (i in 0..11) {
            var ArrayListeAtanacakburc = Burclar(b_adi[i], b_tarih[i], b_sembol[i])
            tumBurclar.add(ArrayListeAtanacakburc)

        }

    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var tek_satir_view = convertView
        var tutucu: ViewHolder
        if (tek_satir_view == null) {

            var inflater = LayoutInflater.from(context)
            tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)
            tutucu = ViewHolder(tek_satir_view)
            tek_satir_view.tag = tutucu
        } else {
            tutucu = tek_satir_view.tag as ViewHolder
        }

        tutucu.burcAdi.setText(tumBurclar.get(position).burcAdi)
        tutucu.burcTarih.setText((tumBurclar.get(position).burcTarih))
        tutucu.burcSembol.setImageResource(tumBurclar.get(position).burcSembol)
        return tek_satir_view


    }

    override fun getItem(position: Int): Any {
        return tumBurclar.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumBurclar.size
    }


}

data class Burclar(var burcAdi: String, var burcTarih: String, var burcSembol: Int) {}
class ViewHolder(tek_satir_view: View) {
    var burcAdi: TextView
    var burcTarih: TextView
    var burcSembol: ImageView

    init {
        this.burcAdi = tek_satir_view.tvBurcAdi
        this.burcTarih = tek_satir_view.tvBurcTarihi
        this.burcSembol = tek_satir_view.imgBurcSembol
    }
}

