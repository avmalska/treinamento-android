package br.com.cwi.nespresso_app.presentation.feature.products.accessories

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityAccessoryBinding
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccessoryActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityAccessoryBinding

    private val viewModel: AccessoryViewModel by viewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
    }

    override fun getBottomNavigation() = binding.contentBottomNavigation.bottomNavigation

    private fun setUpViewModel() {
        viewModel.accessories.observe(this@AccessoryActivity) { list ->
            setUpAccessoriesRecyclerView(list)
        }

        viewModel.loading.observe(this@AccessoryActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@AccessoryActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchAccessories()
    }

    private fun setUpAccessoriesRecyclerView(list: List<Type>) {
        binding.rvAccessories.apply {
            addItemDecoration(
                DividerItemDecoration(this@AccessoryActivity, DividerItemDecoration.VERTICAL)
            )
            adapter = AccessoryAdapter(this@AccessoryActivity, list)
        }
    }
}