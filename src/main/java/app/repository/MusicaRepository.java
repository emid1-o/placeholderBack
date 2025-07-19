package app.repository;

import app.entity.Artista;
import app.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    public List<Musica> findByNome(String nome);

    public List<Musica> findByArtista(Artista artista);

    @Query("FROM Musica m WHERE m.ano > :ano")
    public List<Musica> findAcimaAno(int ano);
}
