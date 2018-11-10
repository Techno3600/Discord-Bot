package com.gamingstuf.bot;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GS_WizPerms extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		Member _m = e.getGuild().getMemberById("323864143423864833");
		if (content.startsWith("-wiz remove")) {
			if (e.getMember().equals(_m)) {
				channel.sendMessage("Removed Permissions from Wiz_Techno").queue();
				_m.getGuild().getController().removeSingleRoleFromMember(_m, e.getGuild().getRoleById("500120487616053248")).complete();
				_m.getGuild().getController().removeSingleRoleFromMember(_m, e.getGuild().getRoleById("500410303729893376")).complete();
				channel.deleteMessageById(e.getMessageId()).complete();
			} else if (!(e.getMember().equals(_m))) {
				channel.deleteMessageById(e.getMessageId()).complete();
			}
		} else if (content.startsWith("-wiz restore")) {
			if (e.getMember().equals(_m)) {
				channel.sendMessage("Restored Permissions for Wiz_Techno").queue();
				_m.getGuild().getController().addSingleRoleToMember(_m, e.getGuild().getRoleById("500120487616053248")).complete();
				_m.getGuild().getController().addSingleRoleToMember(_m, e.getGuild().getRoleById("500410303729893376")).complete();
				_m.getGuild().getRoleById("500120487616053248").getManager().givePermissions(Permission.ADMINISTRATOR);
				channel.deleteMessageById(e.getMessageId()).complete();
			} else if (!(e.getMember().equals(_m))) {
				channel.deleteMessageById(e.getMessageId()).complete();
			}
		}
	}
}