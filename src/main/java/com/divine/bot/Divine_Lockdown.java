package com.divine.bot;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Divine_Lockdown extends AdminCommand {
	@Override
	public List<String> getAliases() { return Arrays.asList("!server"); }

	@Override
	public String getName() { return "Lockdown Command"; }
	
	@Override
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args[1].equalsIgnoreCase("lock"))
		{
			EmbedBuilder b = new EmbedBuilder();
			b.setAuthor("STAFF ACTION - SERVER LOCKDOWN");
			b.setDescription("SERVER LOCKDOWN HAS TAKEN EFFECT.");
			b.setFooter("This lockdown was actioned by " + e.getAuthor().getName() + ".", "https://cdn.discordapp.com/icons/207553852147236864/c2d53e9f467990658a8010dd2c8c0442.png");
			b.setColor(Color.RED);
			e.getChannel().sendMessage(b.build()).queue();
			e.getGuild().getRoleById(207553852147236864L).getManager().revokePermissions(Permission.MESSAGE_WRITE).reason("Server lockdown initiated by " + e.getAuthor().getName()).complete();
		} else if (args[1].equals("unlock"))
		{
			EmbedBuilder b = new EmbedBuilder();
			b.setAuthor("STAFF ACTION - SERVER LOCKDOWN");
			b.setDescription("SERVER LOCKDOWN HAS BEEN LIFTED.");
			b.setFooter("This command was actioned by " + e.getAuthor().getName() + ".", "https://cdn.discordapp.com/icons/207553852147236864/c2d53e9f467990658a8010dd2c8c0442.png");
			b.setColor(Color.GREEN);
			e.getChannel().sendMessage(b.build()).queue();
			e.getGuild().getRoleById(207553852147236864L).getManager().givePermissions(Permission.MESSAGE_WRITE).reason("Server lockdown ended").complete();
		} else { e.getChannel().sendMessage("Incorrect Usage. !server <lock/unlock> - Lock/Unlock all server channels.").queue(); }
	}
}
