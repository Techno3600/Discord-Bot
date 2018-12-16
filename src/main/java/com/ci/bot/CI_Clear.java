package com.ci.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CI_Clear extends AdminCommand {
	@Override
	public List<String> getAliases() { return Arrays.asList("-clear", "-c"); }

	@Override
	public String getDescription() { return "Clear chat"; }

	@Override
	public String getName() { return "Clear Command"; }
	
	@Override
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }

	@Override
	public List<String> getUsageInstructions() { return Arrays.asList("-clear <int> - Clear `int` number of messages from `chat`"); }

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args.length == 2)
		{
			int i = 0;
			try {
				i = Integer.parseInt(args[1]);
			} catch (Exception e1) {
				e.getChannel().sendMessage("Argument 2 must be an integer.").queue();
			}
			int l = 0;
			while (l < i)
			{
				e.getChannel().deleteMessageById(e.getChannel().getLatestMessageId()).complete();
			}
		} else
		{
			e.getChannel().sendMessage(getUsageInstructions().toString()).queue();
		}
		
	}

}
