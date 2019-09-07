package com.dsp.kindness.data.datasource.firebase

import com.dsp.kindness.data.datasource.ActDataStore
import com.dsp.kindness.data.datasource.firebase.entity.FirebaseAct
import com.dsp.kindness.data.entity.Act
import com.dsp.kindness.domain.interactor.*
import com.google.firebase.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseActDataStore : ActDataStore {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().reference

    override fun getAllActs(): Either<Failure, List<Act>> = runBlocking {
        withContext(Dispatchers.Default) {
            try {
                val items = db.child(Constants.FIREBASE_ACT_MAP).getValue()
                val acts = items.children.toList()
                    .map { it.getValue(FirebaseAct::class.java)!! }
                    .map { it.toAct() }
                Right(acts)
            } catch (ex: Exception) {
                Left(ServerError(ex.message))
            }
        }
    }

    suspend fun DatabaseReference.getValue(): DataSnapshot {
        return suspendCoroutine { continuation ->
            addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(data: DataSnapshot) =
                    continuation.resume(data)

                override fun onCancelled(error: DatabaseError) =
                    continuation.resumeWithException(error.toException())
            })
        }
    }
}
