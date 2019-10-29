package com.sample.infrastructure.api.versions.v1.modelB

import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.apibuilder.EndpointGroup
import io.javalin.http.Context


class PATCHModelBHandler: EndpointGroup {
    override fun addEndpoints() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val path: String = "/"
    }

    init {
        patch(path) { ctx ->
            ctx.status(501)
        }
    }
}