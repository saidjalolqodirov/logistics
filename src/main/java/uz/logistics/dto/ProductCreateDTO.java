package uz.logistics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Saidjalol Qodirov 2/2/2023 9:47 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDTO {

    private String code;

    private float weight; //  kilosi

    private float cargoPrice;

    private float boxPrice;

    private boolean paid = false;

    private Integer wagonId;
}
