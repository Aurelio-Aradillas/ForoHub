package com.example.demo.domain.respuesta.validaciones.actualizar;

import com.example.demo.domain.respuesta.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuestaDTO data, Long respuestaId);

}
