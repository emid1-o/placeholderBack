package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private String genero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("musicas")
    private Artista artista;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "musica_playlist")
    private List<Playlist> playlists;

}
