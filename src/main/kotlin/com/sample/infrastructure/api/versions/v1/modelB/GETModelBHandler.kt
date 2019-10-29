package com.sample.infrastructure.api.versions.v1.modelB

import io.javalin.http.Context
import io.javalin.http.Handler


class GETModelBHandler: Handler {
    override fun handle(ctx: Context) {
        ctx.result("Hello GETModelAHandler")
    }
}