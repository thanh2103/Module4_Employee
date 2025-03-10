package com.employee.employee.dto.page;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
    public class PageResponse<T> {
        List<T> content;
        PageCustom<T> pageCustom;

        public PageResponse(Page<T> page) {
            this.content = page.getContent();
            this.pageCustom = new PageCustom<>(page);
        }
}
