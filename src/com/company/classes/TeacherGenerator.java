package com.company.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cuongnghiem on 24/10/2021
 **/

public class TeacherGenerator {

    private Long beginTeacherGenerator;
    private Long numberOfTeacher;

    public TeacherGenerator(Long beginTeacherGenerator, Long numberOfTeacher) {
        this.beginTeacherGenerator = beginTeacherGenerator;
        this.numberOfTeacher = numberOfTeacher;
    }

    public List<String> generate() {
        List<String> result = new ArrayList<>();

        for (Long i = beginTeacherGenerator; i < beginTeacherGenerator + numberOfTeacher; i++)
        {
            result.add(
                    "INSERT INTO teacher (id, first_name, last_name, address, city, phone1, phone2) VALUES (" +
                            i +
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
                            "');\n"
            );
        }

        return result;
    }

    public String getRandomPhoneNumber() {
        Random rd = new Random();
//        if (rd.nextInt(100) <= 25 )
//            return "";

        String result = "09";
        for (int i = 0; i < 8; i++)
            result += rd.nextInt(10);

        return result ;
    }

    public String getRandomCity() {
        List<String> cityNameContainer = new ArrayList<>(List.of(
                "An Giang", "Bà Rịa – Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre",
                "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng",
                "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
                "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa",
                "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định",
                "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi",
                "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa",
                "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc",
                "Yên Bái"
        ));

        return cityNameContainer.get(new Random().nextInt(cityNameContainer.size()));
    }

    public String getRandomAddress() {
        List<String> streetNameContainer = new ArrayList<>(List.of(
                "Alexandre de Rhodes", "Bà Lê Chân", "Bùi Thị Xuân", "Bùi Viện", "Cách Mạng Tháng Tám",
                "Calmette", "Cao Bá Nhạ", "Cao Bá Quát", "Cô Bắc", "Cô Giang", "Cống Quỳnh", "Chu Mạnh Trinh",
                "Chương Dương", "Đặng Dung", "Đặng Tất", "Đặng Thị Nhu", "Đặng Trần Côn", "Đề Thám", "Đinh Công Tráng",
                "Đông Du", "Đồng Khởi", "Hai Bà Trưng", "Hải Triều", "Hàm Nghi", "Hàn Thuyên", "Hòa Mỹ", "Hồ Hảo Hớn",
                "Hồ Huấn Nghiệp", "Hồ Tùng Mậu", "Hoàng Sa", "Huyền Quang", "Huyền Trân Công Chúa", "Huỳnh Khương Ninh",
                "Huỳnh Thúc Kháng", "Ký Con", "Lê Anh Xuân", "Lê Công Kiều", "Lê Duẩn", "Lê Lai", "Lê Lợi", "Lê Thánh Tôn",
                "Lê Thị Hồng Gấm", "Lê Thị Riêng", "Lê Văn Hưu", "Lương Hữu Khánh", "Lưu Văn Lang", "Lý Tự Trọng", "Lý Văn Phức",
                "Mã Lộ"
        ));

        String result =
                (new Random().nextInt(301) + 30) + " "
                        + streetNameContainer.get(new Random().nextInt(streetNameContainer.size()));

        return result;
    }

    public String getRandomFirstName() {
        List<String> firstNameContainer = new ArrayList<>(List.of(
                "Dương", "Tường", "Dũng", "Minh", "Tuấn", "Long", "Phong", "Thành", "Khoa", "Bình", "Tài", "Thắng",
                "Toàn", "An", "Duy", "Lưu", "Ân", "Cường", "Khánh", "Huy", "Hưng", "Vỹ", "Bách", "Hoàng", "Nghĩa",
                "Phước", "Tâm", "Vĩ", "Văn", "Quyết", "Vũ", "Trường", "Đạt", "Trọng", "Hữu", "Cương", "Khang", "Khôi",
                "Phương", "Điền", "Vinh", "Thiên", "Trung", "Chí", "Vương", "Tùng"
        ));

        Random rand = new Random();
        return firstNameContainer.get(rand.nextInt(firstNameContainer.size()));
    }

    public String getRandomLastName() {
        List<String> lastNameContainer = new ArrayList<>(List.of(
                "Nguyễn", "Trần", "Lê", "Phạm", "Hoàng", "Huỳnh", "Phan", "Đặng", "Bùi", "Đỗ", "Hồ", "Ngô", "Lý",
                "Dương", "Hầu", "Hình", "Hi", "Hứa", "Lã", "Cù", "Lương", "Đàm", "Nghiêm", "Ninh", "Ngọc", "Đường"
        ));

        Random rand = new Random();
        return lastNameContainer.get(rand.nextInt(lastNameContainer.size()));
    }
}
