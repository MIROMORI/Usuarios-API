package com.miromori.produtosapi.services;

import com.miromori.produtosapi.exceptions.custom_exceptions.UserListIsEmptyException;
import com.miromori.produtosapi.exceptions.custom_exceptions.UserNotFoundException;
import com.miromori.produtosapi.models.Usuario;
import com.miromori.produtosapi.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UsuarioRepository usuarioRepository;

    public UserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll(){
        List<Usuario> lista = usuarioRepository.findAll();
        if(lista.isEmpty()){
            throw new UserListIsEmptyException("Não há usuários cadastrados");
        }
        return lista;
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }

    public Usuario deleteById(Long id){
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
        return usuario;
    }

    public Usuario save(Usuario usuario) throws Exception {
        findById(usuario.getId())
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) throws Exception {
        Usuario temp = findById(usuario.getId());
        return usuarioRepository.save(usuario);
    }
}
