package com.softwaredevone.telegramBot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBoot extends TelegramLongPollingBot {
	
	@Override
	public void onUpdateReceived(Update update) {
		//get telegram user message
		final String messageTextReceived = update.getMessage().getText();
		
		//testing the received message
		System.out.println("The User has written: " + messageTextReceived);
		
		final long chatId = update.getMessage().getChatId();
		
		// send a response message to the user
		SendMessage message = new SendMessage();
		message.setChatId(chatId);
		message.setText("Thanks for contact us! I am softwareDevOne, your developer friend. My Team and I are here for helping you with your projects. Tell me more about your project and its requirements.");
		
		try {
			execute(message);
		} catch(TelegramApiException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public String getBotUsername() {
		return "softwareDevOneBot";
	}
	
	@Override
	public String getBotToken() {
		return "6084512114:AAFCR6cTMq9wO__fqxqvu8xoj1j9rtIfM7M";
	}
}
