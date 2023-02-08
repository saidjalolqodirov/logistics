package uz.logistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: Saidjalol Qodirov 2/8/2023 5:39 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrackCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private Long wagonId;
}
