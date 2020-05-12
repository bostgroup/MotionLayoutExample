package group.bost.motionlayoutexample.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: List<String> = mutableListOf<String>().apply {
        for (i in 1..50) {
            add("Item $i")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolderExample(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    android.R.layout.simple_list_item_1,
                    parent,
                    false
                )
        )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(android.R.id.text1).text = list[position]
    }

}

private class ViewHolderExample(item: View): RecyclerView.ViewHolder(item) {

}