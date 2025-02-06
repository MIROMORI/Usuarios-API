package com.miromori.produtosapi.controllers;

import com.miromori.produtosapi.models.Usuario;
import com.miromori.produtosapi.repositories.UsuarioRepository;
import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/user")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>>  findAll() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioRepository.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable Long id) {
        Usuario user = usuarioRepository.findById(id).get();
        if (user != null) {
            usuarioRepository.delete(user);
            return ResponseEntity.ok(user);
        }
        return null;
    }

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @PutMapping()
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }
}
