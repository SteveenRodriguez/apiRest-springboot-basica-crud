package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios() {

        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuarios(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return this.usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> obtenerUsuarioPorId(Long id) {
        return this.usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(Integer prioridad) {
        return this.usuarioRepository.findByPrioridad(prioridad);
    }

    public Boolean eliminarUsarioPorId(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
