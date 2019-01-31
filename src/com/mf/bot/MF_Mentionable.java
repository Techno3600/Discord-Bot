package com.mf.bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bot.functions.F;
import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MF_Mentionable extends AdminCommand {
	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		List<Role> roles = new ArrayList<>();
		roles.add(e.getGuild().getRoleById(510663401295446016L));
		roles.add(e.getGuild().getRoleById(510663464843477003L));
		roles.add(e.getGuild().getRoleById(511189527273144330L));
		roles.add(e.getGuild().getRoleById(510663501610483712L));
		roles.add(e.getGuild().getRoleById(510663401295446016L));
		if (args[1].equalsIgnoreCase("true"))
		{
			for (Role r : roles)
			{
				r.getManager().setMentionable(true).complete();
				r.getManager().setMentionable(true).complete();
				r.getManager().setMentionable(true).complete();
				r.getManager().setMentionable(true).complete();
			}
		} else if (args[1].equalsIgnoreCase("false"))
		{
			for (Role r : roles)
			{
				r.getManager().setMentionable(false).complete();
				r.getManager().setMentionable(false).complete();
				r.getManager().setMentionable(false).complete();
				r.getManager().setMentionable(false).complete();
			}
		} else
		{
			e.getChannel().sendMessage(F.error("Mentionable Roles Toggle Command", "-m <true/false>", "You must enter either `true` or `false` as the first argument.").build()).queue();
		}
	}
	
	@Override
	public List<String> getAliases() { return Arrays.asList("-m", "-mentionable"); }

	@Override
	public String getName() { return "Mention Toggle Command"; }
	
	public Permission getPerm() {return Permission.MANAGE_SERVER; }
	
}
