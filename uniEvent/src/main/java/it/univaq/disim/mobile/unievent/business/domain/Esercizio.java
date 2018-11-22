package it.univaq.disim.mobile.unievent.business.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "esercizi")

public class Esercizio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_ESERCIZIO", nullable = false)
    private Long id;

    @Column (name = "NOME")
    private String nome;

    @Column(name = "DESCRIZIONE", length = 255)
    private String descrizione;

    @Column (name = "SERIE")
    private int serie;

    @Column (name = "RIPETIZIONI")
    private int ripetizioni;

    @Column (name = "FOTO")
    private String foto;

    @Column (name = "LIVELLO")
    private Long livello;

    @Column (name = "RECUPERO")
    private int recupero;

    @ManyToMany
    @JoinTable (name = "ESERCIZIO_SCHEDAPERSONALE",
            joinColumns = {@JoinColumn(name = "ID_ESERCIZIO")},
            inverseJoinColumns = {@JoinColumn (name = "ID_SCHEDAPERSONALE")})
    private Set<SchedaPersonale> schedepersonali = new HashSet<>();

    @ManyToMany
    @JoinTable (name = "ESERCIZIO_SCHEDA",
            joinColumns =  {@JoinColumn (name = "ID_ESERCIZIO")},
            inverseJoinColumns = {@JoinColumn (name = "ID_SCHEDA")})
    private Set<Scheda> schede = new HashSet<>();

    // GETTER AND SETTER


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getRipetizioni() {
        return ripetizioni;
    }

    public void setRipetizioni(int ripetizioni) {
        this.ripetizioni = ripetizioni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getLivello() {
        return livello;
    }

    public void setLivello(Long livello) {
        this.livello = livello;
    }

    public int getRecupero() {
        return recupero;
    }

    public void setRecupero(int recupero) {
        this.recupero = recupero;
    }

    public Set<SchedaPersonale> getSchedepersonali() {
        return schedepersonali;
    }

    public Set<Scheda> getSchede() {
        return schede;
    }

    public void setSchede(Set<Scheda> schede) {
        this.schede = schede;
    }

    public void setSchedepersonali(Set<SchedaPersonale> schedepersonali) {
        this.schedepersonali = schedepersonali;
    }

    public void addSchedaPersonale (SchedaPersonale schedaPersonale){
        this.schedepersonali.add(schedaPersonale);
    }

    public void addScheda (Scheda scheda){
        this.schede.add(scheda);
    }

    // EQUALS


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esercizio esercizio = (Esercizio) o;
        return serie == esercizio.serie &&
                ripetizioni == esercizio.ripetizioni &&
                livello == esercizio.livello &&
                recupero == esercizio.recupero &&
                Objects.equals(id, esercizio.id) &&
                Objects.equals(nome, esercizio.nome) &&
                Objects.equals(descrizione, esercizio.descrizione) &&
                Objects.equals(foto, esercizio.foto) &&
                Objects.equals(schedepersonali, esercizio.schedepersonali) &&
                Objects.equals(schede, esercizio.schede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descrizione, serie, ripetizioni, foto, livello, recupero, schedepersonali, schede);
    }
}

