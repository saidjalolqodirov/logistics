package uz.logistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: Saidjalol Qodirov 2/2/2023 7:58 AM
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private float weight; //  kilosi

    @Column(nullable = false)
    private float cargoPrice;

    @Column(nullable = false)
    private float boxPrice;

    private boolean paid = false;

    @Column(nullable = false)
    private Long wagonId;
}
