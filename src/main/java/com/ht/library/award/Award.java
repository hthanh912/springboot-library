package com.ht.library.award;

import com.ht.library.book.BookAward;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "awards")
@Setter
@Getter
@NoArgsConstructor
public class Award {
    @Id
    @Column(name = "award_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "award")
    private Set<BookAward> bookAwards;

    public Award(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
