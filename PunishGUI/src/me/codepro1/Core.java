package me.codepro1;

import com.earth2me.essentials.Essentials;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;
import org.bukkit.plugin.java.JavaPlugin;

public class Core
  extends JavaPlugin
  implements Listener
{
  HashMap<Player, Player> punishTarget = new HashMap<Player, Player>();
  HashMap<Player, OfflinePlayer> punishTargetOffline = new HashMap<Player, OfflinePlayer>();
  HashMap<Player, String> punishReason = new HashMap<Player, String>();
  ItemStack chatSev1 = new ItemStack(Material.INK_SACK);
  ItemStack chatSev2 = new ItemStack(Material.INK_SACK);
  ItemStack chatSev3 = new ItemStack(Material.INK_SACK);
  ItemStack chatSev4 = new ItemStack(Material.INK_SACK);
  ItemMeta chatSev1Meta = this.chatSev1.getItemMeta();
  ItemMeta chatSev2Meta = this.chatSev2.getItemMeta();
  ItemMeta chatSev3Meta = this.chatSev3.getItemMeta();
  ItemMeta chatSev4Meta = this.chatSev4.getItemMeta();
  ItemStack gameSev1 = new ItemStack(Material.INK_SACK);
  ItemStack gameSev4 = new ItemStack(Material.INK_SACK);
  ItemMeta gameSev1Meta = this.gameSev1.getItemMeta();
  ItemMeta gameSev4Meta = this.gameSev4.getItemMeta();
  ItemStack clientSev1 = new ItemStack(Material.INK_SACK);
  ItemStack clientSev2 = new ItemStack(Material.INK_SACK);
  ItemStack clientSev3 = new ItemStack(Material.INK_SACK);
  ItemMeta clientSev1Meta = this.clientSev1.getItemMeta();
  ItemMeta clientSev2Meta = this.clientSev2.getItemMeta();
  ItemMeta clientSev3Meta = this.clientSev3.getItemMeta();
  ItemStack generalWarn = new ItemStack(Material.BOOK_AND_QUILL);
  ItemStack generalBan = new ItemStack(Material.REDSTONE_BLOCK);
  ItemMeta generalWarnMeta = this.generalWarn.getItemMeta();
  ItemMeta generalBanMeta = this.generalBan.getItemMeta();
  Essentials essApi;
@SuppressWarnings({ "rawtypes", "unchecked" })
public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this, this);
    
    this.essApi = ((Essentials)getServer().getPluginManager().getPlugin("Essentials"));
    
    List<String> chatSev1Lore = new ArrayList();
    chatSev1Lore.add(ChatColor.RED + "Mute Duration: " + ChatColor.YELLOW + "1 Day");
    chatSev1Lore.add(ChatColor.RED + "Do this if they were warned before");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Caps");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Spam");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "General Rudeness");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Hackusation");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Arguing");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Chat Trolling");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Mini-Modding");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Light Advertisement");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Chat Filter Bypass");
    chatSev1Lore.add(ChatColor.DARK_GREEN + "Unapproved Links");
    
    this.chatSev1Meta.setLore(chatSev1Lore);
    this.chatSev1Meta.setDisplayName(ChatColor.GREEN + "Severity 1");
    Dye chatSev1Dye = new Dye();
    chatSev1Dye.setColor(DyeColor.GREEN);
    this.chatSev1 = chatSev1Dye.toItemStack();
    this.chatSev1.setAmount(1);
    this.chatSev1.setItemMeta(this.chatSev1Meta);
    
    List<String> chatSev2Lore = new ArrayList();
    chatSev2Lore.add(ChatColor.RED + "Mute Duration: " + ChatColor.YELLOW + "3 Days");
    chatSev2Lore.add(ChatColor.YELLOW + "Abusive Behavior");
    chatSev2Lore.add(ChatColor.YELLOW + "Bypassing Chat Filter");
    chatSev2Lore.add(ChatColor.YELLOW + "Sexual Harassment");
    chatSev2Lore.add(ChatColor.YELLOW + "Medium Advertising");
    this.chatSev2Meta.setLore(chatSev2Lore);
    this.chatSev2Meta.setDisplayName(ChatColor.YELLOW + "Severity 2");
    Dye Sev2Dye = new Dye();
    Sev2Dye.setColor(DyeColor.YELLOW);
    this.chatSev2 = Sev2Dye.toItemStack();
    this.chatSev2.setAmount(1);
    this.chatSev2.setItemMeta(this.chatSev2Meta);
    
    List<String> chatSev3Lore = new ArrayList();
    chatSev3Lore.add(ChatColor.RED + "Mute Duration: " + ChatColor.YELLOW + "10 Days");
    chatSev3Lore.add(ChatColor.RED + "DDOS and Death Threats");
    chatSev3Lore.add(ChatColor.RED + "Discrimination/Racism");
    chatSev3Lore.add(ChatColor.RED + "Revealing Personal Information");
    this.chatSev3Meta.setLore(chatSev3Lore);
    this.chatSev3Meta.setDisplayName(ChatColor.RED + "Severity 3");
    Dye sev3 = new Dye();
    sev3.setColor(DyeColor.RED);
    this.chatSev3 = sev3.toItemStack();
    this.chatSev3.setAmount(1);
    this.chatSev3.setItemMeta(this.chatSev3Meta);
    
    List<String> chatSev4Lore = new ArrayList();
    chatSev4Lore.add(ChatColor.RED + "Mute Duration: " + ChatColor.YELLOW + "Permanent");
    chatSev4Lore.add(ChatColor.DARK_GRAY + "Severe Advertisement");
    chatSev4Lore.add(ChatColor.DARK_GRAY + "Impersonation");
    chatSev4Lore.add(ChatColor.DARK_GRAY + "Scamming");
    chatSev4Lore.add(ChatColor.DARK_GRAY + "Unapproved Transactions");
    this.chatSev4Meta.setLore(chatSev4Lore);
    this.chatSev4Meta.setDisplayName(ChatColor.DARK_GRAY + "Severity 4");
    this.chatSev4.setItemMeta(this.chatSev4Meta);
    
    List<String> gameSev1Lore = new ArrayList();
    gameSev1Lore.add(ChatColor.RED + "Ban Duration: " + ChatColor.YELLOW + "1 Day");
    gameSev1Lore.add(ChatColor.DARK_GREEN + "Team Killing");
    gameSev1Lore.add(ChatColor.DARK_GREEN + "Gameplay Trolling (Spawn-killing)");
    gameSev1Lore.add(ChatColor.DARK_GREEN + "Map Exploiting");
    gameSev1Lore.add(ChatColor.DARK_GREEN + "Bug Exploiting");
    gameSev1Lore.add(ChatColor.DARK_GREEN + "Restricted Areas");
    gameSev1Lore.add(ChatColor.DARK_GREEN + "Inappropriate Builds");
    this.gameSev1Meta.setLore(gameSev1Lore);
    this.gameSev1Meta.setDisplayName(ChatColor.GREEN + "Severity 1");
    this.gameSev1 = chatSev1Dye.toItemStack();
    this.gameSev1.setAmount(1);
    this.gameSev1.setItemMeta(this.gameSev1Meta);
    
    List<String> gameSev4Lore = new ArrayList();
    gameSev4Lore.add(ChatColor.RED + "Ban Duration: " + ChatColor.YELLOW + "Permanent");
    gameSev4Lore.add(ChatColor.DARK_GRAY + "Inappropriate Username");
    gameSev4Lore.add(ChatColor.DARK_GRAY + "Inappropriate Skin/Cape");
    this.gameSev4Meta.setLore(gameSev4Lore);
    this.gameSev4Meta.setDisplayName(ChatColor.DARK_GRAY + "Severity 4");
    this.gameSev4.setItemMeta(this.gameSev4Meta);
    
    List<String> clientSev1Lore = new ArrayList();
    clientSev1Lore.add(ChatColor.RED + "Ban Duration: " + ChatColor.YELLOW + "3 Days");
    clientSev1Lore.add(ChatColor.DARK_GREEN + "Unapproved Mods");
    clientSev1Lore.add(ChatColor.DARK_GREEN + "   - Damage Indicators");
    clientSev1Lore.add(ChatColor.DARK_GREEN + "   - Player Radar");
    clientSev1Lore.add(ChatColor.DARK_GREEN + "Unapproved Macros");
    clientSev1Lore.add(ChatColor.DARK_GREEN + "   - Auto Clicker");
    this.clientSev1Meta.setLore(clientSev1Lore);
    this.clientSev1Meta.setDisplayName(ChatColor.GREEN + "Severity 1");
    this.clientSev1 = chatSev1Dye.toItemStack();
    this.clientSev1.setAmount(1);
    this.clientSev1.setItemMeta(this.clientSev1Meta);
    
    List<String> clientSev2Lore = new ArrayList();
    clientSev2Lore.add(ChatColor.RED + "Ban Duration: " + ChatColor.YELLOW + "30 Days");
    clientSev2Lore.add(ChatColor.YELLOW + "Combat Hacking");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Killaura/Forcefield");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Criticals");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Aimbot/Bow Aimbot");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Rapid Fire/Fast Bow");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Regen/Godmode");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Anti-Knockback");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Render hacking");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Nametags");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Xray");
    clientSev2Lore.add(ChatColor.YELLOW + "   - Tracers");
    this.clientSev2Meta.setLore(clientSev2Lore);
    this.clientSev2Meta.setDisplayName(ChatColor.YELLOW + "Severity 2");
    this.clientSev2 = Sev2Dye.toItemStack();
    this.clientSev2.setAmount(1);
    this.clientSev2.setItemMeta(this.clientSev2Meta);
    
    List<String> clientSev3Lore = new ArrayList();
    clientSev3Lore.add(ChatColor.RED + "Ban Duration: " + ChatColor.YELLOW + "Permanent");
    clientSev3Lore.add(ChatColor.RED + "Movement Hacking");
    clientSev3Lore.add(ChatColor.RED + "   - Fly Hack");
    clientSev3Lore.add(ChatColor.RED + "   - Speed/Sprint Hack");
    clientSev3Lore.add(ChatColor.RED + "   - Step Hack");
    clientSev3Lore.add(ChatColor.RED + "   - Water Walking");
    clientSev3Lore.add(ChatColor.RED + "   - Fast Ladder");
    clientSev3Lore.add(ChatColor.RED + "   - Glide Hack");
    clientSev3Lore.add(ChatColor.RED + "   - NoSlowDown Hack");
    clientSev3Lore.add(ChatColor.RED + "   - Sneak Hack");
    this.clientSev3Meta.setLore(clientSev3Lore);
    this.clientSev3Meta.setDisplayName(ChatColor.RED + "Severity 3");
    this.clientSev3 = sev3.toItemStack();
    this.clientSev3.setAmount(1);
    this.clientSev3.setItemMeta(this.clientSev3Meta);
    
    this.generalWarnMeta.setDisplayName(ChatColor.GRAY + "Warning");
    this.generalWarn.setItemMeta(this.generalWarnMeta);
    this.generalBanMeta.setDisplayName(ChatColor.RED + "Permanent Ban");
    this.generalBan.setItemMeta(this.generalBanMeta);
 
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      if ((cmd.getName().equalsIgnoreCase("punish")) && 
        (p.hasPermission("punish.gui")))
      {
        int length = args.length;
        if (length == 0)
        {
          p.sendMessage(ChatColor.RED + "Use " + ChatColor.RED + ChatColor.BOLD + "/punish <player> [reason]" + ChatColor.RESET + ChatColor.RED + " instead");
        }
        else if (length == 1)
        {
          p.sendMessage(ChatColor.RED + "Use " + ChatColor.RED + ChatColor.BOLD + "/punish <player> [reason]" + ChatColor.RESET + ChatColor.RED + " instead");
        }
        else if (length == 2)
        {
          Player t = Bukkit.getPlayer(args[0]);
          if (t != null)
          {
            openPunishGUI(p, t);
            this.punishReason.put(p, args[1]);
            this.punishTarget.put(p, t);
          }
          else
          {
            OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
            openPunishGUIOfflinePlayer(p, op);
            this.punishReason.put(p, args[1]);
            this.punishTargetOffline.put(p, op);
          }
        }
        else
        {
          Player t = Bukkit.getPlayer(args[0]);
          int j;
          if (t != null)
          {
            openPunishGUI(p, t);
            String reason = "";
            String[] arrayOfString1;
            j = (arrayOfString1 = args).length;
            for (int i = 0; i < j; i++)
            {
              String s = arrayOfString1[i];
              if (s != args[0]) {
                if (s != args[1]) {
                  reason = reason + " " + s;
                } else {
                  reason = args[1];
                }
              }
            }
            this.punishReason.put(p, reason);
            this.punishTarget.put(p, t);
          }
          else
          {
            OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
            openPunishGUIOfflinePlayer(p, op);
            String reason = "";
            String[] arrayOfString2;
            int k = (arrayOfString2 = args).length;
            for (j = 0; j < k; j++)
            {
              String s = arrayOfString2[j];
              if (s != args[0]) {
                if (s != args[1]) {
                  reason = reason + " " + s;
                } else {
                  reason = args[1];
                }
              }
            }
            this.punishReason.put(p, reason);
            this.punishTargetOffline.put(p, op);
          }
        }
      }
      return true;
    }
    sender.sendMessage(ChatColor.RED + "This command can only be used as player.");
    
    return false;
  }
  
  public void openPunishGUIOfflinePlayer(Player p, OfflinePlayer t)
  {
    Inventory gui = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Punishment Options");
    ItemStack playerName = new ItemStack(Material.PAPER);
    ItemMeta playerNameMeta = playerName.getItemMeta();
    playerNameMeta.setDisplayName(ChatColor.AQUA + t.getName());
    playerName.setItemMeta(playerNameMeta);
    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta sm = (SkullMeta)skull.getItemMeta();
    sm.setOwner(t.getName());
    sm.setDisplayName(ChatColor.YELLOW + t.getName());
    skull.setItemMeta(sm);
    ItemStack chatSection = new ItemStack(Material.NAME_TAG);
    ItemMeta chatSectionMeta = chatSection.getItemMeta();
    ItemStack gameOffense = new ItemStack(Material.IRON_SWORD);
    ItemMeta gameOffenseMeta = gameOffense.getItemMeta();
    ItemStack clientOffense = new ItemStack(Material.ANVIL);
    ItemMeta clientOffenseMeta = clientOffense.getItemMeta();
    ItemStack general = new ItemStack(Material.BLAZE_ROD);
    ItemMeta generalMeta = general.getItemMeta();
    
    chatSectionMeta.setDisplayName(ChatColor.YELLOW + "Chat Offenses");
    gameOffenseMeta.setDisplayName(ChatColor.YELLOW + "Game Offenses");
    clientOffenseMeta.setDisplayName(ChatColor.YELLOW + "Client Offenses");
    generalMeta.setDisplayName(ChatColor.YELLOW + "General Offenses");
    
    chatSection.setItemMeta(chatSectionMeta);
    gameOffense.setItemMeta(gameOffenseMeta);
    clientOffense.setItemMeta(clientOffenseMeta);
    general.setItemMeta(generalMeta);
    
    gui.setItem(0, playerName);
    gui.setItem(4, skull);
    gui.setItem(10, chatSection);
    gui.setItem(12, gameOffense);
    gui.setItem(14, clientOffense);
    gui.setItem(16, general);
    
    gui.setItem(19, this.chatSev1);
    gui.setItem(28, this.chatSev2);
    gui.setItem(37, this.chatSev3);
    gui.setItem(46, this.chatSev4);
    
    gui.setItem(21, this.gameSev1);
    gui.setItem(30, this.gameSev4);
    
    gui.setItem(23, this.clientSev1);
    gui.setItem(32, this.clientSev2);
    gui.setItem(41, this.clientSev3);
    
    gui.setItem(25, this.generalWarn);
    gui.setItem(34, this.generalBan);
    
    p.openInventory(gui);
  }
  
  public void openPunishGUI(Player p, Player t)
  {
    Inventory gui = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Punishment Options");
    ItemStack playerName = new ItemStack(Material.PAPER);
    ItemMeta playerNameMeta = playerName.getItemMeta();
    playerNameMeta.setDisplayName(ChatColor.AQUA + t.getName());
    playerName.setItemMeta(playerNameMeta);
    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta sm = (SkullMeta)skull.getItemMeta();
    sm.setOwner(t.getName());
    sm.setDisplayName(ChatColor.YELLOW + t.getName());
    skull.setItemMeta(sm);
    ItemStack chatSection = new ItemStack(Material.NAME_TAG);
    ItemMeta chatSectionMeta = chatSection.getItemMeta();
    ItemStack gameOffense = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta gameOffenseMeta = gameOffense.getItemMeta();
    ItemStack clientOffense = new ItemStack(Material.ANVIL);
    ItemMeta clientOffenseMeta = clientOffense.getItemMeta();
    ItemStack general = new ItemStack(Material.BLAZE_ROD);
    ItemMeta generalMeta = general.getItemMeta();
    
    chatSectionMeta.setDisplayName(ChatColor.YELLOW + "Chat Offenses");
    gameOffenseMeta.setDisplayName(ChatColor.YELLOW + "Game Offenses");
    clientOffenseMeta.setDisplayName(ChatColor.YELLOW + "Client Offenses");
    generalMeta.setDisplayName(ChatColor.YELLOW + "General Offenses");
    
    chatSection.setItemMeta(chatSectionMeta);
    gameOffense.setItemMeta(gameOffenseMeta);
    clientOffense.setItemMeta(clientOffenseMeta);
    general.setItemMeta(generalMeta);
    
    gui.setItem(0, playerName);
    gui.setItem(4, skull);
    gui.setItem(10, chatSection);
    gui.setItem(12, gameOffense);
    gui.setItem(14, clientOffense);
    gui.setItem(16, general);
    
    gui.setItem(19, this.chatSev1);
    gui.setItem(28, this.chatSev2);
    gui.setItem(37, this.chatSev3);
    gui.setItem(46, this.chatSev4);
    
    gui.setItem(21, this.gameSev1);
    gui.setItem(30, this.gameSev4);
    
    gui.setItem(23, this.clientSev1);
    gui.setItem(32, this.clientSev2);
    gui.setItem(41, this.clientSev3);
    
    gui.setItem(25, this.generalWarn);
    gui.setItem(34, this.generalBan);
    
    p.openInventory(gui);
  }
  public void NullPointerException(String s) {
}
@EventHandler

  public void onInvClick(InventoryClickEvent e) 
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().contains(this.chatSev2))
    {
      e.setCancelled(true);
      if ((e.getCurrentItem() != null) && (e.getCurrentItem().hasItemMeta()) && (e.getCurrentItem().getType() != Material.AIR))
      {
        ItemStack curItem = e.getCurrentItem();
        if (curItem.getItemMeta().equals(this.chatSev1Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev1.chat")) {        	
              getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((Player)this.punishTarget.get(p)).getName() + " 1day " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
        	getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " 1day " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.chatSev2Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev2.chat")) {
              getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((Player)this.punishTarget.get(p)).getName() + " 3day " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " 3day " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.chatSev3Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev3.chat")) {
              getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((Player)this.punishTarget.get(p)).getName() + " 10day " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " 10day " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.chatSev4Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev4.chat")) {
              getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((Player)this.punishTarget.get(p)).getName() + " " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "mute " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.gameSev1Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev1.game"))
            {
              getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((Player)this.punishTarget.get(p)).getName() + " 1day " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " 1day " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.gameSev4Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev4.game")) {
              getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((Player)this.punishTarget.get(p)).getName() + " " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.clientSev1Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev1.client")) {
              getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((Player)this.punishTarget.get(p)).getName() + " 3day " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " 3day " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.clientSev2Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev2.client")) {
              getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((Player)this.punishTarget.get(p)).getName() + " 30day " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " 30day " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.clientSev3Meta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.sev3.client")) {
              getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((Player)this.punishTarget.get(p)).getName() + " " + (String)this.punishReason.get(p));
            }
          }
          else if (this.punishTargetOffline.get(p) != null) {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " " + (String)this.punishReason.get(p));
          }
        }
        else if (curItem.getItemMeta().equals(this.generalWarnMeta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.warn"))
              getServer().dispatchCommand(getServer().getConsoleSender(), "warn " + ((Player)this.punishTarget.get(p)).getName() + " " + (String)this.punishReason.get(p));
            {
            }
          }
        }
        else if (curItem.getItemMeta().equals(this.generalBanMeta))
        {
          e.setCancelled(true);
          if (this.punishTarget.get(p) != null)
          {
            if (p.hasPermission("punish.permban"))
            {
              getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((Player)this.punishTarget.get(p)).getName() + " " + (String)this.punishReason.get(p));
              }
            }
          }
          else if (this.punishTargetOffline.get(p) != null)
          {
            getServer().dispatchCommand(getServer().getConsoleSender(), "ban " + ((OfflinePlayer)this.punishTargetOffline.get(p)).getName() + " " + (String)this.punishReason.get(p));
        }
        }
      }
    }
  

}


    
  
