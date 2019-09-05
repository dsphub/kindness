package com.dsp.kindness.domain.interactor

sealed class Failure(val message: String? = "")

class NetworkConnection : Failure()

class ServerError(message: String? = "") : Failure(message)

abstract class FeatureFailure : Failure()
