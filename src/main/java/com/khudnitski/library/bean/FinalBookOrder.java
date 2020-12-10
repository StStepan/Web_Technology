package com.khudnitski.library.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalBookOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private UUID userId;
    private UUID librarianId;
    private LocalDateTime timeBookTaken;
    private LocalDateTime timeToReturnBook;
    private List<BookOrdered> bookOrderedList;
    private Boolean isReturned;
    private Boolean isTakenHome; //Rename to represent being taken outside library

}
