package br.com.cwi.nespresso_app.presentation.feature.products.viewholder

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemMachineBinding
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.feature.products.machineInfos.MachineInfosActivity
import com.bumptech.glide.Glide

class MachineViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvName = ItemMachineBinding.bind(item).tvMachineName
    private val tvPrice = ItemMachineBinding.bind(item).tvMachinePrice
    private val ivMachine = ItemMachineBinding.bind(item).ivMachinePhoto
    private val clMachineContent = ItemMachineBinding.bind(item).clMachineContent

    fun bind(context: Context, machine: Machine) {
        tvName.text = machine.name
        tvPrice.text = machine.unitPrice.toMoneyFormat(0)

        Glide.with(context)
            .load(machine.imageUrl)
            .into(ivMachine)

        with(clMachineContent) {
            setOnClickListener {
                val intent = Intent(context, MachineInfosActivity::class.java)
                    .putExtra("machine", machine.id)
                startActivity(context, intent, null)
            }
        }
    }
}