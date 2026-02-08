package com.livros.validation

import com.livros.service.ClienteService
import jakarta.validation.*;
class EmailAvailableValidator(var clienteService: ClienteService): ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrEmpty()) {
            return false
        }
        return clienteService.emailAvailable(value)
    }

}
