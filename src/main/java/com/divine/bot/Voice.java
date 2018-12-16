package com.divine.bot;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Voice extends ListenerAdapter {
	public void onGuildVoiceJoin(GuildVoiceJoinEvent e)
	{
		e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById(518072898498461698L)).reason("Joined a voice channel").complete();
	}
	public void onGuildVoiceLeave(GuildVoiceLeaveEvent e)
	{
		e.getGuild().getController().removeSingleRoleFromMember(e.getMember(), e.getGuild().getRoleById(518072898498461698L)).reason("Left a voice channel").complete();
		//518184310600105995
	}
}
