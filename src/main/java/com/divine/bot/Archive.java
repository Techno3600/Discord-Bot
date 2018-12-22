package com.divine.bot;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Archive extends AdminCommand {
	
	
	private EmbedBuilder getMsg(TextChannel c)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("Admin Action");
		f.setTitle("Channel Archive");
		f.setColor(Color.RED);
		f.setDescription(c.getAsMention() + " has been archived.");
		f.setFooter("This was an automated action initiated by an Administrator", "https://cdn.discordapp.com/icons/207553852147236864/c2d53e9f467990658a8010dd2c8c0442.png");
		return f;
	}

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage(getMsg(e.getTextChannel()).build()).queue();
		e.getTextChannel().getManager().setParent(e.getGuild().getCategoryById(498281958443581470L)).completeAfter(3, TimeUnit.SECONDS);
		e.getTextChannel().getManager().sync(e.getGuild().getCategoryById(498281958443581470L)).completeAfter(6, TimeUnit.SECONDS);
	}
	@Override
	public List<String> getAliases() { return Arrays.asList("!a", "!archive"); }

	@Override
	public String getName() { return "Archive Command"; }

	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }
}
