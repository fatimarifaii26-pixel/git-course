import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // اتصلي على السيرفر المحلي (نفس الجهاز)
        Socket socket = new Socket("localhost", 5252);

        // إدخال من المستخدم
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        // قناة إرسال للسيرفر
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // قناة استقبال من السيرفر
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.print("Enter an integer: ");
        String num = userInput.readLine();

        // إرسال الرقم للسيرفر
        out.println(num);

        // استقبال الرد من السيرفر
        System.out.println("Server response: " + in.readLine());

        socket.close();
    }
}
