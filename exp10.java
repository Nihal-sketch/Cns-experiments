/* UDP CLIENT*/
package exp1;
import java.io.*;
import java.net.*;
public class UDPclient {
public static void main(String[] args) throws Exception
{
BufferedReader cin= new BufferedReader(new 
InputStreamReader(System.in));
DatagramSocket ClientSocket=new DatagramSocket();
InetAddress IPAddress=InetAddress.getByName("192.168.200.20");
byte[] sendData=new byte[1024];
byte[] receiveData= new byte[1024];
String sentence= cin.readLine();
sendData=sentence.getBytes();
DatagramPacket sendPacket= new 
DatagramPacket(sendData,sendData.length,IPAddress,8000);
ClientSocket.send(sendPacket);
DatagramPacket receivePacket=new 
DatagramPacket(receiveData,receiveData.length);
ClientSocket.receive(receivePacket);
String RCVString=new String(receivePacket.getData());
System.out.println("received from Server"+RCVString);
ClientSocket.close(); } }

/* UDP SERVER*/
package exp1;
import java.io.*;
import java.net.*;
public class UDPServer {
public static void main(String[] args) throws Exception {
BufferedReader Cin= new BufferedReader(new 
InputStreamReader(System.in));
DatagramSocket ServerSocket=new DatagramSocket(8000);
byte[] receiveData=new byte[1024];
byte[] sendData=new byte[1024];
while(true)
{
DatagramPacket receivePacket=new 
DatagramPacket(receiveData,receiveData.length);
ServerSocket.receive(receivePacket);
String RCVString=new String(receivePacket.getData());
System.out.println("received from Client "+RCVString);
InetAddress ClientAddress= receivePacket.getAddress();
int port=receivePacket.getPort();
String Sentence=Cin.readLine();
sendData=Sentence.getBytes();
DatagramPacket sendPacket=new 
DatagramPacket(sendData,sendData.length,ClientAddress,port);
ServerSocket.send(sendPacket)
}}}
