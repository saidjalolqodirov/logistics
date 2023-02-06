package uz.logistics.criteria;

import lombok.*;

import java.util.List;

/**
 * @author Saidjalol Qodirov, Thursday 3:54 PM 9/29/2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePage<T> {
    private Integer totalPages;
    private long totalElements;
    private Integer size;
    private Integer number;
    private long numberOfElements;
    private List<T> content;
}
