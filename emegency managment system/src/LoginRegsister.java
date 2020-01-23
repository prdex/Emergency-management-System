import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class LoginRegsister {
	Scanner sc=new Scanner(System.in);
	
	String feature() throws IOException {
		System.out.println("press 0 to exit");
		System.out.println("press 1 for login");
		System.out.println("press 2 for sign up");
		System.out.println("press 3 if you are president");
		String a=sc.nextLine();
		if(a.equals("3")) {
			System.out.println("please enter secret code");
			String ss=sc.nextLine();
			FileReader f=new FileReader("secretcode");
			BufferedReader b=new BufferedReader(f);
			String s=b.readLine();
			if(s.equals(ss)) {
				President p=new President();
				p.BroadCast();
			}
			b.close();
			f.close();
			return null;
		}
		if(a.equals("0"))
			return null;
		else if(a.equals("1")){
			String s=validateLogin();
			return s;
		}
		else{
			signUp();
			String s=validateLogin();
			return s;
		}
	}
	 
	String validateLogin() throws IOException{
		System.out.println("please enter login id");
		String login=sc.nextLine();
		System.out.println("please enter password");
		String pass=sc.nextLine();
		String[] st=login.split("@");
		boolean flag=false;
		if(st[0].equals("Person")) {
			FileReader f=new FileReader(st[0]);
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				String[] a=l.split(",");
				if(a[2].equals(login) && a[3].equals(pass)) {
					System.out.println("welcome "+a[0]);
					flag=true;
					return l;
				}
			}
			b.close();
		}
		else if(st[0].equals("Doctor")) {
			FileReader f=new FileReader(st[0]);
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				String[] a=l.split(",");
				if(a[2].equals(login) && a[3].equals(pass)) {
					System.out.println("welcome "+a[0]);
					flag=true;
					return l;
				}
			}
			b.close();
		}
		else if(st[0].equals("NGO")) {
			FileReader f=new FileReader(st[0]);
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				String[] a=l.split(",");
				if(a[2].equals(login) && a[3].equals(pass)) {
					System.out.println("welcome "+a[0]);
					flag=true;
					return l;
				}
			}
			b.close();
		}
		else if(st[0].equals("reliefTeam")) {
			FileReader f=new FileReader(st[0]);
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				String[] a=l.split(",");
				if(a[2].equals(login) && a[3].equals(pass)) {
					System.out.println("welcome "+a[0]);
					flag=true;
					return l;
				}
			}
			b.close();
		}
		else if(st[0].equals("DiasterTeam")){
			FileReader f=new FileReader(st[0]);
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				String[] a=l.split(",");
				if(a[2].equals(login) && a[3].equals(pass)) {
					System.out.println("welcome "+a[0]);
					flag=true;
					return l;
				}
			}
			b.close();
		}
		if(!flag){
			System.out.println("login id or password is wrong.");
			return feature();
		}
		return null;
	}

	void signUp() throws IOException{
		System.out.println("enter 0 for person");
		System.out.println("enter 1 for relief team");
		System.out.println("enter 2 for disaster team");
		System.out.println("enter 3 for doctor");
		System.out.println("enter 4 for NGO");
		String s=sc.nextLine();
		if(s.equals("0")){
			System.out.println("NAME: ");
			String name=sc.nextLine();
			System.out.println("CONTACT NO: ");
			String co_no=sc.nextLine();
			System.out.println("enter password: ");
			String pass=sc.nextLine();
			System.out.println("Location : ");
			String loc=sc.nextLine();
			int count=0;
			FileReader f=new FileReader("Person");
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				count++;
			}
			b.close();
			f.close();
			count++;
			String login1="Person@"+count;
			FileWriter fw=new FileWriter("Person",true);
			BufferedWriter bb=new BufferedWriter(fw);
			bb.write(name+","+co_no+","+login1+","+pass+","+loc+"\n");
			System.out.println("welcome to EMS system your login id is "+login1);
			bb.close();
			fw.close();
		}
		else if(s.equals("1")){
			System.out.println("NAME: ");
			String name=sc.nextLine();
			System.out.println("CONTACT NO: ");
			String co_no=sc.nextLine();
			System.out.println("ENTER PASSWORD");
			String pass=sc.nextLine();
			System.out.println("HEAD/MEMBER: ");
			String he_me=sc.nextLine();
			System.out.println("Location : ");
			String loc=sc.nextLine();
			int count=0;
			FileReader f=new FileReader("reliefTeam");
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				count++;
			}
			b.close();
			f.close();
			count++;
			String login1="reliefTeam@"+count;
			FileWriter fw=new FileWriter("reliefTeam",true);
			BufferedWriter bb=new BufferedWriter(fw);
			bb.write(name+","+co_no+","+login1+","+pass+","+he_me+","+loc+"\n");
			System.out.println("welcome to EMS system your login id is "+login1);
			bb.close();
			fw.close();
		}
		else if(s.equals("2")){
			System.out.println("NAME: ");
			String name=sc.nextLine();
			System.out.println("CONTACT NO: ");
			String co_no=sc.nextLine();
			System.out.println("PASSWORD : ");
			String pass=sc.nextLine();
			System.out.println("HEAD/MEMBER: ");
			String he_me=sc.nextLine();
			int count=0;
			FileReader f=new FileReader("DiasterTeam");
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				count++;
			}
			b.close();
			f.close();
			count++;
			String login1="DiasterTeam@"+count;
			FileWriter fw=new FileWriter("DiasterTeam",true);
			BufferedWriter bb=new BufferedWriter(fw);
			bb.write(name+","+co_no+","+login1+","+pass+","+he_me+"\n");
			System.out.println("welcome to EMS system your login id is "+login1);
			bb.close();
			fw.close();
		}
		else if(s.equals("3")){
			System.out.println("NAME: ");
			String name=sc.nextLine();
			System.out.println("CONTACT NO: ");
			String co_no=sc.nextLine();
			System.out.println("ENTER PASSWORD: ");
			String pass=sc.nextLine();
			int count=0;
			FileReader f=new FileReader("Doctor");
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				count++;
			}
			b.close();
			f.close();
			count++;
			String login1="Doctor@"+count;
			FileWriter fw=new FileWriter("Doctor",true);
			BufferedWriter bb=new BufferedWriter(fw);
			bb.write(name+","+co_no+","+login1+","+pass+"\n");
			System.out.println("welcome to EMS system your login id is "+login1);
			bb.close();
			fw.close();
		}
		else{
			System.out.println("NAME: ");
			String name=sc.nextLine();
			System.out.println("CONTACT NO: ");
			String co_no=sc.nextLine();
			System.out.println("Bank Details: ");
			String ba_de=sc.nextLine();
			System.out.println("ImportantDoc: ");
			String im_dc=sc.nextLine();
			System.out.println("ENTER PASSWORD: ");
			String pass=sc.nextLine();
			int count=0;
			FileReader f=new FileReader("NGO");
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String l=b.readLine();
				if(l==null)
					break;
				count++;
			}
			b.close();
			f.close();
			count++;
			String login1="NGO@"+count;
			FileWriter fw=new FileWriter("NGO",true);
			BufferedWriter bb=new BufferedWriter(fw);
			bb.write(name+","+co_no+","+login1+","+pass+","+ba_de+","+im_dc+",0"+"\n");
			System.out.println("welcome to EMS system your login id is "+login1);
			bb.close();
			fw.close();
		}
	}
}
