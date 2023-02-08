package uz.logistics.dto.wagon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Saidjalol Qodirov 2/8/2023 5:24 PM
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackCodeDTO {
    private Long wagonId;
    private String code;
}
