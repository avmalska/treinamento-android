package br.com.cwi.hearthstonecards.presentation.feature.categories

import android.content.Intent
import android.os.Bundle
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.databinding.ActivityCategoriesBinding
import br.com.cwi.hearthstonecards.domain.entity.Info
import br.com.cwi.hearthstonecards.presentation.base.BaseBottomNavigation
import br.com.cwi.hearthstonecards.presentation.extension.visibleOrGone
import br.com.cwi.hearthstonecards.presentation.feature.subcategory.SubcategoryActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class CategoriesActivity : BaseBottomNavigation() {

    private lateinit var binding : ActivityCategoriesBinding

    private val viewModel: CategoriesViewModel by viewModel()

    override val currentTab: Int = R.id.home_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.info.observe(this@CategoriesActivity) { info ->
            setUpAdapter(info)
        }

        viewModel.loading.observe(this@CategoriesActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@CategoriesActivity) { hasError ->
            binding.viewLoading.root.visibleOrGone(hasError)
        }

        viewModel.fetchInfos()
    }

    private fun setUpAdapter(info: Info) {
        binding.tvCardPatch.text = "Patch: ${info.patch}"

        binding.contentClasses.setOnClickListener {
            val intent = Intent(this, SubcategoryActivity::class.java)
                .putStringArrayListExtra("subcategorys", info.classes as ArrayList<String>?)
                .putExtra("categoryname", "classes")
            startActivity(intent)
        }

        binding.contentRaces.setOnClickListener {
            val intent = Intent(this, SubcategoryActivity::class.java)
                .putStringArrayListExtra("subcategorys", info.races as ArrayList<String>?)
                .putExtra("categoryname", "races")
            startActivity(intent)
        }

        binding.contentSets.setOnClickListener {
            val intent = Intent(this, SubcategoryActivity::class.java)
                .putStringArrayListExtra("subcategorys", info.sets as ArrayList<String>?)
                .putExtra("categoryname", "sets")
            startActivity(intent)
        }

        binding.contentQuality.setOnClickListener {
            val intent = Intent(this, SubcategoryActivity::class.java)
                .putStringArrayListExtra("subcategorys", info.qualities as ArrayList<String>?)
                .putExtra("categoryname", "qualities")
            startActivity(intent)
        }

        binding.contentFaction.setOnClickListener {
            val intent = Intent(this, SubcategoryActivity::class.java)
                .putStringArrayListExtra("subcategorys", info.factions as ArrayList<String>?)
                .putExtra("categoryname", "factions")
            startActivity(intent)
        }

        binding.contentTypes.setOnClickListener {
            val intent = Intent(this, SubcategoryActivity::class.java)
                .putStringArrayListExtra("subcategorys", info.types as ArrayList<String>?)
                .putExtra("categoryname", "types")
            startActivity(intent)
        }
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

}