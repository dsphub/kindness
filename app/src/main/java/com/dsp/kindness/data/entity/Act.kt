package com.dsp.kindness.data.entity

import com.dsp.kindness.domain.entity.ActEntity

data class Act(val uid: String, val description: String) {
    fun toEntity() = ActEntity(uid, description)
}
