package br.com.cwi.nespresso_app.presentation.feature.products.machineInfos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.databinding.ActivityMachineInfoBinding
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class MachineInfosActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMachineInfoBinding

    private val viewModel: MachineInfosViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpViewModel() {
        viewModel.machine.observe(this@MachineInfosActivity) { machine ->
            setUpAdapter(machine)
        }

        viewModel.loading.observe(this@MachineInfosActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@MachineInfosActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchMachineInfos(intent.getIntExtra("machine", 0))
    }

    private fun setUpAdapter(machine: Machine) {
        binding.tvMachineInfoName.text = machine.name
        binding.tvMachineInfoPrice.text = machine.unitPrice.toMoneyFormat(0)
        binding.tvMachineInfoDescription.text = machine.description

        Glide.with(this).load(machine.imageUrl).into(binding.ivMachineInfoPic)
    }

}