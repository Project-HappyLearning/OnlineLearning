/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DBDao extends DBContext{
    public List getAllAccount(){
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Account c = new Account(rs.getString("username"), rs.getString("password"), rs.getString("classify_account"));
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void insertAccount(String username,String password,String classifyAcc){
        String sql = "insert into Account values (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2, password);
            st.setString(3, classifyAcc);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        DBDao b = new DBDao();
        List<Account> a = b.getAllAccount();
        System.out.println(a);
    }
    
    public void insertProfile(String fullName, String dob, int gender,  
            String parentName, String parentEmail, String parentPhoneNumber, String username, float points) {
    String sql = "INSERT INTO [dbo].[User] (full_name, dob, gender, parent_name, parent_email, parent_phone_number, username, points) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement st = connection.prepareStatement(sql)) {
        st.setString(1, fullName);
        st.setString(2,dob);
        st.setInt(3, gender);
        st.setString(4, parentName);
        st.setString(5, parentEmail);
        st.setString(6, parentPhoneNumber);
        st.setString(7, username);
        st.setFloat(8, points);
        
        st.executeUpdate();
    } catch (Exception e) {
    }
}

    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
