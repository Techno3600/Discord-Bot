package com.gamingstuf.bot;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RoleNotif extends ListenerAdapter {
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent e)
	{
	Role discord = e.getGuild().getRoleById(513907234816917506L);
	Role polls = e.getGuild().getRoleById(513907486647123968L);
	Role cta = e.getGuild().getRoleById(513907560399503371L);
	Role gd = e.getGuild().getRoleById(513907600815816705L);
	Role notif = e.getGuild().getRoleById(513905287141261320L);
	
		if (e.getMessageId().equals("513903122301583370"))
		{
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), discord).complete();
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), notif).complete(); //Discord
		} else if (e.getMessageId().equals("513903298517008386"))
		{
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), polls).complete();
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), notif).complete(); //Polls
		} else if (e.getMessageId().equals("513905956132749312"))
		{
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), cta).complete();
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), notif).complete(); //Call-To-Arms
		} else if (e.getMessageId().equals("513906134092873739"))
		{
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), gd).complete();
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), notif).complete(); //Game-Discussion
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent e1)
	{
		Role discord = e1.getGuild().getRoleById(513907234816917506L);
		Role polls = e1.getGuild().getRoleById(513907486647123968L);
		Role cta = e1.getGuild().getRoleById(513907560399503371L);
		Role gd = e1.getGuild().getRoleById(513907600815816705L);
		Role notif = e1.getGuild().getRoleById(513905287141261320L);
		if (e1.getMessageId().equals("513903122301583370"))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), discord).complete(); ////Discord
		} else if (e1.getMessageId().equals("513903298517008386"))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), polls).complete(); //Polls
		} else if (e1.getMessageId().equals("513905956132749312"))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), cta).complete(); //Call-To-Arms
		} else if (e1.getMessageId().equals("513906134092873739"))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), gd).complete(); //Game-Discussion
		}
		if (!(e1.getMember().getRoles().contains("R:Polls(513907486647123968)")) && !(e1.getMember().getRoles().contains("R:Call-To-Arms(513907560399503371)")) && !(e1.getMember().getRoles().contains("R:Game-Discussion(513907600815816705)")) && !(e1.getMember().getRoles().contains("R:Discord(513907234816917506)")))
		{
			e1.getGuild().getController().removeSingleRoleFromMember(e1.getMember(), notif).complete();
		}
	}
}
