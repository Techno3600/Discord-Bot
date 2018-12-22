package com.mf.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Mentionable extends AdminCommand {
	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args[1].equalsIgnoreCase("true"))
		{
			e.getGuild().getRoleById(510663401295446016L).getManager().setMentionable(true).complete();
			e.getGuild().getRoleById(510663464843477003L).getManager().setMentionable(true).complete();
			e.getGuild().getRoleById(511189527273144330L).getManager().setMentionable(true).complete();
			e.getGuild().getRoleById(510663501610483712L).getManager().setMentionable(true).complete();	
			e.getChannel().sendMessage("Mentionable Role = True").queue();
		} else
		{
			e.getGuild().getRoleById(510663401295446016L).getManager().setMentionable(false).complete();
			e.getGuild().getRoleById(510663464843477003L).getManager().setMentionable(false).complete();
			e.getGuild().getRoleById(511189527273144330L).getManager().setMentionable(false).complete();
			e.getGuild().getRoleById(510663501610483712L).getManager().setMentionable(false).complete();
			e.getChannel().sendMessage("Mentionable Role = False").queue();
		}

		
	}
	
	
	
	@Override
	public List<String> getAliases() { return Arrays.asList("-m", "-mentionable"); }

	@Override
	public String getName() { return "Mention Toggle Command"; }
	
	public Permission getPerm() {return Permission.MANAGE_SERVER; }



}
