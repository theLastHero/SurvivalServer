package Utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemsBuilder {

	public static ItemStack addEnchantment(ItemStack is, Enchantment enc, int level, String displayName){
		ItemStack toEnchant = is;
        ItemMeta toEnchantMeta = toEnchant.getItemMeta();
        
        //add enchants
        toEnchantMeta.addEnchant(enc, level, true);
        //add displayName
        if(displayName != null)
        	{toEnchantMeta.setDisplayName(displayName);
        }
        
        //save
        toEnchant.setItemMeta(toEnchantMeta);
        return toEnchant;
	}
	
}
