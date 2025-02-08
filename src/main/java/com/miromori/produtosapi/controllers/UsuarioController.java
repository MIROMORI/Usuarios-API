package com.miromori.produtosapi.controllers;

import com.miromori.produtosapi.models.Usuario;
import com.miromori.produtosapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("api/v1/user")
public class UsuarioController {
    public final UserService userService;

    public UsuarioController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<List<Usuario>>  findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(userService.save(usuario));
    }

    @PutMapping()
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(userService.update(usuario));
    }
}
