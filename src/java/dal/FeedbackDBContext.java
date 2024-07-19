/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.FeedBack;
import model.FeedbackInfo;
/**
 *
 * @author Nguyen Dep Trai
 */
public class FeedbackDBContext extends DBContext<FeedBack> {

    public FeedbackDBContext() {
        super();
    }

    @Override
    public ArrayList<FeedBack> list() {
        ArrayList<FeedBack> feedbacks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Feedback";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp createAtTimestamp = rs.getTimestamp("createAt");
                LocalDateTime createAt = createAtTimestamp.toLocalDateTime();
                FeedBack fed = new FeedBack(rs.getInt("feedbackID"),
                        rs.getInt("userID"),
                        rs.getInt("lesson_id"), 
                        rs.getInt("feedbackTypeID"),
                        createAt);
                feedbacks.add(fed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

    public ArrayList<FeedbackInfo> listFeedbackByType(int typeId) {
        ArrayList<FeedbackInfo> feedbacks = new ArrayList<>();
        try {
            String sql = "Select * from Feedback F \n"
                    + "  join FeedbackTypes Fb on F.feedbackTypeID = Fb.feedbackTypeID\n"
                    + "  join [User] U on U.user_id = F.userID\n"
                    + "  join [Lession] L on L.lession_id = F.lesson_id\n"
                    + "  join Module M on M.module_id = L.module_id\n"
                    + "  join Course CO on CO.course_id = M.course_id\n"
                    + "  join Class C on C.class_id = CO.class_id where Fb.feedbackTypeID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setInt(1, typeId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp createAtTimestamp = rs.getTimestamp("createAt");
                LocalDateTime createAt = createAtTimestamp.toLocalDateTime();
                FeedbackInfo fbInfo = new FeedbackInfo(
                        rs.getString("full_name"), 
                        rs.getString("feedbackType"), 
                        rs.getString("class_name"),
                        rs.getString("lession_name"),
                        rs.getString("module_name"), createAt);
                feedbacks.add(fbInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
    
    public FeedBack getFeedbackByUserAtLession(int userId, int lessionId) {
        try {
            String sql = "Select * from Feedback where userID = ? and lesson_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, lessionId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp createAtTimestamp = rs.getTimestamp("createAt");
                LocalDateTime createAt = createAtTimestamp.toLocalDateTime();
                FeedBack fed = new FeedBack(rs.getInt("feedbackID"),
                        rs.getInt("userID"),
                        rs.getInt("lesson_id"), 
                        rs.getInt("feedbackTypeID"),
                        createAt);
                return fed;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<FeedbackInfo> listFeedbackManage() {
        ArrayList<FeedbackInfo> feedbacks = new ArrayList<>();
        try {
            String sql = "Select * from Feedback F \n"
                    + "  join FeedbackTypes Fb on F.feedbackTypeID = Fb.feedbackTypeID\n"
                    + "  join [User] U on U.user_id = F.userID\n"
                    + "  join [Lession] L on L.lession_id = F.lesson_id\n"
                    + "  join Module M on M.module_id = L.module_id\n"
                    + "  join Course CO on CO.course_id = M.course_id\n"
                    + "  join Class C on C.class_id = CO.class_id";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp createAtTimestamp = rs.getTimestamp("createAt");
                LocalDateTime createAt = createAtTimestamp.toLocalDateTime();
                FeedbackInfo fbInfo = new FeedbackInfo(
                        rs.getString("full_name"), 
                        rs.getString("feedbackType"), 
                        rs.getString("class_name"),
                        rs.getString("lession_name"),
                        rs.getString("module_name"), createAt);
                feedbacks.add(fbInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
    
//    @Override
//    public FeedBack get(int id) {
//        FeedBack feedback = null;
//        try {
//            String sql = "SELECT * FROM FeedBack WHERE FeedBackID = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                feedback = new FeedBack();
//                feedback.setFeedbackID(rs.getInt("FeedBackID"));
//                feedback.setUserID(rs.getInt("UserID"));
//                feedback.setRating(rs.getInt("Rating"));
//                feedback.setComment(rs.getString("Comment"));
//                feedback.setDate(rs.getDate("Date"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return feedback;
//    }

    @Override
    public void insert(FeedBack feedback) {
        try {
            String sql = "INSERT INTO [dbo].[Feedback]\n"
                    + "           ([userID]\n"
                    + "           ,[feedbackTypeID]\n"
                    + "           ,[createAt]\n"
                    + "           ,[lesson_id])\n"
                    + "     VALUES (?, ?, ?, ?)";
           PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, feedback.getUserID());
            ps.setInt(2, feedback.getFeedbackTypeID());
            ps.setTimestamp(3,  Timestamp.valueOf(feedback.getCreateAt()));
            ps.setInt(4,  feedback.getLesson_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void update(FeedBack feedback) {
//        try {
//            String sql = "UPDATE FeedBack SET UserID = ?, Rating = ?, Comment = ?, Date = ? WHERE FeedBackID = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, feedback.getUserID());
//            ps.setInt(2, feedback.getRating());
//            ps.setString(3, feedback.getComment());
//            ps.setDate(4, new java.sql.Date(feedback.getDate().getTime()));
//            ps.setInt(5, feedback.getFeedbackID());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void delete(FeedBack feedback) {
        try {
            String sql = "DELETE FROM FeedBack WHERE FeedBackID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, feedback.getFeedbackID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FeedBack model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FeedBack get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
