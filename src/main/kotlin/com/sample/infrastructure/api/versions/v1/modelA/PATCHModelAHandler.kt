package com.sample.infrastructure.api.versions.v1.modelA

import io.javalin.http.Context
import io.javalin.http.Handler


class PATCHModelAHandler: Handler {
    override fun handle(ctx: Context) {
        ctx.status(501)
    }
}