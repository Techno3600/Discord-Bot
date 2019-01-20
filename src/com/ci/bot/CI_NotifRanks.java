package com.ci.bot;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CI_NotifRanks extends ListenerAdapter {
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent e)
	{
	Role updates = e.getGuild().getRoleById(514811421041754113L);
	Role spotlight = e.getGuild().getRoleById(514811366419202058L);
	Role notif = e.getGuild().getRoleById(514807417301762048L);
	
		if (e.getMessageId().equals("514803435414093834"))
		{
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), updates).complete();
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), notif).complete(); //Discord
		} else if (e.getMessageId().equals("514258823473659928"))
		{
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), spotlight).complete();
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), notif).complete(); //Polls
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent e1)
	{
		Role updates = e1.getGuild().getRoleById(514811421041754113L);
		Role spotlight = e1.getGuild().getRoleById(514811366419202058L);
		Role notif = e1.getGuild().getRoleById(514807417301762048L);
		if (e1.getMessageId().equals("514803435414093834"))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), updates).complete(); ////Discord
		} else if (e1.getMessageId().equals("514258823473659928"))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), spotlight).complete();
		}
		if (!(e1.getMember().getRoles().contains("R:Forums-Spotlight(514811366419202058)")) && !(e1.getMember().getRoles().contains("R:Discord-Updates(514811421041754113)")))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), notif).complete();
		}
	}
}
