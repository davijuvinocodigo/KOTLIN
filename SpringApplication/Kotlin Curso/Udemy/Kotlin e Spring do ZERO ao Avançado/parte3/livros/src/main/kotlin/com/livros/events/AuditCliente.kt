package com.livros.events

import com.livros.model.Cliente

class AuditCliente(
    source: Any,
    data: Cliente
): AuditEvent<Cliente>(source, data, type = "CLIENTE")