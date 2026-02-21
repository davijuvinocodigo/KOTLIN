package com.livros.events

import com.livros.model.Cliente

class AuditEventCliente(
    source: Any,
    data: Cliente
): Event<Cliente>(source, data, type = "CLIENTE")