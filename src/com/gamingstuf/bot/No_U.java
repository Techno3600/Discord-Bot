package com.gamingstuf.bot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class No_U extends ListenerAdapter
{
	public void onMessageReceived(MessageReceivedEvent e)
	{
		String content = e.getMessage().getContentRaw();
		if (content.toLowerCase().contains(" no u "))
		{
			e.getChannel().sendMessage("Blue skip\n" + 
					"Draw four\n" + 
					"Yellow 7\n" + 
					"Uno\n" + 
					"I win").queue();
		}
	}

}
