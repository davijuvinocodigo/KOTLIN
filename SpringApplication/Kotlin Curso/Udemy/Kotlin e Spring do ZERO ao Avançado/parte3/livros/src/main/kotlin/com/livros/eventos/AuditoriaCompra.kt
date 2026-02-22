package com.livros.eventos

import com.livros.model.Compra

class AuditCompra(
    source: Any,
    data: Compra
): AuditoriaEvento<Compra>(source, data, type = "COMPRA")