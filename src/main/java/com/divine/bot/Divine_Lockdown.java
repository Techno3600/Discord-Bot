package com.divine.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Divine_Lockdown extends AdminCommand {
	@Override
	public List<String> getAliases() { return Arrays.asList("!server"); }

	@Override
	public String getDescription() { return "Lock chat"; }

	@Override
	public String getName() { return "Lockdown Command"; }

	@Override
	public List<String> getUsageInstructions() { return Arrays.asList("!server - Lock chat."); }
	
	@Override
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args[1].equalsIgnoreCase("lock"))
		{
			e.getChannel().sendMessage("Server Lockdown - Initiated").queue();
			e.getGuild().getRoleById(207553852147236864L).getManager().revokePermissions(Permission.MESSAGE_WRITE).reason("Server lockdown initiated by " + e.getAuthor().getName()).complete();
		} else if (args[1].equals("unlock"))
		{
			e.getChannel().sendMessage("Server Lockdown - Ended").queue();
			e.getGuild().getRoleById(207553852147236864L).getManager().givePermissions(Permission.MESSAGE_WRITE).reason("Server lockdown ended").complete();
		}
		
	}

}
