package com.`var`.gobuyy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.`var`.gobuyy.databinding.ActivityAddProductsBinding
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class AddProducts : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductsBinding
    var fStore: FirebaseFirestore? = null
    private val itemList: MutableList<AddProducts> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_products)

        fStore = FirebaseFirestore.getInstance()

        var binding: ActivityAddProductsBinding = ActivityAddProductsBinding.inflate(layoutInflater)

        binding.addProductBtn.setOnClickListener(View.OnClickListener {
            val id: String = itemList.size.toString().trim { it <= ' ' }
            val brandName: String = binding.brand.getText().toString()
            val itemDescription: String = binding.Name.getText().toString().trim { it <= ' ' }
            val price: String = binding.price.getText().toString().trim { it <= ' ' }
            val image: String = ""
            val stat: Boolean
            val documentReference: DocumentReference =
                fStore!!.collection("Products").document(id)
            val products: MutableMap<String, Any> = HashMap()
            products["id"] = id
            products["brandName"] = brandName
            products["itemDescription"] = itemDescription
            products["price"] = price
            products["itemImage"] = "https://firebasestorage.googleapis.com/v0/b/go-buyy.appspot.com/o/rayban.jpg?alt=media&token=27a090c4-6c84-4d74-92c8-a26f34512b1d"
            documentReference.set(products).addOnSuccessListener {
                startActivity(
                    Intent(
                        applicationContext,
                        AddProducts::class.java
                    ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                )
            }.addOnFailureListener { e ->
            }
        })
    }
}
