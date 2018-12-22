package com.divine.bot;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Restricter extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getChannel().getId().equals("520408816375037953"))
		{
			if (!(e.getMember().hasPermission(Permission.MESSAGE_MANAGE) && !(e.getAuthor().isBot())))
			{
				if (!(e.getMessage().getContentRaw().startsWith("-")))
				{
					e.getChannel().deleteMessageById(e.getMessageIdLong()).complete();
				}
			}
		}
	}
}