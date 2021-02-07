/*    */ package org.ehrengames.bankaddon.utils;
/*    */ 
/*    */ import de.plocki.utils.ConfigManager;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BankEconomy
/*    */ {
/*    */   public static void setupEconomy() {
/* 16 */     if (!ConfigManager.cfg.isSet("Host")) {
/* 17 */       ConfigManager.cfg.set("Host", "localhost");
/* 18 */       ConfigManager.saveConfig();
/*    */     } 
/* 20 */     if (!ConfigManager.cfg.isSet("Database")) {
/* 21 */       ConfigManager.cfg.set("Database", "dbname");
/* 22 */       ConfigManager.saveConfig();
/*    */     } 
/* 24 */     if (!ConfigManager.cfg.isSet("User")) {
/* 25 */       ConfigManager.cfg.set("User", "dbuser");
/* 26 */       ConfigManager.saveConfig();
/*    */     } 
/* 28 */     if (!ConfigManager.cfg.isSet("Password")) {
/* 29 */       ConfigManager.cfg.set("Password", "dbpassword");
/* 30 */       ConfigManager.saveConfig();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Integer getCoins(Player p) {
/* 35 */     MySQL.createTable();
/*    */     try {
/* 37 */       PreparedStatement st = MySQL.con.prepareStatement("SELECT coins FROM BankTable WHERE UUID = ?");
/* 38 */       st.setString(1, p.getUniqueId().toString());
/* 39 */       ResultSet rs = st.executeQuery();
/* 40 */       if (rs.next()) {
/* 41 */         return Integer.valueOf(rs.getInt("coins"));
/*    */       }
/* 43 */     } catch (SQLException e) {
/*    */       
/* 45 */       e.printStackTrace();
/*    */     } 
/* 47 */     return Integer.valueOf(-1);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setCoins(Player p, Integer arg) {
/* 52 */     if (getCoins(p).intValue() == -1) {
/*    */       try {
/* 54 */         PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO BankTable (UUID,coins) VALUES (?,?)");
/* 55 */         st.setString(1, p.getUniqueId().toString());
/* 56 */         st.setInt(2, arg.intValue());
/* 57 */         st.executeUpdate();
/* 58 */       } catch (SQLException e) {
/* 59 */         e.printStackTrace();
/*    */       } 
/*    */     } else {
/*    */       try {
/* 63 */         PreparedStatement st = MySQL.con.prepareStatement("UPDATE BankTable SET coins = ? WHERE UUID = ?");
/* 64 */         st.setString(2, p.getUniqueId().toString());
/* 65 */         st.setInt(1, arg.intValue());
/* 66 */         st.executeUpdate();
/* 67 */       } catch (SQLException e) {
/* 68 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   public static void addCoins(Player p, Integer arg) {
/* 73 */     setCoins(p, Integer.valueOf(arg.intValue() + getCoins(p).intValue()));
/*    */   }
/*    */   public static void removeCoins(Player p, Integer arg) {
/* 76 */     setCoins(p, Integer.valueOf(getCoins(p).intValue() - arg.intValue()));
/*    */   }
/*    */   
/*    */   public static void resetCoins(Player p) {
/* 80 */     if (getCoins(p).intValue() == -1) {
/*    */       try {
/* 82 */         PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO BankTable (UUID,coins) VALUES (?,?)");
/* 83 */         st.setString(1, p.getUniqueId().toString());
/* 84 */         st.setInt(2, 0);
/* 85 */         st.executeUpdate();
/* 86 */       } catch (SQLException e) {
/* 87 */         e.printStackTrace();
/*    */       } 
/*    */     } else {
/*    */       try {
/* 91 */         PreparedStatement st = MySQL.con.prepareStatement("UPDATE BankTable SET coins = ? WHERE UUID = ?");
/* 92 */         st.setString(2, p.getUniqueId().toString());
/* 93 */         st.setInt(1, 0);
/* 94 */         st.executeUpdate();
/* 95 */       } catch (SQLException e) {
/* 96 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/plocki/Downloads/BankAddon.jar!/org/ehrengames/bankaddon/utils/BankEconomy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */