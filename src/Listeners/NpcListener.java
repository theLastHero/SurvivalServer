package Listeners;

import java.util.ArrayList;
import java.util.List;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import SurvivalServer.SurvivalServer;
import Utils.BookUtil;

public class NpcListener implements Listener{
	

	@EventHandler
	public void OnNPCRightClickEvent(NPCRightClickEvent e){
		
		int npcID = e.getNPC().getId();
		Player player = e.getClicker();
		
		
		
		String bookText = null;
		String bookCommand = null;
		
		switch (npcID) {
		//Peig Turi
		case 60:
			bookText = ChatColor.DARK_RED +""+ ChatColor.BOLD +"Perks!\n\n" + ChatColor.BLACK + "Here you can buy ingame perks and permissions.";
			break;
		//jur warbringer
		case 47:
				bookText = ChatColor.DARK_RED +""+ ChatColor.BOLD +"You made it!\n" + ChatColor.BLACK + "And just in time, the portal was destoryed just as you entered through it!\n\nGo forward to this new worlds spawn and begin your new adventures.";
				break;
		//Dr Norj
		case 48:
			bookText = ChatColor.DARK_RED +""+ ChatColor.BOLD +"This world is " + ChatColor.DARK_RED +""+ ChatColor.BOLD + "DOOMED!\n " + ChatColor.BLACK + "Due to a bad and EXPLOSIVE experiment, this world has become overrun by giant mutant zombies\n\nLeave everything you have built behind and get through the portal to a safe new land before it closes.";
			break;
		//Kui Jern	
		case 54:
			bookText = ChatColor.DARK_RED +""+ ChatColor.BOLD +"A little help!\n" + ChatColor.BLACK + "Its all I have left, take this handful of pork and keep running!";
			bookCommand = "give " + player.getName() + " 320 16";
			break;
			
		default:
			break;
		}
		
		if(bookText != null){
			List<String> pages = new ArrayList<String>();
			TextComponent page0 = new TextComponent("");
			
			page0.addExtra(bookText);
			pages.add(ComponentSerializer.toString(page0));
			
			openBook(player,  pages);
			
		}
		
		if(bookCommand != null){
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), bookCommand);
		}
		
	}
	
	public static void openBook(Player player, List<String> pages) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta meta = (BookMeta) book.getItemMeta();
		meta.setTitle("");
		meta.setAuthor("");
		BookUtil.setPages(meta, pages);
		book.setItemMeta(meta);
		BookUtil.openBook(book, player);
	}

}
