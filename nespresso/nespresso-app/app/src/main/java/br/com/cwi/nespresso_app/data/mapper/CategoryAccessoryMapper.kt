package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.CategoryAccessoryResponse
import br.com.cwi.nespresso_app.domain.entity.Category

class CategoryAccessoryMapper: DomainMapper<CategoryAccessoryResponse, Category> {

    override fun toDomain(from: CategoryAccessoryResponse) = Category(
        category = from.category,
        products = AccessoryMapper().toDomain(from.accessories)
    )

    override fun toDomain(from: List<CategoryAccessoryResponse>) : List<Category> = from.map {
        toDomain(it)
    }

}