package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.RepostsModel
import com.kprotasov.test.domain.entity.Reposts
import javax.inject.Inject

class RepostsConverter @Inject constructor(
    private val intToBooleanConverter: IntToBooleanConverter
): Converter<RepostsModel?, Reposts?> {

    override fun convert(from: RepostsModel?): Reposts? =
        from?.let { model ->
            Reposts(
                count = model.count,
                userReposted = intToBooleanConverter.convert(model.userReposted)
            )
        }
}