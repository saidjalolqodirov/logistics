package uz.logistics.dto.wagon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author: Saidjalol Qodirov 2/7/2023 11:11 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WagonUpdateDTO {
    private Integer id;
    @NotBlank
    private String name;

    private boolean isArchived = false;
}
