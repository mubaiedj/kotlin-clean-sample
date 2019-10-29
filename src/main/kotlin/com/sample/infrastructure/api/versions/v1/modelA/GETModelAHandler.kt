package com.sample.infrastructure.api.versions.v1.modelA

import io.javalin.http.Context
import io.javalin.http.Handler


class GETModelAHandler: Handler {
    override fun handle(ctx: Context) {
        ctx.result("Hello GETModelAHandler")
    }
}