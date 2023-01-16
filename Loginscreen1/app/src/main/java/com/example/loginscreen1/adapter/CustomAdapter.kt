package com.example.loginscreen1.adapter

import android.R.layout
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.loginscreen1.R
import com.example.loginscreen1.databinding.CardViewDesignBinding
import com.example.loginscreen1.viewmodel.ItemsViewModel


class CustomAdapter(private val mList: MutableList<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private  lateinit var builder : AlertDialog.Builder
    fun addItem(item: ItemsViewModel){
        mList.add(item)
        notifyItemInserted(mList.size)
    }
    fun removeItem(position: Int) {
        mList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,mList.size)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        var binding = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text

        holder.itemView.setOnClickListener {
            // alert dialog
            val builder = AlertDialog.Builder(holder.itemView.context)
            val selectedItems = ArrayList<Int>()

            // Dialog title
            builder.setTitle("Your color pick")
                    .setMultiChoiceItems(R.array.testArray, null,
                        DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                            if (isChecked) {
                                selectedItems.add(which)
                            } else if (selectedItems.contains(which)) {
                                selectedItems.remove(which)
                            }
                        })
                    // Action button
                    .setPositiveButton("OK",
                        DialogInterface.OnClickListener { dialog, id ->
                            Toast.makeText(holder.itemView.context, "THANKS", Toast.LENGTH_LONG).show()
                        })
                    .show()
        }

        // remove item
        holder.removebutton.setOnClickListener {
            removeItem(position)
        }

    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(binding: CardViewDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imageview
        val textView: TextView = binding.textView
        val removebutton: Button = binding.removeButton
    }
}
