package demo.model;

import javax.persistence.*;

@Entity
@Table(name = "cate")
public class Cate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Cate( String name) {

        this.name = name;
    }

    public Cate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
