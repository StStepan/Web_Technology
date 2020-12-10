package com.khudnitski.library.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookOrdered implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String username;
    private Long quantity; //To-Do: restrict max quantity of order to 5?
    private Map<Book, Float> amountOfBooksTaken; //Can take any same books?
}
