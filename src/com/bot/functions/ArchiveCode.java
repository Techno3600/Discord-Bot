package com.bot.functions;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;

public class ArchiveCode {
	public static void Archive(Guild guild, TextChannel targetChannel, Category archiveCategory)
	{
		targetChannel.sendMessage(getMsg(targetChannel).build()).queue();
		targetChannel.getManager().setName("a-" + targetChannel.getName()).queue();
		targetChannel.getManager().setParent(archiveCategory).completeAfter(3, TimeUnit.SECONDS);
		targetChannel.getManager().sync(archiveCategory).completeAfter(6, TimeUnit.SECONDS);
	}
	
	private static EmbedBuilder getMsg(TextChannel c)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("Admin Action");
		f.setTitle("Channel Archive");
		f.setColor(Color.RED);
		f.setDescription(c.getAsMention() + " has been archived.");
		f.setFooter("This was an automated action initiated by an Administrator", c.getGuild().getIconUrl());
		return f;
	}
}
