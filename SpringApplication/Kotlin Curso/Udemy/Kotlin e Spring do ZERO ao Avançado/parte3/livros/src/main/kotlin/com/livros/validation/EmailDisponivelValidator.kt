
import com.livros.service.ClienteService
import com.livros.model.enums.Mensagens
import com.livros.validation.EmailDisponivel
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.stereotype.Component

@Component
class EmailDisponivelValidator(
    private val clienteService: ClienteService
) : ConstraintValidator<EmailDisponivel, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            context?.buildConstraintViolationWithTemplate(Mensagens.CAMPO_OBRIGATORIO.texto)
                ?.addConstraintViolation()
                ?.disableDefaultConstraintViolation()
            return false
        }

        val disponivel = clienteService.emailDisponivel(value)

        if (!disponivel) {
            context?.buildConstraintViolationWithTemplate(Mensagens.EMAIL_DUPLICADO.texto)
                ?.addConstraintViolation()
                ?.disableDefaultConstraintViolation()
        }

        return disponivel
    }
}