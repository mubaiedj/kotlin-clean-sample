package com.sample.infrastructure.api.versions.v1

import com.sample.infrastructure.api.versions.v1.modelA.Router as ModelARouter
import com.sample.infrastructure.api.versions.v1.modelB.Router as ModelBRouter
import io.javalin.apibuilder.EndpointGroup
import io.javalin.apibuilder.ApiBuilder.*

class Router : EndpointGroup {
    override fun addEndpoints() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        path("v1") {
            ModelARouter()
            ModelBRouter()
        }
    }
}