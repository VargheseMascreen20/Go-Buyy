package com.`var`.gobuyy.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.`var`.gobuyy.Models.ProductModel
import com.`var`.gobuyy.R

class HomeAdapter(var itemList: List<ProductModel>?) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    //    private var itemList: List<ItemModel>? = null
    private var clickListener: ClickListener? = null
    /*fun MyAdapter(itemList: List<ItemModel>?) {
        this.itemList = itemList
    }*/

    class MyViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {
        var itemName: TextView
        var brandName: TextView
        var productImage: ImageView
        var price: TextView
        var main: LinearLayout

        init {
            itemName = parent.findViewById(R.id.itemName)
            brandName = parent.findViewById(R.id.brandName)
            price = parent.findViewById(R.id.price)
            productImage = parent.findViewById(R.id.productImage)

            main = parent.findViewById(R.id.main)
        }
    }

    fun setClickListener(clickListener: ClickListener?) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_product, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val row: ProductModel = itemList!![position]
        holder.itemName.setText(row.itemDescription)
        holder.brandName.setText(row.brandName)
        holder.productImage.setImageResource(row.itemImage!!)
        holder.main.setOnClickListener {
            Log.e("Position adapter:", position.toString())
            if (clickListener != null) {
                clickListener?.itemClicked(it, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList!!.size
    }

    interface ClickListener {
        fun itemClicked(view: View?, position: Int)
    }
}