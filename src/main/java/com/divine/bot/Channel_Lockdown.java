package com.divine.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.PermissionOverride;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Channel_Lockdown extends AdminCommand {
	@Override
	public List<String> getAliases() { return Arrays.asList("!channel"); }

	@Override
	public String getDescription() { return "Channel Lockdown"; }

	@Override
	public String getName() { return "Channel Lockdown Command"; }

	@Override
	public List<String> getUsageInstructions() { return Arrays.asList("!channel <lock/unlock> - Lock chat."); }
	
	@Override
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args[1].equalsIgnoreCase("lock"))
		{
			List<PermissionOverride> everyone = e.getTextChannel().getPermissionOverrides();
			e.getChannel().sendMessage(everyone.toString()).queue();
		} else if (args[1].equals("unlock"))
		{
			//e.getChannel().sendMessage("Server Lockdown - Ended").queue();
			//e.getGuild().getRoleById(207553852147236864L).getManager().givePermissions(Permission.MESSAGE_WRITE).reason("Server lockdown ended").complete();
		}
	}

}