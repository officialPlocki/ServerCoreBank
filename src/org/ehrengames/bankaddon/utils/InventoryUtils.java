/*    */ package org.ehrengames.bankaddon.utils;
/*    */ 
/*    */ import de.plocki.main.Settings;
/*    */ import de.plocki.utils.ConfigManager;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ 
/*    */ 
/*    */ public class InventoryUtils
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public static void onJoin(PlayerJoinEvent e) {
/* 17 */     if (!e.getPlayer().hasPlayedBefore() && 
/* 18 */       BankEconomy.getCoins(e.getPlayer()).intValue() == -1) {
/* 19 */       BankEconomy.setCoins(e.getPlayer(), Integer.valueOf(250));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void onClick(InventoryClickEvent e) {
/* 26 */     Player p = (Player)e.getWhoClicked();
/*    */     
/* 28 */     if (e.getView().getTitle().equalsIgnoreCase("§bBank")) {
/* 29 */       e.setCancelled(true);
/* 30 */       if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEinzahlen")) {
/* 31 */         p.closeInventory();
/* 32 */         ConfigManager.tmp.set("Einzahlen." + p.getName(), Boolean.valueOf(true));
/* 33 */         ConfigManager.tmp.set("Auszahlen." + p.getName(), Boolean.valueOf(false));
/* 34 */         ConfigManager.saveTmp();
/* 35 */         p.sendMessage(String.valueOf(Settings.prefix) + "§bBitte schreibe jetzt den Betrag in den Chat.");
/* 36 */       } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAuszahlen")) {
/* 37 */         p.closeInventory();
/* 38 */         ConfigManager.tmp.set("Einzahlen." + p.getName(), Boolean.valueOf(false));
/* 39 */         ConfigManager.tmp.set("Auszahlen." + p.getName(), Boolean.valueOf(true));
/* 40 */         ConfigManager.saveTmp();
/* 41 */         p.sendMessage(String.valueOf(Settings.prefix) + "§bBitte schreibe jetzt den Betrag in den Chat.");
/*    */       } else {
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/plocki/Downloads/BankAddon.jar!/org/ehrengames/bankaddon/utils/InventoryUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */