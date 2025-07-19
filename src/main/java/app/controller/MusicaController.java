package app.controller;

import app.entity.Musica;
import app.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/musica")
@RestController
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Musica musica) {
        try {

            String mensagem = this.musicaService.save(musica);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Musica musica) {

        try {

            String mensagem = this.musicaService.update(id, musica);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {

            String mensagem = this.musicaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Musica>> findAll() {
        try {

            List<Musica> lista = this.musicaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Musica> findById(@PathVariable Long id) {
        try {

            Musica musica = this.musicaService.findById(id);
            return new ResponseEntity<>(musica, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Musica>> findByNome(@RequestParam String nome){

        try {
            List<Musica> lista = this.musicaService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByArtista")
    public ResponseEntity<List<Musica>> findByArtista(@RequestParam Long id){

        try {
            List<Musica> lista = this.musicaService.findByArtista(id);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAcimaAno")
    public ResponseEntity<List<Musica>> findAcimaAno(@RequestParam int ano){

        try {
            List<Musica> lista = this.musicaService.findAcimaAno(ano);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
