package com.bot.main;

import java.util.List;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class UniversalSay extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getMessage().getContentRaw().startsWith("-us"))
		{
			String m = e.getMessage().getContentRaw().replaceAll("-us", "");
			e.getChannel().sendMessage("Sent!").queue();
			try {
				JDA divine = new JDABuilder(AccountType.BOT).setToken("NTE3OTA4ODE1ODI0NDIwODY1.DuJD6Q.LXDrfEvutMETBnElDdaQk5WksSo").build();
				List<Guild> g = divine.getGuildsByName("DivinePegasi's Hangout", true);
				g.get(0).getTextChannelById(212634316969213952L).sendMessage(m).queue();
			} catch (LoginException e1) {
				e1.printStackTrace();
			}
		}
	}
}