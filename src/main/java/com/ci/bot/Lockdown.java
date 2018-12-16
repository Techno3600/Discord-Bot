package com.ci.bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Lockdown extends AdminCommand {
	@Override
	public List<String> getAliases() { return Arrays.asList("-lockdown", "-ld"); }

	@Override
	public String getDescription() { return "Lockdown Server"; }

	@Override
	public String getName() { return "Lockdown Command"; }
	
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }

	@Override
	public List<String> getUsageInstructions() { return Arrays.asList("-lockdown <lock/unlock> - Lockdown server"); }

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args)
	{
		List<Permission> roles = new ArrayList<>();
		roles.add(Permission.MESSAGE_WRITE);
		roles.add(Permission.MESSAGE_ADD_REACTION);
		if (args[1].equalsIgnoreCase("lock"))
		{
			e.getGuild().getRoleById(461206102982393876L).getManager().revokePermissions(roles).complete();
			e.getChannel().sendMessage("Discord Lockdown has taken effect.").queue();
		} else if (args[1].equalsIgnoreCase("unlock"))
		{
			e.getGuild().getRoleById(461206102982393876L).getManager().givePermissions(roles).complete();
			e.getChannel().sendMessage("Discord Lockdown has Ended.").queue();
		} else
		{
			e.getChannel().sendMessage("Error - -lockdown <lock/unlock>").complete();
		}
		
	}

}
