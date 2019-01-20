package com.bot.functions;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;

public class F {
	public static Member getM(Guild g, String s)
	{
		String m1 = s.replaceAll("<", "");
		m1 = m1.replaceAll("!", "");
		m1 = m1.replaceAll(">", "");
		m1 = m1.replaceAll("@", "");
		m1 = m1.trim();
		return g.getMemberById(Long.parseLong(m1));
	}
	public static TextChannel getT(Guild g, String s)
	{
		String m1 = s.replaceAll("<", "");
		m1 = m1.replaceAll("!", "");
		m1 = m1.replaceAll(">", "");
		m1 = m1.replaceAll("#", "");
		m1 = m1.trim();
		try {
			return g.getTextChannelById(Long.parseLong(m1));
		} catch (Exception e)
		{
			return null;
		}
		
	}
	public static EmbedBuilder error(String commandName, String commandDescription, String problem)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setTitle(commandName + " Error");
		f.setColor(Color.RED);
		f.setDescription(commandDescription);
		f.addField("Problem", problem, true);
		return f;
		
	}
}
