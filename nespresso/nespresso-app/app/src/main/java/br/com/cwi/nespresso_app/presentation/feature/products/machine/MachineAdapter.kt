package br.com.cwi.nespresso_app.presentation.feature.products.machine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.feature.products.viewholder.MachineViewHolder
import br.com.cwi.nespresso_app.domain.entity.Machine

class MachineAdapter(val context: Context, private val list: List<Machine>) : Adapter<MachineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_machine, parent, false)
        return MachineViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MachineViewHolder, position: Int) {
        val item = list[position]
        viewHolder.bind(context, item)
    }

    override fun getItemCount() = list.size
}