package com.divine.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class uwu extends AdminCommand {

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args)
	{
		e.getChannel().sendTyping();
		for (int i = 0; i < 6; i++)
		{
			e.getChannel().sendMessage("Uwu").queue();
		}
		e.getChannel().sendTyping();
		
	}

	@Override
	public List<String> getAliases() {
		return Arrays.asList("!uwu", "!u");
	}

	@Override
	public String getName() { return "Uwu Command"; }

	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }
}
