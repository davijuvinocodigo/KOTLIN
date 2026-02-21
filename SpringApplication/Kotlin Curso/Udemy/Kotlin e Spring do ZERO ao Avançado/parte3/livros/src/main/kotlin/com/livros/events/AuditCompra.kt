package com.livros.events

import com.livros.model.Compra

class AuditCompra(
    source: Any,
    data: Compra
): AuditEvent<Compra>(source, data, type = "COMPRA")