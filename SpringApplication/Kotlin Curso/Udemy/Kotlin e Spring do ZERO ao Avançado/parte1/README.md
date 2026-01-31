# Projeto Kotlin + Spring Boot



## 🚀 Injeção de Dependências
- Em Kotlin/Spring, a forma recomendada é **injeção por construtor**.
- Exemplo compacto:
  ```kotlin
  @RestController
  class CustomerController(private val customerService: CustomerService) {
      // endpoints usam customerService
  }


## 📌 DTOs e Separação de Camadas
- **DTOs (Request/Response)** são usados para transportar dados entre a API e o domínio.
- Garantem que o **modelo de domínio não vaze** para a camada de apresentação.
- Mantêm a arquitetura limpa e desacoplada.

## 🔄 Mapping com Extension Functions
- **Extension functions** em Kotlin tornam o mapeamento conciso e legível.
- Facilitam a conversão entre **modelos de domínio** e **DTOs**.
- Exemplo: transformar listas de entidades em listas de responses de forma direta.

## 🗂️ Data Classes para Request/Response
- Requests e responses devem ser **data classes**:
  - Imutabilidade parcial.
  - Facilidade de cópia.
  - Comparação por igualdade.
- Uso de `@PageableDefault` para definir valores padrão de paginação e ordenação.

## ⚙️ Controle de Status com Setter Personalizado
- `var status` com **setter que bloqueia alterações** quando o valor atual é `CANCELADO` ou `DELETADO`.
- Possibilidade de **construtor secundário** para inicializar o status.
- Observações:
  - Use `field` para acessar o valor atual dentro do setter.
  - Prefira exceções específicas, como `IllegalStateException`.

## 🧩 Uso do `let` em Kotlin
- Cria um escopo com o receptor como `it` (ou nomeado).
- Retorna o resultado do bloco.
- Útil para **encadear transformações** de forma clara e concisa.

## ✅ Boas Práticas Gerais
- Mantenha DTOs **finos e sem lógica de negócio**.
- Use **extension functions** para mapeamentos repetitivos.
- Prefira **injeção por construtor** para facilitar testes.
- Trate **transições de estado explicitamente** (enums + validação).
- Escreva **testes unitários** para mapeamentos e regras de negócio (ex.: setter de status).

## 📚 Referências Rápidas
- **Kotlin**: concisão, null-safety, extension functions, data classes, scoping functions (`let`, `apply`, `run`, `also`).
- **Spring Boot**: injeção por construtor, controllers, Spring Data Pageable, `@PageableDefault`.

## Start App
````
- ./gradlew bootRun