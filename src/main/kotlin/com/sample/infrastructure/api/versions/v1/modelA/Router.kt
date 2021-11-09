package com.sample.infrastructure.api.versions.v1.modelA

import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.apibuilder.EndpointGroup

class Router : EndpointGroup {
    override fun addEndpoints() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val path: String = "model-a"
    }

    init {
        path(path) {
            GETModelAHandler()
            PATCHModelAHandler()
        }
    }
}