//package com.ownllm.back.promptmanager.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//public class PromptService {
//   private final String dbUrl;
//
//   public PromptService(String dbUrl) {
//       this.dbUrl = dbUrl;
//       initializeDatabase();
//   }
//
//   private void initializeDatabase() {
//       try (Connection conn = DriverManager.getConnection(dbUrl)) {
//           try (Statement stmt = conn.createStatement()) {
//               stmt.execute("CREATE TABLE IF NOT EXISTS prompts (id INTEGER PRIMARY KEY, prompt TEXT NOT NULL, model TEXT NOT NULL, result TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
//           }
//       } catch (SQLException e) {
//           log.error("Error initializing database: {}", e.getMessage());
//       }
//   }
//
//   public void addPrompt(String prompt) {
//       String sql = "INSERT INTO prompts(prompt) VALUES(?)";
//       try (Connection conn = DriverManager.getConnection(dbUrl);
//            PreparedStatement pstmt = conn.prepareStatement(sql)) {
//           pstmt.setString(1, prompt);
//           pstmt.executeUpdate();
//       } catch (SQLException e) {
//           System.err.println("Error adding prompt: " + e.getMessage());
//       }
//   }
//
//   public List<String> getAllPrompts() {
//       List<String> prompts = new ArrayList<>();
//       String sql = "SELECT prompt FROM prompts";
//       try (Connection conn = DriverManager.getConnection(dbUrl);
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql)) {
//           while (rs.next()) {
//               prompts.add(rs.getString("prompt"));
//           }
//       } catch (SQLException e) {
//           System.err.println("Error retrieving prompts: " + e.getMessage());
//       }
//       return prompts;
//   }
//
//   public boolean removePrompt(int id) {
//       String sql = "DELETE FROM prompts WHERE id = ?";
//       try (Connection conn = DriverManager.getConnection(dbUrl);
//            PreparedStatement pstmt = conn.prepareStatement(sql)) {
//           pstmt.setInt(1, id);
//           int affectedRows = pstmt.executeUpdate();
//           return affectedRows > 0;
//       } catch (SQLException e) {
//           System.err.println("Error removing prompt: " + e.getMessage());
//           return false;
//       }
//    }
//}