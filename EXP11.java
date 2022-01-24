package exp1;
import java.util.Scanner;
class RSA
{
public static void main(String args[])
{
Scanner ip=new Scanner(System.in);
int p,q,n,e=1,j,z,d,i,k;
int slen;
int pt[]= new int[10];
int ct[]= new int[10];
int dt[]= new int[10];
String s=new String();
System.out.println("Enter the two prime numbers:");
p=ip.nextInt();
q=ip.nextInt();
System.out.print("Enter the message to be sent");
s=ip.next();
slen=s.length();
for(j=0;j<slen;j++)
{
pt[j]=(int)(s.charAt(j));   
n=p*q;
z=(p-1)*(q-1);
for(i=1;i<z;i++)
{
if(z%i==0)
continue;
else
break;
}
e=i;
System.out.println("encryption key"+n+" "+e);
for(i=1;i<z;i++)	
if(((e*i-1)%z)==0)
break;
d=i;
System.out.println("decryption key"+n+" "+d);
for(j=0;j<slen;j++)
{
k=pt[j];
for(i=1;i<e;i++)
{
k=k*pt[j];	
k=k%n;
}
k=k%n;
ct[j]=k;
}
System.out.println("Plaintext ----Cipher Text");
for(j=0;j<slen;j++)
{
System.out.println(s.charAt(j)+" "+ct[j]);
}
for(j=0;j<slen;j++)
{  
k=ct[j];
for(i=1;i<d;i++)
{
k=k*ct[j];	
k=k%n;
}
k=k%n;
dt[j]=k;
}
System.out.println("Ciphertext ----PlainText");
for(j=0;j<slen;j++)
{
System.out.println(ct[j]+" "+(char)dt[j]);
}
ip.close();  
}
}
