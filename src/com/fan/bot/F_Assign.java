package com.fan.bot;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class F_Assign extends ListenerAdapter {
	public Role getRole(Long l, Guild g)
	{
		return g.getRoleById(l);
	}
	public void mainA(Role r, Member m, Guild g)
	{
		g.getController().addSingleRoleToMember(m, r).complete();
		g.getController().addSingleRoleToMember(m, getRole(515763411242713088L, g)).complete();
	}
	public void mainR(Role r, Member m, Guild g)
	{
		g.getController().removeSingleRoleFromMember(m, r).complete();
	}
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent e)
	{
		if (e.getMessageId().equals("515759897804144681"))
		{
			mainA(getRole(509223112265433106L, e.getGuild()), e.getMember(), e.getGuild());
		} else if (e.getMessageId().equals("515760095385092096"))
		{
			mainA(getRole(509223507440435210L, e.getGuild()), e.getMember(), e.getGuild());
		} else if (e.getMessageId().equals("515760194198962225"))
		{
			mainA(getRole(515755471274115074L, e.getGuild()), e.getMember(), e.getGuild());
		} else if (e.getMessageId().equals("515760446704320513"))
		{
			mainA(getRole(515755508401963018L, e.getGuild()), e.getMember(), e.getGuild());
		}
	}
	//@SuppressWarnings("unlikely-arg-type")
	public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent f)
	{
		if (f.getMessageId().equals("515759897804144681"))
		{
			mainR(getRole(509223112265433106L, f.getGuild()), f.getMember(), f.getGuild());
		} else if (f.getMessageId().equals("515760095385092096"))
		{
			mainR(getRole(509223507440435210L, f.getGuild()), f.getMember(), f.getGuild());
		} else if (f.getMessageId().equals("515760194198962225"))
		{
			mainR(getRole(515755471274115074L, f.getGuild()), f.getMember(), f.getGuild());
		} else if (f.getMessageId().equals("515760446704320513"))
		{
			mainR(getRole(515755508401963018L, f.getGuild()), f.getMember(), f.getGuild());
		}
		/*if (!(f.getMember().getRoles().contains("R:Discord-Updates(509223112265433106)")) && !(f.getMember().getRoles().contains("R:YouTube-Updates(509223507440435210)")) && !(f.getMember().getRoles().contains("R:Call-To-Arms(515755471274115074)")) && !(f.getMember().getRoles().contains("R:Voice-Chat(515755508401963018)")))
		{
			mainR(getRole(515763411242713088L, f.getGuild()), f.getMember(), f.getGuild());
		}*/
	}
}
