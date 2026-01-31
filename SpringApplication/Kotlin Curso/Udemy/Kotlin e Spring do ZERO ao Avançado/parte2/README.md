# Projeto Kotlin + Spring Boot

## 📌 Tratamento de Erros - melhores práticas

Resumo das recomendações para uso de `@ControllerAdvice` e tratamento de erros em Spring Boot (Kotlin).

## Conceitos principais
- Centralize exceções com `@ControllerAdvice` e métodos `@ExceptionHandler`.
- Retorne respostas padronizadas (`ErrorResponse`, `FieldErrorResponse`) para facilitar o consumo da API.
- Use status HTTP adequados para cada exceção (`NotFoundException` → 404, `BadRequestException` → 400, `MethodArgumentNotValidException` → 422/400).

## Boas práticas
- Padronize o payload de erro: `status`, `message`, `errorCode`, `fields` (quando houver validação).
- Converta erros de validação em lista de campos inválidos.
- Centralize códigos de erro em um `enum` (`Errors`) para reutilização e identificação.
- Trate exceções genéricas com fallback (500) sem expor stacktrace.
- Faça logs estruturados (warn/error) incluindo `errorCode` e `correlationId`.
- Inclua metadados úteis: `timestamp`, `path`, `errorCode`.
- Considere suporte ao padrão RFC 7807 (Problem Details).

## Tratamentos adicionais
- Mapear `ConstraintViolationException` em endpoints com `@Validated`.
- Tratar `HttpMessageNotReadableException` para JSON malformado.
- Diferenciar erros de negócio (400) de recursos não encontrados (404).
- Expor mensagens amigáveis ao cliente, mantendo detalhes técnicos apenas nos logs.



## 📌 Validação e Boas Práticas

Guia rápido de práticas recomendadas para validação em APIs Spring Boot com Kotlin.

## Recomendações
- Use anotações JSR-303/Jakarta Validation nos DTOs (`@field:NotEmpty`, `@Email`, etc.).
- Aplique `@Valid` nos controllers e `@Validated` em serviços ou validação por grupos.
- Centralize mensagens em `messages.properties` usando chaves de mensagem.
- Trate erros com `@ControllerAdvice`, convertendo exceções em payload padronizado (`status`, `errorCode`, `message`, `fields`).
- Utilize códigos de erro centralizados (enum/constantes).
- Trate `HttpMessageNotReadableException` para payloads malformados.
- Defina convenção para uso de HTTP 400 ou 422 e documente.
- Crie validações customizadas com `ConstraintValidator` quando necessário.
- Mantenha DTOs simples; delegue regras ao serviço/validador.
- Escreva testes unitários e de integração para validadores e cenários inválidos.
- Não exponha stacktraces/dados sensíveis; registre detalhes técnicos nos logs.
- Padronize o formato de erro (ex.: RFC 7807 / Problem Details).

## Checklist mínimo
- DTOs com anotações de validação  
- `@Valid` / `@Validated` aplicados  
- `@ControllerAdvice` para erros de validação  
- Enum/constantes para error codes  
- Mensagens em `messages.properties`  
- Testes unitários e de integração



## 🚀 Annotations em **Kotlin**
 São metadados aplicados a elementos do código (classes, propriedades, parâmetros, funções) que podem alterar ou influenciar o comportamento em tempo de compilação ou execução.

No contexto de **Spring Boot** e **Jakarta Validation**, elas são fundamentais para:

- **Validação**: garantir regras de negócio e integridade dos dados.  
- **Serialização**: controlar como objetos são convertidos para JSON/XML.  
- **Configuração declarativa**: reduzir código imperativo e centralizar configurações.  

A ideia central é **separar lógica e comportamento**: a annotation apenas declara a intenção, enquanto a lógica é implementada em **validators** ou **handlers** independentes, pequenos e testáveis.

---

## ✅ Melhores práticas destacadas

- **Meta-anotações**: usar `@Target`, `@Retention`, `@MustBeDocumented`, `@Repeatable` conforme a necessidade.  
- **Jakarta Bean Validation**: criar constraints com  
  ```kotlin
  @Constraint(validatedBy = [MyValidator::class])
  @Retention(AnnotationRetention.RUNTIME)
  
  

## 1. Criando uma constraint personalizada
```kotlin
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [StartsWithValidator::class])
annotation class StartsWith(
    val prefix: String,
    val message: String = "O valor deve começar com {prefix}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
````

## 2. Implementando o Validator
```kotlin
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class StartsWithValidator : ConstraintValidator<StartsWith, String> {
    private lateinit var prefix: String

    override fun initialize(constraintAnnotation: StartsWith) {
        prefix = constraintAnnotation.prefix
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return true // permite nulo
        return value.startsWith(prefix)
    }
}
````

## 3. Usando a annotation em uma classe de DTO
```kotlin
data class UserRequest(
    @field:StartsWith(prefix = "USR", message = "ID deve começar com 'USR'")
    val userId: String,

    val name: String
)
````
## 4. Resultado
````
- Se o userId for "USR123", a validação passa ✅
- Se o userId for "ABC123", a validação falha ❌ e retorna a mensagem configurada
````





## Start App
````
- ./gradlew bootRun