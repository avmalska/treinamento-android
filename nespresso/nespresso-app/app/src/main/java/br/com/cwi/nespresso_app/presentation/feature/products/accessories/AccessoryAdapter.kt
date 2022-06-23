package br.com.cwi.nespresso_app.presentation.feature.products.accessories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.domain.entity.Accessory
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.ItemType
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.feature.products.viewholder.AccessoryViewHolder
import br.com.cwi.nespresso_app.presentation.feature.products.viewholder.CategoryViewHolder

class AccessoryAdapter(private val context: Context, private val list: List<Type>) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == ItemType.CATEGORY.value) {
            val view = inflateView(R.layout.item_category, parent)
            CategoryViewHolder(view)

        } else {
            val view = inflateView(R.layout.item_accessory, parent)
            AccessoryViewHolder(view)

        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        if (item.type == ItemType.CATEGORY) {
            item as Category
            (viewHolder as CategoryViewHolder).bind(item)

        } else {
            item as Accessory
            (viewHolder as AccessoryViewHolder).bind(context, item)
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int) = list[position].type.value

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}