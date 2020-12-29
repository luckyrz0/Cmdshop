import java.io.InputStream;
import java.util.Scanner;

public class Test
{
	public static void main(String args[]) throws ClassNotFoundException {
		boolean bol =false;
		Scanner input =new Scanner(System.in);
		System.out.println("请输入用户名");
		String username =input.next();
		System.out.println("请输入密码");
		String password =input.next();
//		File file  =new File("D:\\lanqiaoProjects\\src\\user.xlsx");
		InputStream in  =Class.forName("Test").getResourceAsStream("user.xlsx");
		InputStream in2 =Class.forName("Test").getResourceAsStream("product.xlsx");
		ReadUserExcel re =new ReadUserExcel();
		ReadProductExcel pro =new ReadProductExcel();
		Product[] products =pro.readExcel(in2);
		User[] users =re.readExcel(in);
        for (int i=0;i<users.length;i++){
			if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password)){
				System.out.println("登录成功");
				System.out.println(products[i].toString());
				bol=true;
			}
		}
       if(!bol){
       	System.out.print("登录失败");
	   }
	}
}

