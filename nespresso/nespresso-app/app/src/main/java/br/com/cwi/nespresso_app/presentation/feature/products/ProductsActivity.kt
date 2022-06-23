package br.com.cwi.nespresso_app.presentation.feature.products

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityProductsBinding
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.feature.products.accessories.AccessoryActivity
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CoffeeActivity
import br.com.cwi.nespresso_app.presentation.feature.products.machine.MachineActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityProductsBinding

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpProductActions()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun setUpProductActions() {
        binding.contentCoffees.root.setOnClickListener {
            val intent = Intent(this, CoffeeActivity::class.java)
            startActivity(intent)
        }

        binding.contentMachines.root.setOnClickListener {
            val intent = Intent(this, MachineActivity::class.java)
            startActivity(intent)
        }

        binding.contentAccessories.root.setOnClickListener {
            val intent = Intent(this, AccessoryActivity::class.java)
            startActivity(intent)
        }
    }

}