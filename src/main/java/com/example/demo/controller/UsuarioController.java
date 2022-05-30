package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.UsuarioModel;
import com.example.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // http://localhost:8080/usuario
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    // http://localhost:8080/usuario
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return this.usuarioService.guardarUsuario(usuarioModel);
    }

    // http://localhost:8080/usuario/3
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerUsuarioPorId(id);
    }

    // http://localhost:8080/usuario/query?prioridad=3
    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerUsuarioPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsarioPorId(@PathVariable("id") Long id) {

        Boolean ok = this.usuarioService.eliminarUsarioPorId(id);
        if (ok) {
            return "Se eliminó usuario con id: " + id;
        } else {
            return "No se eliminó usuario con id: " + id;
        }

    }

}
