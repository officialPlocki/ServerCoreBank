/*    */ package org.ehrengames.bankaddon.utils;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MySQL
/*    */ {
/*    */   public static Connection con;
/* 14 */   static String host = "136.243.4.165";
/* 15 */   static String db = "s655_test2";
/* 16 */   static String user = "u655_AxzFo9pmfk";
/* 17 */   static String pw = "8MiIcxL=UTbdITwxsSVJ!rZS";
/*    */   
/*    */   public static void connect() {
/* 20 */     if (!isConnected()) {
/*    */       try {
/* 22 */         con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db + "?autoReconnect=true", user, pw);
/* 23 */         System.out.println("MySQL verbunden!");
/* 24 */         createTable();
/* 25 */       } catch (SQLException e) {
/*    */         
/* 27 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public static void disconnect() {
/* 33 */     if (!isConnected()) {
/*    */       try {
/* 35 */         con.close();
/* 36 */         System.out.println("MySQL gentrennt!");
/* 37 */       } catch (SQLException e) {
/*    */         
/* 39 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public static void createTable() {
/* 45 */     if (!isConnected()) {
/* 46 */       connect();
/*    */     }
/*    */     try {
/* 49 */       con.prepareStatement("CREATE TABLE IF NOT EXISTS BankTable (UUID VARCHAR(100), coins INT(16))").executeUpdate();
/* 50 */     } catch (SQLException e) {
/*    */       
/* 52 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private static boolean isConnected() {
/* 57 */     return (con != null);
/*    */   }
/*    */ }


/* Location:              /home/plocki/Downloads/BankAddon.jar!/org/ehrengames/bankaddon/utils/MySQL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */