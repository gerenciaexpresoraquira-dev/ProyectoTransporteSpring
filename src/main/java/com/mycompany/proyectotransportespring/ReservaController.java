package com.mycompany.proyectotransportespring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador encargado de gestionar las reservas
 * del sistema Expreso Ráquira.
 * 
 * Permite mostrar el formulario principal y procesar
 * la información enviada por el usuario.
 */
@Controller
public class ReservaController {

    /**
     * Método encargado de mostrar el formulario principal
     * del sistema de reservas.
     * 
     * @return Vista index.html
     */
    @GetMapping("/")
    public String mostrarFormulario() {

        return "index";

    }

    /**
     * Método encargado de procesar la reserva enviada
     * desde el formulario web.
     * 
     * @param nombre Nombre del pasajero
     * @param origen Lugar de origen
     * @param destino Lugar de destino
     * @param fecha Fecha del viaje
     * @param hora Hora del viaje
     * @param personas Cantidad de pasajeros
     * @param model Objeto para enviar datos a la vista
     * 
     * @return Vista resultado.html
     */
    @PostMapping("/reservar")
    public String procesarReserva(
            @RequestParam String nombre,
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam String fecha,
            @RequestParam String hora,
            @RequestParam String personas,
            Model model) {

        // Enviar datos del formulario a la vista
        model.addAttribute("nombre", nombre);
        model.addAttribute("origen", origen);
        model.addAttribute("destino", destino);
        model.addAttribute("fecha", fecha);
        model.addAttribute("hora", hora);
        model.addAttribute("personas", personas);

        // Generar número de reserva aleatorio
        String numeroReserva = "ER-" + (int)(Math.random() * 10000);

        // Enviar número de reserva a la vista
        model.addAttribute("numeroReserva", numeroReserva);

        return "resultado";

    }

}
