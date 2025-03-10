package com.employee.employee.dto.page;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageCustom<T> {
    int numberPage;
    int size;
    int totalElements;
    int totalPages;

    public PageCustom(Page<T> page) {
        this.numberPage=page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getNumberOfElements();
        this.totalPages = page.getTotalPages();
    }
}
