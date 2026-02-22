package com.livros.eventos

import com.livros.model.Cliente

class AuditCliente(
    source: Any,
    data: Cliente
): AuditoriaEvento<Cliente>(source, data, type = "CLIENTE")