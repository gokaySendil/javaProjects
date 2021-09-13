package GokaySendilEfeNerman;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class CreateDatabase {
    String url = "jdbc:mysql://localhost:3306/ınventorymanagementsystem?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    String user="root";
    String password="efe1997";
    private ResultSet rs;

    public Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            connection = null;
        }
        return connection;
    }

    public boolean SAVE_COMPANY(String name,String branch,String location,String slogan) throws SQLException {
        Connection c = connect();
        Statement statement= c.createStatement();
        boolean s=false;
        String sql="INSERT INTO inventory(Company_name,Company_Branch,Company_Location,Company_Slogan) VALUES('"+name+"','"+branch+"','"+location+"','"+slogan+"');";
        int i=statement.executeUpdate(sql);
        if (i==0){
            return false;
        }
        return true;
    }
    public boolean SAVE_USER(String name,String password,String email,String Birthdate,String Address) throws SQLException {

        Connection c= connect();
        Statement statement = c.createStatement();
        String sql = "SELECT * FROM inventory ORDER BY idInventory DESC LIMIT 1";
        int id=-1;
        rs=statement.executeQuery(sql);
        if (rs==null){
            return false;
        }
        while (rs.next()){
            id=rs.getInt("idInventory");
        }
        if (id!=-1){
            sql="INSERT INTO user (username,password,email,birthdate,address,Inventory_idInventory) VALUES('"+name+"','"+password+"','"+email+"','"+Birthdate+"','"
                    +Address+"','"+id+"');";
            int i=statement.executeUpdate(sql);
            if (i==0){
                return false;
            }
        }


        return true;
    }
    public boolean username_isvalid(String uname) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql = "SELECT username FROM user;";
        rs=statement.executeQuery(sql);
        while (rs.next()){
            if (uname==rs.getString("username")){
                return false;
            }
        }
        return true;
    }
    public boolean companyname_isValid(String cname) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql = "SELECT Company_name FROM inventory;";
        rs=statement.executeQuery(sql);
        while (rs.next()){
            if (cname==rs.getString("Company_name")){
                return false;
            }
        }
        return true;
    }

    public boolean log_in(String uname,String password) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql = "SELECT username,password FROM user;";
        rs=statement.executeQuery(sql);
        while (rs.next()){
            if (uname.equals(rs.getString("username"))&& password.equals(rs.getString("password"))){
                return true;
            }
        }
        return false;
    }








    public int find_inventory_id(String uname) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql = "SELECT username,Inventory_idInventory FROM user";
        int inventory=-1;
        rs=statement.executeQuery(sql);
        while (rs.next()){
            if (uname.equals(rs.getString("username"))){
                inventory=rs.getInt("Inventory_idInventory");
            }
        }
    return inventory;
    }





    public ArrayList<String> company_infos(String uname) throws SQLException {

        ArrayList<String> company_infos= new ArrayList<>();
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql = "SELECT username,Inventory_idInventory FROM user";
        int inventory=-1;
        rs=statement.executeQuery(sql);
        while (rs.next()){
            if (uname.equals(rs.getString("username"))){
                inventory=rs.getInt("Inventory_idInventory");
            }
        }
        if (inventory!=-1){
            sql="SELECT Company_name,Company_Branch FROM inventory where idInventory="+inventory+";";
            rs=statement.executeQuery(sql);
            while (rs.next()){
                company_infos.add(rs.getString("Company_name"));
                company_infos.add(rs.getString("Company_Branch"));

            }
        }



        return company_infos;
    }


    public ArrayList<String> get_products(int inventory) throws SQLException {

        // fill the list
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql ="SELECT * FROM products where Inventory_idInventory="+inventory+";";
        ArrayList<String> products = new ArrayList<>();
        rs=statement.executeQuery(sql);
        while (rs.next()){
            String s = rs.getString(2)+"=>"+rs.getString(3)+"=>"+rs.getString(4)+"=>"+rs.getString(6);
            products.add(s);
        }
        return products;
    }

    public boolean remove_from_products(String name) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql ="DELETE  FROM products where Name ='"+name+"';";
        int i=statement.executeUpdate(sql);
        if (i==0){
            return false;
        }
        return true;

    }

    public boolean find_product(String pname) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql ="Select *FROM products;";
        rs=statement.executeQuery(sql);
        while (rs.next()){
            if (pname.equals(rs.getString(2))){
                return true;
            }
        }
        return false;
    }

    public int get_product_quantity(String name) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql ="Select quantity FROM products where Name ='"+name+"';";
        rs=statement.executeQuery(sql);
        while (rs.next()){

            return rs.getInt("quantity");
        }
        return -1;
    }

    public boolean update_quantity(String name,int quantity) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        String sql ="UPDATE products SET quantity = '"+quantity +"' WHERE Name ='"+name+"';";
        int i=statement.executeUpdate(sql);
        if (i==0){
            return false;
        }
        return true;

    }

    public boolean update_order(String name, String desc, int count, int inventory_id) throws SQLException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        LocalDateTime now = LocalDateTime.now();
        String s = dtf.format(now);
        System.out.println(s);
        Connection c= connect();
        Statement statement = c.createStatement();
        System.out.println(desc);
        String sql = "INSERT INTO ınventorymanagementsystem.order(Order_count,OrderDate,OrderDescription,id_inventory) VALUES('"+count+"','"+s+"','"+desc+"','"+inventory_id+"');";
        String sql2= "INSERT INTO order";
        int i=statement.executeUpdate(sql);
        //int j=statement.executeUpdate(sql2);
        if (i==0){
            return false;
        }
        return true;
    }

    public boolean add_product(String name,String desc,String category,int quantity,int inventory_id) throws SQLException {
        Connection c= connect();
        Statement statement = c.createStatement();
        Random r = new Random();
        float price=r.nextFloat()*101;
        String sql =  "INSERT INTO products ( Name,Description,Price,Category,Quantity,Inventory_idInventory) VALUES('"+name+"','"+desc+"','"+price+"','"+category+"','"+quantity+"','"+inventory_id+"');";
        int i=statement.executeUpdate(sql);
        if (i==0){
            return false;
        }
        return true;
    }





}



