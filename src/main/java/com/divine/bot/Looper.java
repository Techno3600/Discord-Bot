package com.divine.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Looper extends AdminCommand {

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args)
	{
		int i = Integer.parseInt(args[1]);
		String _m = e.getMessage().getContentRaw().replaceAll(args[0], "");
		 _m = _m.replaceAll(args[1], "");
		for (int i1 = 0; i1 < i; i1++)
		{
			e.getChannel().sendMessage(_m).queue();
		}
		
	}

	@Override
	public List<String> getAliases() {
		return Arrays.asList("!spam");
	}

	@Override
	public String getName() { return "Spam Command"; }

	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }
}
