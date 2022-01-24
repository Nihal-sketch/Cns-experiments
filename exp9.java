/*TCP Client*/
package exp1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class TCPClient
 {	
public static void main(String[] args) throws 
IOException,InterruptedException 
{
DataOutputStream out;
DataInputStream in;		
Scanner scanner = new Scanner(System.in);
Socket socket = new Socket("127.0.0.1", 6000); 
System.out.println("Client Connected to Server");
System.out.print("\nEnter the filename to request\n");
String filename = scanner.nextLine();
in = new DataInputStream(socket.getInputStream());
out = new DataOutputStream(socket.getOutputStream());
out.writeUTF(filename);
String fileContent = in.readUTF();
if (fileContent.length() > 0)
System.out.println(fileContent);
else
System.out.println("FILE IS EMPTY");
}
}

/*TCP SERVER*/ 
package exp1;
import java.io.*;
import java.net.*;
import java.nio.file.*;
public class TCPServer 
{
public static void main(String[] args) throws IOException 
{
ServerSocket server;
DataOutputStream out = null;
DataInputStream in;
try 
{
server = new ServerSocket(6000, 1); 
System.out.println("Server Waiting for client");
Socket socket = server.accept();
System.out.println("Client connected ");
in = new DataInputStream(socket.getInputStream());
out = new DataOutputStream(socket.getOutputStream());
String fileName = in.readUTF();
System.out.println("File Requested is : " + fileName);
byte[] filedata = Files.readAllBytes(Paths.get(fileName));
String fileContent = new String(filedata);
out.writeUTF(fileContent.toString());
System.out.println("FILE SENT SUCCESSFULLY");
} 
catch (Exception e)
 {
System.out.println(e.getMessage());
out.writeUTF("FILE DOESN'T EXISTS");
}
}
}
