package com.mf.bot;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MF_VoiceText extends ListenerAdapter {
	public void onGuildVoiceJoin(GuildVoiceJoinEvent e)
	{
		e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById(515254164557660171L)).complete();
	}
	public void onGuildVoiceLeave(GuildVoiceLeaveEvent f)
	{
		f.getGuild().getController().removeSingleRoleFromMember(f.getMember(), f.getGuild().getRoleById(515254164557660171L)).complete();
	}
}
