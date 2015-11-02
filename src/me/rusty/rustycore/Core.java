package me.rusty.rustycore;

import me.rusty.rustycore.commands.Clear;
import me.rusty.rustycore.commands.FlySpeed;
import me.rusty.rustycore.commands.Help;
import me.rusty.rustycore.commands.Home;
import me.rusty.rustycore.commands.Hub;
import me.rusty.rustycore.commands.Spawn;
import me.rusty.rustycore.commands.TP;
import me.rusty.rustycore.commands.Time;
import me.rusty.rustycore.commands.Weather;
import me.rusty.rustycore.hanlders.Chat;
import me.rusty.rustycore.hanlders.CustomNoPermissions;
import me.rusty.rustycore.hanlders.Damaged;
import me.rusty.rustycore.hanlders.Exit;
import me.rusty.rustycore.hanlders.Gamemode;
import me.rusty.rustycore.hanlders.Join;
import me.rusty.rustycore.hanlders.Navigation;
import me.rusty.rustycore.hanlders.Protection;
import me.rusty.rustycore.hanlders.Visibility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Core extends JavaPlugin {


	@Override
	public void onEnable() {

		initializeEvents();
		initializeCommands();

		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		for (Player player : Bukkit.getOnlinePlayers()) {

			if (player.hasPermission("rustycore.staff")) {

				player.setGameMode(GameMode.CREATIVE);

			}

		}

	}

	private static Core instance;

	public Core() {
		instance = this;
	}

	public static Core getInstance() {
		return instance;
	}

	@Override
	public void onDisable() {

	}

	public void initializeEvents() {

		PluginManager pm = Bukkit.getServer().getPluginManager();

		pm.registerEvents(new Protection(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Exit(), this);
		pm.registerEvents(new Damaged(), this);
		pm.registerEvents(new Navigation(), this);
		pm.registerEvents(new CustomNoPermissions(), this);
		pm.registerEvents(new Visibility(), this);

	}

	public void initializeCommands() {

		getCommand("help").setExecutor(new Help());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("weather").setExecutor(new Weather());
		getCommand("time").setExecutor(new Time());
		getCommand("tp").setExecutor(new TP());
		getCommand("ci").setExecutor(new Clear());
		getCommand("home").setExecutor(new Home());
		getCommand("sethome").setExecutor(new Home());
		getCommand("hub").setExecutor(new Hub());
		getCommand("flyspeed").setExecutor(new FlySpeed());

	}

	public static ScoreboardManager manager = Bukkit.getScoreboardManager();
	public static Scoreboard ranks = manager.getNewScoreboard();

	public static Team member = ranks.registerNewTeam("member");
	public static Team mod = ranks.registerNewTeam("mod");
	public static Team admin = ranks.registerNewTeam("admin");
	public static Team owner = ranks.registerNewTeam("owner");

	static {

		member.setPrefix(ChatColor.GRAY + "");
		mod.setPrefix(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + ""
				+ ChatColor.BOLD + "MOD" + ChatColor.DARK_GRAY + "] ");

		admin.setPrefix(ChatColor.DARK_GRAY + "[" + ChatColor.RED + ""
				+ ChatColor.BOLD + "ADMIN" + ChatColor.DARK_GRAY + "] ");

		owner.setPrefix(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + ""
				+ ChatColor.BOLD + "OWNER" + ChatColor.DARK_GRAY + "] ");

	}

}
