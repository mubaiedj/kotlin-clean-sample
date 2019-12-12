package com.sample.domain.usecases

import com.sample.domain.gateway.MessageGateway

class GetMessagesByTypeImpl(private val messageGateway: MessageGateway?) :
    GetMessagesByType {
    override fun getByType(request: GetMessagesByType.Request): GetMessagesByType.Response {
        val result = messageGateway!!.getMessagesByType(request.type)
        return GetMessagesByType.Response(result)
    }
}