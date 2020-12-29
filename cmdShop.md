# POI操作Excel，实现简单地数据读取
## 一、大体框架
### 1.实体类：对应Excel表中的实体；
### 2.POI读取操作类；
### 3.根据表中数据进行判断，从而实现简单登录；
## 二、具体实现
### 1.实体类：
#### 类中包含变量和get、set方法，get方法用来获取实体中的具体值，set方法为实体类赋予具体的值（实例化）
####样例代码如下
```java
public class User {
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
```
### 2.poi读取Excel表：
####
以文件读取或者以InputStream读取，文件读取：File file =new File("路径");
InputStream读取：InputStream in =Class.forName("Test").getResourceAsStream("文件名.后缀")；
其中Class.forName()的作用是检查是否存在这样的一个类，存在的话就在当前文件下找，然后再以流的形式获取资源。
#### 主要代码如下：
```java
public class Test
{
File file  =new File("D:\\lanqiaoProjects\\src\\user.xlsx");
InputStream in  =Class.forName("Test").getResourceAsStream("user.xlsx");
ReadUserExcel re =new ReadUserExcel();
User[] users =re.readExcel(in);
}

public class ReadUserExcel {
    public User[] readExcel(InputStream inputStream) {
        User users[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(inputStream);
            XSSFSheet xs = xw.getSheetAt(0);
            users = new User[xs.getLastRowNum()];
}catch (IOException e) {
            e.printStackTrace();
        }
}
/*
根据类型取值
*/
 private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellType();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
}

```
### 3.从表中获取数据后，遍历进行判断
```java
 /*for (int i=0;i<users.length;i++){
			if(users[i].getUsername().equals(username)&&users[i].getPassword().equals(password)){
				System.out.println("登录成功");
				System.out.println(products[i].toString());
				bol=true;
			}
		}
       if(!bol){
       	System.out.print("登录失败");
	   }
*/
```