package uz.logistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: Saidjalol Qodirov 2/2/2023 8:28 AM
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    private boolean main;
    private boolean archive = false;
}
