package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.CourseClass;
import model.Class;
public class ClassDBContext extends DBContext<Class> {

    @Override
    public void insert(Class model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Class model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Class model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class get(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  @Override
public ArrayList<Class> list() {
    ArrayList<Class> classes = new ArrayList<>();
    String sql = "SELECT * FROM Class";
    try (PreparedStatement stm = connection.prepareStatement(sql);
         ResultSet rs = stm.executeQuery()) {
        while (rs.next()) {
            Class cl = new Class();
            cl.setClass_id(rs.getInt("class_id"));
            cl.setClass_name(rs.getString("class_name"));
            classes.add(cl);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
    }
    return classes;
}

    
    public static void main(String[] args) {
         ClassDBContext dB = new ClassDBContext();
        List<Class> luList= dB.list();
         for(Class o:luList){
            System.out.println(o);
        }
    }
}
