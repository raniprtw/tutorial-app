package apap.tutorial.gopud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="reviewer")
public class ReviewerModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReviewer;

    @NotNull
    @Size(max=10)
    @Column(name="nama_reviewer", nullable=false)
    private String nama_reviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isi_review", nullable=false)
    private String isi_review;

    @Size(max=50)
    @Column(name="kritik")
    private String kritik;

    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name="menuId", referencedColumnName = "id", nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private MenuModel menu;

}
