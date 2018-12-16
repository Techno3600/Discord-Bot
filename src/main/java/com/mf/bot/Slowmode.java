package com.mf.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Slowmode extends AdminCommand {
	private static int i;
	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args.length == 2) {
			try {
				i = Integer.parseInt(args[1]);
			} catch (Exception e1) { 
				e.getChannel().sendMessage("Invalid argument. Must be an integer.").queue();
			}
			e.getTextChannel().getManager().setSlowmode(i).complete();
			if (i == 0)
			{
				e.getChannel().sendMessage("A slowdown for `" + e.getChannel().getName() + "` has been cleared.").queue();
			} else {
				e.getChannel().sendMessage("A slowdown for `" + e.getChannel().getName() + "` has been set to `" + i + "` seconds.").queue();
			}
			
		}
		
	}

	
	@Override
	public List<String> getAliases() { return Arrays.asList("-slowdown", "-sm"); }

	@Override
	public String getDescription() { return "Slowdown a channel"; }

	@Override
	public String getName() { return "Slowmode Command"; }
	
	@Override
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }

	@Override
	public List<String> getUsageInstructions() { return Arrays.asList("-slowdown <int> - Slowness Channel"); }


}
