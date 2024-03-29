package TestPlaceHolder;

import lombok.Data;

@Data
public class User {
    /*

        "id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
          "street": "Kulas Light",
          "suite": "Apt. 556",
          "city": "Gwenborough",
          "zipcode": "92998-3874",
          "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
          }
        },
        "phone": "1-770-736-8031 x56442",
        "website": "hildegard.org",
        "company": {
          "name": "Romaguera-Crona",
          "catchPhrase": "Multi-layered client-server neural-net",
          "bs": "harness real-time e-markets"
        }
     */
    int id;
    String name;
    String userName;
    String email;
    Adress adress;
    String phone;
    String website;
    Company company;

    @Data
    static
    class Adress {
        String street;
        String suite;
        String city;
        String zipcode;
        Geo geo;

        @Data
        static
        class Geo {
            String lat;
            String lng;
            public Geo(String lat, String lng){
                this.lat = lat;
                this.lng = lng;
            }
        }
    }

    @Data
    static
    class Company {
        String name;
        String catchPhrase;
        String bs;

        public Company(String name, String catchPhrase, String  bs){
            this.name = name;

            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }
    }
}