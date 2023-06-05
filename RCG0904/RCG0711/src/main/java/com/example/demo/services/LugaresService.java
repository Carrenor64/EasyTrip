// package com.example.demo.services;

// import java.util.List;

// import com.example.demo.domain.Lugares;
// import com.example.demo.domain.Pais;

// public interface LugaresService {
//     public Lugares add(Lugares p);
//     public List<Lugares> findAll();
//     public Lugares findById(long id);
//     public Lugares edit(Lugares p);
//     public void delete(Long id);
//     public List<Lugares> findByPais(Pais pais);
//     public Lugares findByNombre(String nombre);
// }

package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Lugares;
import com.example.demo.domain.Pais;

public interface LugaresService {
    public Lugares add(Lugares p);

    public List<Lugares> findAll();

    public Lugares findById(long id);

    public Lugares edit(Lugares p);

    public void delete(Long id);

    public List<Lugares> findByPais(Pais categoria);

    public Lugares findByNombre(String nombre);

    public Lugares findOneLugares(long id);
}
