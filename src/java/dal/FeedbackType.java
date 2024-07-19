/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.FeedBackType;

/**
 *
 * @author Nguyen Dep Trai
 */
public class FeedbackType extends DBContext<FeedBackType>{

    @Override
    public void insert(FeedBackType model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(FeedBackType model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(FeedBackType model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FeedBackType get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<FeedBackType> list() {
         ArrayList<FeedBackType> list = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM FeedbackTypes";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedBackType fedType = new FeedBackType(
                        rs.getInt("feedbackTypeID"),
                        rs.getString("feedbackType"),
                        rs.getString("feedbackIcon"));
                list.add(fedType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
