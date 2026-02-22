package com.livros.eventos

import com.livros.model.Cliente

class AuditoriaCliente(
    source: Any,
    dados: Cliente
) : AuditoriaEvento<Cliente>(source, dados, tipo = "CLIENTE")