package com.khudnitski.library.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookInStorage implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String author;
    private Long quantity;
    private Long presentQuantity;
}
