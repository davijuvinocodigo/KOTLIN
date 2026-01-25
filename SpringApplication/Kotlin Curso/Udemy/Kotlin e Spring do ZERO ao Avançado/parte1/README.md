# KOTLIN



# Projeto Kotlin + Spring Boot

Descrição curta:
Este projeto usa Kotlin com Spring Boot seguindo boas práticas como injeção de dependência por construtor, uso de DTOs, extension functions para mapeamento, e convenções de manipulação de estado em `data class`/classes de domínio.

\- Tecnologias
\- Kotlin
\- Spring Boot
\- Spring Data (Pageable)
\- Gradle
\- SQL (banco de dados)

## Principais conceitos e padrões

\- Injeção de dependência via construtor  
Em Kotlin/Spring a forma recomendada é injetar dependências pelo construtor. Exemplo compacto:
```kotlin
@RestController
class CustomerController(private val customerService: CustomerService) {
    // endpoints usam customerService
}


- DTOs e separação de camadas
Usa-se DTOs (Request/Response) para separar modelos de transporte da camada de domínio. Assim o domínio não vaza para a API.
- Mapping com extension functions
Extension functions em Kotlin tornam o mapeamento conciso e legível:

- Transformação de coleções
Converter listas de modelos de domínio para responses é direto:


- data class para request/response
Requests e responses são data class para facilitar imutabilidade parcial, cópia e igualdade:

@PageableDefault define valores padrão para paginação e ordenação.


Controle de status com setter personalizado
Exemplo onde status é um var com setter que impede alteração quando o valor atual é CANCELADO ou DELETADO. Há também um construtor secundário para inicializar o status:


Observações:
Use field para ler o valor atual dentro do setter.
Preferir exceções específicas (ex.: IllegalStateException) em produção.
Uso do let em Kotlin
let cria um escopo com o receptor como it (ou nomeado) e retorna o resultado do bloco. Útil para encadear transformações:



Boas práticas gerais
Mantenha DTOs finos e sem lógica de negócio.
Use extension functions para mapeamentos repetitivos.
Prefira injeção por construtor para facilitar testes.
Trate transições de estado explicitamente (enums + validação no setter ou em serviços).
Escreva testes unitários para mapeamentos e regras de negócio (ex.: setter de status).
Referências rápidas
Kotlin: concisão, null-safety, extension functions, data classes, scoping functions (let, apply, run, also).
Spring Boot: injeção por construtor, controllers, Spring Data Pageable, @PageableDefault.