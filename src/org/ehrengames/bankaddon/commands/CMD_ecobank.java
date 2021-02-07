package org.ehrengames.bankaddon.commands;

import de.plocki.main.Settings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ehrengames.bankaddon.utils.BankEconomy;




public class CMD_ecobank
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 18 */     Player p = (Player)sender;
    
/* 20 */     if (p.hasPermission(String.valueOf(Settings.permissionprefix) + ".ecobank")) {
/* 21 */       if (args.length == 0) {
/* 22 */         p.sendMessage("§e§lEcobank Hilfe");
/* 23 */         p.sendMessage("§c");
/* 24 */         p.sendMessage("§e/ecobank set <Spieler> <Geld>");
/* 25 */         p.sendMessage("§e/ecobank give <Spieler> <Geld>");
/* 26 */         p.sendMessage("§e/ecobank take <Spieler> <Geld>");
/* 27 */         p.sendMessage("§e/ecobank reset <Spieler>");
/* 28 */         p.sendMessage("§c");
/* 29 */         return false;
/* 30 */       }  if (args.length == 1) {
/* 31 */         p.sendMessage("§e§lEcobank Hilfe");
/* 32 */         p.sendMessage("§c");
/* 33 */         p.sendMessage("§e/ecobank set <Spieler> <Geld>");
/* 34 */         p.sendMessage("§e/ecobank give <Spieler> <Geld>");
/* 35 */         p.sendMessage("§e/ecobank take <Spieler> <Geld>");
/* 36 */         p.sendMessage("§e/ecobank reset <Spieler>");
/* 37 */         p.sendMessage("§c");
/* 38 */         return false;
/* 39 */       }  if (args.length == 2) {
/* 40 */         if (args[0].equalsIgnoreCase("reset")) {
/* 41 */           if (Bukkit.getPlayer(args[1]).isOnline()) {
/* 42 */             p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.value + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden zurückgesetzt.");
/* 43 */             BankEconomy.resetCoins(Bukkit.getPlayer(args[1]));
/* 44 */             return false;
          } 
/* 46 */           p.sendMessage(Settings.playernotonline);
/* 47 */           return false;
        } 
/* 49 */         p.sendMessage("§e§lEcobank Hilfe");
/* 50 */         p.sendMessage("§c");
/* 51 */         p.sendMessage("§e/ecobank set <Spieler> <Geld>");
/* 52 */         p.sendMessage("§e/ecobank give <Spieler> <Geld>");
/* 53 */         p.sendMessage("§e/ecobank take <Spieler> <Geld>");
/* 54 */         p.sendMessage("§e/ecobank reset <Spieler>");
/* 55 */         p.sendMessage("§c");
/* 56 */         return false;
      } 
/* 58 */       if (args.length == 3) {
/* 59 */         if (args[0].equalsIgnoreCase("set")) {
/* 60 */           if (Bukkit.getPlayer(args[1]).isOnline()) {
/* 61 */             p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.value + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden auf §e" + args[2] + " " + Settings.value + "§7 gesetzt.");
/* 62 */             BankEconomy.setCoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
/* 63 */             return false;
          } 
/* 65 */           p.sendMessage(Settings.playernotonline);
/* 66 */           return false;
        } 
/* 68 */         if (args[0].equalsIgnoreCase("give")) {
/* 69 */           if (Bukkit.getPlayer(args[1]).isOnline()) {
/* 70 */             p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.value + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden " + args[2] + " " + Settings.value + " hinzugefügt.");
/* 71 */             BankEconomy.addCoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
/* 72 */             return false;
          } 
          p.sendMessage(Settings.playernotonline);
          return false;
        } 
        if (args[0].equalsIgnoreCase("take")) {
          if (Bukkit.getPlayer(args[1]).isOnline()) {
            p.sendMessage(String.valueOf(Settings.prefix) + "§7Die §e" + Settings.value + " von " + Bukkit.getPlayer(args[1]) + "§7 wurden " + args[2] + " " + Settings.value + " entfernt.");
            BankEconomy.addCoins(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]));
            return false;
          } 
          p.sendMessage(Settings.playernotonline);
          return false;
        } 
      } 
    } else {
      
      p.sendMessage(Settings.nopermission);
    } 
    return false;
  }
}