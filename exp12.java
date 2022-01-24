package exp1;
import java.util.Scanner;
import java.util.Random;
public class LeakyBucket {
 public static void main(String[] args) {
int n, clk, b_size ,o_rate ,p_sz_rm=0, p_sz, p_time;
int[] packets;
Scanner sc= new Scanner(System.in);
System.out.println("Enter total number of packets");
n=sc.nextInt();
//System.out.println("enter size of n packets");
packets = new int[n];
Random rand=new Random();
for(int i=0;i<n;i++){
// packets[i]=sc.nextInt();
packets[i]=(rand.nextInt(5)+1)*10; }
System.out.println("Enter Output rate");
o_rate=sc.nextInt();
System.out.println("enter Bucket Size");
b_size=sc.nextInt();	
for(int i=0;i<n;i++) {
if((packets[i]+p_sz_rm)>b_size){
if(packets[i]>b_size)
System.out.println("Incoming packet size" + packets[i]+"is Greater than  
 bucket  capacity REJECTED");                   			
else
System.out.println("Incomming packet size is" +packets[i] +" Bucket 
capacity exceeded - REJECTED!!"); 
else {
 p_sz=packets[i];
p_sz_rm+=p_sz;
System.out.println("Incoming Packet size:"+ p_sz);
System.out.println("Transmission left:"+ p_sz_rm);
p_time=rand.nextInt(4);
System.out.println("Next Packet Will come at :"+p_time);
for(clk=0;clk<=p_time;clk+=1) {
System.out.println("Time Left:" + (p_time-clk));
if(p_sz_rm!=0){
if(p_sz_rm<=o_rate){
System.out.println(" Bytes  Transmitted--"+p_sz_rm);
p_sz_rm=0; }
else {
System.out.println("Bytes  Transmitted--"+ o_rate);
p_sz_rm-=o_rate; }
System.out.println("Bytes Remaining:--"+p_sz_rm);}
else
 System.out.println("No packets to transmit--");
}}}
System.out.println();
sc.close();
}} 
