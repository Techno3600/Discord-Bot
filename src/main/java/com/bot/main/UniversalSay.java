/*package com.bot.main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class UniversalSay extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getMessage().getContentRaw().startsWith("-us"))
		{
			String m = e.getMessage().getContentRaw().replaceAll("-us", "");
			e.getChannel().sendMessage("Sent!").queue();
			
		}
	}
}*/