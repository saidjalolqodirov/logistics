package uz.logistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;
}
