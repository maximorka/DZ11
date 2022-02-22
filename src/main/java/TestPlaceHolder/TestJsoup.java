package TestPlaceHolder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestJsoup {

    public static   User createUser(){
        User test = new User();
        test.setName("Leanne Mor");
        test.setEmail("MA@gmail.com");
        test.setId(12);
        test.setPhone("1-770-736-8031 x56442");
        test.setWebsite("myWeb.com");
        test.setUserName("Byba");
        User.Adress adress = new User.Adress();
        adress.setCity("Starcon");
        adress.setStreet("MyStreet");
        adress.setSuite("MySuit");
        adress.setZipcode("31100");
        adress.setGeo(new User.Adress.Geo("12121212","34343434"));

        test.setAdress(adress);

        test.setCompany(new User.Company("GU","Phase", "BS"));
        return  test;
    }

    public static Us1 cr(){
        Us1 u = new Us1();
u.setId(1);
        u.setTitle("foo");
        u.setBody("bar");
        u.setUserId(1);
        return u;
    }
    private static void sendPOST() throws IOException {
//        URL url = new URL(TEST_URL);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true);
//        OutputStream os = connection.getOutputStream();
//        os.write(Files.readAllBytes(new File("user.json").toPath()));
//        os.flush();
//        os.close();
//
//        int responseCode = connection.getResponseCode();
//        System.out.println("POST response code: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_CREATED) {
//            BufferedReader in =
//                    new BufferedReader(
//                            new InputStreamReader(connection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            System.out.println(response.toString());
//        } else {
//            System.out.println("POST request not worked");
//        }
   // }
}

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(TestJsoup.createUser());

        String myURL = "https://jsonplaceholder.typicode.com/users";

//        URL url = new URL(myURL);
//
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true);
//
//        OutputStream os = connection.getOutputStream();
//        os.write(json.getBytes());
//        //os.write(Files.readAllBytes(new File("user.json").toPath()));
//        os.flush();
//        os.close();
//
//        int responseCode = connection.getResponseCode();
//        System.out.println("POST response code: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_CREATED) {
//            BufferedReader in =
//                    new BufferedReader(
//                            new InputStreamReader(connection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            System.out.println(response.toString());
//        } else {
//            System.out.println("POST request not worked");
//        }
//
//




        // 2. POST authentication
//        Connection.Response auth = Jsoup.connect(myURL)
//                .timeout(10*1000)
//                .userAgent("Firefox ...")
//                .requestBody(json)
//                //.data("password", PASSWORD)
//                //.data("urlFwd", forwardingUrl)
//                //.data("tokenLogin", token)
//                //.cookies(loginForm.cookies()) // important!
//                .method(Connection.Method.POST)
//                .execute();
//        Document document = auth.parse();
//        String htmlAuth = document.toString();
//        System.out.println(htmlAuth);

        Document document = Jsoup.connect(myURL)
                .requestBody(json)
                .header("Content-Type", "application/json")
                .post();




        String htmlAuth = document.toString();
        System.out.println(htmlAuth);


    }
}
