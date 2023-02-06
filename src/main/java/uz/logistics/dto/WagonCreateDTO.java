package uz.logistics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: Saidjalol Qodirov 2/2/2023 8:34 AM
 */
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class WagonCreateDTO {
    private String name;
}
