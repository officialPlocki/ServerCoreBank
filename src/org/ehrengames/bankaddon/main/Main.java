/*    */ package org.ehrengames.bankaddon.main;
/*    */ import de.plocki.utils.MySQL;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ import org.ehrengames.bankaddon.commands.CMD_bank;
/*    */ import org.ehrengames.bankaddon.commands.CMD_ecobank;
/*    */ import org.ehrengames.bankaddon.utils.InventoryUtils;
/*    */ 
/*    */ public class Main extends JavaPlugin {
/*    */   public void onEnable() {
/* 14 */     MySQL.connect();
/* 15 */     MySQL.createTable();
/* 16 */     Bukkit.getPluginManager().registerEvents((Listener)new InventoryUtils(), (Plugin)this);
/* 17 */     getCommand("bank").setExecutor((CommandExecutor)new CMD_bank());
/* 18 */     getCommand("ecobank").setExecutor((CommandExecutor)new CMD_ecobank());
/*    */   }
/*    */   public void onDisable() {
/* 21 */     MySQL.disconnect();
/*    */   }
/*    */ }


/* Location:              /home/plocki/Downloads/BankAddon.jar!/org/ehrengames/bankaddon/main/Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */