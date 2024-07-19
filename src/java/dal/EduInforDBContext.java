package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.EduInfor;

public class EduInforDBContext extends DBContext<EduInfor> {

    public List<EduInfor> getAll() {
        List<EduInfor> list = new ArrayList<>();
        String sql = "SELECT * FROM EducationInformation";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String linkInfor = rs.getString("link_infor");
                EduInfor c = new EduInfor(id, title, linkInfor);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return list;
    }
    public void insertInfor(String title, String link) {
    String sql = "INSERT INTO EducationInformation (title, link_infor) VALUES (?, ?)";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, title);
        st.setString(2, link);
        st.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    
    public void deleteInfor(int id) {
    String sql = "DELETE FROM EducationInformation WHERE id = ?";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, id);
        st.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    public void updateInfor(String title,String link,int id) {
        String sql = "UPDATE [dbo].[EducationInformation]\n"
                + "   SET [title] = ?\n"
                + "      ,[link_infor] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, link);
            stm.setInt(3, id);

            stm.executeUpdate();
        } catch (Exception ex) {
        }
    }

    @Override
    public void insert(EduInfor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(EduInfor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(EduInfor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EduInfor get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public ArrayList<EduInfor> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        EduInforDBContext ed = new EduInforDBContext();
        List<EduInfor> list = ed.getAll();
        for(EduInfor e : list){
            System.out.println(e.getTitle());
        }
    }
}