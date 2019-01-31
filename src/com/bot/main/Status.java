package com.bot.main;

import java.util.Arrays;
import java.util.List;

import com.bot.functions.F;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Status extends AdminCommand {
	//-status <GAME game> <String status>
	// args[0]   args[1]     args[2]
	
	@Override
	public List<String> getAliases() { return Arrays.asList("-s", "-status"); }

	@Override
	public String getName() { return "Status Command"; }
	
	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args)
	{
		if (args.length < 3)
		{
			e.getChannel().sendMessage("Incorrect Usage. -status <Game GAME> <String status> \n List of possible games: WATCHING, LISTENING, PLAYING.").queue();
		}
		StringBuilder sb = new StringBuilder();
		String message;
		for(int i = 2; i < args.length; i++)
		{
			sb.append(args[i]).append(" ");
		}
		message = sb.toString().trim();
		
		if (args[1].equalsIgnoreCase("WATCHING"))
		{
			e.getJDA().getPresence().setGame(Game.watching(message));
			e.getChannel().sendMessage("Set bot's game status to: WATCHING " + "'" + message + "'.").queue();
		} else if (args[1].equalsIgnoreCase("LISTENING"))
		{
			e.getJDA().getPresence().setGame(Game.listening(message));
			e.getChannel().sendMessage("Set bot's game status to: LISTENING " + "'" + message + "'.").queue();
		} else if (args[1].equalsIgnoreCase("PLAYING"))
		{
			e.getJDA().getPresence().setGame(Game.playing(message));
			e.getChannel().sendMessage("Set bot's game status to: PLAYING " + "'" + message + "'.").queue();
		} else
		{
			e.getChannel().sendMessage(F.error("Bot Status Command", "-status <Game GAME> <String status>. List of possible games: WATCHING, LISTENING, PLAYING", "The first argument must be `WATCHING`, `LISTENING`, or `PLAYING`").build()).queue();
		}
	}
}

/*if (!args[i].equals("WATCHING") || (!args[i].equals("LISTENING")) || (!args[i].equals("PLAYING")))
{
	sb.append(args[i]).append(" ");
}*/