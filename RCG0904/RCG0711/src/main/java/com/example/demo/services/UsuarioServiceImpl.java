// package com.example.demo.services;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.demo.domain.Usuario;
// import com.example.demo.repository.UsuarioRepository;

// @Service
// public class UsuarioServiceImpl implements UsuarioService {
//     @Autowired
//     UsuarioRepository repositorio;
//     @Autowired
//     PasswordEncoder passwordEncoder;

//     public Usuario add(Usuario usuario) {
//         if (repositorio.findByNombre(usuario.getNombre()) != null)
//             return null; // ya existe ese nombre de usuario
//         String passCrypted = passwordEncoder.encode(usuario.getPassword());
//         usuario.setPassword(passCrypted);
//         repositorio.save(usuario);
//         return usuario;
//     }

//     public List<Usuario> findAll() {
//         return repositorio.findAll();
//     }

//     public Usuario findById(long id) {
//         return repositorio.findById(id).orElse(null);
//     }

//     public Usuario edit(Usuario usuario) {
//         Usuario otroUsuario = repositorio.findByNombre(usuario.getNombre());
//         if (otroUsuario != null && otroUsuario.getId() != usuario.getId())
//             return null; // ya existe otro usuario con ese nombre
//         String passCrypted = passwordEncoder.encode(usuario.getPassword());
//         usuario.setPassword(passCrypted);
//         return repositorio.save(usuario);
//     }

//     public void delete(Usuario d) {
//         repositorio.delete(d);
//     }

//     public Usuario findByNombre(String nombre) {
//         return repositorio.findByNombre(nombre);
//     }
// }

package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repositorio;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Usuario add(Usuario usuario) {
        if (repositorio.findByNombre(usuario.getNombre()) != null)
            return null; // ya existe ese nombre de usuario
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        repositorio.save(usuario);
        return usuario;
    }

    public List<Usuario> findAll() {
        return repositorio.findAll();
    }

    public Usuario findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Usuario edit(Usuario usuario) {
        Usuario otroUsuario = repositorio.findByNombre(usuario.getNombre());
        if (otroUsuario != null && otroUsuario.getId() != usuario.getId())
            return null; // ya existe otro usuario con ese nombre
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        return repositorio.save(usuario);
    }

    public void delete(Usuario d) {
        repositorio.delete(d);
    }

    public Usuario findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
}
