package me.waqe.plugin

import me.waqe.plugin.cmds.VersionCmd
import me.waqe.plugin.events.JoinEvent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import java.util.*
import java.util.concurrent.ThreadLocalRandom


class App : JavaPlugin(), Listener {
    companion object {
        lateinit var instance: App
    }

    override fun onEnable() {
        instance = this
        //this.reloadConfig()
        //this.saveDefaultConfig()
        Bukkit.addRecipe(getRecipe())
        Bukkit.addRecipe(getPickaxeRecipe())

        server.pluginManager.registerEvents(JoinEvent(this), this)
        getCommand("version")?.setExecutor(VersionCmd())

    }

    override fun onDisable() {

    }

    fun getRecipe() : ShapedRecipe {
        val item = ItemStack(Material.NETHER_STAR)
        val key = NamespacedKey(this, "nether_star")

        val recipe = ShapedRecipe(key, item)
        recipe.shape(" T ","TET"," T ")
        recipe.setIngredient('T', Material.GHAST_TEAR)
        recipe.setIngredient('E', Material.EMERALD_BLOCK)

        return recipe
    }

    fun getPickaxeRecipe() : ShapedRecipe {
        val item = ItemStack(Material.DIAMOND_PICKAXE)
        val itemmeta = item.itemMeta
        itemmeta?.addEnchant(Enchantment.DIG_SPEED, 5, true)
        itemmeta?.setDisplayName("Ax-cess")
        item.itemMeta = itemmeta
        val key = NamespacedKey(this, "waqe")

        val recipe = ShapedRecipe(key, item)
        recipe.shape("EEE"," S "," S ")
        recipe.setIngredient('S', Material.STICK)
        recipe.setIngredient('E', Material.EMERALD_BLOCK)

        return recipe
    }

    @SuppressWarnings
    private fun String.red(): String {
        return this + ChatColor.RED
    }

    @SuppressWarnings
    private fun String.darkgrey(): String {
        return this + ChatColor.DARK_GRAY
    }

    @SuppressWarnings
    private fun String.cyan(): String {
        return this + ChatColor.BLUE
    }

    @SuppressWarnings
    private fun String.darkpurple(): String {
        return this + ChatColor.DARK_PURPLE
    }

    @SuppressWarnings
    private fun String.purple(): String {
        return this + ChatColor.LIGHT_PURPLE
    }

    @SuppressWarnings
    private fun String.gold(): String {
        return this + ChatColor.GOLD
    }

    @SuppressWarnings
    private fun String.green(): String {
        return this + ChatColor.GREEN
    }

    @SuppressWarnings
    private fun String.darkgreen(): String {
        return this + ChatColor.DARK_GREEN
    }

    @SuppressWarnings
    private fun String.darkred(): String {
        return this + ChatColor.DARK_RED
    }

    @SuppressWarnings
    private fun String.gray(): String {
        return this + ChatColor.GRAY
    }

    @SuppressWarnings
    private fun String.darkblue(): String {
        return this + ChatColor.DARK_BLUE
    }

    @SuppressWarnings
    private fun String.bold(): String {
        return this + ChatColor.BOLD
    }

    @SuppressWarnings
    private fun String.blue(): String {
        return this + ChatColor.BLUE
    }

}
