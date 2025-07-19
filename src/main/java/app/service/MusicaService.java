package app.service;

import app.entity.Artista;
import app.entity.Musica;
import app.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public String save(Musica musica){
        this.musicaRepository.save(musica);
        return "musica salva";
    }

    public String update(Long id, Musica musica){
        musica.setId(id);
        this.musicaRepository.save(musica);
        return "musica alterada";
    }

    public String delete(Long id){
        this.musicaRepository.deleteById(id);
        return "musica deletada";
    }

    public List<Musica> findAll(){
        List<Musica> lista =  this.musicaRepository.findAll();
        return lista;

    }

    public Musica findById(Long id){

        Musica musica = this.musicaRepository.findById(id).get();
        return musica;
    }

    public List<Musica> findByNome(String nome){

        return this.musicaRepository.findByNome(nome);
    }


    public List<Musica> findByArtista(Long id){

        Artista artista = new Artista();
        artista.setId(id);
        return this.musicaRepository.findByArtista(artista);
    }

    public List<Musica> findAcimaAno(int ano){

        return this.musicaRepository.findAcimaAno(ano);
    }
}
