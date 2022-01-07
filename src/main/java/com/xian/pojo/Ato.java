package com.xian.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Delete;

@Data
@NoArgsConstructor
public class Ato {
    private Room room;
    private Floor floor;
}
