package com.livros.validation

import com.livros.service.ClienteService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.stereotype.Component

@Component
class EmailDisponivelValidator(
    private val clienteService: ClienteService
) : ConstraintValidator<EmailDisponivel, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }
        return clienteService.emailDisponivel(value)
    }
}
