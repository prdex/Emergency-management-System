import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class President {
	int SecretCode;
	Scanner sc=new Scanner(System.in);
	public void BroadCast() throws IOException{
		System.out.println("please enter the message you want to send");
		String ss=sc.nextLine();
		FileReader f=new FileReader("Person");
		BufferedReader b=new BufferedReader(f);
		while(true) {
			String ssss=b.readLine();
			if(ssss==null)
				break;
			String[] sr=ssss.split(",");
			Person p=new Person(sr[0],sr[1],sr[2],sr[3],sr[4]);
			p.RecieveNotification(ss);
		}
		b.close();
		System.out.println("message send to People");
	}
}
