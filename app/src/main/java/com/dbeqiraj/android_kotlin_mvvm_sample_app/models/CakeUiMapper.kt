package com.dbeqiraj.android_kotlin_mvvm_sample_app.models

import com.dbeqiraj.data.utils.Mapper
import com.dibeqiraj.cakeapp.mvp.model.CakesResponseCakes
import javax.inject.Inject

class CakeUiMapper @Inject constructor() : Mapper<CakesResponseCakes, CakeUiModel> {
    override fun map(t: CakesResponseCakes) = CakeUiModel(
        id = t.id,
        title = t.title,
        previewDsc = t.previewDescription,
        description = t.detailDescription,
        imageUrl = t.image
    )
}