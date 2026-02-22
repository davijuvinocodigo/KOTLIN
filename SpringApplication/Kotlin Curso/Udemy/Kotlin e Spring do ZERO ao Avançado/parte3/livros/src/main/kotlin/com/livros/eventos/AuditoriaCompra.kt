package com.livros.eventos

import com.livros.model.Compra

class AuditoriaCompra(
    source: Any,
    data: Compra
): AuditoriaEvento<Compra>(source, data, tipo = "COMPRA")