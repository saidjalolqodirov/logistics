package uz.logistics.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Saidjalol Qodirov 2/9/2023 3:09 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateDTO {
    private Integer id;
    private String username;
    private String password;
    private String confirmationPassword;
}
