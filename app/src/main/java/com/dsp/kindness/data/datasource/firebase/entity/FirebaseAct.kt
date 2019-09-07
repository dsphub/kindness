package com.dsp.kindness.data.datasource.firebase.entity

import com.dsp.kindness.data.entity.Act
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FirebaseAct(var d: String = "", var a: Boolean = false) {
    @Exclude
    fun toAct() = Act("TODO", d)
}
