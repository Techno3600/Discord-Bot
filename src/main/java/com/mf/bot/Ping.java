package com.mf.bot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getMessage().getContentRaw().startsWith("-ping"))
		{
			if (!(e.getAuthor().isBot()))
			{
				e.getChannel().sendMessage("Pinged").queue();
			}
		}
	}
}
