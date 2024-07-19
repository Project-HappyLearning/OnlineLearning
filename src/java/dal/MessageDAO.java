package dal;

import model.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageDAO extends DBContext<Message> {

    @Override
    public void insert(Message message) {
        String query = "INSERT INTO messages (user_id, message_text, created_at, responded, response_text) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, message.getUserId());
            stmt.setString(2, message.getMessageText());
            stmt.setString(3, message.getCreatedAt());
            stmt.setBoolean(4, message.isResponded());
            stmt.setString(5, message.getResponseText());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Message message) {
        String query = "UPDATE messages SET responded = ?, response_text = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setBoolean(1, message.isResponded());
            stmt.setString(2, message.getResponseText());
            stmt.setInt(3, message.getID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Message message) {
        String query = "DELETE FROM messages WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, message.getID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void delete(int id) {
        String query = "DELETE FROM messages WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Message> list() {
        ArrayList<Message> messages = new ArrayList<>();
        String query = "SELECT * FROM messages";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                messages.add(new Message(
                    rs.getInt("ID"),
                    rs.getInt("user_id"),
                    rs.getString("message_text"),
                    rs.getString("created_at"),
                    rs.getBoolean("responded"),
                    rs.getString("response_text")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages;
    }

    @Override
    public Message get(int ID) {
        String query = "SELECT * FROM messages WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Message(
                        rs.getInt("ID"),
                        rs.getInt("user_id"),
                        rs.getString("message_text"),
                        rs.getString("created_at"),
                        rs.getBoolean("responded"),
                        rs.getString("response_text")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  

    public static void main(String[] args) {
        // Initialize the DAO
        MessageDAO messageDAO = new MessageDAO();

        // Create a new message
        Message newMessage = new Message(1, 1, "This is a test message.", "2024-07-15 10:00:00", true, null);
        messageDAO.insert(newMessage);
     
        // Fetch the message by ID
        Message fetchedMessage = messageDAO.get(1);
        if (fetchedMessage != null) {
            System.out.println("ID: " + fetchedMessage.getID());
            System.out.println("User ID: " + fetchedMessage.getUserId());
            System.out.println("Message Text: " + fetchedMessage.getMessageText());
            System.out.println("Created At: " + fetchedMessage.getCreatedAt());
            System.out.println("Responded: " + fetchedMessage.isResponded());
            System.out.println("Response Text: " + fetchedMessage.getResponseText());
            
        } else {
            System.out.println("Message not found for ID 1");
        }
    }
}
        