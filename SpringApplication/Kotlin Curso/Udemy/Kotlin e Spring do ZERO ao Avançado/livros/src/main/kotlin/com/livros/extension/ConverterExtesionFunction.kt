package com.livros.extension

import com.livros.controller.request.PostCustomerRequest
import com.livros.model.CustomerModel

import com.mercadolivro.controller.request.PutCustomerRequest


fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
