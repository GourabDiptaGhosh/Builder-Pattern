
public class Main {
    public static void main(String args[]) {
        HTTPRequest request = new HTTPRequest(
                "https://api.example.com/users",
                HTTPRequest.HttpMethod.POST
        )
                .addHeader("Authorization", "Bearer xyz")
                .addHeader("Content-Type", "application/json")
                .addQueryParam("page", "2")
                .body("{\"name\":\"John\"}")
                .timeout(10)
                .followRedirects(false);
                /*.build();*/

        System.out.println(request.m_timeout);
    }
}
