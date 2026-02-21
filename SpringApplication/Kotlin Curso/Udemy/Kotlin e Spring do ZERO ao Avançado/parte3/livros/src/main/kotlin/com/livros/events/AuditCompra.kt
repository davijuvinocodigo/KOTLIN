package com.livros.events

import com.livros.model.Compra

class AuditEventCompra(
    source: Any,
    data: Compra
): Event<Compra>(source, data, type = "COMPRA")