package com.bot.main;


import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Shutdown extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		if (e.getMessage().getContentRaw().startsWith("-shutdown"))
		{
			if (e.getMember().hasPermission(Permission.MANAGE_SERVER))
			{
				e.getChannel().sendMessage("Shutting Down...").queue();
				e.getJDA().shutdown();				
			}
		}
	}
}