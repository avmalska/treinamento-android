package br.com.cwi.nespresso_app.presentation.feature.products.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemMachineBinding
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

class MachineViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvName = ItemMachineBinding.bind(item).tvMachineName
    private val tvPrice = ItemMachineBinding.bind(item).tvMachinePrice
    private val ivMachine = ItemMachineBinding.bind(item).ivMachinePhoto

    fun bind(context: Context, item: Machine) {
        tvName.text = item.name
        tvPrice.text = item.unitPrice.toMoneyFormat(0)

        Glide.with(context)
            .load(item.imageUrl)
            .into(ivMachine)
    }
}