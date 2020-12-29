import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) throws ClassNotFoundException {
        boolean bol = false;
        while (!bol) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入用户名");
            String username = input.next();
            System.out.println("请输入密码");
            String password = input.next();
//		File file  =new File("D:\\lanqiaoProjects\\src\\user.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("user.xlsx");
            InputStream in2 = Class.forName("Test").getResourceAsStream("product.xlsx");
            ReadUserExcel re = new ReadUserExcel();
            ReadProductExcel pro = new ReadProductExcel();
            Product[] products = pro.readAllProduct(in2);
            Product[] shoppingCar = new Product[3];
            User[] users = re.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                    System.out.println("登录成功");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    System.out.println("请输入商品id");
                    String proId = input.next();
                    in2 = null;
                    int count = 0;
                    in2 = Class.forName("Test").getResourceAsStream("product.xlsx");
                    Product product = pro.readProducById(proId, in2);
                    if (product != null) {
                        shoppingCar[count++] = product;
                    }

                    bol = true;
                }
                if (!bol) {
                    System.out.println("登录失败");
                }
            }
            if (bol) {
                int index = 0;
                while (shoppingCar[index] != null && index < shoppingCar.length) {
                    System.out.println(shoppingCar[index].toString());
                    index++;
                }
            }
        }

    }
}

