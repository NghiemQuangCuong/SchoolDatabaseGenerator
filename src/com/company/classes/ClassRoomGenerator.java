package com.company.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnghiem on 24/10/2021
 **/

public class ClassRoomGenerator {
    private Long beginClassRoomId;
    private int numberOfClassRoom;
    private List<String> tag = List.of("M", "P", "C", "B", "G", "L", "I");

    public ClassRoomGenerator(Long beginClassRoomId, int numberOfClassRoom) {
        this.beginClassRoomId = beginClassRoomId;
        this.numberOfClassRoom = numberOfClassRoom;
    }

    public List<String> generate() {
        List<String> list = new ArrayList<>();
        int count = 0;
        int bCount = 1;

        for (Long i = beginClassRoomId; i < numberOfClassRoom + beginClassRoomId; i++) {
            list.add("INSERT INTO class_room (id, name, class_type_id) VALUES (" +
                    i +
                    ", '" +
                    tag.get(count) + numToString(bCount) +
                    "', " +
                    (count + 1) +
                    ");\n");
            count++;
            if (count >= tag.size())
            {
                count = 0;
                bCount++;
            }
        }

        return list;
    }

    private String numToString(int num) {
        if (num < 10)
            return "0" + num;
        else
            return String.valueOf(num);
    }
}
