package com.company.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cuongnghiem on 21/10/2021
 **/

public class StudentGenerator {

    private Long beginStudentId;
    private int beginClassroomId;
    private int lastClassroomId;
    private int studentPerClassroom;

    public StudentGenerator() {
    }

    public StudentGenerator(Long beginStudentId, int beginClassroomId, int lastClassroomId, int studentPerClassroom) {
        this.beginStudentId = beginStudentId;
        this.beginClassroomId = beginClassroomId;
        this.lastClassroomId = lastClassroomId;
        this.studentPerClassroom = studentPerClassroom;
    }

    public String generate() {
        String result = "";
        Long count = beginStudentId;

        for (int classRoomId = beginClassroomId; classRoomId <= lastClassroomId; classRoomId++)
            for (int studentNum = 1; studentNum <= studentPerClassroom; studentNum++) {
                result += "INSERT INTO student (id, first_name, last_name, address, city, phone1, phone2, class_room_id) VALUES (" +
                        count++ +
                        ", '" +
                        getRandomFirstName() +
                        "', '" +
                        getRandomLastName() +
                        "', '" +
                        getRandomAddress() +
                        "', '" +
                        getRandomCity() +
                        "', '" +
                        getRandomPhoneNumber() +
                        "', '" +
                        getRandomPhoneNumber() +
                        "', " +
                        classRoomId +
                        ");\n";
            }

        return result;
    }

    public String getRandomPhoneNumber() {
        Random rd = new Random();
        if (rd.nextInt(99) <= 25 )
            return "";

        String result = "09";
        for (int i = 0; i < 8; i++)
            result += rd.nextInt(9);

        return result ;
    }

    public String getRandomCity() {
        List<String> cityNameContainer = new ArrayList<>(List.of(
           "Lakewood", "Cushing", "Mesquite", "San Luis Obispo", "Ripon", "Arkansas Post", "Huntington Beach",
                "Rugby", "Lake Charles", "Pass Christian", "East Hartford", "Rotterdam", "Bartlesville",
                "Muscatine", "Stonington", "Harrison", "Glen Ellyn", "Pawhuska", "Spearfish", "Lakehurst",
                "Seattle", "Morganton", "Lumberton", "Quincy", "Kilgore", "Estherville", "Altus",
                "Randolph", "Roseville", "Whittier", "Hoboken", "Moab", "Braintree", "Peekskill", "Corpus Christi",
                "Lubbock", "Melbourne", "Bessemer", "Decatur", "Golden", "Irvington", "Victorville", "Fort Pierce",
                "Little Falls", "Oxnard", "Hoquiam", "Norwich"
        ));

        return cityNameContainer.get(new Random().nextInt(cityNameContainer.size()));
    }

    public String getRandomAddress() {
        List<String> streetNameContainer = new ArrayList<>(List.of(
                "Wood Street", "West Lane", "Westbourne Road", "Lime Street", "Hamilton Road", "Derwent Avenue",
                "Chestnut Drive", "Orchid Close", "Park Crescent", "Mill Lane", "Ash Street", "Grosvenor Road",
                "Hawthorn Drive", "Lodge Road", "Lime Avenue", "Douglas Road", "The Pines", "Grosvenor Street",
                "Laburnum Close", "Magnolia Close", "Castle Street", "Princes Street", "Church Hill",
                "Long Lane", "Maple Avenue", "Saxon Road", "Heath Road", "Balmoral Close", "Spinney Close",
                "The Glebe", "Rosemary Lane", "Albert Road", "Broadway", "Park Way", "London Road", "Well Lane",
                "Milton Street", "Queensway", "Mayfield Avenue", "Beverley Road", "Kestrel Close", "Main Road",
                "Norfolk Street", "Birch Close", "Eastern Avenue", "St Andrews Close", "Beechwood Road",
                "Hardy Close", "Forge Lane", "Warwick Road", "Fir Tree Close", "Priory Road", "Oaklands",
                "Hamilton Close", "Grove Avenue", "The Square", "Rutland Road", "East Avenue", "Willow Drive",
                "Charles Street", "Westfield Drive", "Kings Close", "Willow Road", "Station Lane", "The Nook",
                "Carlton Close", "Heathfield Road", "Victoria Avenue", "Hill Street", "Linden Grove", "Park Grove",
                "Silver Street", "Woodside", "The Meadows", "Canterbury Road", "The Fairway", "Linden Road",
                "Bramble Close", "Oakwood Road", "Trinity Street", "The Moorings", "Alexandra Road", "Highfield Drive",
                "The Drive", "Commercial Street", "Rowan Close", "The Paddocks", "Hall Lane"
        ));

        String result =
                (new Random().nextInt(2001) + 1) + " "
                        + streetNameContainer.get(new Random().nextInt(streetNameContainer.size()));

        return result;
    }

    public String getRandomFirstName() {
        List<String> firstNameContainer = new ArrayList<>(List.of(
                "Nakita", "Kelvin", "Ceara", "Gus", "Dennis", "Coco", "Sahra", "Kamila",
                "Efe", "Mylo", "Arnie", "Reo", "Cade", "Lucie", "Phyllis", "Bryony", "Bilal",
                "Susannah", "Zachariah", "Taylor", "Teegan", "Krista", "Ariyah", "Alayah", "Menaal",
                "Ellise", "Amman", "Abi", "Ami", "Alara", "Lori", "Gurleen", "Issac", "Glenda", "Marlene",
                "Daanyaal", "Sumayya", "Frederic", "Miyah", "Nasir", "Zaydan", "Prince"
        ));

        Random rand = new Random();
        return firstNameContainer.get(rand.nextInt(firstNameContainer.size()));
    }

    public String getRandomLastName() {
        List<String> lastNameContainer = new ArrayList<>(List.of(
                "Frey", "Drummond", "Moran", "Jennings", "Rosa", "Tate", "Blair", "Conley", "Stein", "Vazquez",
                "Moody", "Ware", "Solomon", "Harrington", "Reyes", "Clemons", "Sims", "Cox", "Person", "Escobar",
                "Chan", "Maldonado", "Rasmussen", "Mccullough", "Stout", "Kelley", "Orozco", "Field", "Glover",
                "Nelson", "Bateman", "Page", "Booth", "Povey", "Mccallum", "Cottrell", "Mcclain", "Driscoll", "Melton",
                "Farley", "Pitt", "Dixon"
        ));

        Random rand = new Random();
        return lastNameContainer.get(rand.nextInt(lastNameContainer.size()));
    }

    public Long getBeginStudentId() {
        return beginStudentId;
    }

    public void setBeginStudentId(Long beginStudentId) {
        this.beginStudentId = beginStudentId;
    }

    public int getBeginClassroomId() {
        return beginClassroomId;
    }

    public void setBeginClassroomId(int beginClassroomId) {
        this.beginClassroomId = beginClassroomId;
    }

    public int getLastClassroomId() {
        return lastClassroomId;
    }

    public void setLastClassroomId(int lastClassroomId) {
        this.lastClassroomId = lastClassroomId;
    }

    public int getStudentPerClassroom() {
        return studentPerClassroom;
    }

    public void setStudentPerClassroom(int studentPerClassroom) {
        this.studentPerClassroom = studentPerClassroom;
    }
}
